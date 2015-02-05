/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp01.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Clase encargada del conteo de lineas y metodos de una clase java.
 * @author Aleja Chica
 */
public class AnalizadorClases {
    
    /**
     * Guarda el total de lineas de un programa
     */
    private int conteoTotal;

    /**
     * Metodo que permite contar lineas validar en una clase java, y contar metodos.
     * @param archivosJava Nombre del archivo a leer.
     * @return String con el conteo de lineas y metodos de la clase.
     */
    public String leerArchivos(List<File> archivosJava) {

        String resultado = "";
        String strLinea;
        int conteoLineas;
        int conteoMetodos;

        BufferedReader br = null;

        try {

            for (File archivo : archivosJava) {

                conteoLineas = 0;
                conteoMetodos = 0;

                br = new BufferedReader(new FileReader(archivo));

                while ((strLinea = br.readLine()) != null) {

                    if (!strLinea.trim().equals("")) {

                        if (!lineaEsComentario(strLinea)) {

                            conteoLineas++;
                        }

                        if (lineaEsMetodo(strLinea)) {

                            conteoMetodos++;
                        }
                    }
                }

                conteoTotal += conteoLineas;
                
                resultado = resultado + " Clase: " + archivo.getName() + ", Numero de lineas: " + conteoLineas + ", Numero de metodos: " + conteoMetodos + "\n";

                br.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AnalizadorClases.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AnalizadorClases.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    /**
     * Metodo que determina si una linea es un comentario.
     * @param linea Linea a leer
     * @return true si la linea es comentario, falso en caso contrario.
     */
    private boolean lineaEsComentario(String linea) {

        return linea.trim().startsWith("/**") || linea.trim().startsWith("/*") || linea.trim().startsWith("*") || linea.trim().startsWith("//");
    }

    /**
     * Metodo que determina si la linea a leer es un metodo java.
     * @param linea Linea a leer.
     * @return true si la linea es un metodo, falso en caso contrario.
     */
    private boolean lineaEsMetodo(String linea) {

        return (linea.trim().startsWith("public") || ((linea.trim().startsWith("protected")) || linea.trim().startsWith("private"))) && ((linea.trim().endsWith("{")) || (linea.trim().endsWith(")"))) && !(linea.trim().contains("class"));
    }
    
    /**
     * Metodo que devuelve el conteo total de lineas de un programa java.
     * @return el total de lineas de codigo de un programa java.
     */
    public int getConteoTotal() {
        
        return conteoTotal;
    }

}
