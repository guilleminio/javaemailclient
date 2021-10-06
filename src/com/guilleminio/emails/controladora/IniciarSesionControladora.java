/*
 * PROGRAMACION III - EXAMEN FINAL
 * MIÑO, GUILLE
 * INGENIERIA EN INFORMATICA - UAA
 * 3/08/2021
 */
package com.guilleminio.emails.controladora;

import com.guilleminio.emails.dao.DBConnector;
import com.guilleminio.emails.modelos.Usuarios;
import java.util.List;

/**
 *
 * @author Guille
 */
public class IniciarSesionControladora {
    
    private int usuarioActual;
    
    public boolean iniciarSesion( String aEmail, String aContrasenia){
    
        try{
            
            List<Usuarios> usuarios = DBConnector.getInstance().executeQuery("FROM Usuarios u WHERE u.emailUsuario = '" + aEmail + "' AND u.contraseniaUsuario = '" + aContrasenia + "'").list();
            
            if ( usuarios.size() == 1){
                this.usuarioActual = usuarios.get(0).getIdUsuario();
                return true;
            }
            
        }catch (Exception e){
            System.out.println(e.toString());
        }
        
        return false;
    }
    
    public int obtenerIdUsuario(){
        return this.usuarioActual;
    }
}
