/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import Modelo.Valoracion;

/**
 *
 * @author saudd
 */
public class Item implements Comparable{
    private int codigo;
    private String prompt;
    private String respuesta;
    private String fuente;
    private String ejemploRelacionado;
    private String fuenteEjemplo;
    private ArrayList<Valoracion> valoracionesRespuesta;
    private ArrayList<Valoracion> valoracionesEjemplo;
    
    
    public Item(String prompt, String respuesta, String fuente, String ejemploRelacionado, String fuenteEjemplo) {
        
        this.prompt = prompt;
        this.respuesta = respuesta;
        this.fuente = fuente;
        this.ejemploRelacionado = ejemploRelacionado;
        this.fuenteEjemplo = fuenteEjemplo;
        this.valoracionesRespuesta = new ArrayList<>();
        this.valoracionesEjemplo = new ArrayList<>();
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    

    public String getEjemploRelacionado() {
        return ejemploRelacionado;
    }

    public void setEjemploRelacionado(String ejemploRelacionado) {
        this.ejemploRelacionado = ejemploRelacionado;
    }

    public String getFuenteEjemplo() {
        return fuenteEjemplo;
    }

    public void setFuenteEjemplo(String fuenteEjemplo) {
        this.fuenteEjemplo = fuenteEjemplo;
    }

    public ArrayList<Valoracion> getValoracionesRes() {
        return valoracionesRespuesta;
    }
    
    public ArrayList<Valoracion> getValoracionesEjm() {
        return valoracionesEjemplo;
    }
    
    


    public void agregarValoracionRes(int estrellas,String comentario) {
        Valoracion nuevaValoracion = new Valoracion(estrellas,comentario);
        valoracionesRespuesta.add(nuevaValoracion);
    }
    
    public void agregarValoracionEjm(int estrellas,String comentario) {
        Valoracion nuevaValoracion = new Valoracion(estrellas,comentario);
        valoracionesEjemplo.add(nuevaValoracion);
    }

    // Método para eliminar un curso de la lista de cursos
   /* public void eliminarValoracion(Valoracion var) {
        valoraciones.remove(var);
    }*/
    
    @Override
    public boolean menorQue(Comparable obj){
        return (this.prompt.compareTo(((Item)obj).prompt)<0);
    }
    
    public double calcularPromedioValoraciones(boolean considerarEjemplos){
        int sumaEstrellas = 0;
        int cantidadValoraciones = 0;
        
        // Calcula la suma total de estrellas y la cantidad de valoraciones
        for (Valoracion v : valoracionesRespuesta) {
            if (v.getEstrellas() >= 4) {
                sumaEstrellas += v.getEstrellas();
                cantidadValoraciones++;
            }
        }
        if (considerarEjemplos) {
            for (Valoracion v : valoracionesEjemplo) {
                if (v.getEstrellas() >= 4) {
                    sumaEstrellas += v.getEstrellas();
                    cantidadValoraciones++;
                }
            }
        }
        
        // Calcula el promedio
        if (cantidadValoraciones > 0) {
            return (double) sumaEstrellas / cantidadValoraciones;
        } else {
            return 0;
        }
    }
    public double promedioValoracionesRes() {
        if (valoracionesRespuesta.isEmpty()) {
            return 0;
        }
        int totalEstrellas = 0;
        for (Valoracion v : valoracionesRespuesta) {
            totalEstrellas += v.getEstrellas();
        }
        return (double) totalEstrellas / valoracionesRespuesta.size();
    }
    
    public double promedioValoracionesEjm() {
        if (valoracionesEjemplo.isEmpty()) {
            return 0;
        }
        int totalEstrellas = 0;
        for (Valoracion v : valoracionesEjemplo) {
            totalEstrellas += v.getEstrellas();
        }
        return (double) totalEstrellas / valoracionesRespuesta.size();
    }

    public ArrayList<Valoracion> getValoracionesRespuesta() {
        return valoracionesRespuesta;
    }

    public ArrayList<Valoracion> getValoracionesEjemplo() {
        return valoracionesEjemplo;
    }

    @Override
    public String toString() {
        return "Item{" + "codigo=" + codigo + ", prompt=" + prompt + ", respuesta=" + respuesta + ", fuente=" + fuente + ", ejemploRelacionado=" + ejemploRelacionado + ", fuenteEjemplo=" + fuenteEjemplo + ", valoracionesRespuesta=" + valoracionesRespuesta + ", valoracionesEjemplo=" + valoracionesEjemplo + '}';
    }


}
