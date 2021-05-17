/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.dbconnection.controllers;


import com.pw.dbconnection.dao.CategoryDAO;
import com.pw.dbconnection.dao.NoticiasDAO;
import com.pw.dbconnection.models.Category;
import com.pw.dbconnection.models.Noticias;
import com.pw.dbconnection.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
/**
/**
 *
 * @author CARLOS
 */
@WebServlet(name = "RevisaNewsController", urlPatterns = {"/RevisaNewsController"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 25)
public class RevisaNewsController extends HttpServlet {

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
        
        List<Noticias> newsRevisa = NoticiasDAO.getNoticiasEdicion();
        request.setAttribute("NewsRevisa", newsRevisa);
        request.getRequestDispatcher("edicion.jsp").forward(request, response);
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
        HttpSession session = request.getSession();  
        //Parte donde se inserta la noticia 
        int idnoti = Integer.parseInt(request.getParameter("NotID"), 10);        
        String respuestita = request.getParameter("Respuesta");    
        if(respuestita.equals("Rechazado") == true){
            String mensajito = request.getParameter("Mensaje");   
            Noticias newNews = new Noticias(idnoti,mensajito);
            NoticiasDAO.insertNoticiaRechazado(newNews);
        }else{
             Noticias newNews = new Noticias(idnoti);
             NoticiasDAO.insertNoticiaAceptado(newNews);
        }
        
        request.getRequestDispatcher("indexController").forward(request, response);
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
