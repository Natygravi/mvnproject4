/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import DAO.ItemDAO;
import Modelo.Catalogo;
import Modelo.Categoria;
import Modelo.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author saudd
 */
public class consultarTopServlet extends HttpServlet {

    private final List<Item> items = new ArrayList<>();
    List<Categoria> categorias;
    //Sprivate final List<Categoria> categorias = new ArrayList<>();
    private Catalogo main;
    
    @Override
    public void init() throws ServletException {

        try {
            main = Catalogo.obtenerInstancia();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrarItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("vistas/consultarTop.jsp").forward(request, response);
    }
    
    @Override
     public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
         categorias = main.obtenerCategorias();
         
         //Cargar las categorias
         //Cargar los items
         //Realizar los filtros
         //filtro respuesta/ejemplo/ambas
         //filtro fuente respuesta admin/chatGPT/ambas
         //filtro fuente ejemplo admin/chatGPT/ambas
         //filtro cantidad items
         
        List<String> items = null;
        String categoria = "";
        ItemDAO itemDAO;
        try {
            // Obtener el valor del parámetro categoria
            categoria = request.getParameter("categoria");
            
            
            // Establecer la conexión con la base de datos MySQL
            
            itemDAO = new ItemDAO();
            // Consultar la base de datos para obtener los items de la categoría seleccionada
            items = itemDAO.getItemsByCategoria(categoria);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("items", items);
        request.setAttribute("categoria", categoria);
        request.getRequestDispatcher("vistas/mostrarPrompts.jsp").forward(request, response);
       
    }
     
     /*public List<Item> consultarTopItems(ArrayList<Item> itemsRegistrados,int x, boolean considerarRespuestas, boolean considerarEjemplos, boolean considerarAdmin, boolean considerarChatGPT) {
        List<Item> itemsFiltrados = new ArrayList<Item>();

        for (Item item : itemsRegistrados) {
            boolean incluirItem = false;

            // Filtrar por valoraciones iguales o superiores a 4
            double valoracionPromedio = item.calcularPromedioValoraciones(considerarEjemplos);
            if (valoracionPromedio >= 4) {
                // Filtrar por tipo de valoraciones
                if (considerarRespuestas && considerarEjemplos) {
                    incluirItem = true;
                } else if (considerarRespuestas && !considerarEjemplos) {
                    if (!item.getValoracionesRespuesta().isEmpty()) {
                        incluirItem = true;
                    }
                } else if (!considerarRespuestas && considerarEjemplos) {
                    if (!item.getValoracionesEjemplo().isEmpty()) {
                        incluirItem = true;
                    }
                }
                // Filtrar por fuente de respuestas
                if (incluirItem && (considerarAdmin || considerarChatGPT)) {
                    boolean incluirAdmin = considerarAdmin && item.getRespuestaAdmin() != null;
                    boolean incluirChatGPT = considerarChatGPT && item.getRespuestaChatGPT() != null;
                    incluirItem = incluirAdmin || incluirChatGPT;
                }
                // Filtrar por fuente de ejemplos
                if (incluirItem && (considerarAdmin || considerarChatGPT)) {
                    boolean incluirAdmin = considerarAdmin && item.getEjemploAdmin() != null;
                    boolean incluirChatGPT = considerarChatGPT && item.getEjemploChatGPT() != null;
                    incluirItem = incluirAdmin || incluirChatGPT;
                }
            }

            if (incluirItem) {
                itemsFiltrados.add(item);
            }
        }

        return itemsFiltrados;
    }*/
    
}
