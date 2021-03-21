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
    public final String slqTabla = "SELECT CodCategoria, Descripcion from categoria_productos";
    private Producto SQLProducto = new Producto();

    public FormProducto() {
        connection = connect.getConexion();
        SQLProducto.setConnection(connection);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void cargarDatos(String consulta) {
        int columnas;
        DefaultTableModel modelo = new DefaultTableModel();
        tbCategoria.setBackground(Color.white);
        tbCategoria.setModel(modelo);
        try {
            ps = connection.prepareStatement(consulta);
            //System.out.println(ps);
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            modelo.addColumn("Documento");
            modelo.addColumn("Descripcion");

            int anchoCol[] = {100, 150};
            for (int i = 0; i < columnas; i++) {
                tbCategoria.getColumnModel().getColumn(i).setPreferredWidth(anchoCol[i]);
            }
            while (rs.next()) {
                Object[] filas = new Object[columnas];

                for (int i = 0; i < columnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        //connect.stopConnection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnFondo = new javax.swing.JPanel();
        pnTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        sep1 = new javax.swing.JSeparator();
        tpUsuarios = new javax.swing.JTabbedPane();
        tabIngreso = new javax.swing.JPanel();
        pnDatos = new javax.swing.JPanel();
        lblDocumento = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        pnBotones = new javax.swing.JPanel();
        btnEliminarUsuaro = new javax.swing.JButton();
        btnBuscarUsuario = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnResetPassword = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        tabListado = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCategoria = new javax.swing.JTable();
        pnDatos1 = new javax.swing.JPanel();
        lblDocumento1 = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
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
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
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

        tabIngreso.setBackground(new java.awt.Color(204, 255, 204));
        tabIngreso.setForeground(new java.awt.Color(204, 255, 204));

        pnDatos.setBackground(new java.awt.Color(153, 255, 204));

        lblDocumento.setBackground(new java.awt.Color(255, 255, 255));
        lblDocumento.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblDocumento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDocumento.setText("Documento");

        lblNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblNombre.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre");

        lblApellido.setBackground(new java.awt.Color(255, 255, 255));
        lblApellido.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblApellido.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblApellido.setText("Apellido");

        lblTelefono.setBackground(new java.awt.Color(255, 255, 255));
        lblTelefono.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblTelefono.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTelefono.setText("Telefono");

        lblUsuario.setBackground(new java.awt.Color(255, 255, 255));
        lblUsuario.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsuario.setText("Usuario");

        lblContraseña.setBackground(new java.awt.Color(255, 255, 255));
        lblContraseña.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblContraseña.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContraseña.setText("Contraseña");

        txtDocumento.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtDocumento.setToolTipText("");
        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });
        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellido.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        txtTelefono.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        txtContraseña.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnDatosLayout = new javax.swing.GroupLayout(pnDatos);
        pnDatos.setLayout(pnDatosLayout);
        pnDatosLayout.setHorizontalGroup(
            pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnDatosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(lblApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(lblDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnDatosLayout.setVerticalGroup(
            pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnDatosLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(lblDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(lblTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(15, Short.MAX_VALUE)))
        );

        pnBotones.setBackground(new java.awt.Color(153, 255, 204));

        btnEliminarUsuaro.setBackground(new java.awt.Color(204, 255, 204));
        btnEliminarUsuaro.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnEliminarUsuaro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/trash.png"))); // NOI18N
        btnEliminarUsuaro.setBorder(null);
        btnEliminarUsuaro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuaroActionPerformed(evt);
            }
        });

        btnBuscarUsuario.setBackground(new java.awt.Color(204, 255, 204));
        btnBuscarUsuario.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnBuscarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        btnBuscarUsuario.setBorder(null);
        btnBuscarUsuario.setBorderPainted(false);
        btnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(204, 255, 204));
        btnLimpiar.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel1.png"))); // NOI18N
        btnLimpiar.setBorder(null);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnResetPassword.setBackground(new java.awt.Color(204, 255, 204));
        btnResetPassword.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnResetPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/resetUser.png"))); // NOI18N
        btnResetPassword.setBorder(null);
        btnResetPassword.setBorderPainted(false);
        btnResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPasswordActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(204, 255, 204));
        btnGuardar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotonesLayout = new javax.swing.GroupLayout(pnBotones);
        pnBotones.setLayout(pnBotonesLayout);
        pnBotonesLayout.setHorizontalGroup(
            pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBotonesLayout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnBotonesLayout.createSequentialGroup()
                        .addGroup(pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarUsuaro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnResetPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnBotonesLayout.setVerticalGroup(
            pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotonesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnResetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarUsuaro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabIngresoLayout = new javax.swing.GroupLayout(tabIngreso);
        tabIngreso.setLayout(tabIngresoLayout);
        tabIngresoLayout.setHorizontalGroup(
            tabIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabIngresoLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(pnDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabIngresoLayout.setVerticalGroup(
            tabIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabIngresoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(tabIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tpUsuarios.addTab("Productos", tabIngreso);

        tabListado.setBackground(new java.awt.Color(204, 255, 204));

        tbCategoria.setBackground(new java.awt.Color(153, 255, 204));
        tbCategoria.setFont(new java.awt.Font("Century", 0, 10)); // NOI18N
        tbCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, ""},
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
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCategoria.setGridColor(new java.awt.Color(0, 0, 0));
        tbCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCategoria);

        pnDatos1.setBackground(new java.awt.Color(153, 255, 204));

        lblDocumento1.setBackground(new java.awt.Color(255, 255, 255));
        lblDocumento1.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblDocumento1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDocumento1.setText("Codigo");

        lblNombre1.setBackground(new java.awt.Color(255, 255, 255));
        lblNombre1.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lblNombre1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre1.setText("Descripcion");

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

        javax.swing.GroupLayout pnDatos1Layout = new javax.swing.GroupLayout(pnDatos1);
        pnDatos1.setLayout(pnDatos1Layout);
        pnDatos1Layout.setHorizontalGroup(
            pnDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnDatos1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblDocumento1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(lblNombre1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(pnDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtCodigoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDescripcionCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnDatos1Layout.setVerticalGroup(
            pnDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
            .addGroup(pnDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnDatos1Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(pnDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCodigoCategoria)
                        .addComponent(lblDocumento1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDescripcionCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(pnBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(pnBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        pnBotones1Layout.setVerticalGroup(
            pnBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotones1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabListadoLayout = new javax.swing.GroupLayout(tabListado);
        tabListado.setLayout(tabListadoLayout);
        tabListadoLayout.setHorizontalGroup(
            tabListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabListadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tabListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnDatos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBotones1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        tabListadoLayout.setVerticalGroup(
            tabListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabListadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                    .addGroup(tabListadoLayout.createSequentialGroup()
                        .addComponent(pnDatos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnBotones1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tpUsuarios.addTab("Categorias", tabListado);

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
                .addComponent(tpUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void limpiarCategoria() {
        txtCodigoCategoria.setText(null);
        txtDescripcionCategoria.setText(null);
    }

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
    private void btnResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPasswordActionPerformed

    }//GEN-LAST:event_btnResetPasswordActionPerformed

    private void btnEliminarUsuaroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuaroActionPerformed

    }//GEN-LAST:event_btnEliminarUsuaroActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCategoria();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioActionPerformed

    }//GEN-LAST:event_btnBuscarUsuarioActionPerformed

    private void txtDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyPressed

    }//GEN-LAST:event_txtDocumentoKeyPressed

    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoActionPerformed

    private void txtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyTyped
        txtDocumento.setBackground(Color.white);
        if (!isNum(evt.getKeyChar())) {
            //getToolkit().beep();
            JOptionPane.showMessageDialog(null, "<html><center>El dato ingresado no es valido,<br>"
                    + "solo se aceptan numeros</center><html>",
                    "Dato no Valido", JOptionPane.PLAIN_MESSAGE, icon.getCancelIcon());
            evt.consume();
        }
        if (txtDocumento.getText().length() >= 10) {
            JOptionPane.showMessageDialog(null, "Solo se aceptan 30 caracteres");
            evt.consume();
        }
    }//GEN-LAST:event_txtDocumentoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        txtTelefono.setBackground(Color.white);
        if (!isNum(evt.getKeyChar())) {
            //getToolkit().beep();
            JOptionPane.showMessageDialog(null, "<html><center>El dato ingresado no es valido,<br>"
                    + "solo se aceptan numeros</center><html>",
                    "Dato no Valido", JOptionPane.PLAIN_MESSAGE, icon.getCancelIcon());
            evt.consume();
        }
        if (txtTelefono.getText().length() >= 10) {
            JOptionPane.showMessageDialog(null, "Solo se aceptan 30 caracteres");
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        txtNombre.setBackground(Color.white);
        if (isLetter(evt.getKeyChar())) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "<html><center>El Dato Ingresado No Es Valido,<br>"
                    + "Solo Se Aceptan Letras y Espacios</center><html>",
                    "Dato no Valido", JOptionPane.PLAIN_MESSAGE, icon.getCancelIcon());
            evt.consume();
        }
        if (txtNombre.getText().length() >= 30) {
            JOptionPane.showMessageDialog(null, "Solo se aceptan 30 caracteres");
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        txtApellido.setBackground(Color.white);
        if (isLetter(evt.getKeyChar())) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "<html><center>El Dato Ingresado No Es Valido,<br>"
                    + "Solo Se Aceptan Letras y Espacios</center><html>",
                    "Dato no Valido", JOptionPane.PLAIN_MESSAGE, icon.getCancelIcon());
            evt.consume();
        }
        if (txtApellido.getText().length() >= 30) {
            JOptionPane.showMessageDialog(null, "Solo se aceptan 30 caracteres");
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        txtUsuario.setBackground(Color.white);
        if (txtUsuario.getText().length() >= 16) {
            JOptionPane.showMessageDialog(null, "Solo se aceptan 16 caracteres");
            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyTyped
        if (txtContraseña.getText().length() >= 80) {
            JOptionPane.showMessageDialog(null, "Solo se aceptan 80 caracteres");
            evt.consume();
        }
        //System.out.println(txtContraseña.getText().length());
        if (txtContraseña.getText().length() < 5) {
            txtContraseña.setBackground(Color.MAGENTA);
        } else {
            txtContraseña.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txtContraseñaKeyTyped

    private void tpUsuariosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tpUsuariosFocusGained
        cargarDatos(slqTabla);
    }//GEN-LAST:event_tpUsuariosFocusGained

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaKeyPressed

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
        cargarDatos(this.slqTabla);

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
        cargarDatos(this.slqTabla);
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
                            cargarDatos(this.slqTabla);
                        } else {
                            System.out.println("ERROR de Actualizacion ln:890");
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
                                cargarDatos(this.slqTabla);
                            } else {
                                System.out.println("ERROR de Actualizacion ln:903");
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
        limpiarCategoria();
    }//GEN-LAST:event_btnModificarCategoriaActionPerformed

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
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnEliminarCategoria;
    private javax.swing.JButton btnEliminarUsuaro;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarCategoria;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiarCategoria;
    private javax.swing.JButton btnModificarCategoria;
    private javax.swing.JButton btnResetPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblDocumento1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnBotones;
    private javax.swing.JPanel pnBotones1;
    private javax.swing.JPanel pnDatos;
    private javax.swing.JPanel pnDatos1;
    private javax.swing.JPanel pnFondo;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JSeparator sep1;
    private javax.swing.JPanel tabIngreso;
    private javax.swing.JPanel tabListado;
    private javax.swing.JTable tbCategoria;
    private javax.swing.JTabbedPane tpUsuarios;
    public javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCodigoCategoria;
    public javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtDescripcionCategoria;
    public javax.swing.JTextField txtDocumento;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTelefono;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
