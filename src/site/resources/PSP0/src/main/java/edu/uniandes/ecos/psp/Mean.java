/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp;

import java.util.LinkedList;

/**
 *Clase que calcula el promedio de los numeros que vienen en la linkedlist.
 * @author Aleja Chica
 */
public class Mean {
    
    /**
     * Metodo que calcula el promedio de los numeros que vienen en la linkedlist
     * @param numeros los numeros con los que se calculara el promedio
     * @return el valor del promedio
     */
    public double calcularPromedio(LinkedList<Double> numeros){
    
        double promedio = 0;
        
        for (Double numero : numeros) {
            
            promedio += numero;
        }
        
        return promedio/numeros.size();
    }
    
}
