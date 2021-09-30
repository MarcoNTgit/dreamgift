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
import javax.swing.JOptionPane;

/**
 *
 * @author caarlos
 */
public class UsuariosDAO  extends conectDb{
    conectDb conectar = new conectDb();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public int busca_usuarios_login(String idUsuario, String claveUsuario){
    int resultado;
    String sql = "SELECT es_activo FROM dg.usuarios WHERE id_usuario = ? AND clave_usuario = ? AND es_activo = 1";
    try{
        conn = conectar.getConexion();
        ps = conn.prepareStatement(sql);
        ps.setString(1, idUsuario);
        ps.setString(2, claveUsuario);
        rs = ps.executeQuery();
        if(rs.next()) {
            resultado = rs.getInt(1);
        } else{
            resultado = 0;
        }
            
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "Error de conexión E: " + e.getMessage());            
        return 0;
    }finally{
        try{
            conn.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión F: " + e.getMessage());            
            return 0;
        }
    }
    return resultado;
    }

}
