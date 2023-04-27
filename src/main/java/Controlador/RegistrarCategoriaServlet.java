/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Catalogo;
import Modelo.Categoria;
import Modelo.Item;
import Modelo.ListaDesplegable;
import config.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/RegistrarCategoriaServlet")
public class RegistrarCategoriaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Catalogo catalogo;
    List<Categoria> categorias;
    
    @Override
    public void init() throws ServletException {
        try {
            catalogo = Catalogo.obtenerInstancia();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrarItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        System.out.println(nombre);
        String descripcion = request.getParameter("descripcion");
        System.out.println(descripcion);
        String cursos = request.getParameter("curso");
        System.out.println(cursos);
        
        Categoria cat=new Categoria(nombre,descripcion);
        catalogo.agregarCategoria(cat);
        /*cat.setCodigo(nombre);
        
    try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrarItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    try (Connection conexion  = DriverManager.getConnection("jdbc:mysql://servidoratitup.mysql.database.azure.com", "adminNaty", "Coquito2022?")){
        PreparedStatement pstmt = null;
        String query = "INSERT INTO categoria (codigo,nombre, descripcion,Cursos,items) VALUES (?, ?, ?)";
        pstmt = conexion.prepareStatement(query);
        pstmt.setString(1, cat.getCodigo());
        pstmt.setString(2, nombre);
        pstmt.setString(3, descripcion);
        //pstmt.setString(4, cursos);
        System.out.println(pstmt);
        pstmt.executeUpdate();
        System.out.println("exitoso");
        } 
    catch (SQLException e) {
        e.printStackTrace();
        } */
        
              
        request.setAttribute("nombre", nombre);
        request.setAttribute("descripcion", descripcion);
        request.setAttribute("cursos", cursos);
        //request.setAttribute("listaDesplegable2", listaDesplegable2);
        
        
        request.getRequestDispatcher("Exitosamente.jsp").forward(request, response);
    }
    
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrarItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<ListaDesplegable> opcionesListaCursos = ListaDesplegable.obtenerOpcionesDesdeBD("Cursos", "id", "nombre");
        request.setAttribute("opcionesListaCursos", opcionesListaCursos);
        request.getRequestDispatcher("registrarCategoria.jsp").forward(request, response);
 
    }
}
    
