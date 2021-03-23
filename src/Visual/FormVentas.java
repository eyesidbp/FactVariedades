package Visual;

import Images.Iconos;
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

public class FormVentas extends javax.swing.JFrame {

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

    public FormVentas() {
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
        tbVentas.setBackground(new Color(204, 255, 204));
        tbVentas.setModel(modeloCompra);
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
                tbVentas.getColumnModel().getColumn(i).setPreferredWidth(anchoCol[i]);
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
        cbProductoVentas.removeAllItems();
        try {
            ps = connection.prepareStatement("select * from producto");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            cbProductoVentas.addItem("Seleccione");
            while (rs.next()) {
                cbProductoVentas.addItem(rs.getObject(2).toString());
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void cargarListaProveedores() {
        int columnas;
        cbClienteVentas.removeAllItems();
        try {
            ps = connection.prepareStatement("select * from proveedor");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            cbClienteVentas.addItem("Seleccione");
            while (rs.next()) {
                cbClienteVentas.addItem(rs.getObject(2).toString());
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
        tpVentas = new javax.swing.JTabbedPane();
        tabVentas = new javax.swing.JPanel();
        pnListadoVentas = new javax.swing.JPanel();
        lblBuscarVentas = new javax.swing.JLabel();
        txtBuscarVentas = new javax.swing.JTextField();
        spTablaCategoria = new javax.swing.JScrollPane();
        tbVentas = new javax.swing.JTable();
        pnDatosVentas = new javax.swing.JPanel();
        lblProductoVentas = new javax.swing.JLabel();
        lblProveedorVentas = new javax.swing.JLabel();
        lblCantidadVentas = new javax.swing.JLabel();
        lblValorVentas = new javax.swing.JLabel();
        lblFechaCompra = new javax.swing.JLabel();
        lblFechaDia = new javax.swing.JLabel();
        lblFechaMes = new javax.swing.JLabel();
        lblFechaAño = new javax.swing.JLabel();
        cbProductoVentas = new javax.swing.JComboBox<>();
        cbClienteVentas = new javax.swing.JComboBox<>();
        txtValorVentas = new javax.swing.JTextField();
        txtCantidadVentas = new javax.swing.JTextField();
        txtFechaDia = new javax.swing.JTextField();
        txtFechaAño = new javax.swing.JTextField();
        cbFechaMes = new javax.swing.JComboBox<>();
        pnBotonesVentas = new javax.swing.JPanel();
        btnGuardarVentas = new javax.swing.JButton();
        btnModificarVentas = new javax.swing.JButton();
        btnLimpiarVentas = new javax.swing.JButton();
        btnEliminarVentas = new javax.swing.JButton();
        tabClientes = new javax.swing.JPanel();
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

        tpVentas.setBackground(new java.awt.Color(204, 255, 204));
        tpVentas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tpVentas.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        tpVentas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tpVentasFocusGained(evt);
            }
        });
        tpVentas.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tpVentasComponentShown(evt);
            }
        });

        tabVentas.setBackground(new java.awt.Color(204, 255, 204));
        tabVentas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabVentasFocusGained(evt);
            }
        });

        pnListadoVentas.setBackground(new java.awt.Color(153, 255, 204));

        lblBuscarVentas.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblBuscarVentas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBuscarVentas.setText("Buscar");

        txtBuscarVentas.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtBuscarVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarVentasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarVentasKeyReleased(evt);
            }
        });

        tbVentas.setBackground(new java.awt.Color(153, 255, 204));
        tbVentas.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        tbVentas.setModel(new javax.swing.table.DefaultTableModel(
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
                "Codigo", "Producto", "Clientes", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbVentas.setGridColor(new java.awt.Color(0, 0, 0));
        tbVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVentasMouseClicked(evt);
            }
        });
        spTablaCategoria.setViewportView(tbVentas);

        javax.swing.GroupLayout pnListadoVentasLayout = new javax.swing.GroupLayout(pnListadoVentas);
        pnListadoVentas.setLayout(pnListadoVentasLayout);
        pnListadoVentasLayout.setHorizontalGroup(
            pnListadoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTablaCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
            .addGroup(pnListadoVentasLayout.createSequentialGroup()
                .addComponent(lblBuscarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBuscarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnListadoVentasLayout.setVerticalGroup(
            pnListadoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnListadoVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnListadoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTablaCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
        );

        pnDatosVentas.setBackground(new java.awt.Color(153, 255, 204));

        lblProductoVentas.setBackground(new java.awt.Color(255, 255, 255));
        lblProductoVentas.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblProductoVentas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProductoVentas.setText("Producto");

        lblProveedorVentas.setBackground(new java.awt.Color(255, 255, 255));
        lblProveedorVentas.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblProveedorVentas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProveedorVentas.setText("Cliente");

        lblCantidadVentas.setBackground(new java.awt.Color(255, 255, 255));
        lblCantidadVentas.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblCantidadVentas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCantidadVentas.setText("Cantidad");

        lblValorVentas.setBackground(new java.awt.Color(255, 255, 255));
        lblValorVentas.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblValorVentas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblValorVentas.setText("Valor UN");

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

        cbProductoVentas.setBackground(new java.awt.Color(204, 255, 204));
        cbProductoVentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        cbClienteVentas.setBackground(new java.awt.Color(204, 255, 204));
        cbClienteVentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        txtValorVentas.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtValorVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorVentasKeyTyped(evt);
            }
        });

        txtCantidadVentas.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtCantidadVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadVentasKeyTyped(evt);
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

        javax.swing.GroupLayout pnDatosVentasLayout = new javax.swing.GroupLayout(pnDatosVentas);
        pnDatosVentas.setLayout(pnDatosVentasLayout);
        pnDatosVentasLayout.setHorizontalGroup(
            pnDatosVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatosVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDatosVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatosVentasLayout.createSequentialGroup()
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
                    .addGroup(pnDatosVentasLayout.createSequentialGroup()
                        .addGroup(pnDatosVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDatosVentasLayout.createSequentialGroup()
                                .addComponent(lblProveedorVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbClienteVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnDatosVentasLayout.createSequentialGroup()
                                .addComponent(lblProductoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbProductoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnDatosVentasLayout.createSequentialGroup()
                                .addGroup(pnDatosVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCantidadVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblValorVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnDatosVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCantidadVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 69, Short.MAX_VALUE))))
        );
        pnDatosVentasLayout.setVerticalGroup(
            pnDatosVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatosVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDatosVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbProductoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDatosVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProveedorVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbClienteVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDatosVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidadVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnDatosVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDatosVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaDia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaAño, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaDia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaMes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaAño, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFechaMes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnBotonesVentas.setBackground(new java.awt.Color(153, 255, 204));

        btnGuardarVentas.setBackground(new java.awt.Color(204, 255, 204));
        btnGuardarVentas.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnGuardarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        btnGuardarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarVentasActionPerformed(evt);
            }
        });

        btnModificarVentas.setBackground(new java.awt.Color(204, 255, 204));
        btnModificarVentas.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnModificarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editar.png"))); // NOI18N
        btnModificarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarVentasActionPerformed(evt);
            }
        });

        btnLimpiarVentas.setBackground(new java.awt.Color(204, 255, 204));
        btnLimpiarVentas.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnLimpiarVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel1.png"))); // NOI18N
        btnLimpiarVentas.setBorder(null);
        btnLimpiarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarVentasActionPerformed(evt);
            }
        });

        btnEliminarVentas.setBackground(new java.awt.Color(204, 255, 204));
        btnEliminarVentas.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnEliminarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/trash.png"))); // NOI18N
        btnEliminarVentas.setBorder(null);
        btnEliminarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotonesVentasLayout = new javax.swing.GroupLayout(pnBotonesVentas);
        pnBotonesVentas.setLayout(pnBotonesVentasLayout);
        pnBotonesVentasLayout.setHorizontalGroup(
            pnBotonesVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBotonesVentasLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnGuardarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnBotonesVentasLayout.setVerticalGroup(
            pnBotonesVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotonesVentasLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnBotonesVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabVentasLayout = new javax.swing.GroupLayout(tabVentas);
        tabVentas.setLayout(tabVentasLayout);
        tabVentasLayout.setHorizontalGroup(
            tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnListadoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDatosVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBotonesVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        tabVentasLayout.setVerticalGroup(
            tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnListadoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabVentasLayout.createSequentialGroup()
                        .addComponent(pnDatosVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnBotonesVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tpVentas.addTab("Ventas", tabVentas);

        tabClientes.setBackground(new java.awt.Color(204, 255, 204));
        tabClientes.setForeground(new java.awt.Color(204, 255, 204));
        tabClientes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabClientesFocusGained(evt);
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

        javax.swing.GroupLayout tabClientesLayout = new javax.swing.GroupLayout(tabClientes);
        tabClientes.setLayout(tabClientesLayout);
        tabClientesLayout.setHorizontalGroup(
            tabClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnListadoProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tabClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDatosProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBotonesProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        tabClientesLayout.setVerticalGroup(
            tabClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnListadoProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tabClientesLayout.createSequentialGroup()
                        .addComponent(pnDatosProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(pnBotonesProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tpVentas.addTab("Clientes", tabClientes);

        javax.swing.GroupLayout pnFondoLayout = new javax.swing.GroupLayout(pnFondo);
        pnFondo.setLayout(pnFondoLayout);
        pnFondoLayout.setHorizontalGroup(
            pnFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFondoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sep1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tpVentas))
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
                .addComponent(tpVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private void tpVentasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tpVentasFocusGained
        cargarDatosProveedor(sqlTablaProveedor);

    }//GEN-LAST:event_tpVentasFocusGained

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

    private void tpVentasComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tpVentasComponentShown

    }//GEN-LAST:event_tpVentasComponentShown

    private void tabClientesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabClientesFocusGained

    }//GEN-LAST:event_tabClientesFocusGained

    private void tabVentasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabVentasFocusGained

    }//GEN-LAST:event_tabVentasFocusGained

    private void btnEliminarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVentasActionPerformed
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
    }//GEN-LAST:event_btnEliminarVentasActionPerformed

    private void btnLimpiarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarVentasActionPerformed
        //limpiarCategoria();

        Calendar c1 = Calendar.getInstance();
        //Calendar c2 = new GregorianCalendar();
        System.out.println("Año: " + Integer.toString(c1.get(Calendar.DATE))
                + "\nMes: " + Integer.toString(c1.get(Calendar.MONTH))
                + "\nMes: " + Integer.toString(c1.get(Calendar.YEAR)));

    }//GEN-LAST:event_btnLimpiarVentasActionPerformed

    private void btnModificarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarVentasActionPerformed
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
    }//GEN-LAST:event_btnModificarVentasActionPerformed

    private void btnGuardarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarVentasActionPerformed
        if (cbProductoVentas.getSelectedItem().equals("Seleccione")
                || cbClienteVentas.getSelectedItem().equals("Seleccione")
                || txtValorVentas.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, icon.getHandIcon());

        } else {

            SQLProducto.setDesProducto(cbProductoVentas.getSelectedItem().toString());
            SQLProveedor.setNomProveedor(cbClienteVentas.getSelectedItem().toString());

            SQLProveedor.setCodProductoCompra(SQLProducto.ObtenerCodProducto(cbProductoVentas.getSelectedItem().toString()));
            SQLProveedor.setCodProveedorCompra(SQLProveedor.ObtenerCodProveedor(cbClienteVentas.getSelectedItem().toString()));
            SQLProveedor.setValorCompra(Double.parseDouble(txtValorVentas.getText()));
            SQLProveedor.setFechaCompra(txtFechaAño.getText() + "/" + ObtenerMes(cbFechaMes.getSelectedItem().toString()) + "/" + txtFechaDia.getText());
            SQLProveedor.setCantidadCompra(Integer.parseInt(txtCantidadVentas.getText()));

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
    }//GEN-LAST:event_btnGuardarVentasActionPerformed

    private void tbVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVentasMouseClicked
        /*        int fila = tbCategoria.getSelectedRow();

        SQLProducto.setCodCategoria(tbCategoria.getValueAt(fila, 0).toString());
        SQLProducto.setDesCategoria(tbCategoria.getValueAt(fila, 1).toString());

        txtCodigoCategoria.setText(SQLProducto.getCodCategoria());
        txtDescripcionCategoria.setText(SQLProducto.getDesCategoria());

        SQLProducto.setCodCategoria1(tbCategoria.getValueAt(fila, 0).toString());
        SQLProducto.setDesCategoria1(tbCategoria.getValueAt(fila, 1).toString());*/
    }//GEN-LAST:event_tbVentasMouseClicked

    private void txtBuscarVentasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarVentasKeyReleased
        cargarDatosCompra(sqlTablaCompra + " and (producto.Descripcion like '%"
                + txtBuscarVentas.getText() + "%' or proveedor.NomProveedor like '%" + txtBuscarVentas.getText() + "%')");
    }//GEN-LAST:event_txtBuscarVentasKeyReleased

    private void txtBuscarVentasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarVentasKeyPressed

    }//GEN-LAST:event_txtBuscarVentasKeyPressed

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

    private void txtValorVentasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorVentasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorVentasKeyTyped

    private void txtFechaDiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaDiaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaDiaKeyTyped

    private void txtFechaAñoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaAñoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaAñoKeyTyped

    private void txtCantidadVentasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVentasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadVentasKeyTyped

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormVentas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormVentas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormVentas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormVentas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnEliminarVentas;
    private javax.swing.JButton btnGuardarProveedor;
    private javax.swing.JButton btnGuardarVentas;
    private javax.swing.JButton btnLimpiarProveedor;
    private javax.swing.JButton btnLimpiarVentas;
    private javax.swing.JButton btnModificarProveedor;
    private javax.swing.JButton btnModificarVentas;
    private javax.swing.JComboBox<String> cbClienteVentas;
    private javax.swing.JComboBox<String> cbFechaMes;
    private javax.swing.JComboBox<String> cbProductoVentas;
    private javax.swing.JLabel lblBuscarProveedor;
    private javax.swing.JLabel lblBuscarVentas;
    private javax.swing.JLabel lblCantidadVentas;
    private javax.swing.JLabel lblCodigoProveedor;
    private javax.swing.JLabel lblFechaAño;
    private javax.swing.JLabel lblFechaCompra;
    private javax.swing.JLabel lblFechaDia;
    private javax.swing.JLabel lblFechaMes;
    private javax.swing.JLabel lblNombreProveedor;
    private javax.swing.JLabel lblProductoVentas;
    private javax.swing.JLabel lblProveedorVentas;
    private javax.swing.JLabel lblTelProveedor;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorVentas;
    private javax.swing.JPanel pnBotonesProveedor;
    private javax.swing.JPanel pnBotonesVentas;
    private javax.swing.JPanel pnDatosProducto;
    private javax.swing.JPanel pnDatosVentas;
    private javax.swing.JPanel pnFondo;
    private javax.swing.JPanel pnListadoProveedores;
    private javax.swing.JPanel pnListadoVentas;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JSeparator sep1;
    private javax.swing.JScrollPane spTablaCategoria;
    private javax.swing.JScrollPane spTablaProveedor;
    private javax.swing.JPanel tabClientes;
    private javax.swing.JPanel tabVentas;
    private javax.swing.JTable tbProveedor;
    private javax.swing.JTable tbVentas;
    private javax.swing.JTabbedPane tpVentas;
    private javax.swing.JTextField txtBuscarProveedor;
    private javax.swing.JTextField txtBuscarVentas;
    private javax.swing.JTextField txtCantidadVentas;
    private javax.swing.JTextField txtCodigoProveedor;
    private javax.swing.JTextField txtFechaAño;
    private javax.swing.JTextField txtFechaDia;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtTelefonoProveedor;
    private javax.swing.JTextField txtValorVentas;
    // End of variables declaration//GEN-END:variables
}
