package Visual;

import Images.Iconos;
import Logica.ConexionBD;
import Logica.Producto;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormProducto extends javax.swing.JFrame {

    Iconos icon = new Iconos();
    Connection connection = null;
    ConexionBD connect = new ConexionBD();
    PreparedStatement ps = null;
    ResultSet rs = null;
    ResultSetMetaData rsmd = null;
    public final String slqTablaCategoria = "SELECT CodCategoria, Descripcion from categoria_productos";
    public final String slqTablaProducto
            = "SELECT producto.CodProducto, producto.Descripcion, categoria_productos.Descripcion"
            + " from producto, categoria_productos where producto.CodCategoria = categoria_productos.CodCategoria";
    public String filtroCategoria;
    private Producto SQLProducto = new Producto();

    public FormProducto() {
        connection = connect.getConexion();
        SQLProducto.setConnection(connection);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void cargarDatosCategoria(String consulta) {
        int columnas;
        DefaultTableModel modeloCategoria = new DefaultTableModel();
        tbCategoria.setBackground(new Color(204, 255, 204));
        tbCategoria.setModel(modeloCategoria);
        tbCategoria.getTableHeader().setBackground(Color.white);
        try {
            ps = connection.prepareStatement(consulta);
            //System.out.println(ps);
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            modeloCategoria.addColumn("Documento");
            modeloCategoria.addColumn("Descripcion");
            int anchoCol[] = {100, 150};
            for (int i = 0; i < columnas; i++) {
                tbCategoria.getColumnModel().getColumn(i).setPreferredWidth(anchoCol[i]);
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
        cargarListaCategorias();
        //connect.stopConnection();
    }

    public void cargarListaCategorias() {
        int columnas;
        try {
            ps = connection.prepareStatement("select * from categoria_productos");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next()) {
                cbCategoria.addItem(rs.getObject(2).toString());
                cbFiltroCategoria.addItem(rs.getObject(2).toString());
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void cargarDatosProductos(String consulta) {
        int columnas;
        DefaultTableModel modeloProducto = new DefaultTableModel();
        tbProducto.setBackground(new Color(204, 255, 204));
        tbProducto.setModel(modeloProducto);
        tbProducto.getTableHeader().setBackground(Color.white);
        try {
            ps = connection.prepareStatement(consulta);
            //System.out.println(ps);
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            modeloProducto.addColumn("Documento");
            modeloProducto.addColumn("Descripcion");
            modeloProducto.addColumn("Categoria");

            int anchoCol[] = {120, 150, 150};
            for (int i = 0; i < columnas; i++) {
                tbProducto.getColumnModel().getColumn(i).setPreferredWidth(anchoCol[i]);
            }
            while (rs.next()) {
                Object[] filas = new Object[columnas];

                for (int i = 0; i < columnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modeloProducto.addRow(filas);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        //connect.stopConnection();
    }

    private void limpiarCategoria() {
        txtCodigoCategoria.setText(null);
        txtDescripcionCategoria.setText(null);
    }

    private void limpiarProducto() {
        txtCodigoProducto.setText(null);
        txtDescProducto.setText(null);
        cbCategoria.setSelectedIndex(0);
        //System.out.println(cbFiltroCategoria.getSelectedIndex());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnFondo = new javax.swing.JPanel();
        pnTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        sep1 = new javax.swing.JSeparator();
        tpUsuarios = new javax.swing.JTabbedPane();
        tabProductos = new javax.swing.JPanel();
        pnListadoProducto = new javax.swing.JPanel();
        lblBuscarProducto = new javax.swing.JLabel();
        txtBuscarProducto = new javax.swing.JTextField();
        cbFiltroCategoria = new javax.swing.JComboBox<>();
        spTablaProducto = new javax.swing.JScrollPane();
        tbProducto = new javax.swing.JTable();
        pnDatosProducto = new javax.swing.JPanel();
        lblCodigoProducto = new javax.swing.JLabel();
        lblDescProducto = new javax.swing.JLabel();
        lblCatProducto = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        txtDescProducto = new javax.swing.JTextField();
        cbCategoria = new javax.swing.JComboBox<>();
        pnBotones2 = new javax.swing.JPanel();
        btnGuardarProducto = new javax.swing.JButton();
        btnModificarProducto = new javax.swing.JButton();
        btnLimpiarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        tabCategorias = new javax.swing.JPanel();
        pnListadoCategoria = new javax.swing.JPanel();
        lblBuscarCategoria = new javax.swing.JLabel();
        txtBuscarCategoria = new javax.swing.JTextField();
        spTablaCategoria = new javax.swing.JScrollPane();
        tbCategoria = new javax.swing.JTable();
        pnDatosCategoria = new javax.swing.JPanel();
        lblCodigoCategoria = new javax.swing.JLabel();
        lblDescCategoria = new javax.swing.JLabel();
        txtCodigoCategoria = new javax.swing.JTextField();
        txtDescripcionCategoria = new javax.swing.JTextField();
        pnBotones1 = new javax.swing.JPanel();
        btnGuardarCategoria = new javax.swing.JButton();
        btnModificarCategoria = new javax.swing.JButton();
        btnLimpiarCategoria = new javax.swing.JButton();
        btnEliminarCategoria = new javax.swing.JButton();

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

        tpUsuarios.setBackground(new java.awt.Color(204, 255, 204));
        tpUsuarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tpUsuarios.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        tpUsuarios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tpUsuariosFocusGained(evt);
            }
        });
        tpUsuarios.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tpUsuariosComponentShown(evt);
            }
        });

        tabProductos.setBackground(new java.awt.Color(204, 255, 204));
        tabProductos.setForeground(new java.awt.Color(204, 255, 204));
        tabProductos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabProductosFocusGained(evt);
            }
        });

        pnListadoProducto.setBackground(new java.awt.Color(153, 255, 204));

        lblBuscarProducto.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblBuscarProducto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBuscarProducto.setText("Buscar");

        txtBuscarProducto.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyReleased(evt);
            }
        });

        cbFiltroCategoria.setBackground(new java.awt.Color(204, 255, 204));
        cbFiltroCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        cbFiltroCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFiltroCategoriaItemStateChanged(evt);
            }
        });
        cbFiltroCategoria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbFiltroCategoriaFocusLost(evt);
            }
        });
        cbFiltroCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFiltroCategoriaActionPerformed(evt);
            }
        });
        cbFiltroCategoria.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                cbFiltroCategoriaVetoableChange(evt);
            }
        });

        tbProducto.setBackground(new java.awt.Color(153, 255, 204));
        tbProducto.setFont(new java.awt.Font("Century", 0, 10)); // NOI18N
        tbProducto.setModel(new javax.swing.table.DefaultTableModel(
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
                "Codigo", "Descripcion", "Categoria"
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
        tbProducto.setGridColor(new java.awt.Color(0, 0, 0));
        tbProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductoMouseClicked(evt);
            }
        });
        spTablaProducto.setViewportView(tbProducto);

        javax.swing.GroupLayout pnListadoProductoLayout = new javax.swing.GroupLayout(pnListadoProducto);
        pnListadoProducto.setLayout(pnListadoProductoLayout);
        pnListadoProductoLayout.setHorizontalGroup(
            pnListadoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTablaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnListadoProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbFiltroCategoria, 0, 114, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        pnListadoProductoLayout.setVerticalGroup(
            pnListadoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnListadoProductoLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnListadoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFiltroCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTablaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        pnDatosProducto.setBackground(new java.awt.Color(153, 255, 204));

        lblCodigoProducto.setBackground(new java.awt.Color(255, 255, 255));
        lblCodigoProducto.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblCodigoProducto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCodigoProducto.setText("Codigo");

        lblDescProducto.setBackground(new java.awt.Color(255, 255, 255));
        lblDescProducto.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblDescProducto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDescProducto.setText("Descripcion");

        lblCatProducto.setBackground(new java.awt.Color(255, 255, 255));
        lblCatProducto.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblCatProducto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCatProducto.setText("Categoria");

        txtCodigoProducto.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtCodigoProducto.setToolTipText("");
        txtCodigoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoProductoActionPerformed(evt);
            }
        });
        txtCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyTyped(evt);
            }
        });

        txtDescProducto.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtDescProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescProductoKeyTyped(evt);
            }
        });

        cbCategoria.setBackground(new java.awt.Color(204, 255, 204));
        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        javax.swing.GroupLayout pnDatosProductoLayout = new javax.swing.GroupLayout(pnDatosProducto);
        pnDatosProducto.setLayout(pnDatosProductoLayout);
        pnDatosProductoLayout.setHorizontalGroup(
            pnDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatosProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnDatosProductoLayout.createSequentialGroup()
                        .addComponent(lblCatProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnDatosProductoLayout.createSequentialGroup()
                        .addComponent(lblDescProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescProducto))
                    .addGroup(pnDatosProductoLayout.createSequentialGroup()
                        .addComponent(lblCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigoProducto)))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        pnDatosProductoLayout.setVerticalGroup(
            pnDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatosProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(pnDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCatProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnBotones2.setBackground(new java.awt.Color(153, 255, 204));

        btnGuardarProducto.setBackground(new java.awt.Color(204, 255, 204));
        btnGuardarProducto.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnGuardarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        btnGuardarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProductoActionPerformed(evt);
            }
        });

        btnModificarProducto.setBackground(new java.awt.Color(204, 255, 204));
        btnModificarProducto.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnModificarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editar.png"))); // NOI18N
        btnModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProductoActionPerformed(evt);
            }
        });

        btnLimpiarProducto.setBackground(new java.awt.Color(204, 255, 204));
        btnLimpiarProducto.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnLimpiarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel1.png"))); // NOI18N
        btnLimpiarProducto.setBorder(null);
        btnLimpiarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setBackground(new java.awt.Color(204, 255, 204));
        btnEliminarProducto.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/trash.png"))); // NOI18N
        btnEliminarProducto.setBorder(null);
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotones2Layout = new javax.swing.GroupLayout(pnBotones2);
        pnBotones2.setLayout(pnBotones2Layout);
        pnBotones2Layout.setHorizontalGroup(
            pnBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBotones2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(pnBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        pnBotones2Layout.setVerticalGroup(
            pnBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotones2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificarProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBotones2Layout.createSequentialGroup()
                        .addComponent(btnLimpiarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout tabProductosLayout = new javax.swing.GroupLayout(tabProductos);
        tabProductos.setLayout(tabProductosLayout);
        tabProductosLayout.setHorizontalGroup(
            tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnListadoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnDatosProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBotones2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        tabProductosLayout.setVerticalGroup(
            tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnListadoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tabProductosLayout.createSequentialGroup()
                        .addComponent(pnDatosProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnBotones2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tpUsuarios.addTab("Productos", tabProductos);

        tabCategorias.setBackground(new java.awt.Color(204, 255, 204));
        tabCategorias.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabCategoriasFocusGained(evt);
            }
        });

        pnListadoCategoria.setBackground(new java.awt.Color(153, 255, 204));

        lblBuscarCategoria.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblBuscarCategoria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBuscarCategoria.setText("Buscar");

        txtBuscarCategoria.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtBuscarCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarCategoriaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarCategoriaKeyReleased(evt);
            }
        });

        tbCategoria.setBackground(new java.awt.Color(153, 255, 204));
        tbCategoria.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        tbCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Descripcion"
            }
        ));
        tbCategoria.setGridColor(new java.awt.Color(0, 0, 0));
        tbCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCategoriaMouseClicked(evt);
            }
        });
        spTablaCategoria.setViewportView(tbCategoria);

        javax.swing.GroupLayout pnListadoCategoriaLayout = new javax.swing.GroupLayout(pnListadoCategoria);
        pnListadoCategoria.setLayout(pnListadoCategoriaLayout);
        pnListadoCategoriaLayout.setHorizontalGroup(
            pnListadoCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTablaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnListadoCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnListadoCategoriaLayout.setVerticalGroup(
            pnListadoCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnListadoCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnListadoCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTablaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        pnDatosCategoria.setBackground(new java.awt.Color(153, 255, 204));

        lblCodigoCategoria.setBackground(new java.awt.Color(255, 255, 255));
        lblCodigoCategoria.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblCodigoCategoria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCodigoCategoria.setText("Codigo");

        lblDescCategoria.setBackground(new java.awt.Color(255, 255, 255));
        lblDescCategoria.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblDescCategoria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDescCategoria.setText("Descripcion");

        txtCodigoCategoria.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtCodigoCategoria.setToolTipText("");
        txtCodigoCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoCategoriaActionPerformed(evt);
            }
        });
        txtCodigoCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoCategoriaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoCategoriaKeyTyped(evt);
            }
        });

        txtDescripcionCategoria.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtDescripcionCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionCategoriaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnDatosCategoriaLayout = new javax.swing.GroupLayout(pnDatosCategoria);
        pnDatosCategoria.setLayout(pnDatosCategoriaLayout);
        pnDatosCategoriaLayout.setHorizontalGroup(
            pnDatosCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnDatosCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnDatosCategoriaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnDatosCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblCodigoCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addComponent(lblDescCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(pnDatosCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCodigoCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addComponent(txtDescripcionCategoria))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnDatosCategoriaLayout.setVerticalGroup(
            pnDatosCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
            .addGroup(pnDatosCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnDatosCategoriaLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(pnDatosCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCodigoCategoria)
                        .addComponent(lblCodigoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnDatosCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDescripcionCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDescCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pnBotones1.setBackground(new java.awt.Color(153, 255, 204));

        btnGuardarCategoria.setBackground(new java.awt.Color(204, 255, 204));
        btnGuardarCategoria.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnGuardarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        btnGuardarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCategoriaActionPerformed(evt);
            }
        });

        btnModificarCategoria.setBackground(new java.awt.Color(204, 255, 204));
        btnModificarCategoria.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnModificarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editar.png"))); // NOI18N
        btnModificarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCategoriaActionPerformed(evt);
            }
        });

        btnLimpiarCategoria.setBackground(new java.awt.Color(204, 255, 204));
        btnLimpiarCategoria.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnLimpiarCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel1.png"))); // NOI18N
        btnLimpiarCategoria.setBorder(null);
        btnLimpiarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCategoriaActionPerformed(evt);
            }
        });

        btnEliminarCategoria.setBackground(new java.awt.Color(204, 255, 204));
        btnEliminarCategoria.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnEliminarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/trash.png"))); // NOI18N
        btnEliminarCategoria.setBorder(null);
        btnEliminarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotones1Layout = new javax.swing.GroupLayout(pnBotones1);
        pnBotones1.setLayout(pnBotones1Layout);
        pnBotones1Layout.setHorizontalGroup(
            pnBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBotones1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(pnBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(pnBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        pnBotones1Layout.setVerticalGroup(
            pnBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotones1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabCategoriasLayout = new javax.swing.GroupLayout(tabCategorias);
        tabCategorias.setLayout(tabCategoriasLayout);
        tabCategoriasLayout.setHorizontalGroup(
            tabCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCategoriasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnListadoCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnDatosCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBotones1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        tabCategoriasLayout.setVerticalGroup(
            tabCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCategoriasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnListadoCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tabCategoriasLayout.createSequentialGroup()
                        .addComponent(pnDatosCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnBotones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tpUsuarios.addTab("Categorias", tabCategorias);

        javax.swing.GroupLayout pnFondoLayout = new javax.swing.GroupLayout(pnFondo);
        pnFondo.setLayout(pnFondoLayout);
        pnFondoLayout.setHorizontalGroup(
            pnFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFondoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sep1)
                    .addComponent(pnTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tpUsuarios, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        pnFondoLayout.setVerticalGroup(
            pnFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpUsuarios))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private void tpUsuariosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tpUsuariosFocusGained
        cargarDatosProductos(slqTablaProducto);
        cargarDatosCategoria(slqTablaCategoria);
    }//GEN-LAST:event_tpUsuariosFocusGained

    private void txtCodigoCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoCategoriaActionPerformed

    private void txtCodigoCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoCategoriaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoCategoriaKeyPressed

    private void txtCodigoCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoCategoriaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoCategoriaKeyTyped

    private void txtDescripcionCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionCategoriaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionCategoriaKeyTyped

    private void btnEliminarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCategoriaActionPerformed
        SQLProducto.setCodCategoria(txtCodigoCategoria.getText());
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
        cargarDatosCategoria(slqTablaCategoria);

    }//GEN-LAST:event_btnEliminarCategoriaActionPerformed

    private void btnLimpiarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCategoriaActionPerformed
        limpiarCategoria();
    }//GEN-LAST:event_btnLimpiarCategoriaActionPerformed

    private void btnGuardarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCategoriaActionPerformed
        SQLProducto.setCodCategoria(txtCodigoCategoria.getText());
        SQLProducto.setDesCategoria(txtDescripcionCategoria.getText());

        if (txtCodigoCategoria.getText().equals("") || txtDescripcionCategoria.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, icon.getHandIcon());

        } else {
            if (SQLProducto.ExisteCodCategoria(SQLProducto.getCodCategoria())) {
                JOptionPane.showMessageDialog(null, "El Codigo ingresado ya existe\n"
                        + "Si lo va a actualizar presione modificar", "Dato ya existe",
                        JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());

            } else {
                if (SQLProducto.crearCategoria()) {
                    JOptionPane.showMessageDialog(null, "Se Creo la Categoria Exitosamente",
                            "Ingreso Exitoso", JOptionPane.PLAIN_MESSAGE, icon.getOkIcon());
                } else {
                    System.out.println("ERROR");
                }
            }
        }
        cargarDatosCategoria(this.slqTablaCategoria);
        limpiarCategoria();
    }//GEN-LAST:event_btnGuardarCategoriaActionPerformed

    private void tbCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCategoriaMouseClicked
        int fila = tbCategoria.getSelectedRow();

        SQLProducto.setCodCategoria(tbCategoria.getValueAt(fila, 0).toString());
        SQLProducto.setDesCategoria(tbCategoria.getValueAt(fila, 1).toString());

        txtCodigoCategoria.setText(SQLProducto.getCodCategoria());
        txtDescripcionCategoria.setText(SQLProducto.getDesCategoria());

        SQLProducto.setCodCategoria1(tbCategoria.getValueAt(fila, 0).toString());
        SQLProducto.setDesCategoria1(tbCategoria.getValueAt(fila, 1).toString());
    }//GEN-LAST:event_tbCategoriaMouseClicked

    private void btnModificarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCategoriaActionPerformed
        SQLProducto.setCodCategoria(SQLProducto.getCodCategoria1());
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
        limpiarCategoria();
    }//GEN-LAST:event_btnModificarCategoriaActionPerformed

    private void txtBuscarCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCategoriaKeyPressed

    }//GEN-LAST:event_txtBuscarCategoriaKeyPressed

    private void txtBuscarCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCategoriaKeyReleased
        cargarDatosCategoria(this.slqTablaCategoria + " where CodCategoria like '%"
                + txtBuscarCategoria.getText() + "%' or Descripcion like '%" + txtBuscarCategoria.getText() + "%'");
    }//GEN-LAST:event_txtBuscarCategoriaKeyReleased

    private void tbProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductoMouseClicked
        int fila = tbProducto.getSelectedRow();

        //System.out.println("Tercer Dato: " + tbProducto.getValueAt(fila, 2));
        SQLProducto.setCodProducto(tbProducto.getValueAt(fila, 0).toString());
        SQLProducto.setDesProducto(tbProducto.getValueAt(fila, 1).toString());
        SQLProducto.setCodCatProducto(SQLProducto.ObtenerCodCategoria(tbProducto.getValueAt(fila, 2).toString()));

        txtCodigoProducto.setText(SQLProducto.getCodProducto());
        txtDescProducto.setText(SQLProducto.getDesProducto());
        cbCategoria.setSelectedItem(tbProducto.getValueAt(fila, 2).toString());

        SQLProducto.setCodProducto1(tbProducto.getValueAt(fila, 0).toString());
        SQLProducto.setDesProducto1(tbProducto.getValueAt(fila, 1).toString());
        SQLProducto.setCodCatProducto1(SQLProducto.ObtenerCodCategoria(tbProducto.getValueAt(fila, 2).toString()));
    }//GEN-LAST:event_tbProductoMouseClicked

    private void txtBuscarProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProductoKeyPressed

    private void txtBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyReleased
        buscar();
    }//GEN-LAST:event_txtBuscarProductoKeyReleased
    public void buscar() {
        if (cbFiltroCategoria.getSelectedItem().toString() == "Seleccione") {
            filtroCategoria = "";
        } else {
            filtroCategoria = " and categoria_productos.Descripcion = '" + cbFiltroCategoria.getSelectedItem().toString() + "'";
        }
//        System.out.println(slqTablaProducto + " and (producto.CodProducto like '%"
//                + txtBuscarProducto.getText() + "%' or producto.Descripcion like '%"
//                + txtBuscarProducto.getText() + "%' " + filtroCategoria + ")");

        cargarDatosProductos(slqTablaProducto + " and (producto.CodProducto like '%"
                + txtBuscarProducto.getText() + "%' or producto.Descripcion like '%"
                + txtBuscarProducto.getText() + "%') " + filtroCategoria);
    }
    private void txtCodigoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProductoActionPerformed

    private void txtCodigoProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProductoKeyPressed

    private void txtCodigoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProductoKeyTyped

    private void txtDescProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescProductoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescProductoKeyTyped

    private void btnGuardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProductoActionPerformed

        if (txtCodigoProducto.getText().equals("") || txtDescProducto.getText().equals("") || cbCategoria.getSelectedItem().equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, icon.getHandIcon());
        } else {
            SQLProducto.setCodProducto(txtCodigoProducto.getText());
            SQLProducto.setDesProducto(txtDescProducto.getText());
            SQLProducto.setCodCatProducto(SQLProducto.ObtenerCodCategoria(cbCategoria.getSelectedItem().toString()));
            if (SQLProducto.ObtenerCodCategoria(cbCategoria.getSelectedItem().toString()) != "") {
                //SQLProducto.setCodCategoria(SQLProducto.ObtenerCodCategoria(cbCategoria.getSelectedItem().toString()));
                if (SQLProducto.ExisteCodProducto(SQLProducto.getCodProducto())) {

                    JOptionPane.showMessageDialog(null, "El Codigo ingresado ya existe\n"
                            + "Si lo va a actualizar presione modificar", "Dato ya existe",
                            JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
                } else {
                    if (SQLProducto.crearProducto()) { //System.out.println("Ingreso Exitoso");
                        JOptionPane.showMessageDialog(null, "Se Creo la Categoria Exitosamente",
                                "Ingreso Exitoso", JOptionPane.PLAIN_MESSAGE, icon.getOkIcon());
                    } else {
                        System.out.println("ERROR");

                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "La Categoria Ingresada No Existe", "Categoria no existe",
                        JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
            }
        }
        cargarDatosProductos(slqTablaProducto);
    }//GEN-LAST:event_btnGuardarProductoActionPerformed

    private void btnModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProductoActionPerformed
        if (txtCodigoProducto.getText().equals("")
                || txtDescProducto.getText().equals("")
                || cbCategoria.getSelectedItem().equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, icon.getHandIcon());

        } else {
            SQLProducto.setCodProducto(txtCodigoProducto.getText());
            SQLProducto.setDesProducto(txtDescProducto.getText());
            SQLProducto.setCodCatProducto(SQLProducto.getCodCatProducto1());

            if (SQLProducto.ExisteCodProducto(SQLProducto.getCodProducto1())
                    && SQLProducto.ExisteDescripcionProducto(SQLProducto.getDesProducto1())) {

                SQLProducto.setCodProducto(txtCodigoProducto.getText());
                SQLProducto.setDesProducto(txtDescProducto.getText());

                if (!SQLProducto.ObtenerCodCategoria(cbCategoria.getSelectedItem().toString()).equals("")) {

                    if (SQLProducto.getCodProducto().equals(SQLProducto.getCodProducto1())
                            && SQLProducto.getDesProducto().equals(SQLProducto.getDesProducto1())
                            && SQLProducto.getCodCatProducto().equals(SQLProducto.getCodCatProducto1())) {

                        JOptionPane.showMessageDialog(null, "<html><center>No Se Actualizaron Los Datos,<br>"
                                + "Los Datos Ingresados Son Iguales A Los Almacenados</center><html>",
                                "Actualización Erronea", JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
                    } else {

                        if (SQLProducto.getCodProducto().equals(SQLProducto.getCodProducto1())) {
                            if (SQLProducto.ModificarProducto()) {
                                JOptionPane.showMessageDialog(null, "Se modificaron los datos correctamente",
                                        "Actualización Exitosa", JOptionPane.PLAIN_MESSAGE, icon.getOkIcon());
                            } else {
                                System.out.println("ERROR");
                            }
                        } else {
                            if (SQLProducto.ExisteCodProducto(SQLProducto.getCodProducto())) {
                                JOptionPane.showMessageDialog(null, "El Codigo Ingresado Ya Existe",
                                        "No Se Puede Modificar", JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
                            } else {
                                if (SQLProducto.ModificarProducto()) {
                                    JOptionPane.showMessageDialog(null, "Se modificaron los datos correctamente",
                                            "Actualización Exitosa", JOptionPane.PLAIN_MESSAGE, icon.getOkIcon());
                                } else {
                                    System.out.println("ERROR");
                                }
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El codigo de la categora no es valido",
                            "Error de Actualizacion", JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());

                }

            } else {
            }
        }

        //limpiarProducto();
        cargarDatosProductos(slqTablaProducto);
    }//GEN-LAST:event_btnModificarProductoActionPerformed

    private void btnLimpiarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarProductoActionPerformed
        limpiarProducto();
    }//GEN-LAST:event_btnLimpiarProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        SQLProducto.setCodProducto(txtCodigoProducto.getText());
        SQLProducto.setDesProducto(txtDescProducto.getText());
        SQLProducto.setCodCatProducto(SQLProducto.getCodCatProducto1());

        if (txtCodigoProducto.getText().equals("") || txtDescProducto.getText().equals("")
                || cbCategoria.getSelectedItem().equals("Seleccione")) {

            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes\n"
                    + "o seleccione un dato de la tabla", "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, icon.getHandIcon());

        } else {

            if (!SQLProducto.ExisteCodProducto(SQLProducto.getCodProducto())
                    || !SQLProducto.ExisteDescripcionProducto(SQLProducto.getDesProducto())
                    || !SQLProducto.ExisteProductosCategoria()) {
                JOptionPane.showMessageDialog(null, "Los datos ingresados no coindiden",
                        "Error de eliminacion", JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
            } else {

                SQLProducto.EliminarProducto();
                JOptionPane.showMessageDialog(null, "Se eliminaron los datos exitosamente",
                        "Eliminacion exitosa", JOptionPane.PLAIN_MESSAGE, icon.getOkIcon());

            }
        }
        cargarDatosProductos(slqTablaProducto);
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void tpUsuariosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tpUsuariosComponentShown

    }//GEN-LAST:event_tpUsuariosComponentShown

    private void tabProductosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabProductosFocusGained

    }//GEN-LAST:event_tabProductosFocusGained

    private void tabCategoriasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabCategoriasFocusGained

    }//GEN-LAST:event_tabCategoriasFocusGained

    private void cbFiltroCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFiltroCategoriaItemStateChanged

    }//GEN-LAST:event_cbFiltroCategoriaItemStateChanged

    private void cbFiltroCategoriaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbFiltroCategoriaFocusLost

    }//GEN-LAST:event_cbFiltroCategoriaFocusLost

    private void cbFiltroCategoriaVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_cbFiltroCategoriaVetoableChange

    }//GEN-LAST:event_cbFiltroCategoriaVetoableChange

    private void cbFiltroCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFiltroCategoriaActionPerformed
        buscar();
    }//GEN-LAST:event_cbFiltroCategoriaActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormProducto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormProducto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormProducto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormProducto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarCategoria;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnGuardarCategoria;
    private javax.swing.JButton btnGuardarProducto;
    private javax.swing.JButton btnLimpiarCategoria;
    private javax.swing.JButton btnLimpiarProducto;
    private javax.swing.JButton btnModificarCategoria;
    private javax.swing.JButton btnModificarProducto;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbFiltroCategoria;
    private javax.swing.JLabel lblBuscarCategoria;
    private javax.swing.JLabel lblBuscarProducto;
    private javax.swing.JLabel lblCatProducto;
    private javax.swing.JLabel lblCodigoCategoria;
    private javax.swing.JLabel lblCodigoProducto;
    private javax.swing.JLabel lblDescCategoria;
    private javax.swing.JLabel lblDescProducto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnBotones1;
    private javax.swing.JPanel pnBotones2;
    private javax.swing.JPanel pnDatosCategoria;
    private javax.swing.JPanel pnDatosProducto;
    private javax.swing.JPanel pnFondo;
    private javax.swing.JPanel pnListadoCategoria;
    private javax.swing.JPanel pnListadoProducto;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JSeparator sep1;
    private javax.swing.JScrollPane spTablaCategoria;
    private javax.swing.JScrollPane spTablaProducto;
    private javax.swing.JPanel tabCategorias;
    private javax.swing.JPanel tabProductos;
    private javax.swing.JTable tbCategoria;
    private javax.swing.JTable tbProducto;
    private javax.swing.JTabbedPane tpUsuarios;
    private javax.swing.JTextField txtBuscarCategoria;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtCodigoCategoria;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtDescProducto;
    private javax.swing.JTextField txtDescripcionCategoria;
    // End of variables declaration//GEN-END:variables
}
