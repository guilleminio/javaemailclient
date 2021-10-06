/*
 * PROGRAMACION III - EXAMEN FINAL
 * MIÑO, GUILLE
 * INGENIERIA EN INFORMATICA - UAA
 * 3/08/2021
 */
package com.guilleminio.emails.controladora;

import com.guilleminio.emails.dao.DBConnector;
import com.guilleminio.emails.modelos.EmailEnvio;
import com.guilleminio.emails.modelos.EmailRecibido;
import com.guilleminio.emails.modelos.Emails;
import com.guilleminio.emails.modelos.Usuarios;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Guille
 */
public class PrincipalControladora {
    
    public static final int LISTADO_RECIBIDOS = 0;
    public static final int LISTADO_ENVIADOS = 1;
    public static final int LISTADO_BORRADORES = 2;
    
    private Usuarios usuario;
    private Emails emailActual;
    
    private List<Emails> emails;
    private ArrayList<Emails> enviados;
    private ArrayList<Emails> recibidos;
    private ArrayList<Emails> borradores;
    
    private int tipoEmailListado;
    
    public boolean obtenerUsuario( int aIdUsuario ){
        
        try{
            
            this.usuario = (Usuarios)DBConnector.getInstance().getSession().get(Usuarios.class, aIdUsuario);
            
            if ( this.usuario != null)
                return true;
        }catch( Exception e){
            System.out.println(e.toString());
        }
        
        return false;
    }
    
    public Usuarios obtenerUsuarioActual(){
        return this.usuario;
    }
    
    public void establecerEmailActual(int aId ){
    
        switch ( this.tipoEmailListado ){
            case PrincipalControladora.LISTADO_RECIBIDOS:
               this.emailActual= this.recibidos.get(aId);
               break;
            case PrincipalControladora.LISTADO_ENVIADOS:
               this.emailActual = this.enviados.get(aId);
               break;
            case PrincipalControladora.LISTADO_BORRADORES:
               this.emailActual = this.borradores.get(aId);
               break;
        }
       
    }
    
    public Emails obtenerEmailActual(){
        return this.emailActual;
    }
    
    public void establecerListadoEmailsRecibidos(){
        
        try{
            this.recibidos = new ArrayList<Emails>();
            
            if ( this.emails != null )
                this.emails.clear();
            
           
            this.emails = DBConnector.getInstance().executeQuery("FROM Emails WHERE tipoEmail = '" + EmailRecibido.class.getSimpleName()+ "' AND idUsuario = " + this.usuario.getIdUsuario()).list();
            
            for ( Emails email : this.emails){
                    EmailRecibido recibido = new EmailRecibido(email.getUsuarios(),email.getAsuntoEmail(),email.getContenidoEmail(),email.getEstadoEmail(),email.getOrigenEmailRecibido(),email.getFechaLlegadaEmailRecibido(),email.isLeidoEmailRecibido());
                    recibido.setIdEmail(email.getIdEmail());
                    this.recibidos.add(recibido);
            }
            
            Collections.sort(recibidos, new Comparator<Emails>() {
                @Override
                public int compare(Emails o1, Emails o2) {
                 return o2.getFechaLlegadaEmailRecibido().compareTo(o1.getFechaLlegadaEmailRecibido());
                }
            });
            
            
        }catch( Exception e){
            System.out.println(e.toString());
        }
        
    }
    
    public void establecerListadoEmailsEnviados(){
        
        try{
            
            this.enviados = new ArrayList<Emails>();
            
            if ( this.emails != null )
                this.emails.clear();
            
            this.emails = DBConnector.getInstance().executeQuery("FROM Emails WHERE tipoEmail = '" + EmailEnvio.class.getSimpleName()+ "' AND estadoEmail= '" + EmailEnvio.ESTADO_EMAIL_ENVIADO + "' AND idUsuario = " + this.usuario.getIdUsuario()).list();
         
            for ( Emails email : this.emails){
                EmailEnvio enviado = new EmailEnvio(email.getUsuarios(),email.getAsuntoEmail(),email.getContenidoEmail(),email.getEstadoEmail(),email.getFechaCreacionEmailEnvio(),email.getFechaEnvioEmailEnvio(),email.getDestinoEmailEnvio());
                enviado.setIdEmail(email.getIdEmail());
                this.enviados.add(enviado);
            }
            
            Collections.sort(enviados, new Comparator<Emails>() {
                @Override
                public int compare(Emails o1, Emails o2) {
                 return o2.getFechaEnvioEmailEnvio().compareTo(o1.getFechaEnvioEmailEnvio());
                }
            });
            
            
        }catch( Exception e){
            System.out.println(e.toString());
        }
        
    }
    
    public void establecerListadoEmailsBorradores(){
        
        try{
            
            this.borradores = new ArrayList<Emails>();
            
            if ( this.emails != null )
                this.emails.clear();
            
            this.emails = DBConnector.getInstance().executeQuery("FROM Emails WHERE tipoEmail = '" + EmailEnvio.class.getSimpleName()+ "' AND estadoEmail= '" + EmailEnvio.ESTADO_EMAIL_BORRADOR + "' AND idUsuario = " + this.usuario.getIdUsuario()).list();
         
            for ( Emails email : this.emails){
                  EmailEnvio enviado = new EmailEnvio(email.getUsuarios(),email.getAsuntoEmail(),email.getContenidoEmail(),email.getEstadoEmail(),email.getFechaCreacionEmailEnvio(),email.getFechaEnvioEmailEnvio(),email.getDestinoEmailEnvio());
                  enviado.setIdEmail(email.getIdEmail());
                  this.borradores.add(enviado);
            }
            
            Collections.sort(borradores, new Comparator<Emails>() {
                @Override
                public int compare(Emails o1, Emails o2) {
                 return o2.getFechaCreacionEmailEnvio().compareTo(o1.getFechaCreacionEmailEnvio());
                }
            });
            
        }catch( Exception e){
            System.out.println(e.toString());
        }
        
    }
    
    public ArrayList<Emails> obtenerListadoEmails( int aTipo){
        
        this.tipoEmailListado = aTipo;
        
        switch (this.tipoEmailListado){
            case PrincipalControladora.LISTADO_RECIBIDOS:
                return this.recibidos;
            case PrincipalControladora.LISTADO_ENVIADOS:
                return this.enviados;
            case PrincipalControladora.LISTADO_BORRADORES:
                return this.borradores;     
        }
        
        return null;
    }
    
   
    
}   


