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

/**
 *
 * @author magoc
 */
@WebServlet(name = "SignInController", urlPatterns = {"/SignInController"})
public class SignInController extends HttpServlet {

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
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
     
            User user = new User(username, password, correo);
            if (UserDAO.signInUser(user) == 1) {
                response.sendRedirect("login_register.jsp");
            } else {
                //response.sendRedirect("noticias.jsp");
                //Mensaje de que hubo un error
            }


//        response.sendRedirect("index.jsp");
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
