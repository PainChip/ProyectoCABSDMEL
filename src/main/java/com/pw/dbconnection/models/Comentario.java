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
public class Comentario {

    private int id;
    private String content;
    private int idNews;
    private User user;
    private int parent;
    private List<Comentario> answers;

    public Comentario() {
    }

    public Comentario(int id) {
        this.id = id;
    }

    public Comentario(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public Comentario(String content, int idNews, User user, int parent) {
        this.content = content;
        this.idNews = idNews;
        this.user = user;
        this.parent = parent;
    }

    public Comentario(int id, String content, int idNews, User user, int parent) {
        this.id = id;
        this.content = content;
        this.idNews = idNews;
        this.user = user;
        this.parent = parent;
    }

    public Comentario(int id, String content, int idNews, User user, int parent, List<Comentario> answers) {
        this.id = id;
        this.content = content;
        this.idNews = idNews;
        this.user = user;
        this.parent = parent;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIdNews() {
        return idNews;
    }

    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public List<Comentario> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Comentario> answers) {
        this.answers = answers;
    }

}
