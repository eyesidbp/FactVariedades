package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProveedorCompras {

    public String CodProveedor, NomProveedor, sql, CodCompra, CodProductoCompra, CodProveedorCompra, FechaCompra;
    public Long TelProveedor;
    public double valorCompra;
    int CantidadCompra;
    public String CodProveedor1, NomProveedor1;
    public Long TelProveedor1;
    private ConexionBD connect = new ConexionBD();
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public String getFechaCompra() {
        return FechaCompra;
    }

    public int getCantidadCompra() {
        return CantidadCompra;
    }

    public void setCantidadCompra(int CantidadCompra) {
        this.CantidadCompra = CantidadCompra;
    }

    public void setFechaCompra(String FechaCompra) {
        this.FechaCompra = FechaCompra;
    }

    public String getCodCompra() {
        return CodCompra;
    }

    public void setCodCompra(String CodCompra) {
        this.CodCompra = CodCompra;
    }

    public String getCodProductoCompra() {
        return CodProductoCompra;
    }

    public void setCodProductoCompra(String CodProductoCompra) {
        this.CodProductoCompra = CodProductoCompra;
    }

    public String getCodProveedorCompra() {
        return CodProveedorCompra;
    }

    public void setCodProveedorCompra(String CodProveedorCompra) {
        this.CodProveedorCompra = CodProveedorCompra;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getCodProveedor1() {
        return CodProveedor1;
    }

    public void setCodProveedor1(String CodProveedor1) {
        this.CodProveedor1 = CodProveedor1;
    }

    public String getNomProveedor1() {
        return NomProveedor1;
    }

    public void setNomProveedor1(String NomProveedor1) {
        this.NomProveedor1 = NomProveedor1;
    }

    public Long getTelProveedor1() {
        return TelProveedor1;
    }

    public void setTelProveedor1(Long TelProveedor1) {
        this.TelProveedor1 = TelProveedor1;
    }

    public String getCodProveedor() {
        return CodProveedor;
    }

    public void setCodProveedor(String CodProveedor) {
        this.CodProveedor = CodProveedor;
    }

    public String getNomProveedor() {
        return NomProveedor;
    }

    public void setNomProveedor(String NomProveedor) {
        this.NomProveedor = NomProveedor;
    }

    public Long getTelProveedor() {
        return TelProveedor;
    }

    public void setTelProveedor(Long TelProveedor) {
        this.TelProveedor = TelProveedor;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean ExisteCodProveedor(String CodProveedor) {
        // connection = connect.getConnection();
        sql = "select * from proveedor"
                + " where CodProveedor=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, CodProveedor);
            rs = ps.executeQuery();
            if (rs.next()) {
                //System.out.println("OK");
                //connect.stopConection();
                return true;
            } else {
                //System.out.println("Error");
                //connect.stopConection();
                return false;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion: " + ex);
            //connect.stopConection();
            return false;
        }
    }

    public boolean ExisteProveedor(String CodProveedor, String NomProveedor, long TelProveedor) {
        // connection = connect.getConnection();
        sql = "select * from proveedor"
                + " where CodProveedor=? and NomProveedor=? and TelProveedor=?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, CodProveedor);
            ps.setString(2, NomProveedor);
            ps.setLong(3, TelProveedor);
            rs = ps.executeQuery();
            if (rs.next()) {
                //System.out.println("OK");
                //connect.stopConection();
                return true;
            } else {
                //System.out.println("Error");
                //connect.stopConection();
                return false;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion: " + ex);
            //connect.stopConection();
            return false;
        }
    }

    public boolean crearProveedor() {
        //connection = connect.getConnection();
        String sql1 = "Insert into proveedor (CodProveedor,NomProveedor, TelProveedor) "
                + "values (?,?,?)";
        try {
            ps = connection.prepareStatement(sql1);

            ps.setString(1, getCodProveedor());
            ps.setString(2, getNomProveedor());
            ps.setLong(3, getTelProveedor());

            ps.execute();

            return true;
        } catch (SQLException ex) {
            //connect.stopConnection();
            System.out.println("Error" + ex);
            return false;
        }
    }

    public boolean ModificarProveedor() {
        //connection = connect.getConnection();
        sql = "UPDATE proveedor SET CodProveedor=?, NomProveedor=?,TelProveedor=? "
                + "where CodProveedor = ? and NomProveedor=? and TelProveedor=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, getCodProveedor());
            ps.setString(2, getNomProveedor());
            ps.setLong(3, getTelProveedor());
            ps.setString(4, getCodProveedor1());
            ps.setString(5, getNomProveedor1());
            ps.setLong(6, getTelProveedor1());
            System.out.println("Prueba modificacion ln160: " + ps);
            ps.execute();
            //connect.stopConection();
            return true;
        } catch (SQLException ex) {
            //connect.stopConnection();
            System.out.println("Error" + ex);
            //Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void EliminarProveedor() {
        sql = "delete from proveedor "
                + "where CodProveedor = ? and NomProveedor=? and TelProveedor=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, getCodProveedor());
            ps.setString(2, getNomProveedor());
            ps.setLong(3, getTelProveedor());
            //System.out.println(ps);
            ps.execute();
        } catch (SQLException ex) {
            //connect.stopConnection();
            System.out.println("Error" + ex);
            //Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String ObtenerCodProveedor(String NomProveedor) {
        //connection = connect.getConnection();
        //String Categoria;
        sql = "select * from proveedor "
                + "where NomProveedor=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, NomProveedor);
            //System.out.println("Sentencia Obtener Proveedor: " + ps);
            rs = ps.executeQuery();
            if (rs.next()) {
                //setCodCatProducto(rs.getString(1));
                return rs.getString(1);
                //return true;
            } else {
                //System.out.println("La Categoria " + DesCatProducto + " No Existe");
                //setCodCatProducto(null);
                return "";
            }
        } catch (SQLException ex) {
            //connect.stopConnection();
            System.out.println("Error" + ex);
            //Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        //connect.stopConection();
    }

    public boolean nuevaCompra(String CodProducto, String CodProveedor, double Valor, String FechaCompra, int Cantidad) {
        //connection = connect.getConnection();
        String sql1 = "INSERT INTO compra"
                + "(CodProducto, CodProveedor, Valor, FechaCompra, Cantidad)"
                + "VALUES(?,?,?,?,?);";
        try {
            ps = connection.prepareStatement(sql1);

            ps.setString(1, CodProducto);
            ps.setString(2, CodProveedor);
            ps.setDouble(3, Valor);
            ps.setString(4, FechaCompra);
            ps.setInt(5, Cantidad);
            //System.out.println("Prueba Compra. " + ps);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            //connect.stopConnection();
            System.out.println("Error" + ex);
            return false;
        }
    }
}
