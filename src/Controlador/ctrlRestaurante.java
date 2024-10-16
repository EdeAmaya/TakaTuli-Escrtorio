/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Restaurante;
import Vista.frmInicio;
import Vista.jpRestaurante;
import Vista.jpSubidos;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author jluis
 */
public class ctrlRestaurante implements MouseListener {
    
    
    private jpRestaurante Vista;
    private Restaurante Modelo;
    frmInicio PantallaPrincipal;
    
    public ctrlRestaurante(jpRestaurante vista, Restaurante modelo, frmInicio pantallaPrincipal){
        
        this.PantallaPrincipal = pantallaPrincipal;
        this.Vista = vista;
        this.Modelo = modelo;
        
        vista.lbFotoMenu.addMouseListener(this); 
        vista.lbFotoRestaurante.addMouseListener(this);
        vista.jbtnGuardar.addMouseListener(this);
        
        
        
        
    }
    private String urlSubidaR;
    private String urlSubidaM;
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == Vista.btnSubidosR) {
            jpSubidos p1 = new jpSubidos(); // Crea una instancia 
            ctrlInicio.Vista.content.removeAll();      // Elimina todos los componentes del contenedor 'content'
            ctrlInicio.Vista.content.add(p1); // Agrega el nuevo panel al centro del contenedor
            ctrlInicio.Vista.content.revalidate();      // Vuelve a validar el contenedor para que se ajuste a los cambios
            ctrlInicio.Vista.content.repaint();
        }

   if (e.getSource() == Vista.lbFotoMenu) {
    System.out.println("se dio click subir imagenes");

    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Selecciona una imagen");
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    int result = fileChooser.showOpenDialog(null);
    
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();

        try {
            // Subir la imagen a Imgur
            urlSubidaR = Modelo.subirImagenImgBB(selectedFile); // 2. Asignar a urlSubida
            JOptionPane.showMessageDialog(null, "Imagen subida a: " + urlSubidaR);
            System.err.println("esta es la URL: " + urlSubidaR);
            
            BufferedImage img = ImageIO.read(new URL(urlSubidaR));
            
            // Ajustar el tamaño deseado
            int desiredWidth = 180; // Cambia este valor al ancho deseado
            int desiredHeight = 180; // Cambia este valor a la altura deseada
            Image scaledImg = img.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
            
            ImageIcon icon = new ImageIcon(scaledImg);
            Vista.lbFotoMenu.setIcon(icon);

        } catch (Exception ee) {
            System.err.print("este es el error: " + ee);
        }
    }
}
   
     if (e.getSource() == Vista.lbFotoRestaurante) {
    System.out.println("se dio click subir imagenes");

    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Selecciona una imagen");
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    int result = fileChooser.showOpenDialog(null);
    
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();

        try {
            // Subir la imagen a Imgur
            urlSubidaM = Modelo.subirImagenImgBB(selectedFile); // 2. Asignar a urlSubida
            JOptionPane.showMessageDialog(null, "Imagen subida a: " + urlSubidaM);
            System.err.println("esta es la URL: " + urlSubidaM);
            
            BufferedImage img = ImageIO.read(new URL(urlSubidaM));
            
            // Ajustar el tamaño deseado
            int desiredWidth = 180; // Cambia este valor al ancho deseado
            int desiredHeight = 180; // Cambia este valor a la altura deseada
            Image scaledImg = img.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
            
            ImageIcon icon = new ImageIcon(scaledImg);
            Vista.lbFotoRestaurante.setIcon(icon);

        } catch (Exception ee) {
            System.err.print("este es el error: " + ee);
        }
    }
}


        if (e.getSource() == Vista.jbtnGuardar) {
            boolean validacionesCorrectas = true;

            if (Vista.txtNombreLugarT.getText().isEmpty() || Vista.txtDetallesLugarT.getText().isEmpty()) {
                JOptionPane.showMessageDialog(Vista, "Llene los campos");
                validacionesCorrectas = false;
            } else {

               /*try {
                    double PrecioNumerico = Double.parseDouble(Vista.txtDetallesLugarT.getText());
                    if (PrecioNumerico < 0) {
                        JOptionPane.showMessageDialog(Vista, "Ingrese un Precio valido");
                        validacionesCorrectas = false;
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Vista, "Ingrese solo numeros");
                    validacionesCorrectas = false;
                }*/

            }

            if (validacionesCorrectas) {
                Modelo.setNombre_Restaurante(Vista.txtNombreLugarT.getText());
                Modelo.setMenu_Restaurante(Vista.txtDetallesLugarT.getText());
                Modelo.setFoto_Menu(urlSubidaR);
                Modelo.setFoto_Restaurante(urlSubidaM);
                Modelo.GuardarRestaurante();
            }
        }

        /*if (e.getSource() == Vista.jbtnCancelar) {
            Modelo.limpiarHospedaje(Vista);
        }*/

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
