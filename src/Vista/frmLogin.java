package Vista;

import Controlador.ctrlLogin;
import Modelo.User;
import Tipografias.Fuentes;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class frmLogin extends javax.swing.JFrame {

    Fuentes tipoFuente;
    public frmLogin() {
        initComponents();
        this.setLocationRelativeTo(this);
        rsscalelabel.RSScaleLabel.setScaleLabel(jlbFondoL,"src/Img/image (8).png");
        this.jlbHide.setVisible(false);
        this.jlbShow.setVisible(true);
        
        
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new RoundedPanel(50,Color.white);
        txtCorreo = new javax.swing.JTextField();
        jTituloL = new javax.swing.JLabel();
        btnIniciarSesion = new javax.swing.JButton();
        jbtnRecuperarContra = new javax.swing.JButton();
        btnIrARegistro = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jlbShow = new javax.swing.JLabel();
        jlbHide = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jlbFondoL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(130, 204, 25));
        jPanel1.setPreferredSize(new java.awt.Dimension(1440, 1024));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logo-removebg-preview (2).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 310, 300));

        jPanel2.setBackground(new java.awt.Color(130, 204, 25));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCorreo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtCorreo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 140, 0), 2, true));
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel2.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 143, 370, 40));

        jTituloL.setForeground(new java.awt.Color(240, 140, 0));
        jTituloL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTituloL.setText("INICIAR SESIÓN");
        jPanel2.add(jTituloL, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 437, 77));

        btnIniciarSesion.setBackground(new java.awt.Color(240, 140, 0));
        btnIniciarSesion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 140, 0), 1, true));
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        jPanel2.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 345, 238, 30));

        jbtnRecuperarContra.setBackground(new java.awt.Color(102, 204, 0));
        jbtnRecuperarContra.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jbtnRecuperarContra.setForeground(new java.awt.Color(255, 255, 255));
        jbtnRecuperarContra.setText("Recuperar Contraseña");
        jbtnRecuperarContra.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 204, 0), 1, true));
        jPanel2.add(jbtnRecuperarContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 452, 238, 31));

        btnIrARegistro.setBackground(new java.awt.Color(51, 153, 255));
        btnIrARegistro.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnIrARegistro.setForeground(new java.awt.Color(255, 255, 255));
        btnIrARegistro.setText("Registro");
        btnIrARegistro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        btnIrARegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrARegistroActionPerformed(evt);
            }
        });
        jPanel2.add(btnIrARegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 401, 238, 33));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 140, 0));
        jLabel3.setText("Usuario o Correo Electrónico");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 118, -1, -1));

        jlbShow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image (12).png"))); // NOI18N
        jlbShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlbShowMousePressed(evt);
            }
        });
        jPanel2.add(jlbShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 37, 46));

        jlbHide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image (13).png"))); // NOI18N
        jlbHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlbHideMousePressed(evt);
            }
        });
        jPanel2.add(jlbHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 37, 40));

        txtContraseña.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtContraseña.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 140, 0), 2, true));
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        jPanel2.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 370, 40));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 140, 0));
        jLabel4.setText("Contraseña");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 450, 530));
        jPanel1.add(jlbFondoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIrARegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrARegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIrARegistroActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void jlbShowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbShowMousePressed
        jlbHide.setVisible(true);
        jlbShow.setVisible(false);
        txtContraseña.setEchoChar((char)0);
        
    }//GEN-LAST:event_jlbShowMousePressed

    private void jlbHideMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbHideMousePressed
        jlbHide.setVisible(false);
        jlbShow.setVisible(true);
        txtContraseña.setEchoChar('*');
    }//GEN-LAST:event_jlbHideMousePressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               initFrmLogin();
            }
        });
    }
    
    
    
    //Códifo para redondear un panel
    // solo que recuerda que se redondea como poniendo otro mini panel dentro de ese
    // entonces que no se te olvide cambiarle el color al fondo del panel
    
    class RoundedPanel extends JPanel
    {
        private Color backgroundColor;
        private int cornerRadius = 15;
        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }
        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
            
        }
        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
        
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
//            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
//             
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnIniciarSesion;
    public javax.swing.JButton btnIrARegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JLabel jTituloL;
    public javax.swing.JButton jbtnRecuperarContra;
    public javax.swing.JLabel jlbFondoL;
    public javax.swing.JLabel jlbHide;
    public javax.swing.JLabel jlbShow;
    public javax.swing.JPasswordField txtContraseña;
    public javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
