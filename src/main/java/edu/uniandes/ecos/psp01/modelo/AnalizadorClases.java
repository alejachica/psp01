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
 *
 * @author Aleja Chica
 */
public class AnalizadorClases {
    
    private int conteoTotal;

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

    private boolean lineaEsComentario(String linea) {

        return linea.trim().startsWith("/**") || linea.trim().startsWith("/*") || linea.trim().startsWith("*") || linea.trim().startsWith("//");
    }

    private boolean lineaEsMetodo(String linea) {

        return (linea.trim().startsWith("public") || ((linea.trim().startsWith("protected")) || linea.trim().startsWith("private"))) && ((linea.trim().endsWith("){")) || (linea.trim().endsWith(")")));
    }
    
    public int getConteoTotal() {
        
        return conteoTotal;
    }

}
