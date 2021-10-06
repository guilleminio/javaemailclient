/*
 * PROGRAMACION III - EXAMEN FINAL
 * MIÑO, GUILLE
 * INGENIERIA EN INFORMATICA - UAA
 * 3/08/2021
 */
package com.guilleminio.emails.modelos;

import java.util.Date;

/**
 *
 * @author Guille
 */
public class EmailEnvio extends Emails {
    
    public static String ESTADO_EMAIL_BORRADOR = "Borrador";
    public static String ESTADO_EMAIL_ENVIADO = "Enviado";
    
    public EmailEnvio(Usuarios aUsuario, String aAsuntoEmail, String aContenidoEmail, String aEstadoEmail, Date aFechaCreacionEmailEnvio, Date aFechaEnvioEmailEnvio, String aDestinoEmailEnvio){
        super(aUsuario,EmailEnvio.class.getSimpleName(),aAsuntoEmail,aContenidoEmail, aEstadoEmail, aFechaCreacionEmailEnvio, aFechaEnvioEmailEnvio, aDestinoEmailEnvio);
    }
    
}
