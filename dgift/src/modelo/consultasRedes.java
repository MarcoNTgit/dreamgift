/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pro 6300
 */
public class consultasRedes extends conectDb {

     
    public boolean registar(redes red) throws SQLException { 
     PreparedStatement ps = null;   
     Connection con =  getConexion();
     String sql = "INSERT INTO redes ( nombre_red, es_activo ) VALUES (?,?)";
     
       try{
       ps = con.prepareStatement(sql);
       ps.setString(1, red.getNombre_red());
       ps.setInt(2, red.getEs_activo()); 
       ps.execute();
       return true;
       }catch(SQLException e){
       System.err.println(e);
           return false;
       }finally{
         try{
           con.close();
          }catch(SQLException e){
             System.err.println(e);
          }
       } 
     
    }
    
    
    public boolean modificar(redes red) throws SQLException { 
     PreparedStatement ps = null;   
     Connection con =  getConexion();
     String sql = "UPDATE redes SET nombre_red=?, es_activo=? WHERE id_rrss=?";
     
       try{
       ps = con.prepareStatement(sql);
       ps.setString(1, red.getNombre_red());
       ps.setInt(2, red.getEs_activo());
       ps.setInt(3, red.getId_rrss());
       ps.execute();
       return true;
       }catch(SQLException e){
       System.err.println(e);
           return false;
       }finally{
         try{
             con.close();
          }catch(SQLException e){
             System.err.println(e);
          }
       } 
     
    }
    
    
    public boolean buscar(redes red) throws SQLException { 
     PreparedStatement ps = null;   
     ResultSet rs =null;
     Connection con =  getConexion();
     String sql = "SELECT * FROM redes WHERE id_rrss=?";
     
       try{
       ps = con.prepareStatement(sql);
       ps.setString(1, red.getNombre_red());
       ps.setInt(2, red.getEs_activo()); 
       rs = ps.executeQuery();
       
       
       return true;
       }catch(SQLException e){
       System.err.println(e);
           return false;
       }finally{
         try{
           con.close();
          }catch(SQLException e){
             System.err.println(e);
          }
       } 
     
    }

}
