/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.dbconnection.controllers;

import com.pw.dbconnection.dao.UserDAO;
import com.pw.dbconnection.models.Category;
import com.pw.dbconnection.models.Noticias;
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
 * @author CARLOS
 */
@WebServlet(name = "ConfiguracionController", urlPatterns = {"/ConfiguracionController"})
public class ConfiguracionController extends HttpServlet {

   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();  
        int rolID = (int)session.getAttribute("id");  
        User usuarioInfo = UserDAO.getRedesFotoUser(rolID);
        request.setAttribute("Usuinfo", usuarioInfo);
        request.getRequestDispatcher("Configuracion.jsp").forward(request, response);
    }

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
        String RedFace = request.getParameter("feis");
        String RedInsta = request.getParameter("insta");
        String RedTuit = request.getParameter("tuit");
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        //Parte donde se inserta la noticia 
        
        String face = "https://www.facebook.com/" + RedFace;
        String twitter = "https://twitter.com/"+ RedTuit;
        String insta = "https://www.instagram.com/" +RedInsta;
        
        User newNews = new User(id, face, face, twitter, insta);

        UserDAO.RedesFotoUser(newNews);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
