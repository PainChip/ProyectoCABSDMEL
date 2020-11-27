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
    private boolean tipo; //1 Imagen, 0 video
    private String Url;

    public Media(int id, boolean tipo, String Url) {
        this.id = id;
        this.tipo = tipo;
        this.Url = Url;
    }

    public Media() {
    }

    public Media(int id) {
        this.id = id;
    }

    public Media(boolean tipo) {
        this.tipo = tipo;
    }

    public Media(String Url) {
        this.Url = Url;
    }

    public Media(int id, boolean tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Media(int id, String Url) {
        this.id = id;
        this.Url = Url;
    }

    public Media(boolean tipo, String Url) {
        this.tipo = tipo;
        this.Url = Url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

