/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.besimontoya.lengaujesprogramacion;
import java.time.Instant;
import java.util.Date;
import  java.util.ArrayList;
/**
 //SE CREA TODA ESTA PARTE PARA PODER EXTRAER LA INFORMACION ATRAVEZ DE ESTAS VARIABLES CREADAS...
 *
 * @author BESSY SIERRA
 */
public class RegistroLenguaje {    

    /**
     * @return the _TipoSistema
     */
    public String getTipoSistema() {
        return _TipoSistema;
    }

    /**
     * @param _TipoSistema the _TipoSistema to set
     */
    public void setTipoSistema(String _TipoSistema) {
        this._TipoSistema = _TipoSistema;
    }
     //ESTABLECER PROPIEDADES EN ESTE CASO SON "GETTER Y SETTER <<para obtener un dato interno o establecer un dato interno, es tambien paran mostrar los datos internos"
    
        public int getId(){
        return this. _id;
    }
    
    public void setId(int id){
       this. _id = id;           //AL TERMINAR ESTA PARTE REGRESAMOS A LA PARTE DE ARRIBA JUSTO EN EL PRIMER CONSTRUCTOR, NOS UBICAMOS AHI PARA ENCAPSULAR ESOS CAMPOS...
    }
    
    /**
     * @return the _nombre
     */
    //ENCAPSULAMIENTOS DE CAMPOS DEL PRIMER CONSTRUCTOR...   <<AUTOMATICAMENTE SE CREA ESTA REFACTORIZACION DE ENCAPSULAMIENTO PARA CREAR AUTOMATICAMENTE LOS SETTER Y GETTER...
    public String getNombre() {
        return _nombre;
    }

    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    /**
     * @return the _diseñador
     */
    public String getDiseñador() {
        return _diseñador;
    }

    /**
     * @param _diseñador the _diseñador to set
     */
    public void setDiseñador(String _diseñador) {
        this._diseñador = _diseñador;
    }

    /**
     * @return the _version
     */
    public Date getversion() {
        return _Lanzamientoversion;
    }

    /**
     * @param _Lanzamientoversion the _version to set
     */
    public void setLanzamientoversion(Date _Lanzamientoversion) {
        this._Lanzamientoversion = _Lanzamientoversion;
    }

    /**
     * @return the _tipoParadigma
     */
    public String getTipoParadigma() {
        return _tipoParadigma;
    }

    /**
     * @param _tipoParadigma the _tipoParadigma to set
     */
    public void setTipoParadigma(String _tipoParadigma) {
        this._tipoParadigma = _tipoParadigma;
    }
    //PRIMER CONSTRUCTOR CREADO
    private int _id;   
    private String _nombre;
    private String _diseñador;
    private String _TipoSistema;
    private Date  _Lanzamientoversion ;
    private String _tipoParadigma;
    
    //SEGUNDO CONSTRUCTOR
    public RegistroLenguaje(){
        this._id = 0;
        this. _nombre = "";
        this. _diseñador = "";
        this. _TipoSistema = "";
        this. _Lanzamientoversion = new Date ();
        this. _tipoParadigma = "";
    }
   
   //CREAR OTRO CONSTRUCTOR PARA QUE TRAIGA Y JALE ESOS DATOS DEL CONSTRUCTOR QUE ESTA CREADO ARRIBA DE ESTE...
    public RegistroLenguaje(int id, String nombre, String diseñador, String TipoSistema, Date Lanzamientoversion, String tipoParadigma){
      //   CLASE              PARAMETRO
        this. _id = id;
        this. _nombre = nombre;
        this. _diseñador = diseñador;
        this. _TipoSistema = TipoSistema;
        this. _Lanzamientoversion = Lanzamientoversion;
        this. _tipoParadigma = tipoParadigma;
    }
    
     public ArrayList<String> obtenerCampos(){
        ArrayList<String> campos = new ArrayList<String>();
        campos.add(String.valueOf(this._id));
        campos.add(this._nombre);
        campos.add(this._diseñador);
        campos.add(this._TipoSistema);
        campos.add(this._tipoParadigma);
        campos.add(String.valueOf(this._Lanzamientoversion));
        
        
        
        return campos;
        
     }
}
