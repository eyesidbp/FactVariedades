package Logica;

//Clase que posibilita la conexion de la Base de datos con el aplicativo
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {

    public static Connection conexion = null;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "h5UWGvy0uD";
    private static final String PASSWORD = "7hLs5NOPwV";
    private static final String URL = "jdbc:mysql://remotemysql.com/h5UWGvy0uD";

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(this.URL, this.USERNAME, this.PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error en la Base de Datos: " + e);
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            System.err.println("Error 1: " + ex);
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            //java.util.logging.Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    /*public Connection getConnection() {
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (conexion != null) {
                //System.out.println("Conexion Exitosa...");
            }
        } catch (ClassNotFoundException | SQLException e) {

            System.out.println("Error de Prueba: " + e);
        }
        return conexion;
    }*/

    public void stopConnection() {
        conexion = null;
    }

}
