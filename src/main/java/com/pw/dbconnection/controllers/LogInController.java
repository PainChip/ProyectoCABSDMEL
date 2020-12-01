/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.dbconnection.controllers;

import com.pw.dbconnection.dao.UserDAO;
import com.pw.dbconnection.models.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author magoc
 */
@WebServlet(name = "LogInController", urlPatterns = {"/LogInController"})
public class LogInController extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User userController = new User(username, password);
        User logIn = UserDAO.logInUser(userController);
        if(logIn == null) {
            //Ver como mandar un mensaje
            //response.sendRedirect("fail.jsp");
            response.sendRedirect("LoginFail.jsp");
        } else {
            HttpSession session = request.getSession();                    
            session.setAttribute("id", logIn.getId());
            session.setAttribute("username", logIn.getUsername());
            session.setAttribute("foto", logIn.getFoto());
            session.setAttribute("rol", logIn.getRol());
            session.setAttribute("rolId", logIn.getIdRol());
            response.sendRedirect("index.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
