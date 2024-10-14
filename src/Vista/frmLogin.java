package Vista;

import Controlador.ctrlLogin;
import Modelo.User;
import Tipografias.Fuentes;

public class frmLogin extends javax.swing.JFrame {

    Fuentes tipoFuente;
    public frmLogin() {
        initComponents();
        this.setLocationRelativeTo(this);
        rsscalelabel.RSScaleLabel.setScaleLabel(jlbFondoL,"src/Img/image (8).png");
        
        
        //Poner tipografia
        tipoFuente = new Fuentes();
        jTituloL.setFont(tipoFuente.fuente(tipoFuente.Baloo,0,25));
        
        
        
    }
    
    public static void initFrmLogin(){
        User Modelo = new User();
        frmLogin Vista = new frmLogin();
        ctrlLogin controlador = new ctrlLogin(Modelo,Vista);
        
        Vista.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRound1 = new Vista.PanelRound();
        jTituloL = new javax.swing.JLabel();
        jNombreUserL = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jContraL = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JTextField();
        btnIniciarSesion = new javax.swing.JButton();
        btnIrARegistro = new javax.swing.JButton();
        btnRecuperarContraseña = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jlbFondoL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(130, 204, 25));
        jPanel1.setPreferredSize(new java.awt.Dimension(1440, 1024));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);

        jTituloL.setBackground(new java.awt.Color(0, 0, 0));
        jTituloL.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTituloL.setForeground(new java.awt.Color(240, 140, 0));
        jTituloL.setText("INICIAR SESION");
        jTituloL.setToolTipText("");

        jNombreUserL.setBackground(new java.awt.Color(255, 255, 255));
        jNombreUserL.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jNombreUserL.setForeground(new java.awt.Color(240, 140, 0));
        jNombreUserL.setText("Nombre o Correo Electronico");

        txtCorreo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 140, 0), 2, true));
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        jContraL.setBackground(new java.awt.Color(255, 255, 255));
        jContraL.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jContraL.setForeground(new java.awt.Color(240, 140, 0));
        jContraL.setText("Contraseña");

        txtContraseña.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 140, 0), 2, true));

        btnIniciarSesion.setBackground(new java.awt.Color(113, 181, 48));
        btnIniciarSesion.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("Iniciar Sesion");
        btnIniciarSesion.setBorder(null);

        btnIrARegistro.setBackground(new java.awt.Color(222, 126, 45));
        btnIrARegistro.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnIrARegistro.setForeground(new java.awt.Color(255, 255, 255));
        btnIrARegistro.setText("Registrarme");

        btnRecuperarContraseña.setBackground(new java.awt.Color(94, 180, 209));
        btnRecuperarContraseña.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnRecuperarContraseña.setForeground(new java.awt.Color(255, 255, 255));
        btnRecuperarContraseña.setText("Recuperar Contraseña");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(0, 95, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnRecuperarContraseña, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIrARegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTituloL)
                .addGap(115, 115, 115))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jNombreUserL)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(jContraL)
                    .addComponent(txtContraseña))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jTituloL, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jNombreUserL, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jContraL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIrARegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRecuperarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 420, 550));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logo-removebg-preview (2).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 310, 300));
        jPanel1.add(jlbFondoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 970, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               initFrmLogin();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnIniciarSesion;
    public javax.swing.JButton btnIrARegistro;
    public javax.swing.JButton btnRecuperarContraseña;
    public javax.swing.JLabel jContraL;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jNombreUserL;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel jTituloL;
    public javax.swing.JLabel jlbFondoL;
    private Vista.PanelRound panelRound1;
    public javax.swing.JTextField txtContraseña;
    public javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
