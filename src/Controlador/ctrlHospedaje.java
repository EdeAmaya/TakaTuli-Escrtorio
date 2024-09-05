/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Hospedaje;
import Vista.frmHospedaje;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author jluis
 */
public class ctrlHospedaje implements MouseListener {
    
    private frmHospedaje vista;
    private Hospedaje modelo;
    
      public ctrlHospedaje(frmHospedaje vista, Hospedaje modelo){
        this.vista = vista;
        this.modelo = modelo;
        
        vista.btnAgregarH.addMouseListener(this);  
        
        vista.jtbHospedaje.addMouseListener(this);
        modelo.MostrarHospedaje(vista.jtbHospedaje);
        
        vista.btnEliminarH.addMouseListener(this);
        vista.jtbHospedaje.addMouseListener(this);
        
        vista.btnActualizarH.addMouseListener(this);
        
        vista.btnLimpiarH.addMouseListener(this);
        
        vista.btnVolverH.addMouseListener(this);
        
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
           if(e.getSource() == vista.btnAgregarH){
               boolean validacionesCorrectas = true;
          
          if(vista.txtNombreH.getText().isEmpty()||vista.txtPrecioH1.getText().isEmpty()||vista.txtDescripcionH.getText().isEmpty()){
                JOptionPane.showMessageDialog(vista, "Llene los campos");
                validacionesCorrectas = false;
            } else {
          
              try {
                double PrecioNumerico = Double.parseDouble(vista.txtPrecioH1.getText());
                if(PrecioNumerico < 0 ){
                    JOptionPane.showMessageDialog(vista, "Ingrese un Precio valido");
                    validacionesCorrectas = false;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vista, "Ingrese solo numeros");
                validacionesCorrectas = false;
            }
          
          }    
               
           if(validacionesCorrectas){
              modelo.setNombre_Hospedaje(vista.txtNombreH.getText());
              modelo.setPrecio_Hospedaje(Double.parseDouble( vista.txtPrecioH1.getText()));
              modelo.setDetalles_Hospedaje(vista.txtDescripcionH.getText());
          
              modelo.GuardarHospedaje();
              modelo.MostrarHospedaje(vista.jtbHospedaje);
            }     
 
         
      }
           
             if (e.getSource() == vista.btnEliminarH) {
            
                modelo.EliminarHospedaje(vista.jtbHospedaje);
                modelo.MostrarHospedaje(vista.jtbHospedaje);
                
      
            
        }
             if (e.getSource() == vista.btnActualizarH) {
            
                  boolean validacionesCorrectas = true;
                 
                 if(vista.txtNombreH.getText().isEmpty()||vista.txtPrecioH1.getText().isEmpty()||vista.txtDescripcionH.getText().isEmpty()){
                JOptionPane.showMessageDialog(vista, "Llene los campos");
                validacionesCorrectas = false;
            } else {
          
              try {
                int PrecioNumerico = Integer.parseInt(vista.txtPrecioH1.getText());
                if(PrecioNumerico < 0 ){
                    JOptionPane.showMessageDialog(vista, "Ingrese un Precio valido");
                    validacionesCorrectas = false;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vista, "Ingrese solo numeros");
                validacionesCorrectas = false;
            }
          
          }
            
                 if(validacionesCorrectas){
             //Asignar lo de la vista al modelo al momento de darle clic a actualizar
                    modelo.setNombre_Hospedaje(vista.txtNombreH.getText());
                    modelo.setPrecio_Hospedaje(Double.parseDouble(vista.txtPrecioH1.getText()));
                    modelo.setDetalles_Hospedaje(vista.txtDescripcionH.getText());

                    //Ejecutar el método    
                    modelo.ActualizarHospedaje(vista.jtbHospedaje);
                    modelo.MostrarHospedaje(vista.jtbHospedaje);
            }  
                    
                    
              
            
        }
    
       if (e.getSource() == vista.btnLimpiarH) {
            modelo.limpiarHospedaje(vista);
        }

        if (e.getSource() == vista.jtbHospedaje) {
            modelo.cargarDatosTabla(vista);
        }
        
          if(e.getSource() == vista.btnVolverH){
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
