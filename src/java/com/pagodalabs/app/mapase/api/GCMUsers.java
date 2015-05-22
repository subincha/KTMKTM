/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.api;

import com.pagodalabs.app.mapase.dao.GCMUsersDAO;
import com.pagodalabs.app.mapase.dao.impl.GCMUserDAOImpl;
import com.pagodalabs.app.mapase.beans.GCMUser;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * REST Web Service
 *
 * @author Maharjan
 */
@Path("gcmusers")
public class GCMUsers {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GCMUser
     */
    public GCMUsers() {
    }

    /**
     * Retrieves representation of an instance of com.pagodalabs.app.mapase.api.GCMUser
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     */
    @GET
    @Produces("application/json")
    public List<GCMUser> getAll() throws SQLException, ClassNotFoundException, IOException {
        GCMUsersDAO gcmDAO = new GCMUserDAOImpl();
        return gcmDAO.getAll();
    }

    /**
     * PUT method for updating or creating an instance of GCMUser
     * @param profileId
     * @param regId
     * @param userName
     * @param email
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    @POST   
     public void postGCMUser(@FormParam("profileId") String profileId,
           @FormParam("regId") String regId,
           @FormParam("userName") String userName,
           @FormParam("email") String email) throws IOException, ClassNotFoundException, SQLException {
            GCMUser gcmUser = new GCMUser();
            GCMUsersDAO gcmDAO = new GCMUserDAOImpl();
            int id = gcmDAO.search(regId);
            if(id == -1) {
                gcmUser.setRegId(regId);
                gcmUser.setProfileId(profileId);
                gcmUser.setUserName(userName);
                gcmUser.setEmail(email);
                gcmDAO.insert(gcmUser);
            }
            else{
                gcmDAO.update(profileId, userName, email, id);
            }
            
           
    }
   
}
