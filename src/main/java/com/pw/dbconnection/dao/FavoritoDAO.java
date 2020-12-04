/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.dbconnection.dao;

import com.pw.dbconnection.models.Category;
import com.pw.dbconnection.models.Favorito;
import com.pw.dbconnection.models.Media;
import com.pw.dbconnection.models.Noticias;
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
public class FavoritoDAO {
        public static List<Noticias> getFavoritos(int usuario) {
        List<Noticias> news = new ArrayList<>();

        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL SP_VerFavoritos(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, usuario);
            statement.setInt(1, usuario);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                List<Media> Medias = new ArrayList<>();
                int id = result.getInt(1);
                int idCat = result.getInt(4);
                String title = result.getString(5);
                String descripcion = result.getString(6);
                String contenido = result.getString(7);               
                sql = "CALL SP_VerNotiMedia(?);";
                statement = con.prepareCall(sql);
                statement.setInt(1, id);
                ResultSet result2 = statement.executeQuery();
                while(result2.next()) {
                    int id2 = result2.getInt(1);
                    boolean tipo = result2.getBoolean(3);
                    String URL = result2.getString(4);
                    Medias.add(new Media(id2, tipo, URL));
                }                
                Category category = CategoryDAO.getCategory(idCat);
                news.add(new Noticias(id,title, descripcion,contenido, category,Medias));
            }
            return news;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NoticiasDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return news;
    }
        
    public static int insertFavorito(int idnoticia, int usuario) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL SP_NotiFav(?, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idnoticia);
            statement.setInt(2, usuario);

            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NoticiasDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }    
}
