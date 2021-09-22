package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class articulosDAO {
    conectDb conectar= new conectDb();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        List<articulos>datos=new ArrayList<>();
        String sql="SELECT * FROM dg.articulos";
        
        try {
            conn=conectar.getConexion();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                articulos a=new articulos();
                a.setIdArticulo(rs.getInt(0));
            }
        } catch (Exception e) {   
        }
        return datos;
    }
}
