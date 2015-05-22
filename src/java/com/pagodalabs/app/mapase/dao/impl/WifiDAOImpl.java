/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.dao.impl;

import com.pagodalabs.app.mapase.beans.UserLocation;
import com.pagodalabs.app.mapase.beans.Wifi;
import com.pagodalabs.app.mapase.dao.UserLocationDAO;
import com.pagodalabs.app.mapase.dao.WifiDAO;
import com.pagodalabs.app.mapase.dbhandler.DbConnection;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maharjan
 */
public class WifiDAOImpl implements WifiDAO {

    @Override
    public int insert(Wifi wifi, String dbName) throws IOException, SQLException, ClassNotFoundException{
       String sql = "INSERT INTO "+dbName+"(profile_id, user_name, latitude, longitude, name_of_place, status, wifi_user_name, wifi_password, name_of_wifi_place) VALUES (?,?,?,?,?,?,?,?,?)";
       DbConnection dbConn = new DbConnection();
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
        pst.setString(1, wifi.getProfileId());
        pst.setString(2, wifi.getNameOfUser());
        pst.setDouble(3, wifi.getLatitude());
        pst.setDouble(4, wifi.getLongitude());
        pst.setString(5, wifi.getNameOfPlace());
        pst.setInt(6, 1); // insert status is always 1
        pst.setString(7, wifi.getWifiUserName());
        pst.setString(8, wifi.getWifiPassword());
        pst.setString(9, wifi.getNameOfWifiPlace());
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
    public Wifi getByName(String nameOfPlace, String dbName) throws IOException, SQLException, ClassNotFoundException {
      String sql = "SELECT * FROM "+dbName+" where name_of_place = " + nameOfPlace;
        DbConnection dbConn = new DbConnection();
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        Wifi wifi = new Wifi();
        while(rs.next()) { 
            wifi.setId(rs.getInt("id"));
            wifi.setProfileId(rs.getString("profile_id"));
            wifi.setNameOfUser(rs.getString("user_name"));
            wifi.setLatitude(rs.getDouble("latitude"));
            wifi.setLongitude(rs.getDouble("longitude"));
            wifi.setNameOfPlace(rs.getString("name_of_place"));
            wifi.setStatus(rs.getInt("status"));
            wifi.setWifiUserName(rs.getString("wifi_user_name"));
            wifi.setWifiPassword(rs.getString("wifi_password"));
            wifi.setNameOfWifiPlace(rs.getString("name_of_wifi_place"));
        }
        //dbConn.close();
        return wifi;  
    }

    @Override
    public List<Wifi> getAll(String dbName) throws IOException, SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM "+dbName;
        DbConnection dbConn = new DbConnection();
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        List<Wifi> wifiList = new ArrayList<>();
        while(rs.next()) { 
            Wifi wifi = new Wifi();
            wifi.setId(rs.getInt("id"));
            wifi.setProfileId(rs.getString("profile_id"));
            wifi.setNameOfUser(rs.getString("user_name"));
            wifi.setLatitude(rs.getDouble("latitude"));
            wifi.setLongitude(rs.getDouble("longitude"));
            wifi.setNameOfPlace(rs.getString("name_of_place"));
            wifi.setStatus(rs.getInt("status"));
            wifi.setTime(String.valueOf(rs.getDate("time")));
            wifi.setWifiUserName(rs.getString("wifi_user_name"));
            wifi.setWifiPassword(rs.getString("wifi_password"));
            wifi.setNameOfWifiPlace(rs.getString("name_of_wifi_place"));
            wifiList.add(wifi);
        }
       // dbConn.close();
        return wifiList;
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
    public Wifi getByStatus(int status, String dbName) throws IOException, SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM "+dbName+" where status = " + status;
        DbConnection dbConn = new DbConnection();
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        Wifi wifi = new Wifi();
        while(rs.next()) { 
            wifi.setId(rs.getInt("id"));
            wifi.setProfileId(rs.getString("profile_id"));
            wifi.setNameOfUser(rs.getString("user_name"));
            wifi.setLatitude(rs.getDouble("latitude"));
            wifi.setLongitude(rs.getDouble("longitude"));
            wifi.setNameOfPlace(rs.getString("name_of_place"));
            wifi.setStatus(rs.getInt("status"));
            wifi.setTime(String.valueOf(rs.getDate("time")));
            wifi.setWifiUserName(rs.getString("wifi_user_name"));
            wifi.setWifiPassword(rs.getString("wifi_password"));
            wifi.setNameOfWifiPlace(rs.getString("name_of_wifi_place"));
        }
        //dbConn.close();
        return wifi;  
    }
    
}
