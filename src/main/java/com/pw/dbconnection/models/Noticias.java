/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.dbconnection.models;
import java.util.List;


/**
 *
 * @author CARLOS
 */
public class Noticias {
    
    private int id;
    private String title;
    private String description;
    private String contenido;    
    private String rol;
    private int idRol;
    private boolean status;
    private String Respuesta;
    // has-a
    private Category category;
    private List<Media> Media;

    public Noticias(int id, String title, String description, List<Media> Media) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.Media = Media;
    }

    public Noticias(int id) {
        this.id = id;
    }

    public Noticias(int id, String Respuesta) {
        this.id = id;
        this.Respuesta = Respuesta;
    }
    
    public String getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(String Respuesta) {
        this.Respuesta = Respuesta;
    }
    
    
    
    public List<Media> getMedia() {
        return Media;
    }
    
    public void setMedia(List<Media> Media) {
        this.Media = Media;
    }
    //Traer todo lo de la noticia 

    public Noticias(int id, String title, String description, String contenido, Category category, List<Media> Media) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.contenido = contenido;
        this.category = category;
        this.Media = Media;
    }
    
    public Noticias(String title, String description, String contenido, String rol, int idRol, Category category, List<Media> Media) {
        this.title = title;
        this.description = description;
        this.contenido = contenido;
        this.rol = rol;
        this.idRol = idRol;
        this.category = category;
        this.Media = Media;
    }
    
    //Constructor de cuando insertar noticia
    public Noticias(String title, String description, String contenido, String rol, int idRol, Category category) {
        this.title = title;
        this.description = description;
        this.contenido = contenido;
        this.rol = rol;
        this.idRol = idRol;
        this.category = category;
    }
    
    
    public Noticias(int id, String title, String contenido, String rol, int idRol, Category category) {
        this.id = id;
        this.title = title;
        this.contenido = contenido;
        this.rol = rol;
        this.idRol = idRol;
        this.category = category;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    
}
