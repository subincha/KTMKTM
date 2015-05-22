/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.controllers;

import com.google.android.gcm.server.Constants;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.pagodalabs.app.mapase.beans.GCMUser;
import com.pagodalabs.app.mapase.dao.GCMUsersDAO;
import com.pagodalabs.app.mapase.dao.impl.GCMUserDAOImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maharjan
 */
@WebServlet(name = "GCMController", urlPatterns = {"/GCMController"})
public class GCMController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // The SENDER_ID here is the "Browser Key" that was generated when I
    // created the API keys for my Google APIs project.
    private static final String SENDER_ID = "AIzaSyAaOGvW-K18dppb9RrYSlRYTfdlpIVrNMg";

    // This is a *cheat*  It is a hard-coded registration ID from an Android device
    // that registered itself with GCM using the same project id shown above.
   // private static final String ANDROID_DEVICE = "APA91bGK29sqy8wwW2QabZHHzx6BGXue3G_L0-GW5i90Y9DFGv8tSOwQ-ymfaMRaBESRzsGIZsBQQ2ZYpr2deui7LjLIX_H9RnF9opE8xFS-yuPLne4KlpqRpNWpZzsOX4FSpnKnbPqzOq-9sdIOVQ1-Q3whzsG_uTb1Zi2J_1nl3o7FXXbxxj0";

    // This array will hold all the registration ids used to broadcast a message.
    // for this demo, it will only have the ANDROID_DEVICE id that was captured 
    // when we ran the Android client app through Eclipse.
    private List<String> androidTargets;

    /**
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     * @see HttpServlet#HttpServlet()
     */
    public GCMController() throws SQLException, ClassNotFoundException, IOException {

        super();
      androidTargets = new ArrayList<>();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // We'll collect the "CollapseKey" and "Message" values from our JSP page
        String collapseKey = "";
        String userMessage = "";
        String latitude;
        String longitude;
        String traffic = "";
        String title;
        String regId;

        try {
            userMessage = request.getParameter("Message");
            collapseKey = request.getParameter("CollapseKey");
            latitude = request.getParameter("latitude");
            longitude = request.getParameter("longitude");
            traffic = request.getParameter("traffic");
            title = request.getParameter("title");
            regId = request.getParameter("regId");
        } catch (Exception e) {
            return;
        }

        // Instance of com.android.gcm.server.Sender, that does the
        // transmission of a Message to the Google Cloud Messaging service.
        Sender sender = new Sender(SENDER_ID);

        // This Message object will hold the data that is being transmitted
        // to the Android client devices.  For this demo, it is a simple text
        // string, but could certainly be a JSON object.
        
        Message message = new Message.Builder()
                // If multiple messages are sent using the same .collapseKey()
                // the android target device, if it was offline during earlier message
                // transmissions, will only receive the latest message for that key when
                // it goes back on-line.
                .collapseKey(collapseKey)
                .timeToLive(30)
                .delayWhileIdle(true)
                .addData("message", userMessage)
                .addData("latitude", latitude)
                .addData("longitude", longitude)
                .addData("traffic", traffic)
                .addData("title", title)
                .build();

        try {
            // use this for multicast messages.  The second parameter
            // of sender.send() will need to be an array of register ids.
                androidTargets.clear();
                GCMUsersDAO gcmDAO = new GCMUserDAOImpl();
                for(GCMUser u: gcmDAO.getAll()) {
                 androidTargets.add(u.getRegId());
            }

                androidTargets.remove(regId);
                MulticastResult result = sender.send(message, androidTargets, 1);
                androidTargets.add(regId);
              //MulticastResult result = sender.send(message, androidTargets, 1);
                
//            if (result.getResults() != null) {
//                int canonicalRegId = result.getCanonicalIds();
//                if (canonicalRegId != 0) {
//                    
//                }
//            } else {
//                int error = result.getFailure();
//                System.out.println("Broadcast failure: " + error);
//            }
                List<Result> results = result.getResults();
                for(int i = 0; i < androidTargets.size(); i++) {
                    String getRegId = androidTargets.get(i);
                    Result newResult = results.get(i);
                    String newMessageId = newResult.getMessageId();
                    if(newMessageId != null) {
                        String canonicalRegId = newResult.getCanonicalRegistrationId();
                        if(canonicalRegId != null) {
                            //Database update(getRegId, canonicalRegId);
                            log("yeta pugiyo");
                            gcmDAO.delete(getRegId);
                            GCMUser user = new GCMUser();
                            user.setRegId(canonicalRegId);
                            gcmDAO.insert(user);
                        }
                    } else {
                        String error = newResult.getErrorCodeName();
                        if(error.equals(Constants.ERROR_NOT_REGISTERED)) {
                            //application has been removed from device - unregister it
                            //database.unregister(getRegId);
                            gcmDAO.delete(getRegId);
                        } else {
                            System.out.println("Error sending message tp " + getRegId + ": " + error);
                        }
                    }
                }
             
        } catch (Exception e) {
            e.printStackTrace();
        }

        // We'll pass the CollapseKey and Message values back to index.jsp, only so
        // we can display it in our form again.
        request.setAttribute("CollapseKey", collapseKey);
        request.setAttribute("Message", userMessage);

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

}
