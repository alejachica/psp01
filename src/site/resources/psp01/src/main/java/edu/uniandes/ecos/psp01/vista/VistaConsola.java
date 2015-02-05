/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp01.vista;

import edu.uniandes.ecos.psp01.controlador.Controlador;
import java.io.File;

/**
 *Clase encarada de mostrar el resultado del conteo de LOCs por consola.
 * @author Aleja Chica
 */
public class VistaConsola {
    
    /**
     * Metodo que permite ejecutar la aplicacion
     * @param args parametros para la ejecucion
     */
    public static void main(String[] args) {
        
        Controlador controlador = new Controlador();
        String salida = controlador.contarLOCs(new File("src/site/resources"));
        
        System.out.println(salida);
    }
            
}
