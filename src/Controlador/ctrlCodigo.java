package Controlador;

import Modelo.User;
import Vista.frmCodigo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ctrlCodigo implements MouseListener {
    User modelo;
    frmCodigo vista;
    ctrlRecuperacion recuperacion;
    
    public ctrlCodigo(User Modelo,frmCodigo Vista, ctrlRecuperacion Recuperacion){
        this.modelo = Modelo;
        this.vista = Vista;
        this.recuperacion = Recuperacion;
        
        vista.btnVCodigo.addMouseListener(this);
        
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnVCodigo) {
            int codigoRecuperacion  = recuperacion.getNumeroAleatorio();
            String codigoIngresado = vista.txtCode.getText();
            
            if (codigoIngresado.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor, ingresa el código de verificación.");
        } else {
            try {
                int codigoIngresadoInt = Integer.parseInt(codigoIngresado); // Convertir a int para comparar

                // Comparar los códigos
                if (codigoRecuperacion == codigoIngresadoInt) {
                    JOptionPane.showMessageDialog(vista, "Código verificado correctamente.");
                    Vista.frmContraseña.initFrmContraseña();
                    vista.dispose();
                    // Aquí puedes proceder a permitir que el usuario restablezca su contraseña
                } else {
                    JOptionPane.showMessageDialog(vista, "Código incorrecto.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vista, "El código ingresado no es válido. Asegúrate de que sea un número.");
            }
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
