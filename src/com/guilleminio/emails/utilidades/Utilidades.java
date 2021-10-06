/*
 * PROGRAMACION III - EXAMEN FINAL
 * MIÑO, GUILLE
 * INGENIERIA EN INFORMATICA - UAA
 * 3/08/2021
 */
package com.guilleminio.emails.utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Guille
 */
public class Utilidades {
    
    public static final String DEFAULT_PATH_USER_PROFILE = "res\\imagenes_usuarios\\perfiles\\profile";
    public static final String DEFAULT_IMAGE_EXTENSION = ".jpg";
    
    public static boolean validarFormatoEmail(String aEmail ){
        
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(aEmail);
 
        if (mather.find() == true) 
            return true;
        
        return false;
    }
}
