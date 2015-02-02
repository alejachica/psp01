/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp01;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aleja Chica
 */
public class ExploradorDirectorios {

    private File directorioHijo;
    private File raiz;
    private List<File> archivosJava;

    public ExploradorDirectorios() {

        archivosJava = new ArrayList<File>();
    }

    public List<File> encontrarClases(File raiz) {

        File[] archivos = raiz.listFiles();

        for (File archivo : archivos) {

            if (archivo.isDirectory()) {

                encontrarClases(archivo);
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

    public String imprimirListaArchivos() {

        String listaArchivos = " ";

        for (File archivo : archivosJava) {

            listaArchivos += archivo.getName() + " ";
        }
//        System.out.println(archivosJava.keySet().size());

        return listaArchivos;
    }

}
