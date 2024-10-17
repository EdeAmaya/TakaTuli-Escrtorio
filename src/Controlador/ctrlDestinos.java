/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.frmInicio;
import Vista.jpDestinos;
import Vista.jpHospedaje;
import Vista.jpRestaurante;
import Vista.jpSubidos;
import Vista.jpSubidos2;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Estudiante
 */
public class ctrlDestinos implements MouseListener {

    private jpDestinos vista;
    frmInicio PantallaPrincipal;

    public ctrlDestinos(jpDestinos vista, frmInicio pantallaPrincipal) {
        this.PantallaPrincipal = pantallaPrincipal;
        this.vista = vista;
        vista.btnHospedaje.addMouseListener(this);
        vista.btnLugarTuristico.addMouseListener(this);
        vista.btnPaqueteViaje.addMouseListener(this);
        vista.btnRestaurante.addMouseListener(this);
        vista.btnSubidos.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnHospedaje) {
            jpHospedaje p1 = new jpHospedaje(); // Crea una instancia 
            ctrlInicio.Vista.content.removeAll();      // Elimina todos los componentes del contenedor 'content'
            ctrlInicio.Vista.content.add(p1); // Agrega el nuevo panel al centro del contenedor
            ctrlInicio.Vista.content.revalidate();      // Vuelve a validar el contenedor para que se ajuste a los cambios
            ctrlInicio.Vista.content.repaint();
        }
        
        //cambien nada más el panel
          if (e.getSource() == vista.btnSubidos) {
            jpSubidos2 p2 = new jpSubidos2(); // Crea una instancia 
            ctrlInicio.Vista.content.removeAll();      // Elimina todos los componentes del contenedor 'content'
            ctrlInicio.Vista.content.add(p2); // Agrega el nuevo panel al centro del contenedor
            ctrlInicio.Vista.content.revalidate(); // Vuelve a validar el contenedor para que se ajuste a los cambios
            ctrlInicio.Vista.content.repaint();
        }
          
          if (e.getSource() == vista.btnRestaurante) {
            jpRestaurante p1 = new jpRestaurante(); // Crea una instancia 
            ctrlInicio.Vista.content.removeAll();      // Elimina todos los componentes del contenedor 'content'
            ctrlInicio.Vista.content.add(p1); // Agrega el nuevo panel al centro del contenedor
            ctrlInicio.Vista.content.revalidate();      // Vuelve a validar el contenedor para que se ajuste a los cambios
            ctrlInicio.Vista.content.repaint();
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
