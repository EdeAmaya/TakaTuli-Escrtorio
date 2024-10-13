/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ctrlInicio;
import java.awt.BorderLayout;
import java.awt.Color;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;



/**
 *
 * @author edeni
 */
public class frmInicio extends javax.swing.JFrame {

    /**
     * Creates new form frmInicio
     */
    
    public frmInicio() {
        initComponents();
        rsscalelabel.RSScaleLabel.setScaleLabel(jlbFondo,"src/Img/image (8).png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jlbLogo,"src/Img/logo.png"); 
    }
    
     public static void initFrmInicio(){
        frmInicio Vista = new frmInicio();  
         ctrlInicio ctrl = new ctrlInicio(Vista);
        Vista.setVisible(true);
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        content = new javax.swing.JPanel();
        btnAjustes = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        btnDestinos = new javax.swing.JButton();
        btnChat = new javax.swing.JButton();
        jlbLogo = new javax.swing.JLabel();
        jlbFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 680));
        setResizable(false);
        setSize(new java.awt.Dimension(1440, 1024));

        jPanel1.setBackground(new java.awt.Color(130, 204, 25));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setLayout(new java.awt.BorderLayout());
        jPanel1.add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 830, 600));

        btnAjustes.setBackground(new java.awt.Color(130, 204, 25));
        btnAjustes.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnAjustes.setForeground(new java.awt.Color(255, 255, 255));
        btnAjustes.setText("Ajustes");
        btnAjustes.setBorder(null);
        jPanel1.add(btnAjustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 170, 50));

        btnInicio.setBackground(new java.awt.Color(130, 204, 25));
        btnInicio.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setText("Inicio");
        btnInicio.setBorder(null);
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        jPanel1.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 170, 50));

        btnDestinos.setBackground(new java.awt.Color(130, 204, 25));
        btnDestinos.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnDestinos.setForeground(new java.awt.Color(255, 255, 255));
        btnDestinos.setText("Destinos");
        btnDestinos.setBorder(null);
        btnDestinos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDestinosActionPerformed(evt);
            }
        });
        jPanel1.add(btnDestinos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 170, 50));

        btnChat.setBackground(new java.awt.Color(130, 204, 25));
        btnChat.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnChat.setForeground(new java.awt.Color(255, 255, 255));
        btnChat.setText("Chat");
        btnChat.setBorder(null);
        jPanel1.add(btnChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 170, 50));

        jlbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logo.png"))); // NOI18N
        jPanel1.add(jlbLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 180, 70));

        jlbFondo.setToolTipText("");
        jPanel1.add(jlbFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 680));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDestinosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDestinosActionPerformed
      
    }//GEN-LAST:event_btnDestinosActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnInicioActionPerformed

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initFrmInicio();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAjustes;
    public javax.swing.JButton btnChat;
    public javax.swing.JButton btnDestinos;
    public javax.swing.JButton btnInicio;
    public javax.swing.JPanel content;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel jlbFondo;
    public javax.swing.JLabel jlbLogo;
    // End of variables declaration//GEN-END:variables
}
