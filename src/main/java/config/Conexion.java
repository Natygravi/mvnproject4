/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author saudd
 */
public class Conexion {
        
    public Connection getConexion(){
        
       String url = "jdbc:mysql://servidoratitup.mysql.database.azure.com:3306/disennoDB?useSSL=TRUE";
       String usuario = "adminNaty";
       String contraseña = "Coquito2022?";
       
       try (Connection conn = DriverManager.getConnection(url, usuario, contraseña)) {
           System.out.println("Conexion exitosa!!");
            return conn;
        } catch (SQLException e) {
          System.out.println(e.toString());
          return null;
        }
    }
}
