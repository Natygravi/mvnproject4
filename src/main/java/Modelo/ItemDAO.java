/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author saudd
 */


public class ItemDAO {
    //private Connection conexion;
    
    public ItemDAO() {
        //Conexion con  = new Conexion();
        //this.conexion = con.getConexion();
        //System.out.println(conexion);
    }
    
    /*public void agregarItem(Item item) throws SQLException {
        Connection conexion;
        Conexion con  = new Conexion();
        conexion = con.getConexion();
        System.out.println(conexion);

        try {
            // 2. Crear una transacción
            conexion.setAutoCommit(false);

            // 3. Insertar el nuevo Item en la tabla item y obtener el ID generado automáticamente
            PreparedStatement itemStmt = conexion.prepareStatement("INSERT INTO item (prompt, respuesta, fuente, ejemploRelacionado, fuenteEjemplo) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            itemStmt.setString(1, item.getPrompt());
            itemStmt.setString(2, item.getRespuesta());
            itemStmt.setString(3, item.getFuente());
            itemStmt.setString(4, item.getEjemploRelacionado());
            itemStmt.setString(5, item.getFuenteEjemplo());
            itemStmt.executeUpdate();

            // Obtener el ID generado automáticamente del nuevo Item
            ResultSet itemKeys = itemStmt.getGeneratedKeys();
            itemKeys.next();
            int idItem = itemKeys.getInt(1);

            // 4. Insertar cada Valoración en la tabla valoracion asociado con el ID del nuevo Item
            PreparedStatement valoracionStmt = conexion.prepareStatement("INSERT INTO valoracion (estrellas, comentarios, id_item) VALUES (?, ?, ?)");
            for (Valoracion valoracion : item.getValoraciones()) {
                valoracionStmt.setInt(1, valoracion.getEstrellas());
                valoracionStmt.setString(2, valoracion.getComentarios());
                valoracionStmt.setInt(3, idItem);
                valoracionStmt.executeUpdate();
            }

            // 5. Confirmar la transacción
            conexion.commit();
        } catch (SQLException ex) {
            // 6. Manejar cualquier excepción
            conexion.rollback();
            throw ex;
        } finally {
            // Cerrar la conexión
            conexion.close();
        }
    }*/
    
    /*public void agregarItem(Item item) throws SQLException {
        
        PreparedStatement itemStmt = null;
        PreparedStatement valoracionStmt = null;
        try {
            // 2. Crear una transacción
            conexion.setAutoCommit(false);

            // 3. Insertar el nuevo Item en la tabla item y obtener el ID generado automáticamente
            itemStmt = conexion.prepareStatement("INSERT INTO item (prompt, respuesta, fuente, ejemploRelacionado, fuenteEjemplo) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            itemStmt.setString(1, item.getPrompt());
            itemStmt.setString(2, item.getRespuesta());
            itemStmt.setString(3, item.getFuente());
            itemStmt.setString(4, item.getEjemploRelacionado());
            itemStmt.setString(5, item.getFuenteEjemplo());
            itemStmt.executeUpdate();

            // Obtener el ID generado automáticamente del nuevo Item
            ResultSet itemKeys = itemStmt.getGeneratedKeys();
            itemKeys.next();
            int idItem = itemKeys.getInt(1);

            // 4. Insertar cada Valoración en la tabla valoracion asociado con el ID del nuevo Item
            valoracionStmt = conexion.prepareStatement("INSERT INTO valoracion (estrellas, comentarios, id_item) VALUES (?, ?, ?)");
            for (Valoracion valoracion : item.getValoraciones()) {
                valoracionStmt.setInt(1, valoracion.getEstrellas());
                valoracionStmt.setString(2, valoracion.getComentarios());
                valoracionStmt.setInt(3, idItem);
                valoracionStmt.executeUpdate();
            }

            // 5. Confirmar la transacción
            conexion.commit();
        } catch (SQLException ex) {
            // 6. Manejar cualquier excepción
            conexion.rollback();
            throw ex;
        } finally {
            // Cerrar el Prepared Statement y liberar sus recursos
            if (itemStmt != null) {
                itemStmt.close();
            }
            if (valoracionStmt != null) {
                valoracionStmt.close();
            }
        }

        // Cerrar la conexión
        conexion.close();
    }*/
    
    /*public boolean guardarItem(Item item) {
        boolean success = false;
        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO items (prompt, respuesta, fuente, ejemplo_relacionado, fuente_ejemplo) VALUES (?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(query);
            ps.setString(1, item.getPrompt());
            ps.setString(2, item.getRespuesta());
            ps.setString(3, item.getFuente());
            ps.setString(4, item.getEjemploRelacionado());
            ps.setString(5, item.getFuenteEjemplo());
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                success = true;
            }
        } catch (SQLException ex) {
            // Handle exception
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                // Handle exception
            }
        }
        return success;
    }*/
}