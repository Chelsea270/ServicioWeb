package org.test.servicioweb.config;

public class Supabaseconfig {
    // devuelve el url guardada en las variables de entorno.
    public static String getUrl() {
        return leerVariable("SUPABASE_URL");
    }
    // devuelve la api key en las variables de entorno.
    public static String getApiKey() {
        return leerVariable("SUPABASE_KEY");
    }

    public static String leerVariable(String nombre){
        String valor = System.getenv(nombre);

        if (valor == null || valor.isEmpty()){
            throw new RuntimeException(nombre + " invalido o no configurado");
        }
        return valor;
    }
}