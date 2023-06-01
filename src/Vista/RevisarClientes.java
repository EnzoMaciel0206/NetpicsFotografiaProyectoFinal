/*
Descripcion: Ventana para que trabajador revise clientes registrados
Nombre: Giancarlo Martin Ibarra
Fecha: 26-junio-2022
 */
package Vista;

import Controlador.CMenu;

public class RevisarClientes extends javax.swing.JFrame {

   
    public RevisarClientes() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabClientesCLI = new javax.swing.JTable();
        tfEdadACLI = new javax.swing.JTextField();
        tfCorreoCLI = new javax.swing.JTextField();
        btnModificarCLI = new javax.swing.JButton();
        tfModificarCLI = new javax.swing.JTextField();
        btnEliminarCLI = new javax.swing.JButton();
        tfAMACLI = new javax.swing.JTextField();
        tfAMCLI = new javax.swing.JTextField();
        btnRegresarCLI = new javax.swing.JButton();
        lblAPA41 = new javax.swing.JLabel();
        btnAgregarCLI = new javax.swing.JButton();
        lblEliminar41 = new javax.swing.JLabel();
        tfAPACLI = new javax.swing.JTextField();
        lblTelefono41 = new javax.swing.JLabel();
        tfNombreCLI = new javax.swing.JTextField();
        lblAP41 = new javax.swing.JLabel();
        lblModificar41 = new javax.swing.JLabel();
        tfEdadCLI = new javax.swing.JTextField();
        lblAgregar41 = new javax.swing.JLabel();
        tfCiudadACLI = new javax.swing.JTextField();
        lblAM41 = new javax.swing.JLabel();
        lblNombre41 = new javax.swing.JLabel();
        lblID41 = new javax.swing.JLabel();
        lblCiudad41 = new javax.swing.JLabel();
        tfCiudadCLI = new javax.swing.JTextField();
        tfBuscarCLI = new javax.swing.JTextField();
        tfTelefonoCLI = new javax.swing.JTextField();
        tfEliminarCLI = new javax.swing.JTextField();
        btnBuscarCLI = new javax.swing.JButton();
        lblCiudadA41 = new javax.swing.JLabel();
        tfTelefonoACLI = new javax.swing.JTextField();
        lblEdad41 = new javax.swing.JLabel();
        lblCorreo41 = new javax.swing.JLabel();
        lblTelefonoA41 = new javax.swing.JLabel();
        lblEdadA41 = new javax.swing.JLabel();
        lblCorreoA41 = new javax.swing.JLabel();
        lblId41 = new javax.swing.JLabel();
        lblBuscar41 = new javax.swing.JLabel();
        tfAPCLI = new javax.swing.JTextField();
        tfNombreACLI = new javax.swing.JTextField();
        tfCorreoACLI = new javax.swing.JTextField();
        lblAMA41 = new javax.swing.JLabel();
        lblIDModi41 = new javax.swing.JLabel();
        lblNombreA41 = new javax.swing.JLabel();
        lblTitulo42 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1300, 650));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(251, 235, 163));
        jPanel1.setMaximumSize(new java.awt.Dimension(1300, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabClientesCLI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabClientesCLI.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabClientesCLI);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 1105, 142));
        jPanel1.add(tfEdadACLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(557, 497, 111, 29));
        jPanel1.add(tfCorreoCLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 380, 111, 29));

        btnModificarCLI.setBackground(new java.awt.Color(245, 206, 18));
        btnModificarCLI.setFont(new java.awt.Font("Roboto Condensed", 1, 20)); // NOI18N
        btnModificarCLI.setText("Modificar");
        jPanel1.add(btnModificarCLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, -1, 35));
        jPanel1.add(tfModificarCLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 105, 35));

        btnEliminarCLI.setBackground(new java.awt.Color(245, 206, 18));
        btnEliminarCLI.setFont(new java.awt.Font("Roboto Condensed", 1, 20)); // NOI18N
        btnEliminarCLI.setText("Eliminar");
        btnEliminarCLI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCLIActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarCLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 250, 120, 35));
        jPanel1.add(tfAMACLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 497, 153, 29));
        jPanel1.add(tfAMCLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, 153, 29));

        btnRegresarCLI.setBackground(new java.awt.Color(245, 206, 18));
        btnRegresarCLI.setFont(new java.awt.Font("Roboto Condensed", 1, 20)); // NOI18N
        btnRegresarCLI.setText("Regresar");
        btnRegresarCLI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarCLIActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresarCLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 550, 127, 35));

        lblAPA41.setFont(new java.awt.Font("Roboto Condensed", 0, 20)); // NOI18N
        lblAPA41.setText("Apellido paterno:");
        jPanel1.add(lblAPA41, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 466, 148, 25));

        btnAgregarCLI.setBackground(new java.awt.Color(245, 206, 18));
        btnAgregarCLI.setFont(new java.awt.Font("Roboto Condensed", 1, 20)); // NOI18N
        btnAgregarCLI.setText("Agregar");
        btnAgregarCLI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCLIActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarCLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 419, 122, 35));

        lblEliminar41.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblEliminar41.setText("Eliminar");
        jPanel1.add(lblEliminar41, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, -1, -1));
        jPanel1.add(tfAPACLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 497, 148, 29));

        lblTelefono41.setFont(new java.awt.Font("Roboto Condensed", 0, 20)); // NOI18N
        lblTelefono41.setText("Telefono:");
        jPanel1.add(lblTelefono41, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 350, -1, 25));
        jPanel1.add(tfNombreCLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 111, 29));

        lblAP41.setFont(new java.awt.Font("Roboto Condensed", 0, 20)); // NOI18N
        lblAP41.setText("Apellido paterno:");
        jPanel1.add(lblAP41, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 148, 25));

        lblModificar41.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblModificar41.setText("Modificar");
        jPanel1.add(lblModificar41, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));
        jPanel1.add(tfEdadCLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, 111, 29));

        lblAgregar41.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblAgregar41.setText("Agregar");
        jPanel1.add(lblAgregar41, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 430, -1, -1));
        jPanel1.add(tfCiudadACLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 497, 111, 29));

        lblAM41.setFont(new java.awt.Font("Roboto Condensed", 0, 20)); // NOI18N
        lblAM41.setText("Apellido materno:");
        jPanel1.add(lblAM41, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 153, 25));

        lblNombre41.setFont(new java.awt.Font("Roboto Condensed", 0, 20)); // NOI18N
        lblNombre41.setText("Nombre:");
        jPanel1.add(lblNombre41, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, -1, 25));

        lblID41.setFont(new java.awt.Font("Roboto Condensed", 0, 20)); // NOI18N
        lblID41.setText("Id:");
        jPanel1.add(lblID41, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        lblCiudad41.setFont(new java.awt.Font("Roboto Condensed", 0, 20)); // NOI18N
        lblCiudad41.setText("Ciudad:");
        jPanel1.add(lblCiudad41, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 350, -1, 25));
        jPanel1.add(tfCiudadCLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 380, 111, 29));
        jPanel1.add(tfBuscarCLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 87, 35));
        jPanel1.add(tfTelefonoCLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 380, 111, 29));
        jPanel1.add(tfEliminarCLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 87, 35));

        btnBuscarCLI.setBackground(new java.awt.Color(245, 206, 18));
        btnBuscarCLI.setFont(new java.awt.Font("Roboto Condensed", 1, 20)); // NOI18N
        btnBuscarCLI.setText("Buscar");
        jPanel1.add(btnBuscarCLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 101, 35));

        lblCiudadA41.setFont(new java.awt.Font("Roboto Condensed", 0, 20)); // NOI18N
        lblCiudadA41.setText("Ciudad:");
        jPanel1.add(lblCiudadA41, new org.netbeans.lib.awtextra.AbsoluteConstraints(709, 466, -1, 25));
        jPanel1.add(tfTelefonoACLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(839, 497, 111, 29));

        lblEdad41.setFont(new java.awt.Font("Roboto Condensed", 0, 20)); // NOI18N
        lblEdad41.setText("Edad:");
        jPanel1.add(lblEdad41, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, -1, 25));

        lblCorreo41.setFont(new java.awt.Font("Roboto Condensed", 0, 20)); // NOI18N
        lblCorreo41.setText("Correo:");
        jPanel1.add(lblCorreo41, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 350, -1, 25));

        lblTelefonoA41.setFont(new java.awt.Font("Roboto Condensed", 0, 20)); // NOI18N
        lblTelefonoA41.setText("Telefono:");
        jPanel1.add(lblTelefonoA41, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 466, -1, 25));

        lblEdadA41.setFont(new java.awt.Font("Roboto Condensed", 0, 20)); // NOI18N
        lblEdadA41.setText("Edad:");
        jPanel1.add(lblEdadA41, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 466, -1, 25));

        lblCorreoA41.setFont(new java.awt.Font("Roboto Condensed", 0, 20)); // NOI18N
        lblCorreoA41.setText("Correo:");
        jPanel1.add(lblCorreoA41, new org.netbeans.lib.awtextra.AbsoluteConstraints(1005, 466, -1, 25));

        lblId41.setFont(new java.awt.Font("Roboto Condensed", 0, 20)); // NOI18N
        lblId41.setText("Id:");
        jPanel1.add(lblId41, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 250, -1, -1));

        lblBuscar41.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblBuscar41.setText("Buscar");
        jPanel1.add(lblBuscar41, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));
        jPanel1.add(tfAPCLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 148, 29));
        jPanel1.add(tfNombreACLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 497, 111, 29));
        jPanel1.add(tfCorreoACLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(984, 497, 111, 29));

        lblAMA41.setFont(new java.awt.Font("Roboto Condensed", 0, 20)); // NOI18N
        lblAMA41.setText("Apellido materno:");
        jPanel1.add(lblAMA41, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 466, 153, 25));

        lblIDModi41.setFont(new java.awt.Font("Roboto Condensed", 0, 20)); // NOI18N
        lblIDModi41.setText("Id:");
        jPanel1.add(lblIDModi41, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, -1, -1));

        lblNombreA41.setFont(new java.awt.Font("Roboto Condensed", 0, 20)); // NOI18N
        lblNombreA41.setText("Nombre:");
        jPanel1.add(lblNombreA41, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 466, -1, 25));

        lblTitulo42.setFont(new java.awt.Font("Roboto Condensed", 1, 48)); // NOI18N
        lblTitulo42.setText("Ventana Clientes");
        jPanel1.add(lblTitulo42, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO - SOLO FIGURA png.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(47, 47));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 152, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarCLIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCLIActionPerformed

    }//GEN-LAST:event_btnEliminarCLIActionPerformed

    private void btnAgregarCLIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCLIActionPerformed

    }//GEN-LAST:event_btnAgregarCLIActionPerformed

    private void btnRegresarCLIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarCLIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarCLIActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RevisarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RevisarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RevisarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RevisarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RevisarClientes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarCLI;
    public javax.swing.JButton btnBuscarCLI;
    public javax.swing.JButton btnEliminarCLI;
    public javax.swing.JButton btnModificarCLI;
    public javax.swing.JButton btnRegresarCLI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAM41;
    private javax.swing.JLabel lblAMA41;
    private javax.swing.JLabel lblAP41;
    private javax.swing.JLabel lblAPA41;
    private javax.swing.JLabel lblAgregar41;
    private javax.swing.JLabel lblBuscar41;
    private javax.swing.JLabel lblCiudad41;
    private javax.swing.JLabel lblCiudadA41;
    private javax.swing.JLabel lblCorreo41;
    private javax.swing.JLabel lblCorreoA41;
    private javax.swing.JLabel lblEdad41;
    private javax.swing.JLabel lblEdadA41;
    private javax.swing.JLabel lblEliminar41;
    private javax.swing.JLabel lblID41;
    private javax.swing.JLabel lblIDModi41;
    private javax.swing.JLabel lblId41;
    private javax.swing.JLabel lblModificar41;
    private javax.swing.JLabel lblNombre41;
    private javax.swing.JLabel lblNombreA41;
    private javax.swing.JLabel lblTelefono41;
    private javax.swing.JLabel lblTelefonoA41;
    private javax.swing.JLabel lblTitulo42;
    public javax.swing.JTable tabClientesCLI;
    public javax.swing.JTextField tfAMACLI;
    public javax.swing.JTextField tfAMCLI;
    public javax.swing.JTextField tfAPACLI;
    public javax.swing.JTextField tfAPCLI;
    public javax.swing.JTextField tfBuscarCLI;
    public javax.swing.JTextField tfCiudadACLI;
    public javax.swing.JTextField tfCiudadCLI;
    public javax.swing.JTextField tfCorreoACLI;
    public javax.swing.JTextField tfCorreoCLI;
    public javax.swing.JTextField tfEdadACLI;
    public javax.swing.JTextField tfEdadCLI;
    public javax.swing.JTextField tfEliminarCLI;
    public javax.swing.JTextField tfModificarCLI;
    public javax.swing.JTextField tfNombreACLI;
    public javax.swing.JTextField tfNombreCLI;
    public javax.swing.JTextField tfTelefonoACLI;
    public javax.swing.JTextField tfTelefonoCLI;
    // End of variables declaration//GEN-END:variables
}
