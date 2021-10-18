/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.besimontoya.Utilities;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author BESSY SIERRA
 */
public class Layout {
 //-----------------------PARTE DE ENCABEZADO----------------------------//  
        public static void printSeperator () { // SE IMPRIME UN SEPARADOR
    System.out.println("=====================================================");   
    }
    
        //EL PATRON DEL LAYOUT ES EL DRY: QUE SIGNIFICA DON'T REPEAT YOURSELF
    public static void printHeader (String header) { //IMPRIMIR ENCABEZADO
    int headerLength = header.length();  
    int startpoint = (int) Math.floor((80 - headerLength)/2);
    String headerBuffer = "";
    for(int i = 0; i<startpoint; i++){
    headerBuffer += " ";
    }
    headerBuffer += header;
    startpoint = headerBuffer.length();
    for(int i = startpoint; i<80; i++){
    headerBuffer += " ";
    }
    printSeperator();
    System.out.println(headerBuffer);
    printSeperator();
    }
    
     //CRUD ------ PARA MOSTRAR MENU UN TEXTO PARA SOLICITAR UN MENU----// 
    //-------PARTE 1//
        public static void printMenu(){  //IMPRIMIR UN MENU
         printHeader("Menu");
        
        System.out.println("\nM - Mostrar\nI - Ingresar\nA - Actualizar\nE - Eliminar\n\nS - Salir\n");
        printSeperator();
        System.out.println("Seleccione una opción : ");
            
        }
     
        
        
        /*  EN ESTA PARTE NOS PERMITE IR GUARDANDO LOS DATOS INGRESADOS AL MENU*/
        //IR A LA PARTE DE LA CLASE CREADA "APLICACION" PRIMERO ANTES DE COMENZAR, PORQUE AHI SE VAN A CREAR LOS METODOS..
        //ANTES DE COMENZAR CON "INGRESAR REGISTRO" HACEMOS ESTO PRIMERO
     public static String obtenerValorparaCampo(String Etiqueta, String ValorPredeterminado, Scanner entradaTeclado){
        //AQUI SE OBTIENE EL VALOR PARA CAMPOS EN DONDE SE DEFINEN ELEMENTOS BASICOS QUE NOS PERMITEN CAPTURAR LA INFORMACION  
        //Y SI LA INFORMACION VIENE VACIA QUE FUE CAPTURADA PUEDE VOLVER AL VALOR PREDETERMINADO, ESTO HACE EL TRABAJO DE ARRIBA PARA ABAJO
        System.out.println(Etiqueta + " (" + ValorPredeterminado + ") : ");
        String valor = entradaTeclado.nextLine(); 
        if (valor.isEmpty()){
            return ValorPredeterminado;  
        }
        return valor;
    } 
     //ESTE ELEMENTO NOS PERMITE IMPRIMIR LAS COLUMNAS SEGUN LO ESTABLECIDO EN LA LISTA DE LAS COLUMNAS, LOA ANCHOS,Y SEPARADORES  
     public static void imprimirEnColumna(ArrayList<String> columnas, ArrayList<Integer> anchos, String separator) throws Exception{
        if ( columnas.size() != anchos.size()) {
            throw new Exception("Las columnas no coinciden con los anchos");
        }
        System.out.print(separator);
        for (int i = 0; i < columnas.size(); i++){
            // Columna1    10      "1%S-10s"    "Columna1  "
            String columna = String.format("%1$-" + String.valueOf(anchos.get(i)) +"s", columnas.get(i));
            columna = columna.substring(0, anchos.get(i));
            
            System.out.print(columna);
            System.out.print(separator);
        
        }
        System.out.println();
    }
 
}
   


