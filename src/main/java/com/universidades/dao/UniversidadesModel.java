/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universidades.dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Josue
 */
public class UniversidadesModel {
    
    public static void verificarTablaUniversidades(){
        try{
             Connection conn = Conn.obtenerConexion();
        
             String SQLCrearTabla = "CREATE TABLE IF NOT EXISTS universidades"
                        + " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                        + " siglas TEXT NOT NULL,"
                        + " nombrecomple TEXT NOT NULL,"
                        + " rector TEXT NOT NULL"
                        + ")";
                Statement comandoSql = conn.createStatement();
                comandoSql.executeUpdate(SQLCrearTabla);
                comandoSql.close();
        }catch(Exception ex){
            //
            System.err.println(ex.getMessage());
        }
    }
    
    public static ArrayList<Universidad> getUniversidades(){
        ArrayList<Universidad> universidades = new ArrayList<Universidad>();
       
        try {
            Connection conn = Conn.obtenerConexion();

            String SQLGetUniversidades = "Select * FROM universidades;";
            Statement comandoSql = conn.createStatement();
            ResultSet cursorUniversidades = comandoSql.executeQuery(SQLGetUniversidades);
            while(  cursorUniversidades.next() ){
                Universidad _miUni = new Universidad();
                _miUni.setId( cursorUniversidades.getDouble("id"));
                _miUni.setSiglas( cursorUniversidades.getString("siglas"));
                _miUni.setNombrecomple( cursorUniversidades.getString("nombrecomple"));
                _miUni.setRector( cursorUniversidades.getString("rector"));
                universidades.add(_miUni);
            }
            comandoSql.close();

            return universidades;
        
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
            return universidades;
        } 
    }
    
    public static Universidad getUniversidadById(double Id){
        Universidad _miUni = new Universidad();
        
       
        try {
            Connection conn = Conn.obtenerConexion();

            String SQLGetuniversidades = String.format("Select * FROM universidades where id=%s;", String.valueOf(Id));
            System.out.println(SQLGetuniversidades);
            Statement comandoSql = conn.createStatement();
            ResultSet cursorUnis = comandoSql.executeQuery(SQLGetuniversidades);
            while( cursorUnis.next() ){
             
                _miUni.setId(cursorUnis.getInt("id"));
                _miUni.setSiglas(cursorUnis.getString("siglas"));
                _miUni.setNombrecomple(cursorUnis.getString("nombrecomple"));
                _miUni.setRector(cursorUnis.getString("rector"));
                
            }
            comandoSql.close();

            return _miUni;
        
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
            return _miUni;
        }
    }
    
    public static boolean agregarUniversidad(Universidad uniAAgregar){
        try{
            String sqlStr = "INSERT INTO universidades (siglas, nombrecomple, rector) VALUES ('%s', '%s', '%s')";
            
            Connection conn = Conn.obtenerConexion();
            Statement comandoSQL = conn.createStatement();
            int registroAfectados = comandoSQL.executeUpdate(
                    String.format(sqlStr,
                       uniAAgregar.getSiglas(), 
                       uniAAgregar.getNombrecomple(), 
                       uniAAgregar.getRector()
                    )
            );
            return registroAfectados > 0;
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }
    
    public static boolean editarUniversidad(Universidad uniAEditar){
        try{
            String sqlStr = "UPDATE universidades set siglas = '%s', nombrecomple = '%s', rector = '%s' WHERE id='%s'";
            
            Connection conn = Conn.obtenerConexion();
            Statement comandoSQL = conn.createStatement();
            int registroAfectados = comandoSQL.executeUpdate(
                    String.format(sqlStr,
                       
                       uniAEditar.getSiglas(),
                       uniAEditar.getNombrecomple(),
                       uniAEditar.getRector(),
                       uniAEditar.getId()
                    )
            );
            return registroAfectados > 0;
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }
    
    public static boolean eliminarUniversidad(Universidad uniAEliminar){
        try{
            String sqlStr = "DELETE FROM  universidades where id=%f;";
            
            Connection conn = Conn.obtenerConexion();
            Statement comandoSQL = conn.createStatement();
            int registroAfectados = comandoSQL.executeUpdate(
                    String.format(sqlStr,
                       uniAEliminar.getId()
                    )
            );
            return registroAfectados > 0;
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }
}
