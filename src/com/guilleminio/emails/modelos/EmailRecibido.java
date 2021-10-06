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
public class EmailRecibido extends Emails {
    public EmailRecibido(Usuarios aUsuario, String aAsuntoEmail, String aContenidoEmail, String aEstadoEmail, String origenEmailRecibido, Date fechaEmailRecibido, boolean leidoEmailRecibido){
        super(aUsuario,EmailRecibido.class.getSimpleName(),aAsuntoEmail,aContenidoEmail, aEstadoEmail, origenEmailRecibido, fechaEmailRecibido, leidoEmailRecibido);
    }
}
