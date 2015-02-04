/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp;

import java.util.LinkedList;

/**
 *Clase que calcula la desviacion estadar
 * @author Aleja Chica
 */
public class StandardDeviation {
    
    /**
     * Metodo que permite calcular la desviacion estandar
     * @param promedio promedio de los numeros para calcular la desviacion estandar
     * @param numeros lista de numeros con los que se calculara la desviacion estandar.
     * @return el valor de la desviacion estandar.
     */
    public double calcularDesviacionEstandar(double promedio, LinkedList<Double> numeros){
    
        double acumulado = 0;
        double desviacion = 0;
        
        for (Double numero : numeros) {
            
            acumulado += Math.pow((numero - promedio), 2);
        }
        
        desviacion = Math.sqrt((acumulado) / (numeros.size() -1));
        
        return desviacion;
    }
    
}
