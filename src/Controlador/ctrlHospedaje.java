/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Hospedaje;
import Vista.frmInicio;

import Vista.jpHospedaje;
import Vista.jpSubidos;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author jluis
 */
public class ctrlHospedaje implements MouseListener {

    private jpHospedaje Vista;
    private Hospedaje Modelo;
    frmInicio PantallaPrincipal;

    public ctrlHospedaje(jpHospedaje vista, Hospedaje modelo, frmInicio pantallaPrincipal) {
        this.PantallaPrincipal = pantallaPrincipal;
        this.Vista = vista;
        this.Modelo = modelo;

        vista.btnSubirImagenH.addMouseListener(this);

        vista.btnGuardarH.addMouseListener(this);

        vista.btnCancelarH.addMouseListener(this);
        vista.lbImagenHospedaje.addMouseListener(this);
        vista.btnSubidosH.addMouseListener(this);
        //vista.contentH.add(Vista);

    }
  
    private String urlSubida;

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == Vista.btnSubidosH) {
            jpSubidos p1 = new jpSubidos(); // Crea una instancia 
            ctrlInicio.Vista.content.removeAll();      // Elimina todos los componentes del contenedor 'content'
            ctrlInicio.Vista.content.add(p1); // Agrega el nuevo panel al centro del contenedor
            ctrlInicio.Vista.content.revalidate();      // Vuelve a validar el contenedor para que se ajuste a los cambios
            ctrlInicio.Vista.content.repaint();
        }

        if (e.getSource() == Vista.btnSubirImagenH) {
            System.out.println("se dio click subir imagenes");

    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Selecciona una imagen");
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    int result = fileChooser.showOpenDialog(null);
    
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();

        try {
            // Subir la imagen a Imgur
            urlSubida = Modelo.subirImagenImgBB(selectedFile); // 2. Asignar a urlSubida
            JOptionPane.showMessageDialog(null, "Imagen subida a: " + urlSubida);
            System.err.println("esta es la URL: " + urlSubida);
            
            BufferedImage img = ImageIO.read(new URL(urlSubida));
            
            // Ajustar el tamaño deseado
            int desiredWidth = 180; // Cambia este valor al ancho deseado
            int desiredHeight = 180; // Cambia este valor a la altura deseada
            Image scaledImg = img.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
            
            ImageIcon icon = new ImageIcon(scaledImg);
            Vista.lbImagenHospedaje.setIcon(icon);

        } catch (Exception ee) {
            System.err.print("este es el error: " + ee);
        }
    }
        }


        if (e.getSource() == Vista.btnGuardarH) {
            boolean validacionesCorrectas = true;

            if (Vista.txtNombreHospedaje.getText().isEmpty() || Vista.txtPrecioHospedaje.getText().isEmpty() || Vista.txtDescripcionHospedaje.getText().isEmpty()) {
                JOptionPane.showMessageDialog(Vista, "Llene los campos");
                validacionesCorrectas = false;
            } else {

                try {
                    double PrecioNumerico = Double.parseDouble(Vista.txtPrecioHospedaje.getText());
                    if (PrecioNumerico < 0) {
                        JOptionPane.showMessageDialog(Vista, "Ingrese un Precio valido");
                        validacionesCorrectas = false;
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Vista, "Ingrese solo numeros");
                    validacionesCorrectas = false;
                }

            }

            if (validacionesCorrectas) {
                Modelo.setNombre_Hospedaje(Vista.txtNombreHospedaje.getText());
                Modelo.setPrecio_Hospedaje(Double.parseDouble(Vista.txtPrecioHospedaje.getText()));
                Modelo.setDetalles_Hospedaje(Vista.txtDescripcionHospedaje.getText());
                Modelo.setFotos_Hospedaje(urlSubida);
                //Modelo.setFotos_Hospedaje(());
                Modelo.GuardarHospedaje();
            }
        }

        if (e.getSource() == Vista.btnCancelarH) {
            Modelo.limpiarHospedaje(Vista);
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
