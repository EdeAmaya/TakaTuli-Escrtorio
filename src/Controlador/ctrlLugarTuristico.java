/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.LugarTuristico;
import Vista.jpLugarTuristico;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author jluis
 */
public class ctrlLugarTuristico implements MouseListener {
    
    private jpLugarTuristico vista;
    private LugarTuristico modelo;
    
    public ctrlLugarTuristico(jpLugarTuristico vista, LugarTuristico modelo){
    
        this.vista = vista;
        this.modelo = modelo;
        
        
        vista.btnGuardarLugarT.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
             if(e.getSource() == vista.btnGuardarLugarT){
              
              modelo.setNombre_LugarTuristico(vista.txtNombreLugarT.getText());
              modelo.setDetalles_Lugar_Turistico( vista.txtDetallesLugarT.getText());
          
              modelo.GuardarLugarTuristico();
              
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
