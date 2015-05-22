/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.dao.impl;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.pagodalabs.app.mapase.beans.User;
import com.pagodalabs.app.mapase.dao.UsersDAO;
import com.pagodalabs.app.mapase.dbhandler.DbConnection;
import java.util.ArrayList;



/**
 *
 * @author Maharjan
 */

public class UsersDAOImpl implements UsersDAO{

    public UsersDAOImpl(){
     }
    
    @Override
    public List<User> getAll() throws SQLException, ClassNotFoundException, IOException {
        String sql = "SELECT * FROM users";
        DbConnection dbConn = new DbConnection();
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        List<User> userList = new ArrayList<>();
        while(rs.next()) {
           User u = new User();
           u.setId(rs.getInt("id"));
           u.setUserId(rs.getString("profile_id"));
           u.setUserName(rs.getString("fb_username"));
           u.setFirstName(rs.getString("first_name"));
           u.setMiddleName(rs.getString("middle_name"));
           u.setLastName(rs.getString("last_name"));
           u.setEmail(rs.getString("email"));
           u.setBirthday(rs.getString("birthday"));
           u.setFbLink(rs.getString("fb_link"));
           u.setLocation(rs.getString("location"));
           u.setIpAddress(rs.getString("ip_address"));
           u.setCreatedAt(rs.getDate("created_at"));
           userList.add(u);
        }
        return userList;
    }
    
     @Override
    public User getById(String id) throws SQLException, ClassNotFoundException, IOException {
        String sql = "SELECT * FROM users where id = " + id;
        DbConnection dbConn = new DbConnection();
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        User u = new User();
        while(rs.next()) {
           
           u.setId(rs.getInt("id"));
           u.setUserId(rs.getString("profile_id"));
           u.setUserName(rs.getString("fb_username"));
           u.setFirstName(rs.getString("first_name"));
           u.setMiddleName(rs.getString("middle_name"));
           u.setLastName(rs.getString("last_name"));
           u.setEmail(rs.getString("email"));
           u.setBirthday(rs.getString("birthday"));
           u.setFbLink(rs.getString("fb_link"));
           u.setLocation(rs.getString("location"));
           u.setIpAddress(rs.getString("ip_address"));
           u.setCreatedAt(rs.getDate("created_at"));
        }
        return u;
    }

    @Override
    public int insert(User users) throws SQLException, IOException, ClassNotFoundException {
        DbConnection dbConn = new DbConnection();
        String sql = "INSERT INTO users(profile_id, fb_username, first_name,last_name, middle_name,email,location,birthday,fb_link, ip_address) values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
        pst.setString(1, users.getUserId());
        pst.setString(2, users.getUserName());
        pst.setString(3, users.getFirstName());
        pst.setString(4, users.getLastName());
        pst.setString(5, users.getMiddleName());
        pst.setString(6, users.getEmail());
        pst.setString(7, users.getLocation());
        pst.setString(8, users.getBirthday());
        pst.setString(9, users.getFbLink());
        pst.setString(10, users.getIpAddress());
        //dbConn.close();
        return pst.executeUpdate();
    }

    @Override
    public Boolean search(String profileId) throws SQLException, IOException, ClassNotFoundException {
        Boolean answer = false;
        String sql = "SELECT profile_id FROM users";
        DbConnection dbConn = new DbConnection();
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()) {
            if(profileId.equals(rs.getString("profile_id"))) {
                answer = true;
                break;
            }
        }
        return answer;
    }
    
}
