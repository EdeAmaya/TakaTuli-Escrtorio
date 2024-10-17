/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Hospedaje;
import Vista.jpSubidos2;
import java.awt.event.MouseListener;

/**
 *
 * @author CAPITANA MARVEL
 */
public class ctrlSubidos2 {
    private jpSubidos2 vista;
    private Hospedaje modelo;
    
    
    public ctrlSubidos2(jpSubidos2 vista, Hospedaje modelo){
        this.vista = vista;
        this.modelo = modelo;
        
        vista.jtbHost.addMouseListener((MouseListener)this);
        modelo.MostrarHospedaje(vista.jtbHost);
        modelo.cargarDatosTabla(vista);
        
        
        
        
        /*vista.txtNombreHost.addMouseListener((MouseListener)this);
        vista.txtPrecioH.addMouseListener((MouseListener)this);
        vista.txtDetallesH.addMouseListener((MouseListener)this);*/
    }
}
