package Controlador;

import Modelo.User;
import Vista.frmCodigo;
import Vista.frmContraseña;
import Vista.frmRecuperacion;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JOptionPane;


public class ctrlRecuperacion implements MouseListener {
    
    User modelo;
    frmRecuperacion vista;
    private int numeroAleatorio;
    private static String correo;
    
    public ctrlRecuperacion(User Modelo, frmRecuperacion Vista) {
        this.modelo = Modelo;
        this.vista = Vista;

        vista.btnEnviarCodigo.addMouseListener(this);
        vista.btnvolverRecuperacion.addMouseListener(this);
    }
    
    
    public int getNumeroAleatorio() {
        return numeroAleatorio; 
    }
    
    public String getCorreoRecuperacion() {
        return correo; 
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnEnviarCodigo) {
            boolean correoCorrecto = true;
            modelo.setCorreo_Usuario(vista.txtCorreoRecuperacion.getText());
            boolean comprobar = modelo.verificarCorreo();

            if (comprobar == true) {
                JOptionPane.showMessageDialog(vista, "Tu Código de Verificación ha sido Enviado");
            } else {
                JOptionPane.showMessageDialog(vista, "Correo no registrado");
                correoCorrecto = false;
            }

            if (correoCorrecto) {
                Random random = new Random();
                correo = vista.txtCorreoRecuperacion.getText();
                numeroAleatorio = 1000 + random.nextInt(9000); // Asignar el número aleatorio a la variable de instancia
                String recipient = vista.txtCorreoRecuperacion.getText();
                String subject = "Recuperación de contraseña";
                String content = "Este es el código de recuperación: " + numeroAleatorio;

                User.enviarCorreo(recipient, subject, content);
                
                // Aquí puedes instanciar el formulario de código, pasando controladores
                  frmCodigo vistaCodigo = new frmCodigo();
                  ctrlCodigo controladorCodigo = new ctrlCodigo(modelo, vistaCodigo, this);
                  vistaCodigo.setVisible(true); // Asegúrate de mostrar el formulario
                  vista.dispose();
                  
                  
            }
            System.out.println("Código generado: " + numeroAleatorio);
        }
        
        if(e.getSource() == vista.btnvolverRecuperacion){
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
