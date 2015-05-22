/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.api;

import com.pagodalabs.app.mapase.beans.UserLocation;
import com.pagodalabs.app.mapase.dao.UserLocationDAO;
import com.pagodalabs.app.mapase.dao.impl.UserLocationDAOImpl;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * REST Web Service
 *
 * @author Maharjan
 */
@Path("/server_ip")
public class ServerIP {

     @Context
    private HttpServletRequest request;
 
    @Context
    private HttpServletResponse response;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserLocation
     */
    public ServerIP() {
    }

    /**
     * Retrieves representation of an instance of com.pagodalabs.app.mapase.api.UserLocation
     * @return an instance of java.lang.String
     */
   
    @GET
    @Produces("application/json")
    public String getServerIP() {
      
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                    if (!addr.isLoopbackAddress()) {
                        String sAddr = addr.getHostAddress().toUpperCase();
                        return sAddr;
                       
                    }
                }
            }
        } catch (Exception ex) { } // for now eat exceptions
        return "";
    }  
}
