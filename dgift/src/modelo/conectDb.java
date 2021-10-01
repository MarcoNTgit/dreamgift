package modelo;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class conectDb {
/* Conexion a base de datos en la nube */    
//    private final String BASE ="bfjckqmq9ts1wg2pmsv0";
//    private final String URL = "jdbc:mysql://u6nshiylpcrj0ubv:PkqAVXAQUbHFcYUu8IVx@bfjckqmq9ts1wg2pmsv0-mysql.services.clever-cloud.com:3306/" + BASE;
//    private final String USER = "u6nshiylpcrj0ubv";
//    private final String CLAVE = "PkqAVXAQUbHFcYUu8IVx";
    
/* Conexión a base de datos local Notebook */
//  private final String BASE ="dg";
//  private final String URL = "jdbc:mysql://localhost:3306/" + BASE;  
//  private final String USER = "root"; 
//  private final String CLAVE = "aw868950";

/* Conexión a base de datos local desktop */    
  private final String BASE ="dg";
  private final String URL = "jdbc:mysql://localhost:8689/" + BASE;  
  private final String USER = "caarlos";
  private final String CLAVE = "868950";
  
  private Connection con = null;

    
    public Connection getConexion(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        }catch(SQLException e){
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conectDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

   
}

