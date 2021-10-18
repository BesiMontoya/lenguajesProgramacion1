/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.besimontoya.dao;
import com.besimontoya.lengaujesprogramacion.RegistroLenguaje;
import java.util.ArrayList;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author BESSY SIERRA
 */
public class lenguajeDB {
    private ArrayList _RegistroLenguaje;
    
    public lenguajeDB(){
        this._RegistroLenguaje = new ArrayList<RegistroLenguaje>();
    }
    
    public ArrayList<RegistroLenguaje> getRegistroLenguaje(){
        return this.getRegistroLenguaje();
    }
    
    public void tableInitialize(){
        String sqlCreate = "CREATE TABLE IF NOT EXISTS LENGUAJE"
                        + " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                        + " NOMBRE TEXT NOT NULL,"
                        + " DISEÑADOR TEXT NOT NULL,"
                        + " TIPO SISTEMA TEXT NOT NULL"
                        + " PARADIGMA TEXT NOT NULL"
                        + ")";
       
        try {
            Statement comando = Conexion.getConexion().createStatement();
            int resultado = comando.executeUpdate(sqlCreate);
            comando.close();
        } catch( Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public ArrayList<RegistroLenguaje> getRegistroLenguaje(boolean forceLoad){
        try {
           if (forceLoad) {
                Statement comando =  Conexion.getConexion().createStatement();
                ResultSet misRegistro = comando.executeQuery("SELECT * from LENGUAJE;");
                this._RegistroLenguaje.clear();
                while (misRegistro.next()) {
                    RegistroLenguaje registro = new RegistroLenguaje();
                    registro.setId(misRegistro.getInt("ID"));
                    registro.setNombre(misRegistro.getString("NOMBRE"));
                    registro.setDiseñador(misRegistro.getString("DISEÑADOR"));
                    registro.setTipoSistema(misRegistro.getString("TIPO SISTEMA"));
                    registro.setTipoParadigma(misRegistro.getString("PARADIGMA"));
                    this._RegistroLenguaje.add(registro);
                }
                comando.close();
           }
           return this._RegistroLenguaje;
        } catch(Exception ex){
            System.err.println(ex.getMessage());
            return this._RegistroLenguaje;
        }   
    }
    
    public RegistroLenguaje getRegistroLenguajeById(int id){
        try {
            String SQLGetByID = "SELECT * FROM LENGUAJE WHERE ID = ?;";
            PreparedStatement comando =  Conexion.getConexion().prepareStatement(SQLGetByID);
            comando.setInt(1, id);
            ResultSet misRegistro = comando.executeQuery();
            RegistroLenguaje registro = new RegistroLenguaje();
            while (misRegistro.next()) {
                registro.setId(misRegistro.getInt("ID"));
                registro.setNombre(misRegistro.getString("NOMBRE"));
                registro.setDiseñador(misRegistro.getString("DISEÑADOR"));
                registro.setTipoSistema(misRegistro.getString("TIPO SISTEMA"));
                registro.setTipoParadigma(misRegistro.getString("PARADIGMA"));
                break;
            }
            comando.close();

            return registro;
        } catch(Exception ex){
            System.err.println(ex.getMessage());
            return null;
        }   
    }
    
    public int updateRegistroLenguaje(RegistroLenguaje ItemToUpdate) {
        try {
            String SQLUpdate = "UPDATE LENGUAJE set NOMBRE=?, DISEÑADOR=?, TIPO SISTEMA=?, PARADIGMA=? where ID=?;";
            PreparedStatement comando = Conexion.getConexion().prepareStatement(SQLUpdate);
            
            comando.setString(1, ItemToUpdate.getNombre());
            comando.setString(2, ItemToUpdate.getDiseñador());
            comando.setString(3, ItemToUpdate.getTipoSistema());
            comando.setString(4, ItemToUpdate.getTipoParadigma());
            comando.setInt(5, ItemToUpdate.getId());
            
            int registrAfectado = comando.executeUpdate();
            comando.close();
            return registrAfectado;
            
        } catch( Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
     public int insertRegistroLenguaje(RegistroLenguaje ItemToInsert) {
        try {
            String SQLInsert = "INSERT INTO LENGUAJE(NOMBRE, DISEÑADOR, TIPO SISTEMA, PARADIGMA) values (?, ?, ?, ?);";
            PreparedStatement comando = Conexion.getConexion().prepareStatement(SQLInsert);
            
            comando.setString(1, ItemToInsert.getNombre());
            comando.setString(2, ItemToInsert.getDiseñador());
            comando.setString(3, ItemToInsert.getTipoSistema());
            comando.setString(4, ItemToInsert.getTipoParadigma());
            int registrAfectado = comando.executeUpdate();
            comando.close();
            return registrAfectado;
            
        } catch( Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
     
    public int deleteRegistroLenguaje(RegistroLenguaje ItemToDelete) {
        try {
            String SQLDelete = "DELETE FROM LENGUAJE WHERE ID = ?;";
            PreparedStatement comando = Conexion.getConexion().prepareStatement(SQLDelete);
            
            comando.setInt(1, ItemToDelete.getId());
            
            int registrAfectado = comando.executeUpdate();
            comando.close();
            return registrAfectado;
            
        } catch( Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
}
    
