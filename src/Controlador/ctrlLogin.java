
package Controlador;

import Modelo.User;
import Vista.frmLogin;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ctrlLogin implements MouseListener{
    
    User modelo;
    frmLogin vista;
    private String user;
    
    public ctrlLogin(User Modelo, frmLogin Vista) {
        this.modelo = Modelo;
        this.vista = Vista;

        vista.btnIniciarSesion.addMouseListener(this);
        vista.btnIrARegistro.addMouseListener(this);
        vista.btnRecuperarContra.addMouseListener(this);   
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnIniciarSesion) {
            modelo.setCorreo_Usuario(vista.txtCorreo.getText());
            modelo.setPassword_Usuario(modelo.convertirSHA256(vista.txtContraseña.getText()));

            //Creo una variable llamada "comprobar" 
            //que guardará el resultado de ejecutar el metodo iniciarSesion()            
            boolean comprobar = modelo.iniciarSesion();

            //Si la variable es "true" significa que si existe el usuario ingresado    
        
            
            
            if(vista.txtCorreo.getText().isEmpty() || vista.txtContraseña.getText().isEmpty()){
                JOptionPane.showMessageDialog(vista, "Llene los campos");
            } else {
            
                 if (comprobar == true) {
                JOptionPane.showMessageDialog(vista,"Usuario existe, ¡Bienvenido!");
                Vista.frmInicio.initFrmInicio();
                 user = vista.txtCorreo.getText();
                System.out.println("El Usuario es " + user);
                vista.dispose();
            } else {
                JOptionPane.showMessageDialog(vista, "Usuario no encontrado");

            }
            
            }
        }
        
     
        //Clic al botón de Ir Al Registro
        if(e.getSource() == vista.btnIrARegistro){
            Vista.FrmRegistrar.initFrmRegistro();
             vista.dispose();
        }
        
        if(e.getSource() == vista.btnRecuperarContra){
            Vista.frmRecuperacion.initFrmRecuperacion();
             vista.dispose();
        }
        
       
    }

 public String getUser() {
        return user;
        
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
