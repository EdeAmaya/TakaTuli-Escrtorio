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
    
    
    User modelo;
    FrmRegistrar vista;
    
    public ctrlRegistro(User Modelo,FrmRegistrar Vista){
        this.modelo = Modelo;
        this.vista = Vista;
        
        Vista.btnRegisrtar.addMouseListener(this);
        Vista.btnIrALogin.addMouseListener(this);
      
    }
    
    //Vista.txtContrasena.getText()

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == vista.btnRegisrtar) {
            modelo.setNombre_Usuario(vista.txtNombre.getText());
            modelo.setPassword_Usuario(modelo.convertirSHA256(vista.txtContrasena.getText()));
            modelo.setEdad_Usuario(Integer.parseInt(vista.txtEdad.getText()));
            modelo.setTelefono_Usuario(vista.txtTelefono.getText());
            modelo.setCorreo_Usuario(vista.txtCorreoElectronico.getText());
            modelo.setDUI_Usuario(vista.txtDUI.getText());
            modelo.GuardarUsuario();
        }
        
      if(e.getSource() == vista.btnIrALogin){
            Vista.frmLogin.initFrmLogin();
            vista.dispose();
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
