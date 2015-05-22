/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.dao;

import com.pagodalabs.app.mapase.beans.StaticLocation;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Maharjan
 */
public interface StaticLocationDAO {
    public List<StaticLocation> getAll() throws IOException, SQLException, ClassNotFoundException;
}
