/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.dao;

import com.pagodalabs.app.mapase.beans.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Maharjan
 */
public interface UsersDAO {

    public int insert(User u) throws SQLException, IOException, ClassNotFoundException;

    public Boolean search(String profileId) throws SQLException, IOException, ClassNotFoundException;

    public User getById(String id) throws SQLException, ClassNotFoundException, IOException;

    public List<User> getAll() throws SQLException, ClassNotFoundException, IOException;
}
