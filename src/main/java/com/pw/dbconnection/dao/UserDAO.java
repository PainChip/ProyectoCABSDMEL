/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.dbconnection.dao;

import com.pw.dbconnection.models.User;
import com.pw.dbconnection.utils.DbConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author magoc
 */
public class UserDAO {
    
//    CREATE TABLE `pw02`.`user` (
//    `idUser` INT NOT NULL AUTO_INCREMENT,
//    `username` VARCHAR(45) NULL,
//    `password` VARCHAR(45) NULL,
//    PRIMARY KEY (`idUser`),
//    UNIQUE INDEX `idUser_UNIQUE` (`idUser` ASC) VISIBLE,
//    UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);
    
    
//    USE `pw02`;
//    DROP procedure IF EXISTS `signIn`;
//
//    DELIMITER $$
//    USE `pw02`$$
//    CREATE PROCEDURE `signIn` (
//    IN `pUsername` varchar(45),
//    IN `pPassword` varchar(45)
//    )
//    BEGIN
//    INSERT INTO `user`
//    (`username`,
//    `password`)
//    VALUES
//    (pUsername,
//    pPassword);
//
//    END$$
//
//    DELIMITER ;


    public static int signInUser(User user) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            CallableStatement statement = con.prepareCall("call SP_AgregaUR(?,?,?)");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getCorreo());
            
            return statement.executeUpdate();
        }catch (SQLException ex) {
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
    
//    USE `pw02`;
//    DROP procedure IF EXISTS `logIn`;
//
//    DELIMITER $$
//    USE `pw02`$$
//    CREATE PROCEDURE `logIn` (
//    IN `pUsername` varchar(45),
//    IN `pPassword` varchar(45)
//    )
//    BEGIN
//    SELECT u.`idUser` ID,
//        u.`username`
//    FROM `user` u
//    WHERE
//            u.username = pUsername
//    AND
//            u.password = pPassword;
//    END$$
//
//    DELIMITER ;


    public static User logInUser(User user) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            CallableStatement statement = con.prepareCall("call SP_VerUR(?,?)");
            statement.setString(2, user.getUsername());
            statement.setString(1, user.getPassword());
            int id, id2 =0;
            String username, foto, rol;
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                id = result.getInt(1);
                username = result.getString(2);
                foto = result.getString(3);
                rol = "Usuario";
                statement = con.prepareCall("call SP_VerCC(?)");
                statement.setInt(1, id);
                ResultSet result2 = statement.executeQuery();
                while(result2.next()) {
                    id2 = result2.getInt(1);
                    rol = "CC";
                }
                if(id2 == 0){
                    statement = con.prepareCall("call SP_VerE(?)");
                    statement.setInt(1, id);
                    ResultSet result3 = statement.executeQuery();
                    while(result3.next()) {
                    id2 = result3.getInt(1);
                    rol = "E";
                    }
                }
                return new User(id, username, foto, rol, id2);  
            }
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
        return null;
    }
    
    public static int RedesFotoUser(User user) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL SP_EditaRedesFoto(?, ?, ?, ?, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, user.getId());            
            statement.setString(2, user.getFoto());
            statement.setString(3, user.getFace());
            statement.setString(4, user.getInsta());
            statement.setString(5, user.getTwitter());
            
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
    
    public static User getRedesFotoUser(int ID) {
        User news = null;

        Connection con = null;
        try {
            con = DbConnection.getConnection();
            
            String sql = "CALL SP_GetRedesFoto(?);";
            CallableStatement statement = con.prepareCall(sql);   
            statement.setInt(1,ID); 
            ResultSet result = statement.executeQuery();
            String nombre="", foto="", feis="", insta="", tuiter="";
            while (result.next()) {
                nombre = result.getString(1);
                foto = result.getString(2);
                feis = result.getString(3);
                insta = result.getString(4);
                tuiter = result.getString(5);               
                
            }
            return new User(nombre, foto,feis,tuiter,insta);
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
    
    public static User getUser(int idUser) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            CallableStatement statement = con.prepareCall("call SP_VerURID(?)");
            statement.setInt(1, idUser);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                String username = result.getString(2);
                String imagen = result.getString(3);
                return new User(id, username,imagen);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
}
