/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.dbconnection.models;

/**
 *
 * @author magoc
 */
public class User {

    private int id;
    private String username;
    private String password;
    private String correo;
    private String foto;
    private String Rol;
    private int idRol;
    private String face;
    private String twitter;
    private String insta;
    
    public User(int id, String username, String foto, String Rol, int idRol) {
        this.id = id;
        this.username = username;
        this.foto = foto;
        this.Rol = Rol;
        this.idRol = idRol;
    }

    public User(String foto, String face, String twitter, String insta) {
        this.foto = foto;
        this.face = face;
        this.twitter = twitter;
        this.insta = insta;
    }

    
    public User(int id, String foto, String face, String twitter, String insta) {
        this.id = id;
        this.foto = foto;
        this.face = face;
        this.twitter = twitter;
        this.insta = insta;
    }

    
    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInsta() {
        return insta;
    }

    public void setInsta(String insta) {
        this.insta = insta;
    }
    
    
    
    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    
    public User() {
    }

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String foto) {
        this.id = id;
        this.username = username;
        this.foto = foto;
    }

    
    public User(int id, String username, String password, String correo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.correo = correo;
    }

    //signIn
    public User(String username, String password, String correo) {

        this.username = username;
        this.password = password;
        this.correo = correo;
    }

    public User(String Rol, int idRol) {
        this.Rol = Rol;
        this.idRol = idRol;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
