/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.dbconnection.controllers;


import com.pw.dbconnection.dao.CategoryDAO;
import com.pw.dbconnection.dao.MediaDAO;
import com.pw.dbconnection.dao.NoticiasDAO;
import com.pw.dbconnection.models.Category;
import com.pw.dbconnection.models.Media;
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
        
        //Parte donde se inserta la media
        

        Part file = request.getPart("image");        
        Part file2 = request.getPart("image2");
        Part file3 = request.getPart("image3");
        Part file4 = request.getPart("video");
        String nameImage= "",nameImage2= "" ,nameImage3= "",nameImage4= "";
        String fullPath = "",fullPath2= "" ,fullPath3= "",fullPath4= "";
        boolean bandera = false,bandera2 = false,bandera3 = false;

        String path = request.getServletContext().getRealPath("");
        File fileSaveDir = new File(path + FileUtils.RUTE_USER_IMAGE);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        
        String contentType = file.getContentType();
        if(contentType.equals("image/png")== true || contentType.equals("image/jpeg")== true){
            nameImage = file.getName() + System.currentTimeMillis() + FileUtils.GetExtension(contentType);
            fullPath = path + FileUtils.RUTE_USER_IMAGE + "/" + nameImage;
            bandera = true;
        }

        String contentType2 = file2.getContentType();
        if(contentType2.equals("image/png")== true || contentType2.equals("image/jpeg")== true){
            nameImage2 = file2.getName() + System.currentTimeMillis() + FileUtils.GetExtension(contentType2);
            fullPath2 = path + FileUtils.RUTE_USER_IMAGE + "/" + nameImage2;
            bandera2 = true;
       
        }
        
        String contentType3 = file3.getContentType();
        if (contentType.equals("image/png") == true || contentType.equals("image/jpeg") == true) {
            nameImage3 = file3.getName() + System.currentTimeMillis() + FileUtils.GetExtension(contentType3);
            fullPath3 = path + FileUtils.RUTE_USER_IMAGE + "/" + nameImage3;
            bandera3 = true;
        }
        
        if(bandera == true && bandera2 == true && bandera3 == true)
        {
            NoticiasDAO.insertNoticia(newNews);
            int respuesta = NoticiasDAO.getNoticiaMediaID(newNews);
            if(respuesta != 0)
            {
                file.write(fullPath);
                Media Media1 = new Media(respuesta,true,FileUtils.RUTE_USER_IMAGE + "/" + nameImage);
                MediaDAO.insertMedia(Media1);
                file2.write(fullPath2);
                Media Media2 = new Media(respuesta,true,FileUtils.RUTE_USER_IMAGE + "/" + nameImage2);
                MediaDAO.insertMedia(Media2);
                file3.write(fullPath3);
                Media Media3 = new Media(respuesta,true,FileUtils.RUTE_USER_IMAGE + "/" + nameImage3);
                MediaDAO.insertMedia(Media3);
            }
        }
        String contentType4 = file4.getContentType();
        if (contentType.equals("video/mp4") == true) {
            nameImage4 = file4.getName() + System.currentTimeMillis() + FileUtils.GetExtension(contentType4);
            fullPath4 = path + FileUtils.RUTE_USER_IMAGE + "/" + nameImage4;

            file4.write(fullPath4);
        }

        List<Category> categories = CategoryDAO.getCategories();
        request.setAttribute("Categories", categories);
        request.getRequestDispatcher("CrearNoticia.jsp").forward(request, response);
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
