package modelo;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class conectDb {
    private final String BASE ="bfjckqmq9ts1wg2pmsv0";
    private final String URL = "jdbc:mysql://u6nshiylpcrj0ubv:PkqAVXAQUbHFcYUu8IVx@bfjckqmq9ts1wg2pmsv0-mysql.services.clever-cloud.com:3306/" + BASE;
    private final String USER = "u6nshiylpcrj0ubv";
    private final String CLAVE = "PkqAVXAQUbHFcYUu8IVx";
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

