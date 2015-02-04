package edu.uniandes.ecos.psp;

import java.util.LinkedList;

/**
 * Clase con el manin para calcular el prmedio y la desviacion estandar para PSP0
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
        * Se ejecutan los casos de prueba
        */
        test1();
        test2();
    }
    
    /**
     * Metodo que permite ejecutar el caso de prueba de la tabla 1
     */
    public static void test1(){
    
         /*
        * Se crea la linkedlist con los datos de prueba
        */
        LinkedList<Double> listaDeNumeros = new LinkedList<Double>();
        listaDeNumeros.add(160d);
        listaDeNumeros.add(591d);
        listaDeNumeros.add(114d);
        listaDeNumeros.add(229d);
        listaDeNumeros.add(230d);
        listaDeNumeros.add(270d);
        listaDeNumeros.add(128d);
        listaDeNumeros.add(1657d);
        listaDeNumeros.add(624d);
        listaDeNumeros.add(1503d);
        
        /*
        * Se calcula el promedio
        */
        Mean mean = new Mean();
        double promedio = mean.calcularPromedio(listaDeNumeros);
        
        /*
        *Se calcula la desviacion estandar
        */
        StandardDeviation deviation = new StandardDeviation();
        double desviacionEstandar = deviation.calcularDesviacionEstandar(promedio, listaDeNumeros);
        
        System.out.println("Los numeros son: " + listaDeNumeros);
        System.out.println( "El promedio es: " + promedio + " y la desviacion estandar es: " + desviacionEstandar );
    }
    
    /**
     * Metodo que permite ejecutar el caso de prueba de la tabla 2
     */
    public static void test2(){
    
         /*
        * Se crea la linkedlist con los datos de prueba
        */
        LinkedList<Double> listaDeNumeros = new LinkedList<Double>();
        listaDeNumeros.add(15.0);
        listaDeNumeros.add(69.9);
        listaDeNumeros.add(6.5);
        listaDeNumeros.add(22.4);
        listaDeNumeros.add(28.4);
        listaDeNumeros.add(65.9);
        listaDeNumeros.add(19.4);
        listaDeNumeros.add(198.7);
        listaDeNumeros.add(38.8);
        listaDeNumeros.add(138.2);
        
        /*
        * Se calcula el promedio
        */
        Mean mean = new Mean();
        double promedio = mean.calcularPromedio(listaDeNumeros);
        
        /*
        *Se calcula la desviacion estandar
        */
        StandardDeviation deviation = new StandardDeviation();
        double desviacionEstandar = deviation.calcularDesviacionEstandar(promedio, listaDeNumeros);
        
        System.out.println("Los numeros son: " + listaDeNumeros);
        System.out.println( "El promedio es: " + promedio + " y la desviacion estandar es: " + desviacionEstandar );
    }
    
    
}
