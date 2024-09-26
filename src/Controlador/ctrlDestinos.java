/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.frmInicio;
import Vista.jpDestinos;
import Vista.jpHospedaje;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Estudiante
 */
public class ctrlDestinos implements MouseListener {
    
private jpDestinos vista;
    
public ctrlDestinos(jpDestinos vista){
        this.vista = vista;
        vista.btnHospedaje.addMouseListener(this);
        vista.btnLugarTuristico.addMouseListener(this);
        vista.btnPaqueteViaje.addMouseListener(this);
        vista.btnRestaurante.addMouseListener(this);
        vista.btnSubidos.addMouseListener(this);
        
 }

    @Override
    public void mouseClicked(MouseEvent e) {
       if(e.getSource() == vista.btnHospedaje){
       jpHospedaje pl = new jpHospedaje(); // Crea una instancia 
       frmInicio fI = new frmInicio();
        
       pl.setSize(830, 600);    // Establece el tamaño  
       pl.setLocation(0, 0);    // Establece la ubicación 
       fI.content.removeAll();      // Elimina todos los componentes del contenedor 'content'
       fI.content.setLayout(new AbsoluteLayout());
       fI.content.add(pl, new AbsoluteConstraints(0, 0, 830, 600)); // Agrega el nuevo panel al centro del contenedor
       fI.content.revalidate();      // Vuelve a validar el contenedor para que se ajuste a los cambios
       fI.content.repaint(); 
          
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
