/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp01.controlador;

import edu.uniandes.ecos.psp01.modelo.ExploradorDirectorios;
import java.io.File;

/**
 *Clase que sirve de controlador en el patron MVC 
 * @author Aleja Chica
 */
public class Controlador {
    
    /**
     * Metodo que invoca el explorador de directorios que busca archivos java.
     * @param raiz Directorio raiz donde se ara la busqueda.
     * @return String con la respuesta del conteo.
     */
    public String contarLOCs(File raiz){
    
        ExploradorDirectorios exp = new ExploradorDirectorios();
        
        return exp.contarLOCs(raiz);
    }
    
}
