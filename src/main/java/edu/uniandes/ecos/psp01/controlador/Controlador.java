/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp01.controlador;

import edu.uniandes.ecos.psp01.modelo.ExploradorDirectorios;
import java.io.File;

/**
 *
 * @author Aleja Chica
 */
public class Controlador {
    
    public String contarLOCs(File raiz){
    
        ExploradorDirectorios exp = new ExploradorDirectorios();
        
        return exp.contarLOCs(raiz);
    }
    
}
