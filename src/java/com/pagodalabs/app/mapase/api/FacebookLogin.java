/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.api;

import com.pagodalabs.app.mapase.beans.User;
import com.pagodalabs.app.mapase.dao.UsersDAO;
import com.pagodalabs.app.mapase.dao.impl.UsersDAOImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * REST Web Service
 *
 * @author Maharjan
 */
@Path("fblogin")
public class FacebookLogin {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public FacebookLogin() {
    }

    /**
     * Retrieves representation of an instance of com.pagodalabs.app.mapase.api.GenericResource
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     */
    @GET
    @Produces("application/json")
    public List<User> getUsers() throws SQLException, ClassNotFoundException, IOException {
        UsersDAO uDao = new UsersDAOImpl();
        return uDao.getAll();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public User getUserById(@PathParam("id") String id) throws SQLException, ClassNotFoundException, IOException {
        UsersDAO uDao = new UsersDAOImpl();
        return uDao.getById(id);
    }
    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param userId    
     * @param userName    
     * @param firstName    
     * @param middleName    
     * @param lastName    
     * @param email    
     * @param birthday    
     * @param fbLink    
     * @param location    
     * @param ipAddress    
     * @throws java.sql.SQLException    
     * @throws java.io.IOException    
     * @throws java.lang.ClassNotFoundException    
     */
    @POST
    public void postFbLoginInfo(@FormParam("user_id") String userId, 
            @FormParam("userName") String userName,
            @FormParam("firstName") String firstName,
            @FormParam("middleName") String middleName,
            @FormParam("lastName") String lastName,
            @FormParam("email") String email,
            @FormParam("birthday") String birthday,
            @FormParam("fbLink") String fbLink,
            @FormParam("location") String location,
            @FormParam("ipAddress") String ipAddress) throws SQLException, IOException, ClassNotFoundException {
        User u = new User();
        UsersDAO uDAO = new UsersDAOImpl();
        if(!uDAO.search(userId)) {
            u.setUserId(userId);
            u.setUserName(userName);
            u.setFirstName(firstName);
            u.setMiddleName(middleName);
            u.setLastName(lastName);
            u.setEmail(email);
            u.setBirthday(birthday);
            u.setFbLink(fbLink);
            u.setLocation(location);
            u.setIpAddress(ipAddress);
            uDAO.insert(u);
        }
        
    }
}
