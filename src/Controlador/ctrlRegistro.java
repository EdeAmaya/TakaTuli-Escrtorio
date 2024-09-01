/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.User;
import Vista.FrmRegistrar;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

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
    
    //Vista.txtContrasena.getText()

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == Vista.btnRegisrtar) {
            if(Vista.txtNombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(Vista, "Llene los campos");
            }
            if(Modelo.convertirSHA256(Vista.txtContrasena.getText()).length() < 6){
                JOptionPane.showMessageDialog(Vista, "La contraseña debe tener mas de 6 caracteres");
            }
            try {
                int edadNumerica = Integer.parseInt(Vista.txtEdad.getText());
                if(edadNumerica > 100 || edadNumerica == 0){
                    JOptionPane.showMessageDialog(Vista, "Ingrese una edad valida");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(Vista, "Ingrese solo numeros");
            }
            
            Modelo.setTelefono_Usuario(Vista.txtTelefono.getText());
            
            
            if(!Vista.txtCorreoElectronico.getText().contains("@") || !Vista.txtCorreoElectronico.getText().contains(".com")){
                JOptionPane.showMessageDialog(Vista, "Ingrese un correo valido");
            }
            
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
