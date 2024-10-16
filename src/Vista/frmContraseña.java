/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ctrlContraseña;
import Controlador.ctrlRecuperacion;
import Modelo.User;
import Tipografias.Fuentes;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import Tipografias.Fuentes;


/**
 *
 * @author edeni
 */
public class frmContraseña extends javax.swing.JFrame {

    /**
     * Creates new form frmContraseña
     */
    Fuentes tipoFuente;
    public frmContraseña() {
        initComponents();
        rsscalelabel.RSScaleLabel.setScaleLabel(jlbFondoC, "src/Img/image(8).png");
        
        //Poner tipografia
        tipoFuente = new Fuentes();
        jlbNewContra.setFont(tipoFuente.fuente(tipoFuente.Baloo,0,25));
                             

    }

    public static void initFrmContraseña(){
        User Modelo = new User();
        frmContraseña Vista = new frmContraseña();
        frmRecuperacion vistaRecuperacion = new frmRecuperacion();
        ctrlRecuperacion controladorRecuperacion = new ctrlRecuperacion(Modelo,vistaRecuperacion);
        ctrlContraseña controlador = new ctrlContraseña(Modelo,Vista,controladorRecuperacion);
        
        
        
        Vista.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanelNC = new javax.swing.JPanel();
        txtNuevaContraseña = new javax.swing.JTextField();
        btnNContraseña = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jlbNewContra = new javax.swing.JLabel();
        jlbFondoC = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelNC.setBackground(new java.awt.Color(130, 204, 25));
        jPanelNC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelNC.add(txtNuevaContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 382, 40));

        btnNContraseña.setBackground(new java.awt.Color(94, 180, 209));
        btnNContraseña.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnNContraseña.setForeground(new java.awt.Color(255, 255, 255));
        btnNContraseña.setText("Actualizar");
        jPanelNC.add(btnNContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 230, 40));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/newpassword (1).png"))); // NOI18N
        jPanelNC.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 240, -1));

        jlbNewContra.setBackground(new java.awt.Color(0, 0, 0));
        jlbNewContra.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jlbNewContra.setText("Nueva Contraseña");
        jPanelNC.add(jlbNewContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        jlbFondoC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbFondoC.setToolTipText("");
        jPanelNC.add(jlbFondoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 890, 530));
        jPanelNC.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelNC, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelNC, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frmContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initFrmContraseña();
            }
        });
    }

    
    
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
    public javax.swing.JButton btnNContraseña;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanelNC;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JLabel jlbFondoC;
    public javax.swing.JLabel jlbNewContra;
    public javax.swing.JTextField txtNuevaContraseña;
    // End of variables declaration//GEN-END:variables
}
