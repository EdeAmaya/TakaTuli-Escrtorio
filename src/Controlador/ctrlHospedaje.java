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
    
    private jpHospedaje Vista;
    private Hospedaje modelo;
    
      public ctrlHospedaje(jpHospedaje vista, Hospedaje modelo){
        this.Vista = vista;
        this.modelo = modelo;
        
      
        
        vista.btnSubirImagenH.addMouseListener(this);
        
        vista.btnGuardarH.addMouseListener(this);
       
        vista.btnCancelarH.addMouseListener(this);
        //vista.contentH.add(Vista);
        
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
           if(e.getSource() == Vista.btnGuardarH){
               boolean validacionesCorrectas = true;
          
          if(Vista.txtNombreHospedaje.getText().isEmpty()||Vista.txtPrecioHospedaje.getText().isEmpty()||Vista.txtDescripcionHospedaje.getText().isEmpty()){
                JOptionPane.showMessageDialog(Vista, "Llene los campos");
                validacionesCorrectas = false;
            } else {
          
              try {
                double PrecioNumerico = Double.parseDouble(Vista.txtPrecioHospedaje.getText());
                if(PrecioNumerico < 0 ){
                    JOptionPane.showMessageDialog(Vista, "Ingrese un Precio valido");
                    validacionesCorrectas = false;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(Vista, "Ingrese solo numeros");
                validacionesCorrectas = false;
            }
          
          }    
               
           if(validacionesCorrectas){
              modelo.setNombre_Hospedaje(Vista.txtNombreHospedaje.getText());
              modelo.setPrecio_Hospedaje(Double.parseDouble( Vista.txtPrecioHospedaje.getText()));
              modelo.setDetalles_Hospedaje(Vista.txtDescripcionHospedaje.getText());          
              modelo.GuardarHospedaje();
            }     
      }
           
           
          
    
       if (e.getSource() == Vista.btnCancelarH) {
            modelo.limpiarHospedaje(Vista);
        }
       
    }
    
    public void actionPerformed(ActionEvent e){
 
     if (e.getSource() == Vista.btnSubirImagenH) {
       
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
