/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ctrlHospedaje;
import Controlador.ctrlLogin;
import Modelo.Hospedaje;
import Modelo.User;


public class frmHospedaje extends javax.swing.JFrame {

   
    public frmHospedaje() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNombreH = new javax.swing.JTextField();
        txtDescripcionH = new javax.swing.JTextField();
        txtPrecioH1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbHospedaje = new javax.swing.JTable();
        btnAgregarH = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnEliminarH = new javax.swing.JButton();
        btnActualizarH = new javax.swing.JButton();
        btnLimpiarH = new javax.swing.JButton();
        btnVolverH = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreH.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreH.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(txtNombreH, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 139, 340, 48));

        txtDescripcionH.setBackground(new java.awt.Color(255, 255, 255));
        txtDescripcionH.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(txtDescripcionH, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 302, 340, 48));

        txtPrecioH1.setBackground(new java.awt.Color(255, 255, 255));
        txtPrecioH1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(txtPrecioH1, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 220, 340, 48));

        jtbHospedaje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtbHospedaje);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 527, 992, 333));

        btnAgregarH.setBackground(new java.awt.Color(113, 181, 48));
        btnAgregarH.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnAgregarH.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarH.setText("Agregar");
        jPanel1.add(btnAgregarH, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 435, 117, 38));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Precio:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Descripcion:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, -1, -1));

        btnEliminarH.setBackground(new java.awt.Color(129, 1, 13));
        btnEliminarH.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnEliminarH.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarH.setText("Eliminar");
        btnEliminarH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarHActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarH, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 435, 117, 38));

        btnActualizarH.setBackground(new java.awt.Color(222, 126, 45));
        btnActualizarH.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnActualizarH.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarH.setText("Actualizar");
        jPanel1.add(btnActualizarH, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 434, 117, 40));

        btnLimpiarH.setBackground(new java.awt.Color(20, 126, 150));
        btnLimpiarH.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnLimpiarH.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarH.setText("Limpiar");
        jPanel1.add(btnLimpiarH, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 434, 121, 40));

        btnVolverH.setBackground(new java.awt.Color(113, 181, 48));
        btnVolverH.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnVolverH.setForeground(new java.awt.Color(255, 255, 255));
        btnVolverH.setText("<---");
        jPanel1.add(btnVolverH, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 21, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Hospedajes");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarHActionPerformed
        
    }//GEN-LAST:event_btnEliminarHActionPerformed

     public static void initFrmHospedaje(){
        Hospedaje Modelo = new Hospedaje();
        frmHospedaje Vista = new frmHospedaje();
        ctrlHospedaje controlador = new ctrlHospedaje(Vista,Modelo);
        
        Vista.setVisible(true);
    }
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initFrmHospedaje();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarH;
    public javax.swing.JButton btnAgregarH;
    public javax.swing.JButton btnEliminarH;
    public javax.swing.JButton btnLimpiarH;
    public javax.swing.JButton btnVolverH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtbHospedaje;
    public javax.swing.JTextField txtDescripcionH;
    public javax.swing.JTextField txtNombreH;
    public javax.swing.JTextField txtPrecioH1;
    // End of variables declaration//GEN-END:variables
}
