/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.dbconnection.dao;

import com.pw.dbconnection.models.Category;
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
public class NoticiasDAO {
    
    public static int insertNoticia(Noticias news) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL SP_AgregaNotE(?, ?, ?, ?, ?);";
            String QueRol = news.getRol();
            if(QueRol.equals("CC") == true){
                sql = "CALL SP_AgregaNotCC(?, ?, ?, ?, ?);";
            }
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, news.getCategory().getId());            
            statement.setString(2, news.getTitle());
            statement.setString(3, news.getDescription());
            statement.setString(4, news.getContenido());
            statement.setInt(5, news.getIdRol());
            
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
    
    public static int insertNoticiaAceptado(Noticias news) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL SP_AceptaNoti(?,?);";
            int idNoti = news.getId();
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idNoti);
            statement.setInt(2, 1);
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
     
    public static int insertNoticiaRechazado(Noticias news) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL SP_RechazaNoti(?,?,?);";
            int idNoti = news.getId();
            String respuestafinal = news.getRespuesta();
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idNoti);
            statement.setInt(2, 2);
            statement.setString(3, respuestafinal);
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
    
    public static List<Noticias> getNoticias() {
        List<Noticias> news = new ArrayList<>();

        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL SP_VerAllNoti();";
            CallableStatement statement = con.prepareCall(sql);
            
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                List<Media> Medias = new ArrayList<>();
                int id = result.getInt(1);
                int idCat = result.getInt(2);
                String title = result.getString(3);
                String descripcion = result.getString(4);
                String contenido = result.getString(5);               
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
        public static List<Noticias> getIndexNoticias() {
        List<Noticias> news = new ArrayList<>();

        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL SP_VerAllNotIndex();";
            CallableStatement statement = con.prepareCall(sql);
            
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                List<Media> Medias = new ArrayList<>();
                int id = result.getInt(1);
                int idCat = result.getInt(2);
                String title = result.getString(3);
                String descripcion = result.getString(4);
                String contenido = result.getString(5);               
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
    public static List<Noticias> getNoticias(String buscador) {
        List<Noticias> news = new ArrayList<>();

        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL SP_VerNotiBusca(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, buscador);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                List<Media> Medias = new ArrayList<>();
                int id = result.getInt(1);
                int idCat = result.getInt(2);
                String title = result.getString(3);
                String descripcion = result.getString(4);
                String contenido = result.getString(5);               
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
    
    public static List<Noticias> getNoticias(int categoria) {
        List<Noticias> news = new ArrayList<>();

        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL SP_VerAllNotiCat(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, categoria);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                List<Media> Medias = new ArrayList<>();
                int id = result.getInt(1);
                int idCat = result.getInt(2);
                String title = result.getString(3);
                String descripcion = result.getString(4);
                String contenido = result.getString(5);               
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
    
    public static List<Noticias> get3Noticias() {
        List<Noticias> Noticias3 = new ArrayList<>();

        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL SP_Ver3Noti();";
            CallableStatement statement = con.prepareCall(sql);
            
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                List<Media> MediaRevisar = new ArrayList<>();
                int id = result.getInt(1); //idNoticia
                String title = result.getString(3); //Titulo
                String descripcion = result.getString(4); //Descripcion
                sql = "CALL SP_VerNotiMedia(?);";
                statement = con.prepareCall(sql);
                statement.setInt(1, id);
                ResultSet result2 = statement.executeQuery();
                while(result2.next()) {
                    int id2 = result2.getInt(1);
                    boolean tipo = result2.getBoolean(3);
                    String URL = result2.getString(4);
                    MediaRevisar.add(new Media(id2, tipo, URL));
                }                
                Noticias3.add(new Noticias(id,title, descripcion,MediaRevisar));
            }
            return Noticias3;
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

        return Noticias3;
    }
    
    public static List<Noticias> get3Noticias(int categoria) {
        List<Noticias> news = new ArrayList<>();

        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL SP_Ver3NotiCat(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, categoria);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                List<Media> Medias = new ArrayList<>();
                int id = result.getInt(1);
                int idCat = result.getInt(2);
                String title = result.getString(3);
                String descripcion = result.getString(4);
                String contenido = result.getString(5);               
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
    
    public static List<Noticias> getNoticiasEdicion()
    {
        List<Noticias> NoticiasRevisar = new ArrayList<>();

        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL SP_VerAllNotiRevisa();";
            CallableStatement statement = con.prepareCall(sql);
            
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                List<Media> MediaRevisar = new ArrayList<>();
                int id = result.getInt(1); //idNoticia
                String title = result.getString(3); //Titulo
                String descripcion = result.getString(4); //Descripcion
                sql = "CALL SP_VerNotiMedia(?);";
                statement = con.prepareCall(sql);
                statement.setInt(1, id);
                ResultSet result2 = statement.executeQuery();
                while(result2.next()) {
                    int id2 = result2.getInt(1);
                    boolean tipo = result2.getBoolean(3);
                    String URL = result2.getString(4);
                    MediaRevisar.add(new Media(id2, tipo, URL));
                }                
                NoticiasRevisar.add(new Noticias(id,title, descripcion,MediaRevisar));
            }
            return NoticiasRevisar;
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

        return NoticiasRevisar;
    }
    public static Noticias getNoticiaEspecifica(int idNoticia) {
        Noticias lanoticia = null;
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL SP_VerNoti(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idNoticia);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                List<Media> Medias = new ArrayList<>();
                int id = result.getInt(1);
                int idCat = result.getInt(2);
                String title = result.getString(3);
                String descripcion = result.getString(4);
                String contenido = result.getString(5);               
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
                lanoticia = new Noticias(id,title, descripcion,contenido, category,Medias);
            }
            return lanoticia;
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
        return lanoticia;
    }    
    public static int getNoticiaMediaID(Noticias nueva){
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL SP_NotiRecienIns(?, ?, ?, ?);";
            CallableStatement statement = con.prepareCall(sql);

            statement.setInt(1, nueva.getCategory().getId());            
            statement.setString(2, nueva.getTitle());
            statement.setString(3, nueva.getDescription());
            statement.setString(4, nueva.getContenido());
            
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int id = result.getInt(1);
                return id;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Noticias.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }
}
