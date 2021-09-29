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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marco Bonilla
 */
public class redesDAO extends conectDb {

     
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
    
    
   /* public List listar(){
        PreparedStatement ps;   
        ResultSet rs ;
        Connection con =  getConexion();
       
        String sql="SELECT * FROM redes";
        
        List<redes>datos=new ArrayList<>();
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                redes red=new redes();
                red.setId_rrss(Integer.parseInt(rs.getString("id_rrss")));
                red.setNombre_red(rs.getString("nombre_red"));
                red.setEs_activo(Integer.parseInt (rs.getString("es_activo")));
                datos.add(red);
            }
        } catch (SQLException e) {
       System.err.println(e);
       
       }finally{
         try{
           con.close();
          }catch(SQLException e){
             System.err.println(e);
          }
       } 
        return datos;
    }*/
    
    
    public List buscar(redes redb) throws SQLException{
        PreparedStatement ps; 
        ResultSet rs ;
        Connection con =  getConexion();

        String sql="SELECT * FROM redes where id_rrss=? or nombre_red LIKE CONCAT('%',?,'%')";
        ps = con.prepareStatement(sql);
        ps.setInt(1, redb.getId_rrss());
        ps.setString(2, redb.getNombre_red());
        rs=ps.executeQuery();
        List<redes>datos=new ArrayList<>();
        try {
            while (rs.next()){
                redes red=new redes();
                red.setId_rrss(Integer.parseInt(rs.getString("id_rrss")));
                red.setNombre_red(rs.getString("nombre_red"));
                red.setEs_activo(Integer.parseInt (rs.getString("es_activo")));
                datos.add(red);
            }
        } catch (SQLException e) {
       System.err.println(e);
       
       }finally{
         try{
           con.close();
          }catch(SQLException e){
             System.err.println(e);
          }
       } 
        return datos;
    }

}
