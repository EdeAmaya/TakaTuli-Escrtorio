/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.ctrlLugarTuristico;
import Modelo.LugarTuristico;
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
    
    public static void initjpLugarTuristico(){
        LugarTuristico Modelo = new LugarTuristico();
        jpLugarTuristico Vista = new jpLugarTuristico();
        ctrlLugarTuristico controlador = new ctrlLugarTuristico(Vista,Modelo);
        
        Vista.setVisible(true);
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
        btnSubidosLT = new javax.swing.JButton();
        txtNombreLugarT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDetallesLugarT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnGuardarLugarT = new javax.swing.JButton();
        txtTipoLugarT = new javax.swing.JComboBox<>();
        btnGuardarH = new javax.swing.JButton();
        btnSubirImagenH = new javax.swing.JButton();
        lbImagenHospedaje = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contentLT.setBackground(new java.awt.Color(255, 255, 255));
        contentLT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        txtNombreLugarT.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreLugarT.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 140, 0), 1, true));
        txtNombreLugarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreLugarTActionPerformed(evt);
            }
        });
        contentLT.add(txtNombreLugarT, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 590, 40));

        jLabel2.setForeground(new java.awt.Color(255, 140, 0));
        jLabel2.setText("Nombre");
        contentLT.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        txtDetallesLugarT.setBackground(new java.awt.Color(255, 255, 255));
        txtDetallesLugarT.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 140, 0), 1, true));
        contentLT.add(txtDetallesLugarT, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 280, 340));

        jLabel3.setForeground(new java.awt.Color(255, 140, 0));
        jLabel3.setText("Detalles");
        contentLT.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel1.setForeground(new java.awt.Color(255, 140, 0));
        jLabel1.setText("TipoLugarTuristico");
        contentLT.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));

        btnGuardarLugarT.setBackground(new java.awt.Color(51, 153, 0));
        btnGuardarLugarT.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarLugarT.setText("Guardar");
        contentLT.add(btnGuardarLugarT, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 100, 40));

        txtTipoLugarT.setBackground(new java.awt.Color(255, 255, 255));
        txtTipoLugarT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtTipoLugarT.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 140, 0), 1, true));
        contentLT.add(txtTipoLugarT, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 210, -1));

        btnGuardarH.setBackground(new java.awt.Color(255, 51, 51));
        btnGuardarH.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarH.setText("Cancelar");
        contentLT.add(btnGuardarH, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 100, 40));

        btnSubirImagenH.setBackground(new java.awt.Color(255, 140, 0));
        btnSubirImagenH.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirImagenH.setText("Subir Imagen");
        contentLT.add(btnSubirImagenH, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 130, 40));

        lbImagenHospedaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Subir.png"))); // NOI18N
        contentLT.add(lbImagenHospedaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, -1, -1));

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

    private void txtNombreLugarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreLugarTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreLugarTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardarH;
    public javax.swing.JButton btnGuardarLugarT;
    public javax.swing.JButton btnSubidosLT;
    public javax.swing.JButton btnSubirImagenH;
    public javax.swing.JPanel contentLT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel lbImagenHospedaje;
    public javax.swing.JTextField txtDetallesLugarT;
    public javax.swing.JTextField txtNombreLugarT;
    public javax.swing.JComboBox<String> txtTipoLugarT;
    // End of variables declaration//GEN-END:variables
}
