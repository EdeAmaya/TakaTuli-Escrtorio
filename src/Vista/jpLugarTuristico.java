/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import java.awt.BorderLayout;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author edeni
 */
public class jpLugarTuristico extends javax.swing.JPanel {

    /**
     * Creates new form jpLugarTuristico
     */
    public jpLugarTuristico() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentLT = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSubidosLT = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contentLT.setBackground(new java.awt.Color(255, 255, 255));
        contentLT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Lugares Turisticos");
        contentLT.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, -1, -1));

        btnSubidosLT.setBackground(new java.awt.Color(251, 212, 95));
        btnSubidosLT.setForeground(new java.awt.Color(255, 140, 0));
        btnSubidosLT.setText("Subidos");
        btnSubidosLT.setBorder(null);
        btnSubidosLT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubidosLTActionPerformed(evt);
            }
        });
        contentLT.add(btnSubidosLT, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 542, 156, 36));

        add(contentLT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubidosLTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubidosLTActionPerformed
        jpSubidos pl = new jpSubidos(); // Crea una instancia
        pl.setSize(830, 600);    // Establece el tamaño
        pl.setLocation(0, 0);    // Establece la ubicación

        contentLT.removeAll();      // Elimina todos los componentes del contenedor 'content'
        contentLT.setLayout(new AbsoluteLayout());
        contentLT.add(pl, new AbsoluteConstraints(0, 0, 830, 600)); // Agrega el nuevo panel al centro del contenedor
        contentLT.revalidate();      // Vuelve a validar el contenedor para que se ajuste a los cambios
        contentLT.repaint();
    }//GEN-LAST:event_btnSubidosLTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnSubidosLT;
    public javax.swing.JPanel contentLT;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
