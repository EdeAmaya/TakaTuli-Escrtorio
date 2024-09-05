/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.User;
import Vista.frmContraseña;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author edeni
 */
public class ctrlContraseña implements MouseListener {
    User modelo;
    frmContraseña vista;
    ctrlRecuperacion recuperacion;
    
    public ctrlContraseña(User Modelo,frmContraseña Vista,ctrlRecuperacion Recuperacion) {
        this.modelo = Modelo;
        this.vista = Vista;
        this.recuperacion = Recuperacion;

        vista.btnNContraseña.addMouseListener(this);

        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    if (e.getSource() == vista.btnNContraseña) {
        // Obtener la nueva contraseña y convertirla a SHA256
        String correo = recuperacion.getCorreoRecuperacion();

       
        boolean validacionesCorrectas = true;
        
        
          if(vista.txtNuevaContraseña.getText().isEmpty()){
                JOptionPane.showMessageDialog(vista, "Llene los campos");
                  validacionesCorrectas = false;

            } else {
            
                 if(vista.txtNuevaContraseña.getText().length() < 6){
                JOptionPane.showMessageDialog(vista, "La contraseña debe tener mas de 6 caracteres");
                validacionesCorrectas = false;
            }

            }

            
            if(validacionesCorrectas){
        modelo.setPassword_Usuario(modelo.convertirSHA256(vista.txtNuevaContraseña.getText()));
        modelo.setCorreo_Usuario(correo);
        modelo.ActualizarContraseña();
        
      
            Vista.frmLogin.initFrmLogin();
             vista.dispose();
        
            }
            
    }
}

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
