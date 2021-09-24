/**
 * @author Carlos Thieme
 * fecha   13/09/2021
 * 
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ArticuloDAO extends conectDb {
    
    conectDb conectar = new conectDb();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public List listar(){
        List<Articulos>datos = new ArrayList<>();
        String sql = "SELECT * FROM dg.articulos";
        try{
            conn = conectar.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Articulos a = new Articulos();
                a.setIdArticulo(rs.getInt(1));
                a.setNombreArticulo(rs.getString(2));
                a.setStockArticulo(rs.getInt(3));
                a.setFechaVence(rs.getDate(4));
                a.setIdCategoria(rs.getInt(5));
                a.setPrecioArticulo(rs.getFloat(6));
                datos.add(a);

            }
            
        }catch (Exception e) {
            
        }
            
        return datos;
    }
    
    
    
        
}
