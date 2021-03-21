package Logica;

//Mediante esta clase se hace conexion CRUM con la tabla empleado de la Base de Datos
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {

    private String NomEmpleado, ApeEmpleado, Usuario, Contraseña, sql;
    private long CodEmpleado, TelEmpleado;
    private ConexionBD connect = new ConexionBD();
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getNomEmpleado() {
        return NomEmpleado;
    }

    public void setNomEmpleado(String NomEmpleado) {
        this.NomEmpleado = NomEmpleado;
    }

    public String getApeEmpleado() {
        return ApeEmpleado;
    }

    public void setApeEmpleado(String ApeEmpleado) {
        this.ApeEmpleado = ApeEmpleado;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public long getCodEmpleado() {
        return CodEmpleado;
    }

    public void setCodEmpleado(long CodEmpleado) {
        this.CodEmpleado = CodEmpleado;
    }

    public long getTelEmpleado() {
        return TelEmpleado;
    }

    public void setTelEmpleado(long TelEmpleado) {
        this.TelEmpleado = TelEmpleado;
    }

    public boolean ExisteDocumento() {
        //connection = connect.getConnection();
        sql = "select * from empleado "
                + "where CodEmpleado=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, this.getCodEmpleado());
            rs = ps.executeQuery();
            if (rs.next()) {

                return true;
            } else {

                return false;
            }
        } catch (SQLException ex) {
            //connect.stopConnection();
            System.out.println("Error" + ex);
            //Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean ExisteUsuario() {
        //connection = connect.getConnection();
        sql = "select * from empleado "
                + "where Usuario=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, this.getUsuario());
            rs = ps.executeQuery();
            if (rs.next()) {

                return true;
            } else {

                return false;
            }
        } catch (SQLException ex) {
            //connect.stopConnection();
            System.out.println("Error" + ex);
            //Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean nuevoUsuario() {
        //connection = connect.getConnection();
        sql = "Insert into empleado(CodEmpleado, NomEmpleado, ApeEmpleado, TelEmpleado, Usuario, Contraseña) "
                + "values (?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, this.getCodEmpleado());
            ps.setString(2, this.getNomEmpleado());
            ps.setString(3, this.getApeEmpleado());
            ps.setLong(4, this.getTelEmpleado());
            ps.setString(5, this.getUsuario());
            ps.setString(6, this.getContraseña());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            //connect.stopConnection();
            System.out.println("Error" + ex);
            //Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean actualizarUsuario() {
        //connection = connect.getConnection();
        sql = "UPDATE empleado SET NomEmpleado=?, ApeEmpleado=?,TelEmpleado = ?, "
                + "Usuario = ?  where CodEmpleado = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, this.getNomEmpleado());
            ps.setString(2, this.getApeEmpleado());
            ps.setLong(3, this.getTelEmpleado());
            ps.setString(4, this.getUsuario());
            ps.setLong(5, this.getCodEmpleado());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            //connect.stopConnection();
            System.out.println("Error" + ex);
            //Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean ConsultarUsuarios() {

        sql = "select CodEmpleado, NomEmpleado, ApeEmpleado,TelEmpleado, Usuario, Contraseña from empleado "
                + "where CodEmpleado=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, this.getCodEmpleado());
            rs = ps.executeQuery();
            if (rs.next()) {
                this.setCodEmpleado(rs.getLong("CodEmpleado"));
                this.setNomEmpleado(rs.getString("NomEmpleado"));
                this.setApeEmpleado(rs.getString("ApeEmpleado"));
                this.setTelEmpleado(rs.getLong("TelEmpleado"));
                this.setUsuario(rs.getString("Usuario"));
                this.setContraseña(rs.getString("Contraseña"));

                //connect.stopConnection();
                return true;
            } else {
                //connect.stopConnection();

                return false;
            }
        } catch (SQLException ex) {
            //connect.stopConnection();
            System.out.println("Error" + ex);
            //Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean restablecerPassword() {
        //connection = connect.getConnection();
        String passwd = Encrypt.sha1(String.valueOf(this.getCodEmpleado()));
        try {
            sql = "UPDATE empleado SET Contraseña = ?"
                    + " where Usuario = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, passwd);
            ps.setString(2, this.getUsuario());
            ps.execute();

            sql = "select * from empleado where Usuario=? and Contraseña=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, this.getUsuario());
            ps.setString(2, passwd);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            //Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR: " + ex);
            return false;
        }
    }

    public boolean EliminarUsuario() {
        //connection = connect.getConnection();
        sql = "delete from empleado "
                + "where CodEmpleado=? and Usuario=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, this.getCodEmpleado());
            ps.setString(2, this.getUsuario());
            ps.execute();
            if (ExisteDocumento() && ExisteUsuario()) {
                //Usuario no eliminado
                return false;
            } else {
                //Usuario Eliminado
                return true;

            }
        } catch (SQLException ex) {
            //connect.stopConnection();
            System.out.println("Error" + ex);
            //Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            //Usuario no eliminado
            return false;
        }
    }
}
