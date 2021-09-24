/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Marco Bonilla
 */
public class usuariosDAO extends conectDb {
    
    public boolean registrar(usuarios usu) throws SQLException{
     PreparedStatement ps =null;
     Connection con = getConexion();
     String sql = "INSERT INTO usuarios (nombre_usuario, clave_usuario, es_activo) VALUES (?,?,?)";
     
       try{
        ps = con.prepareStatement(sql);
        ps.setString(1, usu.getNombre_usuario());
        ps.setString(2, usu.getClave_usuario());
        ps.setInt(3, usu.getEs_activo());
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
    
    public boolean modificar(usuarios usu) throws SQLException {
     PreparedStatement ps = null;   
     Connection con =  getConexion();
     String sql = "UPDATE usuarios SET nombre_usuario=?, clave_usuario=?, es_activo=? WHERE id_usuario=?";
     
       try{
       ps = con.prepareStatement(sql);
       ps.setString(1, usu.getNombre_usuario());
       ps.setString(2, usu.getClave_usuario());
       ps.setInt(3, usu.getEs_activo());
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



}


     
