/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.ListaDesplegable;
import java.util.ArrayList;

/**
 *
 * @author saudd
 */
public class UsuarioDAO {
    
    public UsuarioDAO(){
}
    
    ArrayList<ListaDesplegable> usuarios=ListaDesplegable.obtenerOpcionesDesdeBD("usuarios", "tipo", "email");
      
    private boolean existeUsuario(String correo){
        for(ListaDesplegable usuario:usuarios){
            if(usuario.getTexto().equals(correo)){
                return true;
            }
        }
        return false;
    }
    private ListaDesplegable getUsuario(String correo){ 
            for(ListaDesplegable usuario:usuarios){
                if(usuario.getTexto().equals(correo)){
                return usuario;
                }
                
    }
        return null;
    }
    
        
  public int verificarTipoUsuario(String correo){
        int encontrado;
        
        if(existeUsuario(correo)){
            ListaDesplegable user=getUsuario(correo);
            return Integer.parseInt(user.getValor());
        } 
        else {
            return 0;
        }
        
        }
    

}
