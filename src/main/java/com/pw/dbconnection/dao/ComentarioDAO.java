/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.dbconnection.dao;

import com.pw.dbconnection.models.Comentario;
import com.pw.dbconnection.models.User;
import com.pw.dbconnection.utils.DbConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CARLOS
 */
public class ComentarioDAO {
        public static int insertCommentary(Comentario commentary) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            User usuario = commentary.getUser();
            CallableStatement statement;
            if(usuario.getUsername().equals("") == true ){
                String sql = "CALL SP_AgregaComen(?, ?, ?);";
                statement = con.prepareCall(sql);

                statement.setString(1, commentary.getContent());
                statement.setInt(3, commentary.getIdNews());
                statement.setInt(2, commentary.getUser().getId());
            }else{
                String sql = "CALL SP_AgregaComenAnon(?, ?, ?);";
                statement = con.prepareCall(sql);

                statement.setString(1, commentary.getContent());
                statement.setInt(3, commentary.getIdNews());
                statement.setString(2, commentary.getUser().getUsername());
            }
            return statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }
        public static int insertRespuesta(Comentario commentary) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            User usuario = commentary.getUser();
            CallableStatement statement;
            if(usuario.getUsername().equals("") == true ){
                String sql = "CALL SP_AgregaComenRes(?, ?, ?, ?);";
                statement = con.prepareCall(sql);

                statement.setString(1, commentary.getContent());
                statement.setInt(2, commentary.getUser().getId());   
                statement.setInt(3, commentary.getParent());
                statement.setInt(4, commentary.getIdNews());
            }else{
                String sql = "CALL SP_AgregaComenResAnon(?, ?, ?, ?);";
                statement = con.prepareCall(sql);

                statement.setString(1, commentary.getContent());
                statement.setString(2, commentary.getUser().getUsername()); 
                statement.setInt(3, commentary.getParent());
                statement.setInt(4, commentary.getIdNews());

            }
            return statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
        }        
        
        public static List<Comentario> getCommentaries(int idNews) {
        List<Comentario> commentaries = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL SP_ComentariosBase(?)";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idNews);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                String content = result.getString(2);
                int idUser = result.getInt(4);
                int parent = result.getInt(5);
                User user;
                if(idUser != 0 )
                {
                 user = UserDAO.getUser(idUser);
                }else{
                 user = new User(-1,result.getString(7));
                }
                List<Comentario> respuestas = new ArrayList<>();
                sql = "CALL SP_ComentariosRespuesta(?);";
                statement = con.prepareCall(sql);
                statement.setInt(1, id);
                ResultSet result2 = statement.executeQuery();
                while (result2.next()) {
                    int id2 = result2.getInt(1);
                    String content2 = result2.getString(2);
                    int idUser2 = result2.getInt(5);
                    int parent2 = result2.getInt(6);
                    User user2;
                    if (idUser != 0) {
                        user2 = UserDAO.getUser(idUser2);
                    } else {
                        user2 = new User(-1, result2.getString(7));
                    }
                    respuestas.add(new Comentario(id2, content2, idNews, user2, parent2));
                }
                commentaries.add(new Comentario(id, content, idNews, user, parent,respuestas));
            }
            return commentaries;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return commentaries;
    }
        
        public static int deleteCommentary(int idCommentary) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL deleteCommentary(?);";
            CallableStatement statement = con.prepareCall(sql);

            statement.setInt(1, idCommentary);

            return statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }
}
