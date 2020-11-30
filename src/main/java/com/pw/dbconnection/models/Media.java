/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.dbconnection.models;

/**
 *
 * @author CARLOS
 */
public class Media {
    private int id;
    private int idNot;
    private boolean tipo; //1 Imagen, 0 video
    private String Url;
    //Constructor para insertar Media
    public Media(int idNot, boolean tipo, String Url) {
        this.idNot = idNot;
        this.tipo = tipo;
        this.Url = Url;
    }
    //Constructor para traer Media
    public Media(int id, int idNot, boolean tipo, String Url) {
        this.id = id;
        this.idNot = idNot;
        this.tipo = tipo;
        this.Url = Url;
    }

    public Media() {
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNot() {
        return idNot;
    }

    public void setIdNot(int idNot) {
        this.idNot = idNot;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

  
        
}

