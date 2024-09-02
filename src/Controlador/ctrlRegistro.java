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
    
 
    User modelo;
    FrmRegistrar vista;
    
    public ctrlRegistro(User Modelo,FrmRegistrar Vista){
        this.modelo = Modelo;
        this.vista = Vista;
        
        vista.btnRegisrtar.addMouseListener(this);
        vista.btnIrALogin.addMouseListener(this);
      
    }
    
    //Vista.txtContrasena.getText()

    @Override
    public void mouseClicked(MouseEvent e) {
         if (e.getSource() == vista.btnRegisrtar) {
        boolean validacionesCorrectas = true;

       if(vista.txtNombre.getText().isEmpty()||vista.txtContrasena.getText().isEmpty()||vista.txtEdad.getText().isEmpty()||vista.txtTelefono.getText().isEmpty()||vista.txtCorreoElectronico.getText().isEmpty()||vista.txtDUI.getText().isEmpty()){
                JOptionPane.showMessageDialog(vista, "Llene los campos");
                validacionesCorrectas = false;
            }
            if(vista.txtContrasena.getText().length() < 6){
                JOptionPane.showMessageDialog(vista, "La contraseña debe tener mas de 6 caracteres");
                validacionesCorrectas = false;
            }
            try {
                int edadNumerica = Integer.parseInt(vista.txtEdad.getText());
                if(edadNumerica > 100 || edadNumerica == 0){
                    JOptionPane.showMessageDialog(vista, "Ingrese una edad valida");
                    validacionesCorrectas = false;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vista, "Ingrese solo numeros");
                validacionesCorrectas = false;
            }

            if( !vista.txtTelefono.getText().matches("\\d{4}-\\d{4}")){
                JOptionPane.showMessageDialog(vista, "Ingrese un número de teléfono válido en el formato 1234-5678");
                validacionesCorrectas = false;
            }

            if(!vista.txtCorreoElectronico.getText().contains("@") || !vista.txtCorreoElectronico.getText().contains(".com")){
                JOptionPane.showMessageDialog(vista, "Ingrese un correo valido");
                validacionesCorrectas = false;
            }

             if( !vista.txtDUI.getText().matches("\\d{8}-\\d{1}")){
                JOptionPane.showMessageDialog(vista, "Ingrese un número de DUI válido en el formato 12345678-9");
                validacionesCorrectas = false;
            }
             
         
           
            if(validacionesCorrectas){
            modelo.setNombre_Usuario(vista.txtNombre.getText());
            modelo.setPassword_Usuario(modelo.convertirSHA256(vista.txtContrasena.getText()));
            modelo.setEdad_Usuario(Integer.parseInt(vista.txtEdad.getText()));
            modelo.setTelefono_Usuario(vista.txtTelefono.getText());
            modelo.setCorreo_Usuario(vista.txtCorreoElectronico.getText());
            modelo.setDUI_Usuario(vista.txtDUI.getText());
            modelo.GuardarUsuario();
            }
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

