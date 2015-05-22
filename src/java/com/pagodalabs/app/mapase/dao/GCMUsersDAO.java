/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.dao;

import com.pagodalabs.app.mapase.beans.GCMUser;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Maharjan
 */
public interface GCMUsersDAO {

    public int insert(GCMUser u) throws SQLException, IOException, ClassNotFoundException;

    public int search(String regId) throws SQLException, IOException, ClassNotFoundException;

    public int update(String profileId, String userName, String email, int id) throws ClassNotFoundException, IOException, SQLException;

    public int delete(String regId) throws ClassNotFoundException, SQLException, IOException;
    
    public List<GCMUser> getAll() throws SQLException, ClassNotFoundException, IOException;
}
