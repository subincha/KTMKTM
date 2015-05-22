/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.api;

import com.pagodalabs.app.mapase.beans.Report;
import com.pagodalabs.app.mapase.dao.ReportDAO;
import com.pagodalabs.app.mapase.dao.impl.ReportDAOImpl;
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
public class ReportLocation {

     @Context
    private HttpServletRequest request;
 
    @Context
    private HttpServletResponse response;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ReportLocation
     */
    public ReportLocation() {
    }

    /**
     * Retrieves representation of an instance of com.pagodalabs.app.mapase.api.ReportLocation
     * @return an instance of java.lang.String
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    @Path("/userlocation/report")
    @GET
    @Produces("application/json")
    public List<Report> getAllReportLocation() throws IOException, SQLException, ClassNotFoundException {
        ReportDAO locDAO = new ReportDAOImpl();
        return locDAO.getAll( "report");
    }
    
    @Path("/userlocation/report/truestatus")
    @GET
    @Produces("application/json")
    public List<Report> getTrueReportLocation() throws IOException, SQLException, ClassNotFoundException {
        ReportDAO locDAO = new ReportDAOImpl();
        List<Report> temp = new ArrayList<>();
        for(Report u : locDAO.getAll("report")) {
            if(u.getStatus() == 1) {
                temp.add(u);
            }
        }
        return temp;
    }
    
   
    /**
     * PUT method for updating or creating an instance of ReportLocation
     * @param profileId
     * @param userName
     * @param latitude
     * @param longitude
     * @param nameOfPlace
     * @param label
     * @param buildingType
     * @param materialType
     * @param distructionType
     * @param levelOfDistruction
     * @param wardNum
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws javax.servlet.ServletException
     */
    @Path("/userlocation/report")
    @POST
   public void postReportLocation(@FormParam("profileId") String profileId,
           @FormParam("userName") String userName,
           @FormParam("latitude") String latitude,
           @FormParam("longitude") String longitude,
           @FormParam("nameOfPlace") String nameOfPlace,
           @FormParam("label") String label,
           @FormParam("buildingType") String buildingType,
           @FormParam("materialType") String materialType,
           @FormParam("distructionType") String distructionType,
           @FormParam("levelOfDistruction") String levelOfDistruction,
           @FormParam("wardNum") String wardNum) throws IOException, ClassNotFoundException, SQLException, ServletException {
       Report uLoc = new Report();
       ReportDAO uLocDAO = new ReportDAOImpl();
       Double lat = Double.parseDouble(latitude);
       Double lon = Double.parseDouble(longitude);
       int id = uLocDAO.search(lat, lon, profileId, "report");
       if(id == -1) {
           uLoc.setProfileId(profileId);
           uLoc.setNameOfUser(userName);
           uLoc.setLatitude(Double.parseDouble(latitude));
           uLoc.setLongitude(Double.parseDouble(longitude));
           uLoc.setNameOfPlace(nameOfPlace);
           uLoc.setStatus(1);
           uLoc.setLabel(label);
           uLoc.setBuildingType(buildingType);
           uLoc.setMaterialType(materialType);
           uLoc.setDistructionType(distructionType);
           uLoc.setLevelOfDistruction(levelOfDistruction);
           uLoc.setWardNum(Integer.parseInt(wardNum));
           uLocDAO.insert(uLoc, "report");
       } else {
            uLocDAO.update(id, 1, "report");
        }

    }
   
   @Path("/userlocation/report/removelocation")
    @POST
   public void removeReportLocation(@FormParam("profileId") String profileId,
           @FormParam("userName") String userName,
           @FormParam("latitude") String latitude,
           @FormParam("longitude") String longitude,
           @FormParam("nameOfPlace") String nameOfPlace,
           @FormParam("label") String label,
           @FormParam("buildingType") String buildingType,
           @FormParam("materialType") String materialType,
           @FormParam("distructionType") String distructionType,
           @FormParam("levelOfDistruction") String levelOfDistruction,
           @FormParam("wardNum") String wardNum) throws IOException, ClassNotFoundException, SQLException, ServletException {
      // UserLocation uLoc = new UserLocation();
       ReportDAO uLocDAO = new ReportDAOImpl();
       Double lat = Double.parseDouble(latitude);
       Double lon = Double.parseDouble(longitude);
       int id = uLocDAO.search(lat, lon, profileId, "report");
       if(id > -1) {
           uLocDAO.update(id, 0, "report");
       }
   }
}
