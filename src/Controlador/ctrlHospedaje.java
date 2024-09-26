/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Hospedaje;

import Vista.jpHospedaje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author jluis
 */
public class ctrlHospedaje implements MouseListener {
    
    private jpHospedaje vista;
    private Hospedaje modelo;
    
      public ctrlHospedaje(jpHospedaje vista, Hospedaje modelo){
        this.vista = vista;
        this.modelo = modelo;
        
      
        
        vista.btnSubirImagenH.addMouseListener(this);
        
        vista.btnGuardarH.addMouseListener(this);
       
        vista.btnCancelarH.addMouseListener(this);
        
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
           if(e.getSource() == vista.btnGuardarH){
               boolean validacionesCorrectas = true;
          
          if(vista.txtNombreHospedaje.getText().isEmpty()||vista.txtPrecioHospedaje.getText().isEmpty()||vista.txtDescripcionHospedaje.getText().isEmpty()){
                JOptionPane.showMessageDialog(vista, "Llene los campos");
                validacionesCorrectas = false;
            } else {
          
              try {
                double PrecioNumerico = Double.parseDouble(vista.txtPrecioHospedaje.getText());
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
              modelo.setNombre_Hospedaje(vista.txtNombreHospedaje.getText());
              modelo.setPrecio_Hospedaje(Double.parseDouble( vista.txtPrecioHospedaje.getText()));
              modelo.setDetalles_Hospedaje(vista.txtDescripcionHospedaje.getText());
          
              modelo.GuardarHospedaje();
             
            }     
 
         
      }
           
           
          
    
       if (e.getSource() == vista.btnCancelarH) {
            modelo.limpiarHospedaje(vista);
        }
       
    }
    
       public void actionPerformed(ActionEvent e){
 
if (e.getSource() == vista.btnSubirImagenH) {
       
           JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Selecciona una imagen");
                
                // Solo permitir seleccionar archivos
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    
                   

                    try {
                        // Subir la imagen a Imgur
                        String urlSubida = modelo.subirImagenImgur(selectedFile);
                        
                        // Mostrar URL en un JOptionPane
                        JOptionPane.showMessageDialog(null, "Imagen subida a: " + urlSubida);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error subiendo la imagen: " + ex.getMessage());
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
