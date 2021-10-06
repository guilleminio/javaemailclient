/*
 * PROGRAMACION III - EXAMEN FINAL
 * MIÑO, GUILLE
 * INGENIERIA EN INFORMATICA - UAA
 * 3/08/2021
 */
package com.guilleminio.emails.controladora;

import com.guilleminio.emails.dao.DBConnector;
import com.guilleminio.emails.modelos.Contactos;
import java.util.List;

/**
 *
 * @author Guille
 */
public class ContactosControladora {
    
    
    private List<Contactos> contactos;
    
    public boolean establecerContactos( int aIdUsuario ){
        
        try{
            this.contactos = DBConnector.getInstance().executeQuery("FROM Contactos WHERE idUsuario = " + aIdUsuario).list();
            
            if ( this.contactos.size()>0)
                return true;
            
        }catch( Exception e){
            System.out.println(e.toString());
        }
        return false;
    }
    
    public Contactos obtenerContacto( int aIndex ){
        return this.contactos.get(aIndex);
    }
    
    public int obtenerTotalContactos(){
        return this.contactos.size();
    }
    
}
