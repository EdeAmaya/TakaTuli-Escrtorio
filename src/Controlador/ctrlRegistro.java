/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.User;
import Vista.FrmRegistrar;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Estudiante
 */
public class ctrlRegistro implements MouseListener {
    
    
    User Modelo;
    FrmRegistrar Vista;
    
    public ctrlRegistro(User Modelo,FrmRegistrar Vista){
        this.Modelo = Modelo;
        this.Vista = Vista;
        
        Vista.btnRegisrtar.addMouseListener(this);
      
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == Vista.btnRegisrtar) {
            Modelo.setNombre_Usuario(Vista.txtNombre.getText());
            Modelo.setPassword_Usuario(Vista.txtContrasena.getText());
            Modelo.setEdad_Usuario(Integer.parseInt(Vista.txtEdad.getText()));
            Modelo.setTelefono_Usuario(Vista.txtTelefono.getText());
            Modelo.setCorreo_Usuario(Vista.txtCorreoElectronico.getText());
            Modelo.setDUI_Usuario(Vista.txtDUI.getText());
            Modelo.GuardarUsuario();
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
