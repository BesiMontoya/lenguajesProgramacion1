/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.besimontoya.lengaujesprogramacion;
import com.besimontoya.Utilities.Layout;
import java.util.Scanner;
/**
 *
 * @author BESSY SIERRA
 */

    //-----------------------PARTE DE ENCABEZADO----------------------------// 

public class Main {
        public static void main (String[] args) {
    Layout.printSeperator();
    System.out.println("-------MENU-------");
    Layout.printSeperator();
    Layout.printHeader("MENU");  //ESTA PARTE SE UTILIZA PARA IMPRIMIR EL ENCABEZADO DEL SISTEMA
    //APARTIR DE AQUI EMPIEZA LA OPCION MENU//
    //----- PARTE 2----//
    String OpcionMenu = "";
    Scanner entradaTeclado = new Scanner (System.in); //CREAR UNA ENITRADA ESPECIFICA Y ESA ENTRADA TIENE UNA INSTANCIA QUE LE DA ACCESO AL TECLADO
    Aplication lengProgra = new Aplication(entradaTeclado);
       // ||         ||                        ||
    //<<CLASE  <<INSTANCIA                 <<ES COMO UN PARAMETRO
    
    while (!(OpcionMenu.toUpperCase().equals("S"))){ //ESTE ES UN CICLO CUYA FUNCIONALIDAD ES DETERMINAR SI EXISTE UN ELEMENTO DE OPCION PARA DEERMINAR QUE SE VA UTILIZAR 
        Layout.printMenu();
        OpcionMenu = entradaTeclado.nextLine();
        System.out.println("El texto ingresado es igual a " + OpcionMenu);
        
        //CREAR OPCION O ACCION DEL MENU QUE DEBE DE HACER.. <<DESPUES DE CREAR EL SWITCH CON LOS CASE Y BREAK EN LA APLICACION VA ESTE SEGUIENTE PARTE:
        lengProgra.activarEvento(OpcionMenu);
        
        
        
        }
    }
    
        
      
}
           
/*---------------------------------------------------------------------------*/

//UN SINGLETON:  RESTRINGE LA CREACION DE OBJETOS QUE PERTENECEN A UNA CLASE, CONSISTE EN QU UNA CLASE TENGA UNA SOLA INSTANCIA Y ASI PROPORCIONAR UN ACCESO GLOBAL A ELLA


// UN POJO : (ES UN OBJETO DE JAVA PLANO, NO TIENE METODOS SOLO CONTIENE DATOS)Y USA LAS PROPIEDADES DE SETTER Y HETTERS PARA LOS DATOS 
