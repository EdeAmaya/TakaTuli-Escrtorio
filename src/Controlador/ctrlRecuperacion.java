package Controlador;

import Modelo.User;
import Vista.frmRecuperacion;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JOptionPane;


public class ctrlRecuperacion implements MouseListener {
    
    User modelo;
    frmRecuperacion vista;
    
    public ctrlRecuperacion(User Modelo, frmRecuperacion Vista) {
        this.modelo = Modelo;
        this.vista = Vista;

        vista.btnEnviarCodigo.addMouseListener(this);
    }
    
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnEnviarCodigo) {
            boolean correoCorrecto = true;
            modelo.setCorreo_Usuario(vista.txtCorreoRecuperacion.getText());
            //Creo una variable llamada "comprobar" 
            //que guardará el resultado de ejecutar el metodo iniciarSesion()            
            boolean comprobar = modelo.verificarCorreo();

            //Si la variable es "true" significa que si existe el usuario ingresado    
            if (comprobar == true) {
                JOptionPane.showMessageDialog(vista,"Tu Codigo de Verificacion a sido Enviado");
            } else {
                JOptionPane.showMessageDialog(vista, "Correo no registrado");
                correoCorrecto = false;
            }
           
        
            if(correoCorrecto){
             Random random = new Random();
        
            int numeroAleatorio = 1000 + random.nextInt(9000);

            String recipient = vista.txtCorreoRecuperacion.getText();
            String subject = "Recuperacion de contraseña";
            String content = "Este es el codigo de recuperacion" + numeroAleatorio;

            User.enviarCorreo(recipient, subject, content);
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
