/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import DAO.CategoriaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author saudd
 */
public class Catalogo {
    private static Catalogo instancia = null;
    private List<Categoria> categorias;
    private CategoriaDAO categoriaDAO;

    private Catalogo() throws ClassNotFoundException, SQLException {
        categorias = new ArrayList<>();
        categoriaDAO = new CategoriaDAO();
        categorias.add(new Categoria("Refactoring","Descripcion 1"));
        categorias.add(new Categoria("Principios básicos de diseño","Descripcion 2"));
        categorias.add(new Categoria("Olores de software","Descripcion 3"));
        categorias.add(new Categoria("Deuda técnica","Descripcion 4"));
        categorias.add(new Categoria("Principios de diseño SOLID","Descripcion 5"));
        //categorias = categoriaDAO.obtenerCategoriasConItemsYValoraciones();
    }

    public static Catalogo obtenerInstancia() throws ClassNotFoundException, SQLException {
        if (instancia == null) {
            instancia = new Catalogo();
        }
        return instancia;
    }

    public List<Categoria> obtenerCategorias() {
        return categorias;
    }
    
    public int getCantidadCategorias(){
        return categorias.size();
    }
    
    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public void eliminarCategoria(Categoria categoria) {
        categorias.remove(categoria);
    }
    
    public void guardarCategorias() throws SQLException{
        categoriaDAO.guardarCategoriasConItemsYValoraciones(categorias);
    }
    
    public void insertarValoracionEjem(String promptSeleccionado, int estrellas, String comentarios) {

        // Aquí puedes acceder a la variable "categorias" para buscar el Item correspondiente al prompt seleccionado y agregarle la valoración
        // Paso 1: Buscar el Item correspondiente al prompt seleccionado
        Item item = null;
        for (Categoria categoria : categorias) {
            for (Item i : categoria.getItems()) {
                if (i.getPrompt().equals(promptSeleccionado)) {
                    item = i;
                    break;
                }
            }
            if (item != null) {
              break;
            }
        }


        // Paso 2: Insertar la valoración del usuario en la tabla Valoracion del Item encontrado
        if (item != null) {
            // Paso 2: Insertar la valoración del usuario en la tabla Valoracion del Item encontrado
            item.agregarValoracionEjm(estrellas,comentarios);
        } else {
            System.out.println("No se encontró ningún Item correspondiente al prompt seleccionado.");
        }
    }
    
    public void insertarValoracionRes(String promptSeleccionado, int estrellas, String comentarios) {

        // Aquí puedes acceder a la variable "categorias" para buscar el Item correspondiente al prompt seleccionado y agregarle la valoración
        // Paso 1: Buscar el Item correspondiente al prompt seleccionado
        Item item = null;
        for (Categoria categoria : categorias) {
            for (Item i : categoria.getItems()) {
                if (i.getPrompt().equals(promptSeleccionado)) {
                    item = i;
                    break;
                }
            }
            if (item != null) {
              break;
            }
        }


        // Paso 2: Insertar la valoración del usuario en la tabla Valoracion del Item encontrado
        if (item != null) {
            // Paso 2: Insertar la valoración del usuario en la tabla Valoracion del Item encontrado
            item.agregarValoracionRes(estrellas,comentarios);
        } else {
            System.out.println("No se encontró ningún Item correspondiente al prompt seleccionado.");
        }
    }
}
