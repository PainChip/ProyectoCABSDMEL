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
public class Favorito {
    private int idUser;
    private int idNoticia;

    public Favorito(int idNoticia, int idUser) {
        this.idUser = idUser;
        this.idNoticia = idNoticia;
    }

    public Favorito() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(int idNoticia) {
        this.idNoticia = idNoticia;
    }
    
    
    
}
