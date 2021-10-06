/*
 * PROGRAMACION III - EXAMEN FINAL
 * MIÑO, GUILLE
 * INGENIERIA EN INFORMATICA - UAA
 * 3/08/2021
 */
package com.guilleminio.emails.controladora;

import com.guilleminio.emails.dao.DBConnector;
import com.guilleminio.emails.modelos.Usuarios;

/**
 *
 * @author Guille
 */
public class ModificarCuentaControladora {
    
    private Usuarios usuario;
    
    public boolean buscarUsuario(int aIdUsuario ){
        
        try{
            this.usuario = (Usuarios)DBConnector.getInstance().getSession().get(Usuarios.class,aIdUsuario);
        
            return true;
            
        }catch( Exception e ){
            System.out.println(e.toString());
        }
        
        return false;
    }
    
    public Usuarios obtenerUsuario(){
        return this.usuario;
    }
    
    public boolean actualizarContrasenia(String aContrasenia){
        try{
            
            this.usuario.setContraseniaUsuario(aContrasenia);
            
            DBConnector.getInstance().executeUpdate(this.usuario);
            
            return true;
            
        }catch( Exception e){
            System.out.println(e.toString());
        }
        
        return false;
    }
    public boolean actualizarUsuario(String aNombre, String aApellido, String aImagenPerfil ){
     
        try{
            
            this.usuario.setNombreUsuario(aNombre);
            this.usuario.setApellidoUsuario(aApellido);
            this.usuario.setImagenPathUsuario(aImagenPerfil);
            
            DBConnector.getInstance().executeUpdate(this.usuario);
            
            return true;
            
        }catch( Exception e){
            System.out.println(e.toString());
        }
        
        return false;
    }
    
}
