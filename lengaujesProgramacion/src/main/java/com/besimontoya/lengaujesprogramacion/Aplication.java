/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.besimontoya.lengaujesprogramacion;
import com.besimontoya.Utilities.Layout;  // ESTE ES UN UTILITARIO, LAYOUT TIENE METODOS ESTATICOS QUE NOS PERMITE DEFINIR METODOS PARA MOSTRAR LA INFORMACION
import com.besimontoya.dao.lenguajeDB;
import java.util.Scanner;
import java.util.ArrayList; //ES UN ARREGLO ESPECIAL QUE NOS PERMITE MANEJAR ELEMENTOS BASADOS EN UN TIPO DE DATO...
import java.time.ZonedDateTime;


//EJEMPLO DE METODOS :     private Scanner _entradaTeclado;

/**
 *
 * @author BESSY SIERRA
 */
public class Aplication {    //ESTO ES UNA CLASE
    //ESTA CLASE TIENE MUCHOS METODOS TANTO PRIVADOS COMO PUBLICOS 
 private Scanner _entradaTeclado;     //SE CREA LA INSTANCIA O "IMPORT java.util.Scanner;" PARA QUE NO TIRE ERROR EN ESTA PARTE..

 //DESPUES DE DECLARAR EL IMPORT ARRAYLIST HACEMOS ESTA PARTE... ES UN ARREGLO QUE NO TIENE UN TAMAÑO FIJO
 //AQUI SE NOS PRESENTAN VARIOS ELEMENTOS:
private ArrayList _Lenguajes; //ESTE ELEMENTO CAPTURA LA INFORMACION QUE VIENE DE LA BASE DE DATOS  
private int _RegistroLenguajeIdCounter;
private lenguajeDB _RegistroLenguajeModel;

public Aplication (Scanner entradaTeclado){ // SCANNER QUE ES LA ENTRADA DEL TECLADO
    this. _entradaTeclado = entradaTeclado;
    this. _Lenguajes = new ArrayList<RegistroLenguaje>();
    this._RegistroLenguajeIdCounter = 0;
    this._RegistroLenguajeModel = new lenguajeDB();
    this._RegistroLenguajeModel.tableInitialize();
    this._Lenguajes = this._RegistroLenguajeModel.getRegistroLenguaje(true);
    
}

    //ESTO ES UN CONSTRUCTOR ES COMO UN VALOR UNICO PARA LLAMAR ESE VALOR CREADO, ESTO SON OBJETOS CREADOS BASADOS EN LA CLASE ES DECIR ESE OBJETO SE PUEDE MANDAR A LLAMAR A OTRAS CLASES...
    // PRACTICAMENTE ES UNA INSTANCIA QUE PERMITE CREAR VALORES INICIALES O PREDETERMINADOS CON LOS CUALES SE VAN A LLENAR LOS ATRIBUTOS..
    //ESTE OBJETO SE CREA PARA PODER UTILIZAR EN LA CLASE "MAIN"..
    
     /*public Aplication (Scanner entradaTeclado){   //EL "this" HACE REFERENCIA A LA INSTANCIA DE LA CLASE..
          this._entradaTeclado = entradaTeclado; 
    }*/
    
    //PRIMERO SE CREA UN METODO PARA "CREAR OPCION O ACCION DEL MENU QUE DEBE DE HACER"
    
    public void activarEvento (String opcionMenu){  //ESTE ES UN METODO PUBLICO, POR MEDIO DE EL SE DECIDE QUE OPCION SE VA A REALIZAR Y DEPENDIENDO DE ESO SE CORRE CADA UNO DE LOS METODOS INTERNOS.
        
    switch(opcionMenu.toUpperCase()){   //ESTO DETERM. QUE ACCIONES VA A HACER Y VA A SER LA APLICACION LA Q VA A PERMITIR DAR LA INF. PARA EXTRAER ESTOS DATOS Y MOSTRARLOS...
                                        //PRACTICAMENTE LO QUE HACE ESTA PARTE ES QUE AL MOMENTO DE EJECUTAR SE MUESTRA EN LA VENTANA LA PARTE DE LAS OPCIONES Y DE CAUERDO A LA ELECCION DE CADA OPCION EJEMPLO: "OPCION "M" <<MOSTRAR DATOS>> 
            case "M":
                System.out.println("Mostrar Datos");  
                this.mostrarRegistros();
            break;
            
            case "I":
                    System.out.println("Ingresar Registro"); 
                    this.IngresarRegistro();
            break;
            
            case "A":
                    System.out.println("Actualizar Registro"); 
                    this.actualizarRegistro();
            break;
            
            case "E":
                    System.out.println("Eliminar Registro"); 
                    this.eliminarRegistro();
            break;
            
            case "S" :
                break;
              
        default: 
            System.out.println("Opcion no reconocida!!!");  
            break;
            
    }
    }
    //ESTA PARTE SIRVE PARA SOLICITAR INFORMACION POR CADA OPCION... EJEMPLO OPCION "I" INGRESAR REGISTRO, !!!!PERO ANTES DE EMPEZAR NOS VAMOS AL LAYOUT PARA CAPTURAR ESTA INFORMACION
    //primero nos vamos al Layout
    private void IngresarRegistro(){
        Layout.printHeader("Nuevo registro de Lenguaje de Programacion");
        RegistroLenguaje nuevoRegistroLenguaje = new RegistroLenguaje(); // POJO ---- PREGUNTA DE EXAMEN (ES UN OBJETO DE JAVA PLANO, NO TIENE METODOS SOLO CONTIENE DATOS)Y USA LAS PROPIEDADES DE SETTER Y HETTERS PARA LOS DATOS 
        // Nombre Lenguaje Programacion.
        nuevoRegistroLenguaje.setNombre(Layout.obtenerValorparaCampo("Nombre del lenguaje programacion", "lenguaje programacion: ", this. _entradaTeclado ));
        // Diseñador del Lenguaje Programacion.
        nuevoRegistroLenguaje.setDiseñador(Layout.obtenerValorparaCampo("Diseñador del lenguaje programacion", "Nombre del Diseñador: ", this. _entradaTeclado ));
         // Tipo Sistema del Lenguaje Programacion.
        nuevoRegistroLenguaje.setTipoSistema(Layout.obtenerValorparaCampo("Tipo de Sistema del lenguaje programacion", "Nombre del Diseñador: ", this. _entradaTeclado ));
        // Tipo paadigma del Lenguaje Programacion.
        nuevoRegistroLenguaje.setTipoParadigma(Layout.obtenerValorparaCampo("paradigma del lenguaje", "Tipo paradigma:", this. _entradaTeclado ));
         // LanzamientoVersion del Lenguaje Programacion.
         int anio = Integer.parseInt(Layout.obtenerValorparaCampo("Año de Lanzamirnto de la Version yyyy", "2016 ", this. _entradaTeclado ));
         int mes = Integer.parseInt(Layout.obtenerValorparaCampo("Mes de Lanzamirnto de la Version 1-12", "6", this. _entradaTeclado ));
         int dia = Integer.parseInt(Layout.obtenerValorparaCampo("Dia de Lanzamirnto de la Version 1-31", "3 ", this. _entradaTeclado ));
         //ZonedDateTime LanzamientoVersion = new ZonedDateTime();
         //LanzamientoVersion.Setanio(anio);
         //LanzamientoVersion.setMonth(mes);
         //LanzamientoVersion.setDate(dia);
         //nuevoRegistroLenguaje.setLanzamientoversion(LanzamientoVersion);
         this._Lenguajes.add(nuevoRegistroLenguaje);
         
         Layout.printSeperator();
         
         System.out.println(this._Lenguajes.size());
            
    }
     //AQUI DEFINIMOS CUALES SON LAS COLUMNAS QUE SE QUIEREN MOSTRAR Y CUALES SON LOS ANCHOS EN NUMEROS DE LETRAS
     private void mostrarRegistros(){
        Layout.printSeperator();
        ArrayList<String> columnas = new ArrayList<String>();
        columnas.add("Codigo");
        columnas.add("Nombre");
        columnas.add("Diseñador");
        columnas.add("Tipo sistema");
        columnas.add("Tipo Paradigma");
        columnas.add("Lanzamiento version");
        
        ArrayList<Integer> anchos = new ArrayList<Integer>();
        anchos.add(7);
        anchos.add(20);
        anchos.add(20);
        anchos.add(14);
        anchos.add(14);
        anchos.add(10);
        
        // |1234567890|123456789012345|
        try {
            //Imprimir encabezado
            Layout.imprimirEnColumna(columnas, anchos, "|");
            Layout.printSeperator(); //SIEMPRE RECORDAR CERRAR EL SEPARADOR
            for(int i = 0; i< this._Lenguajes.size(); i++){
                columnas = ((RegistroLenguaje) this._Lenguajes.get(i)).obtenerCampos();
                Layout.imprimirEnColumna(columnas, anchos, "|");
            }
            
        } catch(Exception ex) {
            System.err.println("Error al imprimir " + ex.getMessage());
        }
    }
          private void actualizarRegistro(){
        Layout.printHeader("Actualizar Registro");
        int selectedId = Integer.valueOf(Layout.obtenerValorparaCampo("Ingrese Codigo Registro", "0", this._entradaTeclado));
        RegistroLenguaje selectLenguaje = null;
        for( int i=0; i < this._Lenguajes.size(); i++){
            if( selectedId == ((RegistroLenguaje)this._Lenguajes.get(i)).getId()) {
                selectLenguaje = (RegistroLenguaje)this._Lenguajes.get(i);
                break;
            }
        }
        if (selectLenguaje == null ) {
            System.out.println("Registro solicitado no existe!!!");
        } else {
            selectLenguaje.setNombre(Layout.obtenerValorparaCampo("Nombre del Lenguaje Programacion", selectLenguaje.getNombre(), this._entradaTeclado));
            selectLenguaje.setDiseñador(Layout.obtenerValorparaCampo("Nombre del Diseñador", selectLenguaje.getDiseñador(), this._entradaTeclado));
            selectLenguaje.setTipoSistema(Layout.obtenerValorparaCampo("Nombre del Diseñador", selectLenguaje.getTipoSistema(), this._entradaTeclado));
            selectLenguaje.setTipoParadigma(Layout.obtenerValorparaCampo("Tipo Paradigma Lenguaje", selectLenguaje.getTipoParadigma(), this._entradaTeclado));
            int anio = Integer.parseInt(Layout.obtenerValorparaCampo("Año de Lanzamiento Version  yyyy", " ", this._entradaTeclado));
            int mes = Integer.parseInt(Layout.obtenerValorparaCampo("Mes de Lanzamiento 1-12", " ", this._entradaTeclado));
            int dia = Integer.parseInt(Layout.obtenerValorparaCampo("Día de Lanzamiento 1-31", " ", this._entradaTeclado));
            Layout.printSeperator();
            System.out.println("Registro Actualizado Satisfactoriamente!!!");
        }
        
    }
           private void eliminarRegistro(){
        Layout.printHeader("Eliminar Registro");
        int selectedId = Integer.valueOf(Layout.obtenerValorparaCampo("Ingrese Codigo Registro", "0", this._entradaTeclado));
        int encontradoEnIndice = -1;
        for( int i=0; i < this._Lenguajes.size(); i++){
            if( selectedId == ((RegistroLenguaje)this._Lenguajes.get(i)).getId()) {
                encontradoEnIndice = i;
                break;
            }
        }
        if (encontradoEnIndice>=0){
            Layout.printSeperator();
            String confirmado = Layout.obtenerValorparaCampo("¿Desea Eliminar este Registro? S - N", "N", this._entradaTeclado);
            if (confirmado.toUpperCase().equals("S")){
                this._Lenguajes.remove(encontradoEnIndice);
                Layout.printSeperator();
                System.out.println("Registro Eliminado Satisfactoriamente!!!");
            }
        } else {
            System.out.println("Registro solicitado no existe!!!");
        }
    
    }
    
            
        } 

