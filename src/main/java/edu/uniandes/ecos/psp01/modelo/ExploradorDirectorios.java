/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp01.modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aleja Chica
 */
public class ExploradorDirectorios {

    private List<File> archivosJava;
    private AnalizadorClases analizadorClases;
    
    public String contarLOCs(File raiz){
    
        return encontrarDirectorios(raiz);
    }

    private String encontrarDirectorios(File raiz) {

        String resultado = "";
        File[] archivos = raiz.listFiles();

        for (File archivo : archivos) {

            resultado = resultado + "\nNombre del programa: " + archivo.getName() + "\n";
            archivosJava = new ArrayList<File>();

            List<File> archivosEncontrados = encontrarClases(archivo, archivosJava);

            analizadorClases = new AnalizadorClases();
            resultado = "\n" + resultado + analizadorClases.leerArchivos(archivosEncontrados);
            resultado = resultado + " El total de lineas del programa " + archivo.getName() + " es: " +analizadorClases.getConteoTotal() + "\n";
        }

        
        return resultado;
    }

    private List<File> encontrarClases(File raiz, List<File> archivosJava) {

        File[] archivos = raiz.listFiles();

        for (File archivo : archivos) {

            if (archivo.isDirectory()) {

                encontrarClases(archivo, archivosJava);
            } else {

                if (esClaseJava(archivo.getName()) && !archivosJava.contains(archivo)) {

                    archivosJava.add(archivo);
                }
            }
        }

        return archivosJava;
    }

    private boolean esClaseJava(String nombreArchivo) {

        return nombreArchivo.endsWith(".java");
    }

}
