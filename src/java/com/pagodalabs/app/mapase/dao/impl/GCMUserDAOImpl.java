/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.dao.impl;

import com.pagodalabs.app.mapase.beans.GCMUser;
import com.pagodalabs.app.mapase.dao.GCMUsersDAO;
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
public class GCMUserDAOImpl implements GCMUsersDAO {

    @Override
    public int insert(GCMUser u) throws SQLException, IOException, ClassNotFoundException {
         DbConnection dbConn = new DbConnection();
        String sql = "INSERT INTO gcm_users(gcm_regid, profile_id, user_name, email) values(?,?,?,?)";
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
        pst.setString(1, u.getRegId());
        pst.setString(2, u.getProfileId());
        pst.setString(3, u.getUserName());
        pst.setString(4, u.getEmail());
        //dbConn.close();
        return pst.executeUpdate();
    }

    @Override
    public int search(String regId) throws SQLException, IOException, ClassNotFoundException {
          Boolean answer = false;
          int ans = -1;
        String sql = "SELECT * FROM gcm_users";
        DbConnection dbConn = new DbConnection();
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()) {
            if(regId.equals(rs.getString("gcm_regid"))) {
                answer = true;
                ans = rs.getInt("id");
                break;
            }
        }
        return ans;
    }

    @Override
    public List<GCMUser> getAll() throws SQLException, ClassNotFoundException, IOException {
        String sql = "SELECT * FROM gcm_users";
        DbConnection dbConn = new DbConnection();
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        List<GCMUser> userList = new ArrayList<>();
        while(rs.next()) {
           GCMUser u = new GCMUser();
           u.setId(rs.getInt("id"));
           u.setRegId(rs.getString("gcm_regid"));
           u.setProfileId(rs.getString("profile_id"));
           u.setUserName(rs.getString("user_name"));
           u.setEmail(rs.getString("email"));
           u.setCreatedAt(rs.getDate("created_at"));
           userList.add(u);
        }
        return userList;
    }
    
    @Override
    public int update(String profileId, String userName, String email, int id) throws ClassNotFoundException, IOException, SQLException {
        DbConnection dbConn = new DbConnection();
        String sql = "UPDATE gcm_users SET profile_id = ? , user_name = ? , email = ? where id = ?";
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
        pst.setString(1, profileId);
        pst.setString(2, userName);
        pst.setString(3, email);
        pst.setInt(4, id);
        //dbConn.close();
        return pst.executeUpdate();
    }

    @Override
    public int delete(String regId) throws ClassNotFoundException, SQLException, IOException {
        DbConnection dbConn = new DbConnection();
        String sql = "DELETE FROM gcm_users where gcm_regid = ?";
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
        return pst.executeUpdate();
    }
    
}
