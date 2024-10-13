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
    
    private jpLugarTuristico Vista;
    private LugarTuristico Modelo;
    
    public ctrlLugarTuristico(jpLugarTuristico vista, LugarTuristico modelo){
    
        this.Vista = vista;
        this.Modelo = modelo;
        
        
        vista.btnGuardarLugarT.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
             if(e.getSource() == Vista.btnGuardarLugarT){
              
              Modelo.setNombre_LugarTuristico(Vista.txtNombreLugarT.getText());
              Modelo.setDetalles_Lugar_Turistico( Vista.txtDetallesLugarT.getText());
              Modelo.GuardarLugarTuristico();
              
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
