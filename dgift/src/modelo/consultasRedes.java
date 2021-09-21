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
 * @author Pro 6300
 */
public class consultasRedes extends conectDb {

     
    public boolean registar(redes red) throws SQLException {
        
     PreparedStatement ps = null;   
     
     Connection con =  getConexion();
     
     String sql = "INSERT INTO redes ( nombre_red, es_activo ) VALUES (?,?)";
     
     ps = con.prepareStatement(sql);
     
       try{
     
       ps.setInt(1, red.getId_rrss());
     
       }catch{
           
           
       
       }
        
    }

}
