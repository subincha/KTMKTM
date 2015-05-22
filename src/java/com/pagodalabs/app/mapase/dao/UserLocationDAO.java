/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.dao;

import com.pagodalabs.app.mapase.beans.UserLocation;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 *  @author Maharjan
 */
public interface UserLocationDAO {
      public int insert(UserLocation sLoc, String dbName) throws IOException, SQLException, ClassNotFoundException;
      public int search(Double lat, Double lon, String profileId, String dbName) throws IOException, SQLException, ClassNotFoundException;
      public UserLocation getByName(String nameOfPlace, String dbName) throws IOException, SQLException, ClassNotFoundException;
      public List<UserLocation> getAll(String dbName) throws IOException, SQLException, ClassNotFoundException ;
      public UserLocation getByStatus(int status, String dbName) throws IOException, SQLException, ClassNotFoundException;
      public int update(int id, int status, String dbName) throws ClassNotFoundException, IOException, SQLException;
}
