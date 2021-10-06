package com.guilleminio.emails.modelos;
// Generated 01-ago-2021 6:53:46 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Emails generated by hbm2java
 */
public class Emails  implements java.io.Serializable {


     private Integer idEmail;
     private Usuarios usuarios;
     private String tipoEmail;
     private String asuntoEmail;
     private String contenidoEmail;
     private String estadoEmail;
     private Date fechaCreacionEmailEnvio;
     private Date fechaEnvioEmailEnvio;
     private String destinoEmailEnvio;
     private String origenEmailRecibido;
     private Date fechaLlegadaEmailRecibido;
     private boolean leidoEmailRecibido;
     private Set respuestasPorEmailsForIdEmailRespuesta = new HashSet(0);
     private Set respuestasPorEmailsForIdEmailOrigen = new HashSet(0);

    public Emails() {
    }

	
    public Emails(Usuarios usuarios, String tipoEmail, String estadoEmail, boolean leidoEmailRecibido) {
        this.usuarios = usuarios;
        this.tipoEmail = tipoEmail;
        this.estadoEmail = estadoEmail;
        this.leidoEmailRecibido = leidoEmailRecibido;
    }
    public Emails(Usuarios usuarios, String tipoEmail, String asuntoEmail, String contenidoEmail, String estadoEmail, Date fechaCreacionEmailEnvio, Date fechaEnvioEmailEnvio, String destinoEmailEnvio, String origenEmailRecibido, Date fechaLlegadaEmailRecibido, boolean leidoEmailRecibido, Set respuestasPorEmailsForIdEmailRespuesta, Set respuestasPorEmailsForIdEmailOrigen) {
       this.usuarios = usuarios;
       this.tipoEmail = tipoEmail;
       this.asuntoEmail = asuntoEmail;
       this.contenidoEmail = contenidoEmail;
       this.estadoEmail = estadoEmail;
       this.fechaCreacionEmailEnvio = fechaCreacionEmailEnvio;
       this.fechaEnvioEmailEnvio = fechaEnvioEmailEnvio;
       this.destinoEmailEnvio = destinoEmailEnvio;
       this.origenEmailRecibido = origenEmailRecibido;
       this.fechaLlegadaEmailRecibido = fechaLlegadaEmailRecibido;
       this.leidoEmailRecibido = leidoEmailRecibido;
       this.respuestasPorEmailsForIdEmailRespuesta = respuestasPorEmailsForIdEmailRespuesta;
       this.respuestasPorEmailsForIdEmailOrigen = respuestasPorEmailsForIdEmailOrigen;
    }
   
      /*-------------------CONSTRUCTORES ADICIONALES-------------------*/
    public Emails(Usuarios usuario, String tipoEmail, String estadoEmail) {
        this.usuarios = usuario;
        this.tipoEmail = tipoEmail;
        this.estadoEmail = estadoEmail;
    }
    
    public Emails(Usuarios usuario, String tipoEmail, String asuntoEmail, String contenidoEmail, String estadoEmail, Date fechaCreacionEmailEnvio, Date fechaEnvioEmailEnvio, String destinoEmailEnvio) {
       this.usuarios = usuario;
       this.tipoEmail = tipoEmail;
       this.asuntoEmail = asuntoEmail;
       this.contenidoEmail = contenidoEmail;
       this.estadoEmail = estadoEmail;
       this.fechaCreacionEmailEnvio = fechaCreacionEmailEnvio;
       this.fechaEnvioEmailEnvio = fechaEnvioEmailEnvio;
       this.destinoEmailEnvio = destinoEmailEnvio;
    }
    
    public Emails(Usuarios usuario, String tipoEmail, String asuntoEmail, String contenidoEmail, String estadoEmail, String origenEmailRecibido, Date fechaEmailRecibido, boolean leidoEmailRecibido) {
       this.usuarios = usuario;
       this.tipoEmail = tipoEmail;
       this.asuntoEmail = asuntoEmail;
       this.contenidoEmail = contenidoEmail;
       this.estadoEmail = estadoEmail;
       this.origenEmailRecibido = origenEmailRecibido;
       this.fechaLlegadaEmailRecibido = fechaEmailRecibido;
       this.leidoEmailRecibido = leidoEmailRecibido;
    }
    
    /*-----------------FIN CONSTRUCTORES ADICIONALES------------------*/
    
    public Integer getIdEmail() {
        return this.idEmail;
    }
    
    public void setIdEmail(Integer idEmail) {
        this.idEmail = idEmail;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    public String getTipoEmail() {
        return this.tipoEmail;
    }
    
    public void setTipoEmail(String tipoEmail) {
        this.tipoEmail = tipoEmail;
    }
    public String getAsuntoEmail() {
        return this.asuntoEmail;
    }
    
    public void setAsuntoEmail(String asuntoEmail) {
        this.asuntoEmail = asuntoEmail;
    }
    public String getContenidoEmail() {
        return this.contenidoEmail;
    }
    
    public void setContenidoEmail(String contenidoEmail) {
        this.contenidoEmail = contenidoEmail;
    }
    public String getEstadoEmail() {
        return this.estadoEmail;
    }
    
    public void setEstadoEmail(String estadoEmail) {
        this.estadoEmail = estadoEmail;
    }
    public Date getFechaCreacionEmailEnvio() {
        return this.fechaCreacionEmailEnvio;
    }
    
    public void setFechaCreacionEmailEnvio(Date fechaCreacionEmailEnvio) {
        this.fechaCreacionEmailEnvio = fechaCreacionEmailEnvio;
    }
    public Date getFechaEnvioEmailEnvio() {
        return this.fechaEnvioEmailEnvio;
    }
    
    public void setFechaEnvioEmailEnvio(Date fechaEnvioEmailEnvio) {
        this.fechaEnvioEmailEnvio = fechaEnvioEmailEnvio;
    }
    public String getDestinoEmailEnvio() {
        return this.destinoEmailEnvio;
    }
    
    public void setDestinoEmailEnvio(String destinoEmailEnvio) {
        this.destinoEmailEnvio = destinoEmailEnvio;
    }
    public String getOrigenEmailRecibido() {
        return this.origenEmailRecibido;
    }
    
    public void setOrigenEmailRecibido(String origenEmailRecibido) {
        this.origenEmailRecibido = origenEmailRecibido;
    }
    public Date getFechaLlegadaEmailRecibido() {
        return this.fechaLlegadaEmailRecibido;
    }
    
    public void setFechaLlegadaEmailRecibido(Date fechaLlegadaEmailRecibido) {
        this.fechaLlegadaEmailRecibido = fechaLlegadaEmailRecibido;
    }
    public boolean isLeidoEmailRecibido() {
        return this.leidoEmailRecibido;
    }
    
    public void setLeidoEmailRecibido(boolean leidoEmailRecibido) {
        this.leidoEmailRecibido = leidoEmailRecibido;
    }
    public Set getRespuestasPorEmailsForIdEmailRespuesta() {
        return this.respuestasPorEmailsForIdEmailRespuesta;
    }
    
    public void setRespuestasPorEmailsForIdEmailRespuesta(Set respuestasPorEmailsForIdEmailRespuesta) {
        this.respuestasPorEmailsForIdEmailRespuesta = respuestasPorEmailsForIdEmailRespuesta;
    }
    public Set getRespuestasPorEmailsForIdEmailOrigen() {
        return this.respuestasPorEmailsForIdEmailOrigen;
    }
    
    public void setRespuestasPorEmailsForIdEmailOrigen(Set respuestasPorEmailsForIdEmailOrigen) {
        this.respuestasPorEmailsForIdEmailOrigen = respuestasPorEmailsForIdEmailOrigen;
    }




}


