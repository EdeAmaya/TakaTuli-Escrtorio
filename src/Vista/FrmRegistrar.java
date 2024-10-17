
package Vista;

import Controlador.ctrlRegistro;
import Modelo.User;
import Tipografias.Fuentes;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class FrmRegistrar extends javax.swing.JFrame {

    
    Fuentes tipoFuente;
    public FrmRegistrar() {
        initComponents();
        this.setLocationRelativeTo(this);
        
        //Poner tipografia
        tipoFuente = new Fuentes();
        jlbTituloR.setFont(tipoFuente.fuente(tipoFuente.Baloo,0,25));
        
    }
    
     public static void initFrmRegistro(){
        User Modelo = new User();
        FrmRegistrar Vista = new FrmRegistrar();
        ctrlRegistro controlador = new ctrlRegistro(Modelo, Vista);
        
        Vista.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbTituloR = new javax.swing.JLabel();
        jPanel2 = new RoundedPanel(35,Color.white);
        txtCorreoElectronico = new javax.swing.JTextField();
        jCheck = new javax.swing.JCheckBox();
        txtContrasena = new javax.swing.JPasswordField();
        btnRegisrtar = new javax.swing.JButton();
        btnIrALogin = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        txtDUI = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(970, 610));
        setPreferredSize(new java.awt.Dimension(970, 610));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(130, 204, 25));
        jPanel1.setPreferredSize(new java.awt.Dimension(1440, 1024));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbTituloR.setForeground(new java.awt.Color(240, 140, 0));
        jlbTituloR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTituloR.setText("Registro");
        jPanel1.add(jlbTituloR, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 900, 50));

        jPanel2.setBackground(new java.awt.Color(130, 204, 25));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(txtCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 590, 30));

        jCheck.setBackground(new java.awt.Color(255, 255, 255));
        jCheck.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jCheck.setForeground(new java.awt.Color(153, 153, 153));
        jCheck.setText("ver contraseña");
        jCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckActionPerformed(evt);
            }
        });
        jPanel2.add(jCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, 20));
        jPanel2.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 290, 30));

        btnRegisrtar.setBackground(new java.awt.Color(222, 126, 45));
        btnRegisrtar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnRegisrtar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegisrtar.setText("Registrar");
        jPanel2.add(btnRegisrtar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 200, 40));

        btnIrALogin.setBackground(new java.awt.Color(113, 181, 48));
        btnIrALogin.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnIrALogin.setForeground(new java.awt.Color(255, 255, 255));
        btnIrALogin.setText("Iniciar Sesion");
        jPanel2.add(btnIrALogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 200, 40));
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 590, 30));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 140, 0));
        jLabel1.setText("Nombre:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 140, 0));
        jLabel5.setText("Correo Electronico:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 140, 0));
        jLabel3.setText("Contraseña:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 140, 0));
        jLabel2.setText("Edad:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, -1, -1));

        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });
        jPanel2.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, 280, 30));
        jPanel2.add(txtDUI, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 290, 30));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 140, 0));
        jLabel6.setText("DUI:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 280, 30));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 140, 0));
        jLabel4.setText("Telefono:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 900, 640));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 980, 611));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckActionPerformed
       if(jCheck.isSelected()){
           txtContrasena.setEchoChar((char)0);
       }
       else{
           txtContrasena.setEchoChar('*');
       }
    }//GEN-LAST:event_jCheckActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               initFrmRegistro();
            }
        });
    }

    
    
    //Código para redondear un panel
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
    public javax.swing.JButton btnIrALogin;
    public javax.swing.JButton btnRegisrtar;
    public javax.swing.JCheckBox jCheck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JLabel jlbTituloR;
    public javax.swing.JPasswordField txtContrasena;
    public javax.swing.JTextField txtCorreoElectronico;
    public javax.swing.JTextField txtDUI;
    public javax.swing.JTextField txtEdad;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
