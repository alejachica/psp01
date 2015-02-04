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
 *Clase que busca recursivamente en los directorios dados, archivos *.java
 * @author Aleja Chica
 */
public class ExploradorDirectorios {

    /**
     * Lista que almacena los archivos java de un programa.
     */
    private List<File> archivosJava;
    
    /**
     * Instancia del analizador de clases.
     */
    private AnalizadorClases analizadorClases;
    
    /**
     * Metodo encargado de iniciar el conteo de LOCs.
     * @param raiz Directorio del programa java.
     * @return String con la respuesta del conteo.
     */
    public String contarLOCs(File raiz){
    
        return encontrarDirectorios(raiz);
    }

    /**
     * Metodo encargado de analizar los programas java.
     * @param raiz Directorio donde se encuentran los programas java.
     * @return String con la respuesta del conteo.
     */
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

    /**
     * Metodo que buscar recursivamente archivos java.
     * @param raiz Directorio donde se encuentran los programas java.
     * @param archivosJava Lista que almacena los archivos java de un programa.
     * @return Lista archivos java almacenados.
     */
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

    /**
     * Metodo que determina si el archivo encontrao es un archivo .java
     * @param nombreArchivo Nombre del archivo a analizar.
     * @return true si el archivo es java, falso en caso contrario.
     */
    private boolean esClaseJava(String nombreArchivo) {

        return nombreArchivo.endsWith(".java");
    }

}
