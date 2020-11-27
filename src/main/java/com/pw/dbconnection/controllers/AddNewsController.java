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
 *
 * @author CARLOS
 */
@WebServlet(name = "AddNewsController", urlPatterns = {"/AddNewsController"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 25)
public class AddNewsController extends HttpServlet {

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
        List<Category> categories = CategoryDAO.getCategories();
        request.setAttribute("Categories", categories);
        request.getRequestDispatcher("CrearNoticia.jsp").forward(request, response);
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
        String title = request.getParameter("title");
        String description = request.getParameter("description");     
        String contenido = request.getParameter("contenido");        
        String rol = (String)session.getAttribute("rol");
        int rolID = (int)session.getAttribute("rolId");        
        int idCategory = Integer.parseInt(request.getParameter("category"), 10);
        Noticias newNews = new Noticias(title,description,contenido,rol,rolID, new Category(idCategory));
        
        NoticiasDAO.insertNoticia(newNews);
        //Parte donde se inserta la media
        
        /*String probemos = request.getParameter("iteraciones");
        int numeros = Integer.parseInt(probemos);
        
        for(int repetir=1; repetir <= numeros; repetir++){
            
        String mElement = "elemento" + String.valueOf(repetir);
        
        Part file2 = request.getPart(mElement);
        Part file = request.getPart("image");
        
        String path = request.getServletContext().getRealPath("");
        File fileSaveDir = new File(path + FileUtils.RUTE_USER_IMAGE);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        
        String contentType = file.getContentType();
        String nameImage = file.getName() + System.currentTimeMillis() + FileUtils.GetExtension(contentType);
        String extension = FileUtils.GetExtension(contentType);
        String fullPath = path + FileUtils.RUTE_USER_IMAGE + "/" + nameImage;
        file.write(fullPath);
        
        
        }*/

        //News newNews = new News(title, description, FileUtils.RUTE_USER_IMAGE + "/" + nameImage, new Category(idCategory));

        /*
        List<Category> categories = CategoryDAO.getCategories();
        List<Noticias> news = NoticiasDAO.getNoticias();
        request.setAttribute("Categories", categories);
        request.setAttribute("News", news);*/
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
