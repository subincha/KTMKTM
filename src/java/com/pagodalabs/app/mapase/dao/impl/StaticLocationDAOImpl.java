/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.dao.impl;

import com.pagodalabs.app.mapase.beans.StaticLocation;
import com.pagodalabs.app.mapase.beans.UserLocation;
import com.pagodalabs.app.mapase.dao.StaticLocationDAO;
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
public class StaticLocationDAOImpl implements StaticLocationDAO {

    @Override
    public List<StaticLocation> getAll()throws IOException, SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM static_traffic_locations";
        DbConnection dbConn = new DbConnection();
        PreparedStatement pst = dbConn.open().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        List<StaticLocation> sLocList = new ArrayList<>();
        while(rs.next()) { 
            StaticLocation sLoc = new StaticLocation();
            sLoc.setId(rs.getInt("id"));
            sLoc.setLatitude(rs.getDouble("latitude"));
            sLoc.setLongitude(rs.getDouble("longitude"));
            sLoc.setNameOfPlace(rs.getString("name_of_place"));
            sLocList.add(sLoc);
        }
       // dbConn.close();
        return sLocList;
    }
    
}
