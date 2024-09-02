package Controlador;

import Modelo.User;
import Vista.frmCodigo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ctrlCodigo implements MouseListener {
    private User modelo;
    private frmCodigo vista;
    
    public ctrlCodigo(User modelo, frmCodigo vista){
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnVCodigo.addMouseListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
