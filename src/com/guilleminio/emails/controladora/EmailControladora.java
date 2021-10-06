/*
 * PROGRAMACION III - EXAMEN FINAL
 * MIÑO, GUILLE
 * INGENIERIA EN INFORMATICA - UAA
 * 3/08/2021
 */
package com.guilleminio.emails.controladora;

import com.guilleminio.emails.dao.DBConnector;
import com.guilleminio.emails.modelos.Contactos;
import com.guilleminio.emails.modelos.EmailEnvio;
import com.guilleminio.emails.modelos.Emails;
import com.guilleminio.emails.modelos.RespuestasPorEmail;
import com.guilleminio.emails.modelos.RespuestasPorEmailId;
import com.guilleminio.emails.modelos.Usuarios;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Guille
 */
public class EmailControladora {
    
    private Emails email;
    private Emails origenRespuesta;
    private Usuarios usuario;
    private Contactos contacto;
    
    public boolean obtenerUsuario( int aIdUsuario ){
        
        try{
            this.usuario = (Usuarios)DBConnector.getInstance().getSession().get(Usuarios.class, aIdUsuario);
            
            if ( this.usuario != null ){   
                DBConnector.getInstance().executeUpdate(usuario);
                return true;
            }
        
        }catch (Exception e){
            System.out.println(e.toString());
        }

        return false;
    }
    
    public boolean buscarContacto(int aIdContacto ){
        try{
            
            this.contacto = (Contactos)DBConnector.getInstance().getSession().get(Contactos.class, aIdContacto);
            
            if ( this.contacto != null )
                return true;
            
        }catch ( Exception e ){
            System.out.println(e.toString());
        }
        
        return false;
    }
    
    public Contactos obtenerContacto(){
        return this.contacto;
    }
    
    public void obtenerEmail( int aIdEmail ){
        try{
            
            this.email = (Emails)DBConnector.getInstance().getSession().get(Emails.class, aIdEmail);
        
        }catch ( Exception e ){
            System.out.println(e.toString());
        }
        
    }
    
    public void crearEmailBorrador(  ){
        this.email = new Emails();
        this.email.setUsuarios(this.usuario);
        this.email.setEstadoEmail(EmailEnvio.ESTADO_EMAIL_BORRADOR);
        this.email.setTipoEmail(EmailEnvio.class.getSimpleName());
        this.email.setAsuntoEmail("");
        this.email.setContenidoEmail("");
        Date fecha = new Date();
          Calendar calendario = Calendar.getInstance();
          calendario.setTime(fecha);
        this.email.setFechaCreacionEmailEnvio(fecha);
        this.enviarEmailBorrador("", "", "");
    }
    
    public void crearEmailBorrador( String aDestinatario ){
        this.email = new Emails();
        this.email.setUsuarios(this.usuario);
        this.email.setDestinoEmailEnvio(aDestinatario);
        this.email.setEstadoEmail(EmailEnvio.ESTADO_EMAIL_BORRADOR);
        this.email.setTipoEmail(EmailEnvio.class.getSimpleName());
        this.email.setAsuntoEmail("");
        this.email.setContenidoEmail("");
        Date fecha = new Date();
          Calendar calendario = Calendar.getInstance();
          calendario.setTime(fecha);
        this.email.setFechaCreacionEmailEnvio(fecha);
        this.enviarEmailBorrador("", "", "");
    }
    
    public boolean actualizarEmailBorrador(String aAsunto, String aDestinatario, String aContenido){
        
        try{
            this.email.setAsuntoEmail(aAsunto);
            this.email.setContenidoEmail(aContenido);
            this.email.setDestinoEmailEnvio(aDestinatario);
                
            DBConnector.getInstance().executeUpdate(this.email);
           
            return true;
            
        }catch (Exception e){
            System.out.println(e.toString());
        }
        
        return false;
        
    }
    
    public void actualizarEstadoEmailRecibido( ){
        try{
            this.email.setLeidoEmailRecibido(true);
            
            DBConnector.getInstance().executeUpdate(this.email);
           
        }catch( Exception e){
            System.out.println(e.toString());
        }
    }
    public boolean enviarEmailBorrador(String aAsunto,String aContenido,String aDestinatario){
        
        try{
          
          DBConnector.getInstance().executeInsert(this.email);
          return true;
        }catch ( Exception e){
          System.out.println(e.toString());
        }
        
        return false;
    }
    
    public boolean enviarEmail(String aAsunto,String aDestinatario, String aContenido){
      try{
          
          Date fecha = new Date();
          Calendar calendario = Calendar.getInstance();
          calendario.setTime(fecha);
          
          if ( this.email.getTipoEmail().equals(EmailEnvio.class.getSimpleName())){ 
         
            this.email.setAsuntoEmail(aAsunto);
            this.email.setContenidoEmail(aContenido);
            this.email.setEstadoEmail(EmailEnvio.ESTADO_EMAIL_ENVIADO);
            this.email.setFechaEnvioEmailEnvio(fecha);
            this.email.setDestinoEmailEnvio(aDestinatario);
          
            DBConnector.getInstance().executeUpdate(this.email);
          }
          else{
              
            Emails emailRespuesta = new Emails();
            emailRespuesta.setTipoEmail(EmailEnvio.class.getSimpleName());
            emailRespuesta.setUsuarios(this.usuario);
            emailRespuesta.setAsuntoEmail(aAsunto);
            emailRespuesta.setContenidoEmail(aContenido);
            emailRespuesta.setDestinoEmailEnvio(aDestinatario);
            emailRespuesta.setEstadoEmail(EmailEnvio.ESTADO_EMAIL_ENVIADO);
            emailRespuesta.setFechaEnvioEmailEnvio(fecha);
          
            DBConnector.getInstance().executeInsert(emailRespuesta);
            
            int idEmailRespuesta = DBConnector.getInstance().getLastId("SELECT max( idEmail ) FROM Emails");
            emailRespuesta.setIdEmail(idEmailRespuesta);
            
            int idRespuestaPorEmail = DBConnector.getInstance().getLastId("SELECT max( idRespuesta ) FROM Respuestas_por_email");
            idRespuestaPorEmail++;
            
            RespuestasPorEmailId emailRespuestaId = new RespuestasPorEmailId();
            emailRespuestaId.setIdRespuesta(idRespuestaPorEmail);
            emailRespuestaId.setIdEmailRespuesta(emailRespuesta.getIdEmail());
            
            RespuestasPorEmail respuesta = new RespuestasPorEmail();
            respuesta.setId(emailRespuestaId);
            respuesta.setEmailsByIdEmailRespuesta(emailRespuesta);
            respuesta.setEmailsByIdEmailOrigen(this.email);
            
            DBConnector.getInstance().executeInsert(respuesta);
          
          }
          
          return true;
          
      }catch ( Exception e){
          System.out.println(e.toString());
      }
      
      return false;
    }
    
    public boolean eliminarEmail(){
        try{
            DBConnector.getInstance().executeDelete(this.email);
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    }
    
    public boolean establecerEmailOrigenRespuesta( int aIdEmail ){
        
        try{
            
            List<RespuestasPorEmail> respuesta = DBConnector.getInstance().executeQuery("FROM RespuestasPorEmail WHERE idEmailRespuesta = "+ aIdEmail ).list();
            
            if ( respuesta.size() == 1){
                this.origenRespuesta = (Emails)DBConnector.getInstance().getSession().get(Emails.class, respuesta.get(0).getEmailsByIdEmailOrigen().getIdEmail()); 
                return true;
            }
            
        }catch( Exception e ){
            System.out.println(e.toString());
        }
        
        return false;
    }
    
    public Emails obtenerEmailActual(  ){
        return this.email;
    }
    
    public Emails obtenerEmailOrigenRespueta(){
        return this.origenRespuesta;
    }
    
}

