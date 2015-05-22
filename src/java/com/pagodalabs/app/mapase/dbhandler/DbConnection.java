/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.dbhandler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private Connection connection = null;
    String url = "", username = "", password = "";

    public DbConnection() throws ClassNotFoundException, IOException {
//        Properties p = new Properties();
//        p.load(new FileReader(new File("config.properties")));

        String driver = "com.mysql.jdbc.Driver";
//        url = "jdbc:mysql://localhost/mapase";//"jdbc:mysql://127.13.168.130:3306/subin";
//        username = "root";//"adminFG4i91V";
//        password = "";//"8fkg_fpj9Pmd";
        
        url = "jdbc:mysql://127.13.168.130:3306/subin";
        username = "adminFG4i91V";
        password = "8fkg_fpj9Pmd";

        Class.forName(driver);

    }

    public Connection open() throws SQLException {

        connection = (Connection) DriverManager.getConnection(url + "?useUnicode=true&characterEncoding=UTF-8", username, password);
        return connection;
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }
}
