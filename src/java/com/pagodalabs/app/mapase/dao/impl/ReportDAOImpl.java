/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.dao.impl;

import com.pagodalabs.app.mapase.beans.Report;
import com.pagodalabs.app.mapase.dao.ReportDAO;
import com.pagodalabs.app.mapase.dbhandler.DbConnection;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maharjan
 */
public class ReportDAOImpl implements ReportDAO {

    @Override
    public int insert(Report sLoc, String dbName) throws IOException, SQLException, ClassNotFoundException{
       String sql = "INSERT INTO "+dbName+"(profile_id, user_name, latitude, longitude, name_of_place, status, label, building_type, material_type, distruction_type, level_of_distruction, ward_number) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
       DbConnection dbConn = new DbConnection();
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
        pst.setString(1, sLoc.getProfileId());
        pst.setString(2, sLoc.getNameOfUser());
        pst.setDouble(3, sLoc.getLatitude());
        pst.setDouble(4, sLoc.getLongitude());
        pst.setString(5, sLoc.getNameOfPlace());
        pst.setInt(6, 1); // insert status is always 1
        pst.setString(7, sLoc.getLabel());
        pst.setString(8, sLoc.getBuildingType());
        pst.setString(9, sLoc.getMaterialType());
        pst.setString(10, sLoc.getDistructionType());
        pst.setString(11, sLoc.getMaterialType());
        pst.setInt(12, sLoc.getWardNum());
        //dbConn.close();
        return pst.executeUpdate();
    }

    @Override
    public int search(Double lat, Double lon, String profileId, String dbName) throws IOException, SQLException, ClassNotFoundException{
       Boolean answer = false;
       int ans = -1;
        String sql = "SELECT * FROM "+dbName;
        DbConnection dbConn = new DbConnection();
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()) {
            if((lat == rs.getDouble("latitude")) && (lon == rs.getDouble("longitude")) && profileId.equals(rs.getString("profile_id"))) {
                answer = true;
                ans = rs.getInt("id");
                break;
            }
        }
        //dbConn.close();
        return ans;
    }
    

    @Override
    public Report getByName(String nameOfPlace, String dbName) throws IOException, SQLException, ClassNotFoundException {
      String sql = "SELECT * FROM "+dbName+" where name_of_place = " + nameOfPlace;
        DbConnection dbConn = new DbConnection();
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        Report uLoc = new Report();
        while(rs.next()) { 
            uLoc.setId(rs.getInt("id"));
            uLoc.setProfileId(rs.getString("profile_id"));
            uLoc.setNameOfUser(rs.getString("user_name"));
            uLoc.setLatitude(rs.getDouble("latitude"));
            uLoc.setLongitude(rs.getDouble("longitude"));
            uLoc.setNameOfPlace(rs.getString("name_of_place"));
            uLoc.setStatus(rs.getInt("status"));
            uLoc.setLabel(rs.getString("label"));
            uLoc.setBuildingType(rs.getString("building_type"));
            uLoc.setMaterialType(rs.getString("material_type"));
            uLoc.setDistructionType(rs.getString("distruction_type"));
            uLoc.setLevelOfDistruction(rs.getString("level_of_distruction"));
            uLoc.setWardNum(rs.getInt("ward_number"));
        }
        //dbConn.close();
        return uLoc;  
    }

    @Override
    public List<Report> getAll(String dbName) throws IOException, SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM "+dbName;
        DbConnection dbConn = new DbConnection();
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        List<Report> sLocList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        while(rs.next()) { 
            Report sLoc = new Report();
            sLoc.setId(rs.getInt("id"));
            sLoc.setProfileId(rs.getString("profile_id"));
            sLoc.setNameOfUser(rs.getString("user_name"));
            sLoc.setLatitude(rs.getDouble("latitude"));
            sLoc.setLongitude(rs.getDouble("longitude"));
            sLoc.setNameOfPlace(rs.getString("name_of_place"));
            sLoc.setStatus(rs.getInt("status"));
            sLoc.setTime(sdf.format((rs.getTimestamp("time"))));
            sLoc.setLabel(rs.getString("label"));
            sLoc.setBuildingType(rs.getString("building_type"));
            sLoc.setMaterialType(rs.getString("material_type"));
            sLoc.setDistructionType(rs.getString("distruction_type"));
            sLoc.setLevelOfDistruction(rs.getString("level_of_distruction"));
            sLoc.setWardNum(rs.getInt("ward_number"));
            sLocList.add(sLoc);
        }
       // dbConn.close();
        return sLocList;
    }
    
    @Override
    public int update(int id, int status, String dbName) throws ClassNotFoundException, IOException, SQLException {
        DbConnection dbConn = new DbConnection();
        String sql = "UPDATE "+dbName+" SET status = " + status + " where id = " + id;
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
       // pst.setInt(1, 0);
        //pst.setInt(1, id);
        //dbConn.close();
        return pst.executeUpdate();
    }
     
    @Override
    public Report getByStatus(int status, String dbName) throws IOException, SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM "+dbName+" where status = " + status;
        DbConnection dbConn = new DbConnection();
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        Report uLoc = new Report();
        while(rs.next()) { 
            uLoc.setId(rs.getInt("id"));
            uLoc.setProfileId(rs.getString("profile_id"));
            uLoc.setNameOfUser(rs.getString("user_name"));
            uLoc.setLatitude(rs.getDouble("latitude"));
            uLoc.setLongitude(rs.getDouble("longitude"));
            uLoc.setNameOfPlace(rs.getString("name_of_place"));
            uLoc.setStatus(rs.getInt("status"));
            uLoc.setLabel(rs.getString("label"));
            uLoc.setBuildingType(rs.getString("building_type"));
            uLoc.setMaterialType(rs.getString("material_type"));
            uLoc.setDistructionType(rs.getString("distruction_type"));
            uLoc.setLevelOfDistruction(rs.getString("level_of_distruction"));
            uLoc.setWardNum(rs.getInt("ward_number"));
        }
        //dbConn.close();
        return uLoc;  
    }
    
}
