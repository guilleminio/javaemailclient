/*
 * PROGRAMACION III - EXAMEN FINAL
 * MIÑO, GUILLE
 * INGENIERIA EN INFORMATICA - UAA
 * 3/08/2021
 */
package com.guilleminio.emails.controladora;

import com.guilleminio.emails.dao.DBConnector;
import com.guilleminio.emails.modelos.Usuarios;
import java.util.Date;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Guille
 */
public class CrearCuentaControladora {
    
    public boolean existeUsuario( String aEmail ){
        
        try{
            List<Usuarios> usuario = DBConnector.getInstance().executeQuery("FROM Usuarios u WHERE u.emailUsuario = '" + aEmail+"'").list();
            
            if (usuario.size()>0)
                return true;
            
        }catch( Exception e){
             System.out.println(e.toString());
             return true;
        }
        
        return false;
    }
    
    public boolean agregarUsuario( String aNombre, String aApellido, String aEmail, String aContrasenia, Date aFechaAlta ){
        
        try{
            
            Usuarios usuario = new Usuarios(aNombre,aApellido,aEmail,aContrasenia,aFechaAlta);
        
            DBConnector.getInstance().executeUpdate(usuario);
            
            return true;
        }catch (ConstraintViolationException e){
            System.out.println(e.toString());
        }
        
        return false;
    }
    
    public int obtenerUltimoUsuarioAgregado(){
        
        try{
            return DBConnector.getInstance().getLastId("SELECT max( idUsuario ) FROM Usuarios");
        
        }catch(Exception e){
            
             System.out.println(e.toString());
        }
        return -1;
    }
    
    public boolean agregarImagenUsuario( int aIdUsuario, String aUrlImagePath){
        
        try{
            
            Usuarios usuario = (Usuarios)DBConnector.getInstance().getSession().get(Usuarios.class, aIdUsuario);
            
            usuario.setImagenPathUsuario(aUrlImagePath);
                
            DBConnector.getInstance().executeUpdate(usuario);
           
            return true;
            
        }catch (Exception e){
            System.out.println(e.toString());
        }
        
        return false;
    }
}
