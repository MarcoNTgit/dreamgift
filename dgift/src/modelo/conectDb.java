package modelo;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class conectDb {
    public static final String URL = "jdbc:mysql://u6nshiylpcrj0ubv:PkqAVXAQUbHFcYUu8IVx@bfjckqmq9ts1wg2pmsv0-mysql.services.clever-cloud.com:3306/bfjckqmq9ts1wg2pmsv0";
    public static final String USER = "bfjckqmq9ts1wg2pmsv0";
    public static final String CLAVE = "PkqAVXAQUbHFcYUu8IVx";
     
    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
}
