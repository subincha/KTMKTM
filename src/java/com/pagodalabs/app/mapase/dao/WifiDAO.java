/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.dao;

import com.pagodalabs.app.mapase.beans.UserLocation;
import com.pagodalabs.app.mapase.beans.Wifi;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 *  @author Maharjan
 */
public interface WifiDAO {
      public int insert(Wifi wifi, String dbName) throws IOException, SQLException, ClassNotFoundException;
      public int search(Double lat, Double lon, String profileId, String dbName) throws IOException, SQLException, ClassNotFoundException;
      public Wifi getByName(String nameOfPlace, String dbName) throws IOException, SQLException, ClassNotFoundException;
      public List<Wifi> getAll(String dbName) throws IOException, SQLException, ClassNotFoundException ;
      public Wifi getByStatus(int status, String dbName) throws IOException, SQLException, ClassNotFoundException;
      public int update(int id, int status, String dbName) throws ClassNotFoundException, IOException, SQLException;
}
