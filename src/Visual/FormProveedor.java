package Visual;

import Images.Iconos;
import Logica.Compra;
import Logica.ConexionBD;
import Logica.Producto;
import Logica.ProveedorCompras;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormProveedor extends javax.swing.JFrame {

    Iconos icon = new Iconos();
    Connection connection = null;
    ConexionBD connect = new ConexionBD();
    PreparedStatement ps = null;
    ResultSet rs = null;
    ResultSetMetaData rsmd = null;
    public final String sqlTablaProveedor = "SELECT * from proveedor";
    public final String sqlTablaCompra
            = "SELECT  compra.CodCompra, producto.Descripcion, proveedor.NomProveedor ,compra.cantidad,compra.Valor, compra.FechaCompra "
            + "from compra, proveedor,producto "
            + "where compra.CodProducto = producto.CodProducto and compra.CodProveedor = proveedor.CodProveedor";
    //public final String slqTablaProducto
    //        = "SELECT producto.CodProducto, producto.Descripcion, categoria_productos.Descripcion"
    //        + " from producto, categoria_productos where producto.CodCategoria = categoria_productos.CodCategoria";
    public String filtroCategoria;
    private ProveedorCompras SQLProveedor = new ProveedorCompras();
    private Producto SQLProducto = new Producto();
    private Compra SQLCompra = new Compra();

    public FormProveedor() {
        connection = connect.getConexion();
        SQLProveedor.setConnection(connection);
        initComponents();
        this.setLocationRelativeTo(null);
        cargarDatosProveedor(sqlTablaProveedor);
        cargarDatosCompra(sqlTablaCompra);

    }

    public void cargarDatosCompra(String consulta) {
        int columnas;
        DefaultTableModel modeloCompra = new DefaultTableModel();
        tbCcompra.setBackground(new Color(204, 255, 204));
        tbCcompra.setModel(modeloCompra);
        //tbCcompra.getTableHeader().setBackground(Color.white);
        try {
            ps = connection.prepareStatement(consulta);
            //System.out.println(ps);
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            modeloCompra.addColumn("Cod");
            modeloCompra.addColumn("Producto");
            modeloCompra.addColumn("Proveedor");
            modeloCompra.addColumn("Cant");
            modeloCompra.addColumn("Valor");
            modeloCompra.addColumn("Fecha");
            int anchoCol[] = {50, 200, 200, 70, 100, 150};
            for (int i = 0; i < columnas; i++) {
                tbCcompra.getColumnModel().getColumn(i).setPreferredWidth(anchoCol[i]);
            }
            while (rs.next()) {
                Object[] filas = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modeloCompra.addRow(filas);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        cargarListaProductos();
        cargarListaProveedores();
        //cargarListaCategorias();
        //connect.stopConnection();
    }

    public void cargarDatosProveedor(String consulta) {
        int columnas;
        DefaultTableModel modeloCategoria = new DefaultTableModel();
        tbProveedor.setBackground(new Color(204, 255, 204));
        tbProveedor.setModel(modeloCategoria);
        tbProveedor.getTableHeader().setBackground(Color.white);
        try {
            ps = connection.prepareStatement(consulta);
            //System.out.println(ps);
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            modeloCategoria.addColumn("Codigo");
            modeloCategoria.addColumn("Nombre");
            modeloCategoria.addColumn("Telefono");
            int anchoCol[] = {100, 150, 150};
            for (int i = 0; i < columnas; i++) {
                tbProveedor.getColumnModel().getColumn(i).setPreferredWidth(anchoCol[i]);
            }
            while (rs.next()) {
                Object[] filas = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modeloCategoria.addRow(filas);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }

        //connect.stopConnection();
    }

    public void cargarListaProductos() {
        int columnas;
        cbProductoCompra.removeAllItems();
        try {
            ps = connection.prepareStatement("select * from producto");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            cbProductoCompra.addItem("Seleccione");
            while (rs.next()) {
                cbProductoCompra.addItem(rs.getObject(2).toString());
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void cargarListaProveedores() {
        int columnas;
        cbProveedorCompra.removeAllItems();
        try {
            ps = connection.prepareStatement("select * from proveedor");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            cbProveedorCompra.addItem("Seleccione");
            while (rs.next()) {
                cbProveedorCompra.addItem(rs.getObject(2).toString());
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    /*private void limpiarCategoria() {
        txtCodigoCategoria.setText(null);
        txtDescripcionCategoria.setText(null);
    }*/
    private void limpiarProveedor() {
        txtCodigoProveedor.setText(null);
        txtNombreProveedor.setText(null);
        txtTelefonoProveedor.setText(null);
        //System.out.println(cbFiltroCategoria.getSelectedIndex());
    }

    private String ObtenerMes(String Mes) {
        if (Mes.equals("Enero")) {
            return "01";
        } else if (Mes.equals("Febrero")) {
            return "02";
        } else if (Mes.equals("Marzo")) {
            return "03";
        } else if (Mes.equals("Abril")) {
            return "04";
        } else if (Mes.equals("Mayo")) {
            return "05";
        } else if (Mes.equals("Junio")) {
            return "06";
        } else if (Mes.equals("Julio")) {
            return "07";
        } else if (Mes.equals("Agosto")) {
            return "08";
        } else if (Mes.equals("Septiembre")) {
            return "09";
        } else if (Mes.equals("Octubre")) {
            return "10";
        } else if (Mes.equals("Noviembre")) {
            return "11";
        } else if (Mes.equals("Diciembre")) {
            return "12";
        } else {
            return "00";
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnFondo = new javax.swing.JPanel();
        pnTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        sep1 = new javax.swing.JSeparator();
        tpProveedores = new javax.swing.JTabbedPane();
        tabCompras = new javax.swing.JPanel();
        pnListadoCompras = new javax.swing.JPanel();
        lblBuscarCompra = new javax.swing.JLabel();
        txtBuscarCompra = new javax.swing.JTextField();
        spTablaCategoria = new javax.swing.JScrollPane();
        tbCcompra = new javax.swing.JTable();
        pnDatosCompras = new javax.swing.JPanel();
        lblProductoCompra = new javax.swing.JLabel();
        lblProveedorCompra = new javax.swing.JLabel();
        lblCantidadCompra = new javax.swing.JLabel();
        lblValorCompra = new javax.swing.JLabel();
        lblFechaCompra = new javax.swing.JLabel();
        lblFechaDia = new javax.swing.JLabel();
        lblFechaMes = new javax.swing.JLabel();
        lblFechaAño = new javax.swing.JLabel();
        cbProductoCompra = new javax.swing.JComboBox<>();
        cbProveedorCompra = new javax.swing.JComboBox<>();
        txtValorCompra = new javax.swing.JTextField();
        txtCantidadCompra = new javax.swing.JTextField();
        txtFechaDia = new javax.swing.JTextField();
        txtFechaAño = new javax.swing.JTextField();
        cbFechaMes = new javax.swing.JComboBox<>();
        pnBotonesCompras = new javax.swing.JPanel();
        btnGuardarCompra = new javax.swing.JButton();
        btnModificarCompra = new javax.swing.JButton();
        btnLimpiarCompra = new javax.swing.JButton();
        btnEliminarCompra = new javax.swing.JButton();
        tabProveedores = new javax.swing.JPanel();
        pnListadoProveedores = new javax.swing.JPanel();
        lblBuscarProveedor = new javax.swing.JLabel();
        txtBuscarProveedor = new javax.swing.JTextField();
        spTablaProveedor = new javax.swing.JScrollPane();
        tbProveedor = new javax.swing.JTable();
        pnDatosProducto = new javax.swing.JPanel();
        lblCodigoProveedor = new javax.swing.JLabel();
        lblNombreProveedor = new javax.swing.JLabel();
        lblTelProveedor = new javax.swing.JLabel();
        txtCodigoProveedor = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        txtTelefonoProveedor = new javax.swing.JTextField();
        pnBotonesProveedor = new javax.swing.JPanel();
        btnGuardarProveedor = new javax.swing.JButton();
        btnModificarProveedor = new javax.swing.JButton();
        btnLimpiarProveedor = new javax.swing.JButton();
        btnEliminarProveedor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuarios");

        pnFondo.setBackground(new java.awt.Color(255, 255, 255));

        pnTitulo.setBackground(new java.awt.Color(204, 255, 204));
        pnTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTitulo.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("ADMINISTRACION DE PRODUCTOS");

        javax.swing.GroupLayout pnTituloLayout = new javax.swing.GroupLayout(pnTitulo);
        pnTitulo.setLayout(pnTituloLayout);
        pnTituloLayout.setHorizontalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnTituloLayout.setVerticalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        sep1.setForeground(new java.awt.Color(0, 0, 0));

        tpProveedores.setBackground(new java.awt.Color(204, 255, 204));
        tpProveedores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tpProveedores.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        tpProveedores.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tpProveedoresFocusGained(evt);
            }
        });
        tpProveedores.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tpProveedoresComponentShown(evt);
            }
        });

        tabCompras.setBackground(new java.awt.Color(204, 255, 204));
        tabCompras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabComprasFocusGained(evt);
            }
        });

        pnListadoCompras.setBackground(new java.awt.Color(153, 255, 204));

        lblBuscarCompra.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblBuscarCompra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBuscarCompra.setText("Buscar");

        txtBuscarCompra.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtBuscarCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarCompraKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarCompraKeyReleased(evt);
            }
        });

        tbCcompra.setBackground(new java.awt.Color(153, 255, 204));
        tbCcompra.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        tbCcompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Producto", "Proveedor", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCcompra.setGridColor(new java.awt.Color(0, 0, 0));
        tbCcompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCcompraMouseClicked(evt);
            }
        });
        spTablaCategoria.setViewportView(tbCcompra);

        javax.swing.GroupLayout pnListadoComprasLayout = new javax.swing.GroupLayout(pnListadoCompras);
        pnListadoCompras.setLayout(pnListadoComprasLayout);
        pnListadoComprasLayout.setHorizontalGroup(
            pnListadoComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTablaCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
            .addGroup(pnListadoComprasLayout.createSequentialGroup()
                .addComponent(lblBuscarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBuscarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnListadoComprasLayout.setVerticalGroup(
            pnListadoComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnListadoComprasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnListadoComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTablaCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
        );

        pnDatosCompras.setBackground(new java.awt.Color(153, 255, 204));

        lblProductoCompra.setBackground(new java.awt.Color(255, 255, 255));
        lblProductoCompra.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblProductoCompra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProductoCompra.setText("Producto");

        lblProveedorCompra.setBackground(new java.awt.Color(255, 255, 255));
        lblProveedorCompra.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblProveedorCompra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProveedorCompra.setText("Proveedor");

        lblCantidadCompra.setBackground(new java.awt.Color(255, 255, 255));
        lblCantidadCompra.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblCantidadCompra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCantidadCompra.setText("Cantidad");

        lblValorCompra.setBackground(new java.awt.Color(255, 255, 255));
        lblValorCompra.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblValorCompra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblValorCompra.setText("Valor UN");

        lblFechaCompra.setBackground(new java.awt.Color(255, 255, 255));
        lblFechaCompra.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblFechaCompra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFechaCompra.setText("Fecha:");

        lblFechaDia.setBackground(new java.awt.Color(255, 255, 255));
        lblFechaDia.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblFechaDia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFechaDia.setText("D");

        lblFechaMes.setBackground(new java.awt.Color(255, 255, 255));
        lblFechaMes.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblFechaMes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFechaMes.setText("M");

        lblFechaAño.setBackground(new java.awt.Color(255, 255, 255));
        lblFechaAño.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblFechaAño.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFechaAño.setText("A");

        cbProductoCompra.setBackground(new java.awt.Color(204, 255, 204));
        cbProductoCompra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        cbProveedorCompra.setBackground(new java.awt.Color(204, 255, 204));
        cbProveedorCompra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        txtValorCompra.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtValorCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorCompraKeyTyped(evt);
            }
        });

        txtCantidadCompra.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtCantidadCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadCompraKeyTyped(evt);
            }
        });

        txtFechaDia.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtFechaDia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaDiaKeyTyped(evt);
            }
        });

        txtFechaAño.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtFechaAño.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaAñoKeyTyped(evt);
            }
        });

        cbFechaMes.setBackground(new java.awt.Color(204, 255, 204));
        cbFechaMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        javax.swing.GroupLayout pnDatosComprasLayout = new javax.swing.GroupLayout(pnDatosCompras);
        pnDatosCompras.setLayout(pnDatosComprasLayout);
        pnDatosComprasLayout.setHorizontalGroup(
            pnDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatosComprasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatosComprasLayout.createSequentialGroup()
                        .addComponent(lblFechaCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFechaDia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaDia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFechaMes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFechaMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFechaAño)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaAño)
                        .addContainerGap())
                    .addGroup(pnDatosComprasLayout.createSequentialGroup()
                        .addGroup(pnDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDatosComprasLayout.createSequentialGroup()
                                .addComponent(lblProveedorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbProveedorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnDatosComprasLayout.createSequentialGroup()
                                .addComponent(lblProductoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbProductoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnDatosComprasLayout.createSequentialGroup()
                                .addGroup(pnDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCantidadCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCantidadCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 69, Short.MAX_VALUE))))
        );
        pnDatosComprasLayout.setVerticalGroup(
            pnDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatosComprasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbProductoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProveedorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbProveedorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidadCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDatosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaDia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaAño, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaDia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaMes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaAño, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFechaMes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnBotonesCompras.setBackground(new java.awt.Color(153, 255, 204));

        btnGuardarCompra.setBackground(new java.awt.Color(204, 255, 204));
        btnGuardarCompra.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnGuardarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        btnGuardarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCompraActionPerformed(evt);
            }
        });

        btnModificarCompra.setBackground(new java.awt.Color(204, 255, 204));
        btnModificarCompra.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnModificarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editar.png"))); // NOI18N
        btnModificarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCompraActionPerformed(evt);
            }
        });

        btnLimpiarCompra.setBackground(new java.awt.Color(204, 255, 204));
        btnLimpiarCompra.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnLimpiarCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel1.png"))); // NOI18N
        btnLimpiarCompra.setBorder(null);
        btnLimpiarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCompraActionPerformed(evt);
            }
        });

        btnEliminarCompra.setBackground(new java.awt.Color(204, 255, 204));
        btnEliminarCompra.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnEliminarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/trash.png"))); // NOI18N
        btnEliminarCompra.setBorder(null);
        btnEliminarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotonesComprasLayout = new javax.swing.GroupLayout(pnBotonesCompras);
        pnBotonesCompras.setLayout(pnBotonesComprasLayout);
        pnBotonesComprasLayout.setHorizontalGroup(
            pnBotonesComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBotonesComprasLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnGuardarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnBotonesComprasLayout.setVerticalGroup(
            pnBotonesComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotonesComprasLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnBotonesComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabComprasLayout = new javax.swing.GroupLayout(tabCompras);
        tabCompras.setLayout(tabComprasLayout);
        tabComprasLayout.setHorizontalGroup(
            tabComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabComprasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnListadoCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDatosCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBotonesCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        tabComprasLayout.setVerticalGroup(
            tabComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabComprasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnListadoCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabComprasLayout.createSequentialGroup()
                        .addComponent(pnDatosCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnBotonesCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tpProveedores.addTab("Compras", tabCompras);

        tabProveedores.setBackground(new java.awt.Color(204, 255, 204));
        tabProveedores.setForeground(new java.awt.Color(204, 255, 204));
        tabProveedores.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabProveedoresFocusGained(evt);
            }
        });

        pnListadoProveedores.setBackground(new java.awt.Color(153, 255, 204));

        lblBuscarProveedor.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblBuscarProveedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBuscarProveedor.setText("Buscar");

        txtBuscarProveedor.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtBuscarProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarProveedorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProveedorKeyReleased(evt);
            }
        });

        tbProveedor.setBackground(new java.awt.Color(153, 255, 204));
        tbProveedor.setFont(new java.awt.Font("Century", 0, 10)); // NOI18N
        tbProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, "", null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProveedor.setGridColor(new java.awt.Color(0, 0, 0));
        tbProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProveedorMouseClicked(evt);
            }
        });
        spTablaProveedor.setViewportView(tbProveedor);

        javax.swing.GroupLayout pnListadoProveedoresLayout = new javax.swing.GroupLayout(pnListadoProveedores);
        pnListadoProveedores.setLayout(pnListadoProveedoresLayout);
        pnListadoProveedoresLayout.setHorizontalGroup(
            pnListadoProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTablaProveedor)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnListadoProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnListadoProveedoresLayout.setVerticalGroup(
            pnListadoProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnListadoProveedoresLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnListadoProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTablaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        pnDatosProducto.setBackground(new java.awt.Color(153, 255, 204));

        lblCodigoProveedor.setBackground(new java.awt.Color(255, 255, 255));
        lblCodigoProveedor.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblCodigoProveedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCodigoProveedor.setText("Codigo");

        lblNombreProveedor.setBackground(new java.awt.Color(255, 255, 255));
        lblNombreProveedor.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblNombreProveedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombreProveedor.setText("Nombre");

        lblTelProveedor.setBackground(new java.awt.Color(255, 255, 255));
        lblTelProveedor.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblTelProveedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTelProveedor.setText("Telefono");

        txtCodigoProveedor.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtCodigoProveedor.setToolTipText("");
        txtCodigoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoProveedorActionPerformed(evt);
            }
        });
        txtCodigoProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoProveedorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProveedorKeyTyped(evt);
            }
        });

        txtNombreProveedor.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtNombreProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProveedorKeyTyped(evt);
            }
        });

        txtTelefonoProveedor.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtTelefonoProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoProveedorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnDatosProductoLayout = new javax.swing.GroupLayout(pnDatosProducto);
        pnDatosProducto.setLayout(pnDatosProductoLayout);
        pnDatosProductoLayout.setHorizontalGroup(
            pnDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatosProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnDatosProductoLayout.createSequentialGroup()
                        .addComponent(lblTelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                    .addGroup(pnDatosProductoLayout.createSequentialGroup()
                        .addComponent(lblNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreProveedor))
                    .addGroup(pnDatosProductoLayout.createSequentialGroup()
                        .addComponent(lblCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigoProveedor)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnDatosProductoLayout.setVerticalGroup(
            pnDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatosProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(pnDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnBotonesProveedor.setBackground(new java.awt.Color(153, 255, 204));

        btnGuardarProveedor.setBackground(new java.awt.Color(204, 255, 204));
        btnGuardarProveedor.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnGuardarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        btnGuardarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProveedorActionPerformed(evt);
            }
        });

        btnModificarProveedor.setBackground(new java.awt.Color(204, 255, 204));
        btnModificarProveedor.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnModificarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editar.png"))); // NOI18N
        btnModificarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProveedorActionPerformed(evt);
            }
        });

        btnLimpiarProveedor.setBackground(new java.awt.Color(204, 255, 204));
        btnLimpiarProveedor.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnLimpiarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel1.png"))); // NOI18N
        btnLimpiarProveedor.setBorder(null);
        btnLimpiarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarProveedorActionPerformed(evt);
            }
        });

        btnEliminarProveedor.setBackground(new java.awt.Color(204, 255, 204));
        btnEliminarProveedor.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnEliminarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/trash.png"))); // NOI18N
        btnEliminarProveedor.setBorder(null);
        btnEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotonesProveedorLayout = new javax.swing.GroupLayout(pnBotonesProveedor);
        pnBotonesProveedor.setLayout(pnBotonesProveedorLayout);
        pnBotonesProveedorLayout.setHorizontalGroup(
            pnBotonesProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBotonesProveedorLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(pnBotonesProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(pnBotonesProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        pnBotonesProveedorLayout.setVerticalGroup(
            pnBotonesProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotonesProveedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnBotonesProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificarProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnBotonesProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout tabProveedoresLayout = new javax.swing.GroupLayout(tabProveedores);
        tabProveedores.setLayout(tabProveedoresLayout);
        tabProveedoresLayout.setHorizontalGroup(
            tabProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnListadoProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tabProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDatosProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBotonesProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        tabProveedoresLayout.setVerticalGroup(
            tabProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnListadoProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tabProveedoresLayout.createSequentialGroup()
                        .addComponent(pnDatosProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(pnBotonesProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tpProveedores.addTab("Proveedores", tabProveedores);

        javax.swing.GroupLayout pnFondoLayout = new javax.swing.GroupLayout(pnFondo);
        pnFondo.setLayout(pnFondoLayout);
        pnFondoLayout.setHorizontalGroup(
            pnFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFondoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sep1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tpProveedores))
                .addGap(13, 13, 13))
        );
        pnFondoLayout.setVerticalGroup(
            pnFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private static boolean isNum(char caracter) {
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b')) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean isLetter(char caracter) {
        if (((caracter < 'a') || (caracter > 'z')) && ((caracter < 'A') || (caracter > 'Z'))
                && (caracter != '\b') && (caracter != ' ')) {
            return true;
        } else {
            return false;
        }
    }
    private void tpProveedoresFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tpProveedoresFocusGained
        cargarDatosProveedor(sqlTablaProveedor);

    }//GEN-LAST:event_tpProveedoresFocusGained

    private void tbProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProveedorMouseClicked
        int fila = tbProveedor.getSelectedRow();

        //System.out.println("Tercer Dato: " + tbProducto.getValueAt(fila, 2));
        SQLProveedor.setCodProveedor(tbProveedor.getValueAt(fila, 0).toString());
        SQLProveedor.setNomProveedor(tbProveedor.getValueAt(fila, 1).toString());
        SQLProveedor.setTelProveedor(Long.parseLong(tbProveedor.getValueAt(fila, 2).toString()));

        txtCodigoProveedor.setText(SQLProveedor.getCodProveedor());
        txtNombreProveedor.setText(SQLProveedor.getNomProveedor());
        txtTelefonoProveedor.setText(SQLProveedor.getTelProveedor().toString());

        SQLProveedor.setCodProveedor1(tbProveedor.getValueAt(fila, 0).toString());
        SQLProveedor.setNomProveedor1(tbProveedor.getValueAt(fila, 1).toString());
        SQLProveedor.setTelProveedor1(Long.parseLong(tbProveedor.getValueAt(fila, 2).toString()));
    }//GEN-LAST:event_tbProveedorMouseClicked

    private void txtBuscarProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProveedorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProveedorKeyPressed

    private void txtBuscarProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProveedorKeyReleased
        buscarProveedor();
    }//GEN-LAST:event_txtBuscarProveedorKeyReleased
    public void buscarProveedor() {
        cargarDatosProveedor(sqlTablaProveedor + " where "
                + "(CodProveedor like '%" + txtBuscarProveedor.getText() + "%' "
                + "or NomProveedor like '%" + txtBuscarProveedor.getText() + "%' "
                + "or TelProveedor like '%" + txtBuscarProveedor.getText().toString() + "%') "
        );
    }
    private void txtCodigoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProveedorActionPerformed

    private void txtCodigoProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProveedorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProveedorKeyPressed

    private void txtCodigoProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProveedorKeyTyped
        txtCodigoProveedor.setBackground(Color.white);
        if (!isNum(evt.getKeyChar())) {
            //getToolkit().beep();
            JOptionPane.showMessageDialog(null, "<html><center>El dato ingresado no es valido,<br>"
                    + "solo se aceptan numeros</center><html>",
                    "Dato no Valido", JOptionPane.PLAIN_MESSAGE, icon.getCancelIcon());
            evt.consume();
        }
        if (txtCodigoProveedor.getText().length() >= 10) {
            JOptionPane.showMessageDialog(null, "Solo se aceptan 30 caracteres");
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoProveedorKeyTyped

    private void txtNombreProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProveedorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProveedorKeyTyped

    private void btnGuardarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProveedorActionPerformed

        if (txtCodigoProveedor.getText().equals("") || txtNombreProveedor.getText().equals("")
                || txtTelefonoProveedor.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, icon.getHandIcon());

        } else {
            SQLProveedor.setCodProveedor(txtCodigoProveedor.getText());
            SQLProveedor.setNomProveedor(txtNombreProveedor.getText());
            SQLProveedor.setTelProveedor(Long.parseLong(txtTelefonoProveedor.getText()));

            if (SQLProveedor.ExisteCodProveedor(SQLProveedor.getCodProveedor())) {

                JOptionPane.showMessageDialog(null, "El Codigo ingresado ya existe\n"
                        + "Si lo va a actualizar presione modificar", "Dato ya existe",
                        JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
            } else {
                if (SQLProveedor.crearProveedor()) { //System.out.println("Ingreso Exitoso");
                    JOptionPane.showMessageDialog(null, "Se creo el proveedor exitosamente",
                            "Ingreso Exitoso", JOptionPane.PLAIN_MESSAGE, icon.getOkIcon());
                } else {
                    System.out.println("ERROR");

                }
            }
        }
        cargarDatosProveedor(sqlTablaProveedor);
    }//GEN-LAST:event_btnGuardarProveedorActionPerformed

    private void btnModificarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProveedorActionPerformed
        if (txtCodigoProveedor.getText().equals("")
                || txtNombreProveedor.getText().equals("")
                || txtTelefonoProveedor.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, icon.getHandIcon());

        } else {
            SQLProveedor.setCodProveedor(txtCodigoProveedor.getText());
            SQLProveedor.setNomProveedor(txtNombreProveedor.getText());
            SQLProveedor.setTelProveedor(Long.parseLong(txtTelefonoProveedor.getText().toString()));

            if (SQLProveedor.ExisteProveedor(SQLProveedor.getCodProveedor1(), SQLProveedor.getNomProveedor1(), SQLProveedor.getTelProveedor1())) {

                SQLProveedor.setCodProveedor(txtCodigoProveedor.getText());
                SQLProveedor.setNomProveedor(txtNombreProveedor.getText());
                SQLProveedor.setTelProveedor(Long.parseLong(txtTelefonoProveedor.getText().toString()));

                if (SQLProveedor.getCodProveedor().equals(SQLProveedor.getCodProveedor1())
                        && SQLProveedor.getNomProveedor().equals(SQLProveedor.getNomProveedor1())
                        && SQLProveedor.getTelProveedor().equals(SQLProveedor.getTelProveedor1())) {

                    JOptionPane.showMessageDialog(null, "<html><center>No Se Actualizaron Los Datos,<br>"
                            + "Los Datos Ingresados Son Iguales A Los Almacenados</center><html>",
                            "Actualización Erronea", JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
                } else {

                    if (SQLProveedor.getCodProveedor().equals(SQLProveedor.getCodProveedor1())) {
                        if (SQLProveedor.ModificarProveedor()) {
                            JOptionPane.showMessageDialog(null, "Se modificaron los datos correctamente",
                                    "Actualización Exitosa", JOptionPane.PLAIN_MESSAGE, icon.getOkIcon());
                        } else {
                            System.out.println("ERROR");
                        }
                    } else {
                        if (SQLProveedor.ExisteCodProveedor(SQLProveedor.getCodProveedor())) {
                            JOptionPane.showMessageDialog(null, "El Codigo Ingresado Ya Existe",
                                    "No Se Puede Modificar", JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
                        } else {
                            if (SQLProveedor.ModificarProveedor()) {
                                JOptionPane.showMessageDialog(null, "Se modificaron los datos correctamente",
                                        "Actualización Exitosa", JOptionPane.PLAIN_MESSAGE, icon.getOkIcon());
                            } else {
                                System.out.println("ERROR");
                            }
                        }
                    }
                }

            } else {
            }
        }

        //limpiarProducto();
        cargarDatosProveedor(sqlTablaProveedor);
    }//GEN-LAST:event_btnModificarProveedorActionPerformed

    private void btnLimpiarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarProveedorActionPerformed
        limpiarProveedor();
    }//GEN-LAST:event_btnLimpiarProveedorActionPerformed

    private void btnEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProveedorActionPerformed
        SQLProveedor.setCodProveedor(txtCodigoProveedor.getText());
        SQLProveedor.setNomProveedor(txtNombreProveedor.getText());
        SQLProveedor.setTelProveedor(Long.parseLong(txtTelefonoProveedor.getText().toString()));

        if (txtCodigoProveedor.getText().equals("") || txtNombreProveedor.getText().equals("")
                || txtTelefonoProveedor.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes\n"
                    + "o seleccione un dato de la tabla", "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, icon.getHandIcon());

        } else {

            if (!SQLProveedor.ExisteProveedor(
                    SQLProveedor.getCodProveedor(), SQLProveedor.getNomProveedor(), SQLProveedor.getTelProveedor())) {
                JOptionPane.showMessageDialog(null, "Los datos ingresados no coindiden",
                        "Error de eliminacion", JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
            } else {

                SQLProveedor.EliminarProveedor();
                if (SQLProveedor.ExisteProveedor(
                        SQLProveedor.getCodProveedor(), SQLProveedor.getNomProveedor(), SQLProveedor.getTelProveedor())) {
                    JOptionPane.showMessageDialog(null, "No se eimino el proveedor\nIntente nuevamente",
                            "Error de eliminacion", JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
                } else {

                    JOptionPane.showMessageDialog(null, "Se eliminaron los datos exitosamente",
                            "Eliminacion exitosa", JOptionPane.PLAIN_MESSAGE, icon.getOkIcon());
                }

            }
        }
        cargarDatosProveedor(sqlTablaProveedor);
    }//GEN-LAST:event_btnEliminarProveedorActionPerformed

    private void tpProveedoresComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tpProveedoresComponentShown

    }//GEN-LAST:event_tpProveedoresComponentShown

    private void tabProveedoresFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabProveedoresFocusGained

    }//GEN-LAST:event_tabProveedoresFocusGained

    private void tabComprasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabComprasFocusGained

    }//GEN-LAST:event_tabComprasFocusGained

    private void btnEliminarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCompraActionPerformed
        /*        SQLProducto.setCodCategoria(txtCodigoCategoria.getText());
        SQLProducto.setDesCategoria(txtDescripcionCategoria.getText());
        SQLProducto.setCodCatProducto(txtCodigoCategoria.getText());

        if (txtCodigoCategoria.getText().equals("") || txtDescripcionCategoria.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes\n"
                    + "o seleccione un dato de la tabla", "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, icon.getHandIcon());
        } else {
            if (!SQLProducto.ExisteCodCategoria(SQLProducto.getCodCategoria())
                    || !SQLProducto.ExisteDescripcionCategoria(SQLProducto.getDesCategoria())) {
                JOptionPane.showMessageDialog(null, "Los datos ingresados no coindiden",
                        "Error de eliminacion", JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
            } else {
                if (SQLProducto.ExisteProductosCategoria()) {
                    JOptionPane.showMessageDialog(null,
                            "Existen productos asignados a esa categoria\nEliminelos o modifiquelos antes de continuar",
                            "Error de eliminacion", JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
                } else {
                    SQLProducto.EliminarCategoria();
                    JOptionPane.showMessageDialog(null, "Se eliminaron los datos exitosamente",
                            "Eliminacion exitosa", JOptionPane.PLAIN_MESSAGE, icon.getOkIcon());
                }
            }
        }
        cargarDatosCategoria(slqTablaCategoria);*/
    }//GEN-LAST:event_btnEliminarCompraActionPerformed

    private void btnLimpiarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCompraActionPerformed
        //limpiarCategoria();

        Calendar c1 = Calendar.getInstance();
        //Calendar c2 = new GregorianCalendar();
        System.out.println("Año: " + Integer.toString(c1.get(Calendar.DATE))
                + "\nMes: " + Integer.toString(c1.get(Calendar.MONTH))
                + "\nMes: " + Integer.toString(c1.get(Calendar.YEAR)));

    }//GEN-LAST:event_btnLimpiarCompraActionPerformed

    private void btnModificarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCompraActionPerformed
        /*SQLProducto.setCodCategoria(SQLProducto.getCodCategoria1());
        SQLProducto.setDesCategoria(SQLProducto.getDesCategoria1());

        if (txtCodigoCategoria.getText().equals("") || txtDescripcionCategoria.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, icon.getHandIcon());
        } else {
            if (SQLProducto.ExisteCodCategoria(SQLProducto.getCodCategoria1())
                    && SQLProducto.ExisteDescripcionCategoria(SQLProducto.getDesCategoria1())) {

                SQLProducto.setCodCategoria(txtCodigoCategoria.getText());
                SQLProducto.setDesCategoria(txtDescripcionCategoria.getText());

                if (SQLProducto.getCodCategoria().equals(SQLProducto.getCodCategoria1())
                        && SQLProducto.getDesCategoria().equals(SQLProducto.getDesCategoria1())) {
                    JOptionPane.showMessageDialog(null, "<html><center>No Se Actualizaron Los Datos,<br>"
                            + "Los Datos Ingresados Son Iguales A Los Almacenados</center><html>",
                            "Actualización Erronea", JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
                } else {

                    if (SQLProducto.getCodCategoria().equals(SQLProducto.getCodCategoria1())) {
                        if (SQLProducto.ModificarCategoria()) {
                            JOptionPane.showMessageDialog(null, "Se modificaron los datos correctamente",
                                    "Actualización Exitosa", JOptionPane.PLAIN_MESSAGE, icon.getOkIcon());
                            //cargarDatosCategoria(this.slqTablaCategoria);
                        } else {
                            System.out.println("ERROR de Actualizacion ln:917");
                        }
                    } else {
                        if (SQLProducto.ExisteCodCategoria(SQLProducto.getCodCategoria())) {
                            JOptionPane.showMessageDialog(null, "El Codigo Ingresado Ya Existe",
                                    "No Se Puede Modificar",
                                    JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
                        } else {
                            if (SQLProducto.ModificarCategoria()) {
                                JOptionPane.showMessageDialog(null, "Se modificaron los datos correctamente",
                                        "Actualización Exitosa", JOptionPane.PLAIN_MESSAGE, icon.getOkIcon());

                            } else {
                                System.out.println("ERROR de Actualizacion ln:930");
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "<html><center>No Se Encontraron Datos Para Ser Actualizados,<br>"
                        + "Seleccione El Valor De La Tabla e Intente De Nuevo</center><html>",
                        "Error de Actualizacion", JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
            }

        }
        cargarDatosCategoria(this.slqTablaCategoria);
        limpiarCategoria();*/
    }//GEN-LAST:event_btnModificarCompraActionPerformed

    private void btnGuardarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCompraActionPerformed
        if (cbProductoCompra.getSelectedItem().equals("Seleccione")
                || cbProveedorCompra.getSelectedItem().equals("Seleccione")
                || txtValorCompra.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, icon.getHandIcon());

        } else {

            SQLProducto.setDesProducto(cbProductoCompra.getSelectedItem().toString());
            SQLProveedor.setNomProveedor(cbProveedorCompra.getSelectedItem().toString());

            SQLProveedor.setCodProductoCompra(SQLProducto.ObtenerCodProducto(cbProductoCompra.getSelectedItem().toString()));
            SQLProveedor.setCodProveedorCompra(SQLProveedor.ObtenerCodProveedor(cbProveedorCompra.getSelectedItem().toString()));
            SQLProveedor.setValorCompra(Double.parseDouble(txtValorCompra.getText()));
            SQLProveedor.setFechaCompra(txtFechaAño.getText() + "/" + ObtenerMes(cbFechaMes.getSelectedItem().toString()) + "/" + txtFechaDia.getText());
            SQLProveedor.setCantidadCompra(Integer.parseInt(txtCantidadCompra.getText()));

            if (SQLProveedor.getCodProductoCompra() != ""
                    && SQLProveedor.getCodProveedorCompra() != "") {

                if (SQLProveedor.nuevaCompra(SQLProveedor.getCodProductoCompra(),
                        SQLProveedor.getCodProveedorCompra(),
                        SQLProveedor.getValorCompra(),
                        SQLProveedor.getFechaCompra(),
                        SQLProveedor.getCantidadCompra())) { //System.out.println("Ingreso Exitoso");
                    JOptionPane.showMessageDialog(null, "Se Creo la Categoria Exitosamente",
                            "Ingreso Exitoso", JOptionPane.PLAIN_MESSAGE, icon.getOkIcon());
                } else {
                    System.out.println("ERROR");

                }

            } else {
                JOptionPane.showMessageDialog(null, "El producto o proveedor ingresado  no existe", "Datos no existen",
                        JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
            }
        }

        cargarDatosCompra(sqlTablaCompra);
    }//GEN-LAST:event_btnGuardarCompraActionPerformed

    private void tbCcompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCcompraMouseClicked
        /*        int fila = tbCategoria.getSelectedRow();

        SQLProducto.setCodCategoria(tbCategoria.getValueAt(fila, 0).toString());
        SQLProducto.setDesCategoria(tbCategoria.getValueAt(fila, 1).toString());

        txtCodigoCategoria.setText(SQLProducto.getCodCategoria());
        txtDescripcionCategoria.setText(SQLProducto.getDesCategoria());

        SQLProducto.setCodCategoria1(tbCategoria.getValueAt(fila, 0).toString());
        SQLProducto.setDesCategoria1(tbCategoria.getValueAt(fila, 1).toString());*/
    }//GEN-LAST:event_tbCcompraMouseClicked

    private void txtBuscarCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCompraKeyReleased
        cargarDatosCompra(sqlTablaCompra + " and (producto.Descripcion like '%"
                + txtBuscarCompra.getText() + "%' or proveedor.NomProveedor like '%" + txtBuscarCompra.getText() + "%')");
    }//GEN-LAST:event_txtBuscarCompraKeyReleased

    private void txtBuscarCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCompraKeyPressed

    }//GEN-LAST:event_txtBuscarCompraKeyPressed

    private void txtTelefonoProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoProveedorKeyTyped
        txtTelefonoProveedor.setBackground(Color.white);
        if (!isNum(evt.getKeyChar())) {
            //getToolkit().beep();
            JOptionPane.showMessageDialog(null, "<html><center>El dato ingresado no es valido,<br>"
                    + "solo se aceptan numeros</center><html>",
                    "Dato no Valido", JOptionPane.PLAIN_MESSAGE, icon.getCancelIcon());
            evt.consume();
        }
        if (txtTelefonoProveedor.getText().length() >= 10) {
            JOptionPane.showMessageDialog(null, "Solo se aceptan 30 caracteres");
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoProveedorKeyTyped

    private void txtValorCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorCompraKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorCompraKeyTyped

    private void txtFechaDiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaDiaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaDiaKeyTyped

    private void txtFechaAñoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaAñoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaAñoKeyTyped

    private void txtCantidadCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadCompraKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadCompraKeyTyped

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormProveedor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormProveedor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormProveedor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormProveedor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarCompra;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnGuardarCompra;
    private javax.swing.JButton btnGuardarProveedor;
    private javax.swing.JButton btnLimpiarCompra;
    private javax.swing.JButton btnLimpiarProveedor;
    private javax.swing.JButton btnModificarCompra;
    private javax.swing.JButton btnModificarProveedor;
    private javax.swing.JComboBox<String> cbFechaMes;
    private javax.swing.JComboBox<String> cbProductoCompra;
    private javax.swing.JComboBox<String> cbProveedorCompra;
    private javax.swing.JLabel lblBuscarCompra;
    private javax.swing.JLabel lblBuscarProveedor;
    private javax.swing.JLabel lblCantidadCompra;
    private javax.swing.JLabel lblCodigoProveedor;
    private javax.swing.JLabel lblFechaAño;
    private javax.swing.JLabel lblFechaCompra;
    private javax.swing.JLabel lblFechaDia;
    private javax.swing.JLabel lblFechaMes;
    private javax.swing.JLabel lblNombreProveedor;
    private javax.swing.JLabel lblProductoCompra;
    private javax.swing.JLabel lblProveedorCompra;
    private javax.swing.JLabel lblTelProveedor;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorCompra;
    private javax.swing.JPanel pnBotonesCompras;
    private javax.swing.JPanel pnBotonesProveedor;
    private javax.swing.JPanel pnDatosCompras;
    private javax.swing.JPanel pnDatosProducto;
    private javax.swing.JPanel pnFondo;
    private javax.swing.JPanel pnListadoCompras;
    private javax.swing.JPanel pnListadoProveedores;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JSeparator sep1;
    private javax.swing.JScrollPane spTablaCategoria;
    private javax.swing.JScrollPane spTablaProveedor;
    private javax.swing.JPanel tabCompras;
    private javax.swing.JPanel tabProveedores;
    private javax.swing.JTable tbCcompra;
    private javax.swing.JTable tbProveedor;
    private javax.swing.JTabbedPane tpProveedores;
    private javax.swing.JTextField txtBuscarCompra;
    private javax.swing.JTextField txtBuscarProveedor;
    private javax.swing.JTextField txtCantidadCompra;
    private javax.swing.JTextField txtCodigoProveedor;
    private javax.swing.JTextField txtFechaAño;
    private javax.swing.JTextField txtFechaDia;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtTelefonoProveedor;
    private javax.swing.JTextField txtValorCompra;
    // End of variables declaration//GEN-END:variables
}
