/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.api;

import com.pagodalabs.app.mapase.beans.Wifi;
import com.pagodalabs.app.mapase.dao.UserLocationDAO;
import com.pagodalabs.app.mapase.dao.WifiDAO;
import com.pagodalabs.app.mapase.dao.impl.UserLocationDAOImpl;
import com.pagodalabs.app.mapase.dao.impl.WifiDAOImpl;
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
public class WifiLocation {

     @Context
    private HttpServletRequest request;
 
    @Context
    private HttpServletResponse response;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserLocation
     */
    public WifiLocation() {
    }

    /**
     * Retrieves representation of an instance of com.pagodalabs.app.mapase.api.UserLocation
     * @return an instance of java.lang.String
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    @Path("/userlocation/wifi")
    @GET
    @Produces("application/json")
    public List<Wifi> getAllUserLocation() throws IOException, SQLException, ClassNotFoundException {
       WifiDAO wifiDAO = new WifiDAOImpl();
        return wifiDAO.getAll( "wifi");
    }
    
    @Path("/userlocation/wifi/truestatus")
    @GET
    @Produces("application/json")
    public List<Wifi> getTrueUserLocation() throws IOException, SQLException, ClassNotFoundException {
       WifiDAO wifiDAO = new WifiDAOImpl();
        List<Wifi> temp = new ArrayList<>();
        for(Wifi w : wifiDAO.getAll( "wifi")) {
            if(w.getStatus() == 1) {
                temp.add(w);
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
     * @param wifiUserName
     * @param wifiPassword
     * @param nameOfWifiPlace
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws javax.servlet.ServletException
     */
    @Path("/userlocation/wifi")
    @POST
   public void postUserLocation(@FormParam("profileId") String profileId,
           @FormParam("userName") String userName,
           @FormParam("latitude") String latitude,
           @FormParam("longitude") String longitude,
           @FormParam("nameOfPlace") String nameOfPlace,
           @FormParam("wifiUserName") String wifiUserName,
           @FormParam("wifiPassword") String wifiPassword,
           @FormParam("nameOfWifiPlace") String nameOfWifiPlace) throws IOException, ClassNotFoundException, SQLException, ServletException {
       Wifi wifi = new Wifi();
       WifiDAO wifiDAO = new WifiDAOImpl();
       Double lat = Double.parseDouble(latitude);
       Double lon = Double.parseDouble(longitude);
       int id = wifiDAO.search(lat, lon, profileId, "wifi");
       if(id == -1) {
           wifi.setProfileId(profileId);
           wifi.setNameOfUser(userName);
           wifi.setLatitude(Double.parseDouble(latitude));
           wifi.setLongitude(Double.parseDouble(longitude));
           wifi.setNameOfPlace(nameOfPlace);
           wifi.setStatus(1);
           wifi.setWifiUserName(wifiUserName);
           wifi.setWifiPassword(wifiPassword);
           wifi.setNameOfWifiPlace(nameOfWifiPlace);
           wifiDAO.insert(wifi, "wifi");
       } else {
            wifiDAO.update(id, 1, "wifi");
        }

    }
   
   @Path("/userlocation/wifi/removelocation")
    @POST
   public void removeUserLocation(@FormParam("profileId") String profileId,
           @FormParam("userName") String userName,
           @FormParam("latitude") String latitude,
           @FormParam("longitude") String longitude,
           @FormParam("nameOfPlace") String nameOfPlace,
           @FormParam("wifiUserName") String wifiUserName,
           @FormParam("wifiPassword") String wifiPassword,
           @FormParam("nameOfWifiPlace") String nameOfWifiPlace) throws IOException, ClassNotFoundException, SQLException, ServletException {
      // UserLocation uLoc = new UserLocation();
       UserLocationDAO uLocDAO = new UserLocationDAOImpl();
       Double lat = Double.parseDouble(latitude);
       Double lon = Double.parseDouble(longitude);
       int id = uLocDAO.search(lat, lon, profileId, "wifi");
       if(id > -1) {
           uLocDAO.update(id, 0, "wifi");
       }
   }
}
