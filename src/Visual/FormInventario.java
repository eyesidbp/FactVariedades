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

public class FormInventario extends javax.swing.JFrame {

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

    public FormInventario() {
        connection = connect.getConexion();
        SQLProveedor.setConnection(connection);
        initComponents();
        this.setLocationRelativeTo(null);

    }

    /*private void limpiarCategoria() {
        txtCodigoCategoria.setText(null);
        txtDescripcionCategoria.setText(null);
    }*/
    private void limpiarProveedor() {
        txtProductoInventario.setText(null);
        txtCantidadInventario.setText(null);
        txtValorInventario.setText(null);
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
        tpInventario = new javax.swing.JTabbedPane();
        tabProductos = new javax.swing.JPanel();
        pnListadoProductos = new javax.swing.JPanel();
        lblBuscarInventario = new javax.swing.JLabel();
        txtBuscarInventario = new javax.swing.JTextField();
        spTablaInventario = new javax.swing.JScrollPane();
        tbInventario = new javax.swing.JTable();
        pnDatosInventario = new javax.swing.JPanel();
        lblProductoInventario = new javax.swing.JLabel();
        lblCantidadInventario = new javax.swing.JLabel();
        lblValorInventario = new javax.swing.JLabel();
        txtProductoInventario = new javax.swing.JTextField();
        txtCantidadInventario = new javax.swing.JTextField();
        txtValorInventario = new javax.swing.JTextField();
        pnBotonesInventario = new javax.swing.JPanel();
        btnGuardarInventario = new javax.swing.JButton();
        btnModificarInventario = new javax.swing.JButton();
        btnLimpiarInventario = new javax.swing.JButton();
        btnEliminarInventario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuarios");

        pnFondo.setBackground(new java.awt.Color(255, 255, 255));

        pnTitulo.setBackground(new java.awt.Color(204, 255, 204));
        pnTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTitulo.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("INVENTARIOS");

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

        tpInventario.setBackground(new java.awt.Color(204, 255, 204));
        tpInventario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tpInventario.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        tpInventario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tpInventarioFocusGained(evt);
            }
        });
        tpInventario.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tpInventarioComponentShown(evt);
            }
        });

        tabProductos.setBackground(new java.awt.Color(204, 255, 204));
        tabProductos.setForeground(new java.awt.Color(204, 255, 204));
        tabProductos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabProductosFocusGained(evt);
            }
        });

        pnListadoProductos.setBackground(new java.awt.Color(153, 255, 204));

        lblBuscarInventario.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblBuscarInventario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBuscarInventario.setText("Buscar");

        txtBuscarInventario.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtBuscarInventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarInventarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarInventarioKeyReleased(evt);
            }
        });

        tbInventario.setBackground(new java.awt.Color(153, 255, 204));
        tbInventario.setFont(new java.awt.Font("Century", 0, 10)); // NOI18N
        tbInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, "", null, null},
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
                "Codigo", "Producto", "Cantidad", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbInventario.setGridColor(new java.awt.Color(0, 0, 0));
        tbInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbInventarioMouseClicked(evt);
            }
        });
        spTablaInventario.setViewportView(tbInventario);

        javax.swing.GroupLayout pnListadoProductosLayout = new javax.swing.GroupLayout(pnListadoProductos);
        pnListadoProductos.setLayout(pnListadoProductosLayout);
        pnListadoProductosLayout.setHorizontalGroup(
            pnListadoProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTablaInventario)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnListadoProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnListadoProductosLayout.setVerticalGroup(
            pnListadoProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnListadoProductosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnListadoProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTablaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        pnDatosInventario.setBackground(new java.awt.Color(153, 255, 204));

        lblProductoInventario.setBackground(new java.awt.Color(255, 255, 255));
        lblProductoInventario.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblProductoInventario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProductoInventario.setText("Producto");

        lblCantidadInventario.setBackground(new java.awt.Color(255, 255, 255));
        lblCantidadInventario.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblCantidadInventario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCantidadInventario.setText("Cantidad");

        lblValorInventario.setBackground(new java.awt.Color(255, 255, 255));
        lblValorInventario.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblValorInventario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblValorInventario.setText("Valor");

        txtProductoInventario.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtProductoInventario.setToolTipText("");
        txtProductoInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductoInventarioActionPerformed(evt);
            }
        });
        txtProductoInventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductoInventarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductoInventarioKeyTyped(evt);
            }
        });

        txtCantidadInventario.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtCantidadInventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadInventarioKeyTyped(evt);
            }
        });

        txtValorInventario.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtValorInventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorInventarioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnDatosInventarioLayout = new javax.swing.GroupLayout(pnDatosInventario);
        pnDatosInventario.setLayout(pnDatosInventarioLayout);
        pnDatosInventarioLayout.setHorizontalGroup(
            pnDatosInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatosInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDatosInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnDatosInventarioLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblValorInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValorInventario, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                    .addGroup(pnDatosInventarioLayout.createSequentialGroup()
                        .addComponent(lblCantidadInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidadInventario))
                    .addGroup(pnDatosInventarioLayout.createSequentialGroup()
                        .addComponent(lblProductoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtProductoInventario)))
                .addGap(0, 55, Short.MAX_VALUE))
        );
        pnDatosInventarioLayout.setVerticalGroup(
            pnDatosInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatosInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDatosInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProductoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(pnDatosInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidadInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDatosInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnBotonesInventario.setBackground(new java.awt.Color(153, 255, 204));

        btnGuardarInventario.setBackground(new java.awt.Color(204, 255, 204));
        btnGuardarInventario.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnGuardarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        btnGuardarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarInventarioActionPerformed(evt);
            }
        });

        btnModificarInventario.setBackground(new java.awt.Color(204, 255, 204));
        btnModificarInventario.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnModificarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editar.png"))); // NOI18N
        btnModificarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarInventarioActionPerformed(evt);
            }
        });

        btnLimpiarInventario.setBackground(new java.awt.Color(204, 255, 204));
        btnLimpiarInventario.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnLimpiarInventario.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel1.png"))); // NOI18N
        btnLimpiarInventario.setBorder(null);
        btnLimpiarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarInventarioActionPerformed(evt);
            }
        });

        btnEliminarInventario.setBackground(new java.awt.Color(204, 255, 204));
        btnEliminarInventario.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnEliminarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/trash.png"))); // NOI18N
        btnEliminarInventario.setBorder(null);
        btnEliminarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarInventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotonesInventarioLayout = new javax.swing.GroupLayout(pnBotonesInventario);
        pnBotonesInventario.setLayout(pnBotonesInventarioLayout);
        pnBotonesInventarioLayout.setHorizontalGroup(
            pnBotonesInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBotonesInventarioLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(pnBotonesInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(pnBotonesInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        pnBotonesInventarioLayout.setVerticalGroup(
            pnBotonesInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotonesInventarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnBotonesInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificarInventario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarInventario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnBotonesInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout tabProductosLayout = new javax.swing.GroupLayout(tabProductos);
        tabProductos.setLayout(tabProductosLayout);
        tabProductosLayout.setHorizontalGroup(
            tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnListadoProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDatosInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBotonesInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        tabProductosLayout.setVerticalGroup(
            tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnListadoProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tabProductosLayout.createSequentialGroup()
                        .addComponent(pnDatosInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(pnBotonesInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tpInventario.addTab("Productos", tabProductos);

        javax.swing.GroupLayout pnFondoLayout = new javax.swing.GroupLayout(pnFondo);
        pnFondo.setLayout(pnFondoLayout);
        pnFondoLayout.setHorizontalGroup(
            pnFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFondoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sep1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tpInventario))
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
                .addComponent(tpInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tpInventarioComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tpInventarioComponentShown

    }//GEN-LAST:event_tpInventarioComponentShown

    private void tpInventarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tpInventarioFocusGained

    }//GEN-LAST:event_tpInventarioFocusGained

    private void tabProductosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabProductosFocusGained

    }//GEN-LAST:event_tabProductosFocusGained

    private void btnEliminarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarInventarioActionPerformed


    }//GEN-LAST:event_btnEliminarInventarioActionPerformed

    private void btnLimpiarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarInventarioActionPerformed

    }//GEN-LAST:event_btnLimpiarInventarioActionPerformed

    private void btnModificarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarInventarioActionPerformed


    }//GEN-LAST:event_btnModificarInventarioActionPerformed

    private void btnGuardarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarInventarioActionPerformed


    }//GEN-LAST:event_btnGuardarInventarioActionPerformed

    private void txtValorInventarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorInventarioKeyTyped
        txtValorInventario.setBackground(Color.white);
        if (!isNum(evt.getKeyChar())) {
            //getToolkit().beep();
            JOptionPane.showMessageDialog(null, "<html><center>El dato ingresado no es valido,<br>"
                    + "solo se aceptan numeros</center><html>",
                    "Dato no Valido", JOptionPane.PLAIN_MESSAGE, icon.getCancelIcon());
            evt.consume();
        }
        if (txtValorInventario.getText().length() >= 10) {
            JOptionPane.showMessageDialog(null, "Solo se aceptan 30 caracteres");
            evt.consume();
        }
    }//GEN-LAST:event_txtValorInventarioKeyTyped

    private void txtCantidadInventarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadInventarioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadInventarioKeyTyped

    private void txtProductoInventarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoInventarioKeyTyped
        txtProductoInventario.setBackground(Color.white);
        if (!isNum(evt.getKeyChar())) {
            //getToolkit().beep();
            JOptionPane.showMessageDialog(null, "<html><center>El dato ingresado no es valido,<br>"
                    + "solo se aceptan numeros</center><html>",
                    "Dato no Valido", JOptionPane.PLAIN_MESSAGE, icon.getCancelIcon());
            evt.consume();
        }
        if (txtProductoInventario.getText().length() >= 10) {
            JOptionPane.showMessageDialog(null, "Solo se aceptan 30 caracteres");
            evt.consume();
        }
    }//GEN-LAST:event_txtProductoInventarioKeyTyped

    private void txtProductoInventarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoInventarioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoInventarioKeyPressed

    private void txtProductoInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoInventarioActionPerformed

    private void tbInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbInventarioMouseClicked
        int fila = tbInventario.getSelectedRow();

        //System.out.println("Tercer Dato: " + tbProducto.getValueAt(fila, 2));
        SQLProveedor.setCodProveedor(tbInventario.getValueAt(fila, 0).toString());
        SQLProveedor.setNomProveedor(tbInventario.getValueAt(fila, 1).toString());
        SQLProveedor.setTelProveedor(Long.parseLong(tbInventario.getValueAt(fila, 2).toString()));

        txtProductoInventario.setText(SQLProveedor.getCodProveedor());
        txtCantidadInventario.setText(SQLProveedor.getNomProveedor());
        txtValorInventario.setText(SQLProveedor.getTelProveedor().toString());

        SQLProveedor.setCodProveedor1(tbInventario.getValueAt(fila, 0).toString());
        SQLProveedor.setNomProveedor1(tbInventario.getValueAt(fila, 1).toString());
        SQLProveedor.setTelProveedor1(Long.parseLong(tbInventario.getValueAt(fila, 2).toString()));
    }//GEN-LAST:event_tbInventarioMouseClicked

    private void txtBuscarInventarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarInventarioKeyReleased
        buscarProveedor();
    }//GEN-LAST:event_txtBuscarInventarioKeyReleased

    private void txtBuscarInventarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarInventarioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarInventarioKeyPressed

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

    public void buscarProveedor() {

    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormInventario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormInventario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormInventario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormInventario.class
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
                new FormInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarInventario;
    private javax.swing.JButton btnGuardarInventario;
    private javax.swing.JButton btnLimpiarInventario;
    private javax.swing.JButton btnModificarInventario;
    private javax.swing.JLabel lblBuscarInventario;
    private javax.swing.JLabel lblCantidadInventario;
    private javax.swing.JLabel lblProductoInventario;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorInventario;
    private javax.swing.JPanel pnBotonesInventario;
    private javax.swing.JPanel pnDatosInventario;
    private javax.swing.JPanel pnFondo;
    private javax.swing.JPanel pnListadoProductos;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JSeparator sep1;
    private javax.swing.JScrollPane spTablaInventario;
    private javax.swing.JPanel tabProductos;
    private javax.swing.JTable tbInventario;
    private javax.swing.JTabbedPane tpInventario;
    private javax.swing.JTextField txtBuscarInventario;
    private javax.swing.JTextField txtCantidadInventario;
    private javax.swing.JTextField txtProductoInventario;
    private javax.swing.JTextField txtValorInventario;
    // End of variables declaration//GEN-END:variables
}
