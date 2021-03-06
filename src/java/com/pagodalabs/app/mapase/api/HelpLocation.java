/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.api;

import com.pagodalabs.app.mapase.beans.UserLocation;
import com.pagodalabs.app.mapase.dao.UserLocationDAO;
import com.pagodalabs.app.mapase.dao.impl.UserLocationDAOImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * REST Web Service
 *
 * @author Maharjan
 */
@Path("/location")
public class HelpLocation {

     @Context
    private HttpServletRequest request;
 
    @Context
    private HttpServletResponse response;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserLocation
     */
    public HelpLocation() {
    }

    /**
     * Retrieves representation of an instance of com.pagodalabs.app.mapase.api.UserLocation
     * @return an instance of java.lang.String
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    @Path("/userlocation/help")
    @GET
    @Produces("application/json")
    public List<UserLocation> getAllUserLocation() throws IOException, SQLException, ClassNotFoundException {
        UserLocationDAO locDAO = new UserLocationDAOImpl();
        return locDAO.getAll( "help");
    }
    
    @Path("/userlocation/help/truestatus")
    @GET
    @Produces("application/json")
    public List<UserLocation> getTrueUserLocation() throws IOException, SQLException, ClassNotFoundException {
        UserLocationDAO locDAO = new UserLocationDAOImpl();
        List<UserLocation> temp = new ArrayList<>();
        for(UserLocation u : locDAO.getAll( "help")) {
            if(u.getStatus() == 1) {
                temp.add(u);
            }
        }
        return temp;
    }
   
    /**
     * PUT method for updating or creating an instance of UserLocation
     * @param profileId
     * @param userName
     * @param latitude
     * @param longitude
     * @param nameOfPlace
     * @param label
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws javax.servlet.ServletException
     */
    @Path("/userlocation/help")
    @POST
   public void postUserLocation(@FormParam("profileId") String profileId,
           @FormParam("userName") String userName,
           @FormParam("latitude") String latitude,
           @FormParam("longitude") String longitude,
           @FormParam("nameOfPlace") String nameOfPlace,
           @FormParam("label") String label) throws IOException, ClassNotFoundException, SQLException, ServletException {
       UserLocation uLoc = new UserLocation();
       UserLocationDAO uLocDAO = new UserLocationDAOImpl();
       Double lat = Double.parseDouble(latitude);
       Double lon = Double.parseDouble(longitude);
       int id = uLocDAO.search(lat, lon, profileId, "help");
       if(id == -1) {
           uLoc.setProfileId(profileId);
           uLoc.setNameOfUser(userName);
           uLoc.setLatitude(Double.parseDouble(latitude));
           uLoc.setLongitude(Double.parseDouble(longitude));
           uLoc.setNameOfPlace(nameOfPlace);
           uLoc.setStatus(1);
           uLoc.setLabel(label);
           uLocDAO.insert(uLoc, "help");
       } else {
            uLocDAO.update(id, 1, "help");
        }

    }
   
   @Path("/userlocation/help/removelocation")
    @POST
   public void removeUserLocation(@FormParam("profileId") String profileId,
           @FormParam("userName") String userName,
           @FormParam("latitude") String latitude,
           @FormParam("longitude") String longitude,
           @FormParam("nameOfPlace") String nameOfPlace,
           @FormParam("label") String label) throws IOException, ClassNotFoundException, SQLException, ServletException {
      // UserLocation uLoc = new UserLocation();
       UserLocationDAO uLocDAO = new UserLocationDAOImpl();
       Double lat = Double.parseDouble(latitude);
       Double lon = Double.parseDouble(longitude);
       int id = uLocDAO.search(lat, lon, profileId, "help");
       if(id > -1) {
           uLocDAO.update(id, 0, "help");
       }
   }
}
