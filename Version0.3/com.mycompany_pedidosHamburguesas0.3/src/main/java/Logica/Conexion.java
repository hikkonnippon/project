
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    static Connection conn = null;
    
    //Conexion a la base de datos de SQL PEDIDOSHAMBURGUESAS
    public static Connection conectar() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=PEDIDOSHAMBURGUESAS;encrypt=false;";
        String username = "userFabri";
        String password = "edujj281";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Error de SQL: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de conexión del driver: " + e.getMessage());
        }
        
        return conn;
    }
}
