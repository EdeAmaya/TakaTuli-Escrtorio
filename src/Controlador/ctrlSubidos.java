/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Subidos;
import Vista.jpSubidos;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author edeni
 */


public class ctrlSubidos implements MouseListener  {
    private jpSubidos Vista;
    private Subidos Modelo;
    private String IDModDel;
    public Integer valor_pagH, max_pagH = 0;
    public static Integer contadorH = 0;
    
    
    public ctrlSubidos(jpSubidos vista, Subidos modelo) {
        this.Vista = vista;
        this.Modelo = modelo;
    }
    
    public Integer ContadorHospedajeCtrol(){
        return Modelo.ContadorHospedaje();
    }
    
    public Object[][] MostrarHospedajeCtrl(){
        return Modelo.MostrarHospedaje();
    }
    
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == Vista.btnVer1) {
            mostrarDetallesHospedaje(0); // Muestra los detalles del primer hospedaje
        } else if (e.getSource() == Vista.btnVer2) {
            mostrarDetallesHospedaje(1); // Muestra los detalles del segundo hospedaje
        } else if (e.getSource() == Vista.btnVer3) {
            mostrarDetallesHospedaje(2); // Muestra los detalles del tercer hospedaje
        } else if (e.getSource() == Vista.lblnextH){
            try {
                // Imagen activa para el botón de regresar
                BufferedImage imgPrev = ImageIO.read(getClass().getResource("/Img/previous.png"));
                Image imgPrevActive = imgPrev.getScaledInstance(Vista.lblprevH.getWidth(), Vista.lblprevH.getHeight(), Image.SCALE_AREA_AVERAGING);
                Vista.lblprevH.setIcon(new ImageIcon(imgPrevActive));
                //Activamos el lbl de regresar
                Vista.lblprevH.setEnabled(true);
                // Aumentar el contador por cada click de lblnext
                contadorH = contadorH + 1;
                // Calcular el número máximo de páginas
                int totalHospedajes = Modelo.ContadorHospedaje();  // Obtener el total de registros de la BD
                max_pagH = (int) Math.ceil((double) totalHospedajes / 3);  // Total de páginas
                //Se manda el nuevo valor de contador para traer las siguientess 3
                try{
                    //Solo mandamos atraer los datos si aún esta activa el lbl de siguiente
                    if (Vista.lblnextH.isEnabled() == true) {
                        Modelo.setContador(contadorH*3);
                        Vista.mostrarDatosHospedaje();
                    }
                } catch (Exception ex) { //se captura el error
                    System.out.println(ex);
                }
                // Si estamos en la última página, desactivar la flecha de avanzar
                if (contadorH >= (max_pagH - 1)) {
                    try {
                        // Imagen desactivada para el botón de avanzar
                        BufferedImage imgNextD = ImageIO.read(getClass().getResource("/Img/next_d.png"));
                        Image imgNextDisabled = imgNextD.getScaledInstance(Vista.lblnextH.getWidth(), Vista.lblnextH.getHeight(), Image.SCALE_AREA_AVERAGING);
                        Vista.lblnextH.setIcon(new ImageIcon(imgNextDisabled));
                        //Desactivamos el lbl de siguiente
                        Vista.lblnextH.setEnabled(false);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == Vista.lblprevH) {
            try {
                // Solo retrocedemos si el lbl de regresar está activo
                if (Vista.lblprevH.isEnabled() == true) {
                    // Restamos el contador si es mayor que 0
                    if (contadorH > 0) {
                        contadorH -= 1;
                        Modelo.setContador(contadorH * 3);
                        Vista.mostrarDatosHospedaje();
                    }
                    // Desactivar el botón de regresar si estamos en la primera página
                    if (contadorH == 0) {
                        Vista.lblprevH.setEnabled(false);
                        // Cargar la imagen de "previous deshabilitado"
                        BufferedImage imgPrevDisabled = ImageIO.read(getClass().getResource("/Img/previous_d.png"));
                        Image imgRedPrevDisabled = imgPrevDisabled.getScaledInstance(Vista.lblprevH.getWidth(), Vista.lblprevH.getHeight(), Image.SCALE_AREA_AVERAGING);
                        Vista.lblprevH.setIcon(new ImageIcon(imgRedPrevDisabled));
                    } else {
                        // Si hay más páginas hacia atrás, asegurarse de que el botón de regresar está activo
                        Vista.lblprevH.setEnabled(true);
                        BufferedImage imgPrev = ImageIO.read(getClass().getResource("/Img/previous.png"));
                        Image imgRedPrev = imgPrev.getScaledInstance(Vista.lblprevH.getWidth(), Vista.lblprevH.getHeight(), Image.SCALE_AREA_AVERAGING);
                        Vista.lblprevH.setIcon(new ImageIcon(imgRedPrev));
                    }
                    // Activar el botón de "siguiente" si no estamos en la última página
                    int totalHospedajes = Modelo.ContadorHospedaje();
                    int max_pagH = (int) Math.ceil((double) totalHospedajes / 3);

                    if (contadorH < (max_pagH - 1)) {
                        Vista.lblnextH.setEnabled(true);
                        BufferedImage imgNext = ImageIO.read(getClass().getResource("/Img/next.png"));
                        Image imgRedNext = imgNext.getScaledInstance(Vista.lblnextH.getWidth(), Vista.lblnextH.getHeight(), Image.SCALE_AREA_AVERAGING);
                        Vista.lblnextH.setIcon(new ImageIcon(imgRedNext));
                    } else {
                        // Si estamos en la última página, desactivar el botón de "siguiente"
                        Vista.lblnextH.setEnabled(false);
                        BufferedImage imgNextDisabled = ImageIO.read(getClass().getResource("/Img/next_d.png"));
                        Image imgRedNextDisabled = imgNextDisabled.getScaledInstance(Vista.lblnextH.getWidth(), Vista.lblnextH.getHeight(), Image.SCALE_AREA_AVERAGING);
                        Vista.lblnextH.setIcon(new ImageIcon(imgRedNextDisabled));
                    }
                    // Revalidate y repaint para actualizar la vista
                    Vista.lblprevH.repaint();
                    Vista.lblprevH.revalidate();
                    Vista.lblnextH.repaint();
                    Vista.lblnextH.revalidate();
                }
            } catch (Exception p) {
                p.printStackTrace();
            }
        }
    }
    
    private void mostrarDetallesHospedaje(int index) {
        // Obtener los datos del hospedaje seleccionado
        Object[][] datos = Modelo.MostrarHospedaje();

        if (datos.length > index) {
            IDModDel = (String) datos[index][0];
            String nombre = (String) datos[index][1];
            double precio = (double) datos[index][2];
            String detalles = (String) datos[index][3];
            String imgUrl = (String) datos[index][4];

            // Actualizar los componentes de la vista con la información
            Vista.lblnombre.setText(nombre);
            Vista.lblprecio.setText(String.valueOf(precio));
            Vista.tadescrip.setText(detalles);
            
            // Cargar la imagen y mostrarla en lblugar
            try {
                BufferedImage imgOriginal = ImageIO.read(new URL(imgUrl)); // Cambia según cómo estés guardando las imágenes
                Image imgRedimensionada = imgOriginal.getScaledInstance(Vista.lbImglugar.getWidth(), Vista.lbImglugar.getHeight(), Image.SCALE_AREA_AVERAGING);
                Vista.lbImglugar.setIcon(new ImageIcon(imgRedimensionada));
            } catch (IOException ex) {
                ex.printStackTrace();
                try{
                    /*Imagen por defecto*/
                    BufferedImage imgDefault = ImageIO.read(getClass().getResource("/Img/default.jpg"));
                    Image imgDefaultRedimensionada = imgDefault.getScaledInstance(Vista.lbImglugar.getWidth(), Vista.lbImglugar.getHeight(), Image.SCALE_AREA_AVERAGING);
                    Vista.lbImglugar.setIcon(new ImageIcon(imgDefaultRedimensionada));
                } catch (IOException e) {
                    e.printStackTrace();
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