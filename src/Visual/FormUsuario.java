package Visual;

import Images.Iconos;
import Logica.ConexionBD;
import Logica.Encrypt;
import Logica.Usuario;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormUsuario extends javax.swing.JFrame {

    Iconos icon = new Iconos();
    Connection connection = null;
    ConexionBD connect = new ConexionBD();
    PreparedStatement ps = null;
    ResultSet rs = null;
    ResultSetMetaData rsmd = null;
    public static final String slqTabla = "select CodEmpleado , NomEmpleado , ApeEmpleado , TelEmpleado , Usuario from empleado";
    private Usuario SQLUser = new Usuario();

    public FormUsuario() {
        connection = connect.getConexion();
        SQLUser.setConnection(connection);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void cargarDatos(String consulta) {
        int columnas;
        DefaultTableModel modelo = new DefaultTableModel();
        tbUsuarios.setBackground(Color.white);
        tbUsuarios.setModel(modelo);
        try {
            ps = connection.prepareStatement(consulta);
            //System.out.println(ps);
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            modelo.addColumn("Documento");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Telefono");
            modelo.addColumn("Usuario");
            int anchoCol[] = {150, 150, 150, 150, 150};
            for (int i = 0; i < columnas; i++) {
                tbUsuarios.getColumnModel().getColumn(i).setPreferredWidth(anchoCol[i]);
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
        btnEliminarUsuario = new javax.swing.JButton();
        btnBuscarUsuario = new javax.swing.JButton();
        btnLimpiarUsuario = new javax.swing.JButton();
        btnResetPassword = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        tabListado = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuarios");

        pnFondo.setBackground(new java.awt.Color(255, 255, 255));

        pnTitulo.setBackground(new java.awt.Color(204, 255, 204));
        pnTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTitulo.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("ADMINISTRACION DE USUARIOS");

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

        btnEliminarUsuario.setBackground(new java.awt.Color(204, 255, 204));
        btnEliminarUsuario.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnEliminarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/trash.png"))); // NOI18N
        btnEliminarUsuario.setBorder(null);
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
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

        btnLimpiarUsuario.setBackground(new java.awt.Color(204, 255, 204));
        btnLimpiarUsuario.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnLimpiarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel1.png"))); // NOI18N
        btnLimpiarUsuario.setBorder(null);
        btnLimpiarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarUsuarioActionPerformed(evt);
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
                            .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnResetPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiarUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnBotonesLayout.setVerticalGroup(
            pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotonesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnResetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        tpUsuarios.addTab("Ingreso de Usuarios", tabIngreso);

        tabListado.setBackground(new java.awt.Color(204, 255, 204));

        tbUsuarios.setFont(new java.awt.Font("Century", 0, 10)); // NOI18N
        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, "", null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Documento", "Nombre", "Apellido", "Telefono", "Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbUsuarios);

        javax.swing.GroupLayout tabListadoLayout = new javax.swing.GroupLayout(tabListado);
        tabListado.setLayout(tabListadoLayout);
        tabListadoLayout.setHorizontalGroup(
            tabListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabListadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );
        tabListadoLayout.setVerticalGroup(
            tabListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabListadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpUsuarios.addTab("Listado de Usuarios", tabListado);

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

    private void limpiar() {
        txtDocumento.setBackground(Color.white);
        txtNombre.setBackground(Color.white);
        txtApellido.setBackground(Color.white);
        txtTelefono.setBackground(Color.white);
        txtUsuario.setBackground(Color.white);
        txtDocumento.setEnabled(true);
        txtContraseña.setEnabled(true);
        btnGuardar.setText("GUARDAR");

        txtDocumento.setText(null);
        txtNombre.setText(null);
        txtApellido.setText(null);
        txtTelefono.setText(null);
        txtUsuario.setText(null);
        txtContraseña.setText(null);
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
        //connect.getConnection();
        if (txtDocumento.isEnabled() == true) {
            JOptionPane.showMessageDialog(null, "Por favor diligencie el numero de documento y presione cargar",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, icon.getHandIcon());
        } else {
            SQLUser.setUsuario(txtUsuario.getText());
            SQLUser.setCodEmpleado(Long.parseLong(txtDocumento.getText()));
            if (SQLUser.ExisteUsuario()) {
                //int opc = JOptionPane.showConfirmDialog(null,
                //        "¿Esta seguro de querer restablecer la contraseña del usuario seleccionado?",
                //        "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, questionIcon);
                switch (JOptionPane.showConfirmDialog(null,
                        "¿Esta seguro de querer restablecer la contraseña del usuario seleccionado?",
                        "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon.getQuestionIcon())) {
                    case 0: //Opcion SI
                        if (SQLUser.restablecerPassword()) {
                            JOptionPane.showMessageDialog(null,
                                    "<html><center>Restablecimiento Exitoso<br>"
                                    + "Utilice la cedula de ciudadania para ingresar</html><center>",
                                    "Exito", JOptionPane.PLAIN_MESSAGE, icon.getOkIcon());

                        } else {
                            JOptionPane.showMessageDialog(null, new JLabel(
                                    "<html><center>Restablecimiento Erroneo<br>"
                                    + "Verifique los Datos e Intente de Nuevo</center><html>",
                                    JLabel.CENTER), "Error", JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
                        }

                        break;
                    case 1: //Opcion NO
                        JOptionPane.showMessageDialog(null, "Se ha cancelado la eliminacion",
                                "Cancelado por Usuario", JOptionPane.PLAIN_MESSAGE, icon.getCancelIcon());
                        break;
                }

            } else {
            }
        }
    }//GEN-LAST:event_btnResetPasswordActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        if (txtDocumento.isEnabled() == true) {
            JOptionPane.showMessageDialog(null, "Por favor diligencie el numero de documento y presione cargar",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, icon.getHandIcon());
        } else {
            int opc = JOptionPane.showConfirmDialog(null, "¿Esta seguro de querer eliminar el usuario seleccionado?",
                    "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon.getQuestionIcon());

            //JOptionPane.showConfirmDialog(null, "Por favor diligencie los campos correspondientes", "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, 2);
            //JOptionPane.showConfirmDialog(null, "¿Esta seguro de querer eliminar el usuario seleccionado?");
            //System.out.println(opc);
            switch (opc) {
                case 0: //Opcion SI
                    SQLUser.setCodEmpleado(Long.parseLong(txtDocumento.getText()));
                    SQLUser.setUsuario(txtUsuario.getText());
                    if (SQLUser.ExisteDocumento() && SQLUser.ExisteUsuario()) {

                        if (SQLUser.EliminarUsuario()) {
                            JOptionPane.showMessageDialog(null, "Eliminacion Exitosa",
                                    "Exito", JOptionPane.PLAIN_MESSAGE, icon.getOkIcon());
                            limpiar();
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo eliminar",
                                    "Error", JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El usuario Ingresado no existe o ya se elimino",
                                "Usuario no Existe", JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
                    }
                    break;
                case 1: //Opcion NO
                    JOptionPane.showMessageDialog(null, "Se ha cancelado la eliminacion",
                            "Cancelado por Usuario", JOptionPane.PLAIN_MESSAGE, icon.getCancelIcon());
                    break;
            }

        }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void btnLimpiarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarUsuarioActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarUsuarioActionPerformed

    private void btnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioActionPerformed
        txtDocumento.setBackground(Color.white);
        txtNombre.setBackground(Color.white);
        txtApellido.setBackground(Color.white);
        txtTelefono.setBackground(Color.white);
        txtUsuario.setBackground(Color.white);
        if (!txtDocumento.getText().equals("")) {
            //con = connect.getConection();
            SQLUser.setCodEmpleado(Long.parseLong(txtDocumento.getText()));

            if (SQLUser.ConsultarUsuarios()) {
                txtNombre.setText(SQLUser.getNomEmpleado());
                txtApellido.setText(SQLUser.getApeEmpleado());
                txtTelefono.setText(String.valueOf(SQLUser.getTelEmpleado()));
                txtUsuario.setText(SQLUser.getUsuario());
                txtContraseña.setText(SQLUser.getContraseña());
                txtContraseña.setEnabled(false);
                txtDocumento.setEnabled(false);
                btnGuardar.setText("Actualizar");
            } else {
                txtNombre.setText(null);
                txtApellido.setText(null);
                txtTelefono.setText(null);
                txtUsuario.setText(null);
                txtContraseña.setEnabled(true);
                btnGuardar.setText("Guardar");
                JOptionPane.showMessageDialog(null, "Usuario No Existe");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, icon.getHandIcon());
        }
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
        if (txtDocumento.getText().equals("") || txtNombre.getText().equals("")
                || txtApellido.getText().equals("")
                || txtTelefono.getText().equals("") || txtUsuario.getText().equals("")
                || txtContraseña.getPassword().equals("")) {

            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, icon.getHandIcon());

            if (txtDocumento.getText().equals("")) {
                txtDocumento.setBackground(Color.red);
            }
            if (txtNombre.getText().equals("")) {
                txtNombre.setBackground(Color.red);
            }
            if (txtApellido.getText().equals("")) {
                txtApellido.setBackground(Color.red);
            }
            if (txtTelefono.getText().equals("")) {
                txtTelefono.setBackground(Color.red);
            }
            if (txtUsuario.getText().equals("")) {
                txtUsuario.setBackground(Color.red);
            }
        } else {
            SQLUser.setUsuario(txtUsuario.getText());
            SQLUser.setCodEmpleado(Long.parseLong(txtDocumento.getText()));

            if (txtDocumento.isEnabled()) {

                if (SQLUser.ExisteDocumento()) {
                    JOptionPane.showMessageDialog(null,
                            "El Documento Ingresado Ya Existe\nPara Actualizar, Presione el Boton Buscar");
                    txtDocumento.setBackground(Color.red);
                } else if (SQLUser.ExisteUsuario()) {
                    JOptionPane.showMessageDialog(null, "El Usuario Ingresado Ya Existe");
                    txtUsuario.setBackground(Color.red);
                } else {
                    //System.out.println(txtContraseña.getText().length());
                    if (txtContraseña.getText().length() < 6) {
                        JOptionPane.showMessageDialog(null, "La contraseña no puede tener menos de 6 caracteres",
                                "Contraseña muy corta", JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());
                    } else {
                        SQLUser.setCodEmpleado(Long.parseLong(txtDocumento.getText()));
                        SQLUser.setNomEmpleado(txtNombre.getText());
                        SQLUser.setApeEmpleado(txtApellido.getText());
                        SQLUser.setTelEmpleado(Long.parseLong(txtTelefono.getText()));
                        SQLUser.setUsuario(txtUsuario.getText());
                        String passwd = new String(txtContraseña.getPassword());
                        SQLUser.setContraseña(Encrypt.sha1(passwd));
                        SQLUser.nuevoUsuario();
                        //JOptionPane.showMessageDialog(null, "Se Ingreso el Usuario Exitosamente");
                        JOptionPane.showMessageDialog(null, "Se Ingresaron los Datos Exitosamente",
                                "Ingreso Exitoso", JOptionPane.PLAIN_MESSAGE, icon.getOkIcon());
                    }
                }
            } else {
                SQLUser.setCodEmpleado(Long.parseLong(txtDocumento.getText()));
                SQLUser.setNomEmpleado(txtNombre.getText());
                SQLUser.setApeEmpleado(txtApellido.getText());
                SQLUser.setTelEmpleado(Long.parseLong(txtTelefono.getText()));
                SQLUser.setUsuario(txtUsuario.getText());
                SQLUser.setContraseña(Encrypt.sha1(txtContraseña.getPassword().toString()));
                if (SQLUser.ExisteDocumento()) {

                    SQLUser.setCodEmpleado(Long.parseLong(txtDocumento.getText()));
                    SQLUser.setNomEmpleado(txtNombre.getText());
                    SQLUser.setApeEmpleado(txtApellido.getText());
                    SQLUser.setTelEmpleado(Long.parseLong(txtTelefono.getText()));
                    SQLUser.setUsuario(txtUsuario.getText());
                    SQLUser.setContraseña(txtContraseña.getPassword().toString());
                    SQLUser.actualizarUsuario();
                    JOptionPane.showMessageDialog(null, "Se Actualizaron los Datos Exitosamente", "Actualizacion Exitosa", JOptionPane.PLAIN_MESSAGE, icon.getOkIcon());
                } else {
                    JOptionPane.showMessageDialog(null, "No Existen datos para Actualizar", "Actualizacion Erronea", JOptionPane.PLAIN_MESSAGE, icon.getBadIcon());

                }

            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaKeyPressed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiarUsuario;
    private javax.swing.JButton btnResetPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnBotones;
    private javax.swing.JPanel pnDatos;
    private javax.swing.JPanel pnFondo;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JSeparator sep1;
    private javax.swing.JPanel tabIngreso;
    private javax.swing.JPanel tabListado;
    private javax.swing.JTable tbUsuarios;
    private javax.swing.JTabbedPane tpUsuarios;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JPasswordField txtContraseña;
    public javax.swing.JTextField txtDocumento;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTelefono;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
