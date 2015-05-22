/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.app.mapase.controllers;

import com.pagodalabs.app.mapase.beans.User;
import com.pagodalabs.app.mapase.dao.UsersDAO;
import com.pagodalabs.app.mapase.dao.impl.UsersDAOImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maharjan
 */
@WebServlet(name = "FacebookLoginController", urlPatterns = {"/FacebookLoginController"})
public class FacebookLoginController extends HttpServlet {

    User user = new User();
    UsersDAO usersDao = new UsersDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //resp.setContentType("application/json");
        String profileId = req.getParameter("user_id");
        try {
           if (!usersDao.search(profileId)) {
                user.setUserId(profileId);
                user.setUserName(req.getParameter("userName"));
                user.setFirstName(req.getParameter("firstName"));
                user.setMiddleName(req.getParameter("middleName"));
                user.setLastName(req.getParameter("lastName"));
                user.setEmail(req.getParameter("email"));
                user.setBirthday(req.getParameter("birthday"));
                user.setFbLink(req.getParameter("fbLink"));
                user.setLocation(req.getParameter("location"));
                user.setIpAddress(req.getParameter("ipAddress"));
                //if(usersDao.insert(user) == 1) {
                usersDao.insert(user);
               
                RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/userlist.jsp");
                req.setAttribute("users", usersDao.getAll());
                dispatch.forward(req, resp);
                
           }
           else{
                RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/userlist.jsp");
                req.setAttribute("users", usersDao.getAll());
                req.setAttribute("idExists", "Id already exists");
                dispatch.forward(req, resp);
           }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FacebookLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        RequestDispatcher dispatch = request.getRequestDispatcher("userlist.jsp");
        try {
            request.setAttribute("users", usersDao.getAll());
        } catch (SQLException | ClassNotFoundException ex) {
        
        }
        dispatch.forward(request, response);
    }
    
    

  
}
