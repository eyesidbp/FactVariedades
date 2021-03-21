package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producto {

    private String CodCategoria, DesCategoria, CodCategoria1, DesCategoria1, CodProducto, DesProducto, CodCatProducto, sql;
    private ConexionBD connect = new ConexionBD();
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public String getCodCategoria1() {
        return CodCategoria1;
    }

    public void setCodCategoria1(String CodCategoria1) {
        this.CodCategoria1 = CodCategoria1;
    }

    public String getDesCategoria1() {
        return DesCategoria1;
    }

    public void setDesCategoria1(String DesCategoria1) {
        this.DesCategoria1 = DesCategoria1;
    }

    public String getCodCategoria() {
        return CodCategoria;
    }

    public void setCodCategoria(String CodCategoria) {
        this.CodCategoria = CodCategoria;
    }

    public String getDesCategoria() {
        return DesCategoria;
    }

    public void setDesCategoria(String DesCategoria) {
        this.DesCategoria = DesCategoria;
    }

    public String getCodProducto() {
        return CodProducto;
    }

    public void setCodProducto(String CodProducto) {
        this.CodProducto = CodProducto;
    }

    public String getDesProducto() {
        return DesProducto;
    }

    public void setDesProducto(String DesProducto) {
        this.DesProducto = DesProducto;
    }

    public String getCodCatProducto() {
        return CodCatProducto;
    }

    public void setCodCatProducto(String CodCatProducto) {
        this.CodCatProducto = CodCatProducto;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean ExisteCodCategoria(String CodCategoria) {
        //connection = connect.getConnection();
        sql = "select * from categoria_productos "
                + "where CodCategoria=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, CodCategoria);
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

    public boolean ExisteDescripcionCategoria(String DescCategoria) {
        //connection = connect.getConnection();
        sql = "select * from categoria_productos "
                + "where Descripcion=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, this.getDesCategoria());
            rs = ps.executeQuery();
            if (rs.next()) {

                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            //connect.stopConnection();
            System.out.println("Error" + ex);
            //Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean ExisteProductosCategoria() {
        //connection = connect.getConnection();
        sql = "select * from producto "
                + "where CodCategoria=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, this.getCodCatProducto());
            rs = ps.executeQuery();
            System.out.println("Antes de Eliminar: " + ps);
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            //connect.stopConnection();
            System.out.println("Error" + ex);
            //Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean crearCategoria() {
        //connection = connect.getConnection();
        sql = "Insert into categoria_productos(CodCategoria,Descripcion) "
                + "values (?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, this.getCodCategoria());
            ps.setString(2, this.getDesCategoria());
            System.out.println(ps);
            ps.execute();

            return true;
        } catch (SQLException ex) {
            //connect.stopConnection();
            System.out.println("Error" + ex);
            //Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean ModificarCategoria() {
        //connection = connect.getConnection();
        sql = "UPDATE categoria_productos SET CodCategoria=?, Descripcion=? where CodCategoria = ? and Descripcion=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, this.getCodCategoria());
            ps.setString(2, this.getDesCategoria());
            ps.setString(3, this.getCodCategoria1());
            ps.setString(4, this.getDesCategoria1());
            //System.out.println(ps);
            ps.execute();

            return true;
        } catch (SQLException ex) {
            //connect.stopConnection();
            System.out.println("Error" + ex);
            //Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void EliminarCategoria() {
        sql = "delete from categoria_productos "
                + "where CodCategoria=? and Descripcion=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, this.getCodCategoria());
            ps.setString(2, this.getDesCategoria());
            ps.execute();
        } catch (SQLException ex) {
            //connect.stopConnection();
            System.out.println("Error" + ex);
            //Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
