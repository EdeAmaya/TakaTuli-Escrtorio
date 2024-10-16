/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Contactanos;
import Vista.frmInicio;
import Vista.jpAcercaDe;
import Vista.jpAjustes;
import Vista.jpPoliticasPrivacidad;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlAjustes implements MouseListener{
    private jpAjustes Vista;
    
    frmInicio PantallaPrincipal;
    
    
    public ctrlAjustes(jpAjustes vista, frmInicio pantallaPrincipal) {
        this.PantallaPrincipal = pantallaPrincipal;
        this.Vista = vista;
   

        vista.btnAcercaDe.addMouseListener(this);

        vista.btnPoliticasDePrivacidad.addMouseListener(this);

        vista.btnSoporte.addMouseListener(this);
        
        //vista.contentH.add(Vista);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
         if (e.getSource() == Vista.btnAcercaDe) {
            jpAcercaDe p1 = new jpAcercaDe(); // Crea una instancia 
            ctrlInicio.Vista.content.removeAll();      // Elimina todos los componentes del contenedor 'content'
            ctrlInicio.Vista.content.add(p1); // Agrega el nuevo panel al centro del contenedor
            ctrlInicio.Vista.content.revalidate();      // Vuelve a validar el contenedor para que se ajuste a los cambios
            ctrlInicio.Vista.content.repaint();
        }
         
         if (e.getSource() == Vista.btnPoliticasDePrivacidad) {
            jpPoliticasPrivacidad p1 = new jpPoliticasPrivacidad(); // Crea una instancia 
            ctrlInicio.Vista.content.removeAll();      // Elimina todos los componentes del contenedor 'content'
            ctrlInicio.Vista.content.add(p1); // Agrega el nuevo panel al centro del contenedor
            ctrlInicio.Vista.content.revalidate();      // Vuelve a validar el contenedor para que se ajuste a los cambios
            ctrlInicio.Vista.content.repaint();
        }
         
         if (e.getSource() == Vista.btnSoporte) {
            Contactanos p1 = new Contactanos(); // Crea una instancia 
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
