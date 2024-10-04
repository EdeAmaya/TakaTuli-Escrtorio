/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.frmInicio;
import Vista.jpDestinos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Estudiante
 */
public class ctrlInicio implements MouseListener {
  public static frmInicio  Vista;
  
  public ctrlInicio(frmInicio vista){
        this.Vista = vista;
        vista.btnDestinos.addMouseListener(this);
             
 }

    @Override
    public void mouseClicked(MouseEvent e) {
        
       if(e.getSource() == Vista.btnDestinos){
       jpDestinos pl = new jpDestinos(); // Crea una instancia    // Establece la ubicación 
       Vista.content.removeAll();      // Elimina todos los componentes del contenedor 'content'
       Vista.content.add(pl);
       Vista.content.revalidate();      // Vuelve a validar el contenedor para que se ajuste a los cambios
       Vista.content.repaint(); 
            
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
