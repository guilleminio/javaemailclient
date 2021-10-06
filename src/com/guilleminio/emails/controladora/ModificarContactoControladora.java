/*
 * PROGRAMACION III - EXAMEN FINAL
 * MIÑO, GUILLE
 * INGENIERIA EN INFORMATICA - UAA
 * 3/08/2021
 */
package com.guilleminio.emails.controladora;

import com.guilleminio.emails.dao.DBConnector;
import com.guilleminio.emails.modelos.Contactos;
import com.guilleminio.emails.modelos.Usuarios;

/**
 *
 * @author Guille
 */
public class ModificarContactoControladora {
    
    private Contactos contacto;
    private Usuarios usuario;
    
    public void establecerUsuario( int aIdUsuario ){
        
        try{
        
            this.usuario = (Usuarios)DBConnector.getInstance().getSession().get(Usuarios.class, aIdUsuario );
            
        }catch ( Exception e ){
            System.out.println(e.toString());
        }
    }
    
    public Usuarios obtenerUsuario(){
        return this.usuario;
    }
    
    public void establecerContacto( int aIdContacto ){
        
        try{
        
            this.contacto = (Contactos)DBConnector.getInstance().getSession().get(Contactos.class, aIdContacto );
            
        }catch ( Exception e ){
            System.out.println(e.toString());
        }
        
    }
    
    public Contactos obtenerContacto(){
        return this.contacto;
    }
    
    public boolean actualizarContacto( String aNombre, String aApellido, String aEmail ){
        
        try{
        
            this.contacto.setNombreContacto(aNombre);
            this.contacto.setApellidoContacto(aApellido);
            this.contacto.setEmailContacto(aEmail);
            
            DBConnector.getInstance().executeUpdate(this.contacto);
            
            return true;
            
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return false;
    }
    
    public boolean agregarContacto( String aNombre, String aApellido, String aEmail){
        
        try{
        
            Contactos nuevoContacto = new Contactos(this.usuario,aNombre,aApellido,aEmail,"");
            
            DBConnector.getInstance().executeInsert(nuevoContacto);
            
            return true;
            
        }catch(Exception e){
            System.out.println(e.toString());
        }
        
        return false;
    }
    
    public boolean eliminarContacto(){
        try{
            DBConnector.getInstance().executeDelete(this.contacto);
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    }
}
