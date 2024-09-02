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
        boolean validacionesCorrectas = true;
       if(Vista.txtNombre.getText().isEmpty()||Vista.txtContrasena.getText().isEmpty()||Vista.txtEdad.getText().isEmpty()||Vista.txtTelefono.getText().isEmpty()||Vista.txtCorreoElectronico.getText().isEmpty()||Vista.txtDUI.getText().isEmpty()){
                JOptionPane.showMessageDialog(Vista, "Llene los campos");
                validacionesCorrectas = false;
            }
            if(Vista.txtContrasena.getText().length() < 6){
                JOptionPane.showMessageDialog(Vista, "La contraseña debe tener mas de 6 caracteres");
                validacionesCorrectas = false;
            }
            try {
                int edadNumerica = Integer.parseInt(Vista.txtEdad.getText());
                if(edadNumerica > 100 || edadNumerica == 0){
                    JOptionPane.showMessageDialog(Vista, "Ingrese una edad valida");
                    validacionesCorrectas = false;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(Vista, "Ingrese solo numeros");
                validacionesCorrectas = false;
            }
            
            if( !Vista.txtTelefono.getText().matches("\\d{4}-\\d{4}")){
                JOptionPane.showMessageDialog(Vista, "Ingrese un número de teléfono válido en el formato 1234-5678");
                validacionesCorrectas = false;
            }
          
            
            
            if(!Vista.txtCorreoElectronico.getText().contains("@") || !Vista.txtCorreoElectronico.getText().contains(".com")){
                JOptionPane.showMessageDialog(Vista, "Ingrese un correo valido");
                validacionesCorrectas = false;
            }
            
             if( !Vista.txtDUI.getText().matches("\\d{8}-\\d{1}")){
                JOptionPane.showMessageDialog(Vista, "Ingrese un número de DUI válido en el formato 12345678-9");
                validacionesCorrectas = false;
            }
             
         
            
            if(validacionesCorrectas){
             Modelo.setNombre_Usuario(Vista.txtNombre.getText());
            Modelo.setPassword_Usuario(Modelo.convertirSHA256(Vista.txtContrasena.getText()));
            Modelo.setEdad_Usuario(Integer.parseInt(Vista.txtEdad.getText()));
            Modelo.setTelefono_Usuario(Vista.txtTelefono.getText());
            Modelo.setCorreo_Usuario(Vista.txtCorreoElectronico.getText());
            Modelo.setDUI_Usuario(Vista.txtDUI.getText());
            Modelo.GuardarUsuario();
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
