/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.dbconnection.controllers;

import com.pw.dbconnection.dao.ComentarioDAO;
import com.pw.dbconnection.models.Comentario;
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
@WebServlet(name = "ComentariosController", urlPatterns = {"/ComentariosController"})
public class ComentariosController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String elid = request.getParameter("idusuario");  
        User usuario = new User();
        String elname;
        if(elid.equals("") == true ){
            elname = request.getParameter("commenName");
            if(elname.equals("") == true){
               elname = "Anonimo";
            }
            usuario.setUsername(elname);
        }else{
            usuario.setId(Integer.parseInt(elid));
            usuario.setUsername("");
        }
        
        String content = request.getParameter("commentary");
        String idNews = request.getParameter("idNews");
        
        ComentarioDAO.insertCommentary(new Comentario(content, Integer.parseInt(idNews), usuario));
        
        request.getRequestDispatcher("NoticiaEspecificaController?id=" + idNews).forward(request, response);
    }

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
               
        String elid = request.getParameter("idusuario");  
        String elparent = request.getParameter("idparent");  

        User usuario = new User();
        String elname;
        if(elid.equals("") == true ){
            elname = request.getParameter("commenName");
            if(elname.equals("") == true){
               elname = "Anonimo";
            }
            usuario.setUsername(elname);
        }else{
            usuario.setId(Integer.parseInt(elid));
            usuario.setUsername("");
        }
        
        String content = request.getParameter("commentary");
        String idNews = request.getParameter("idNews");
        
        ComentarioDAO.insertRespuesta(new Comentario(content, Integer.parseInt(idNews), usuario, Integer.parseInt(elparent)));
        
        request.getRequestDispatcher("NoticiaEspecificaController?id=" + idNews).forward(request, response);
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
        processRequest(request, response);
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