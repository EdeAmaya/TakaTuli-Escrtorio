/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.ctrlSubidos;
import Modelo.Subidos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
// Importaciones necesarias
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 *
 * @author edeni
 */
public class jpSubidos extends javax.swing.JPanel {

    public static String UUID1, UUID2, UUID3, UUID4, UUID5, UUID6 = "";
    private double precio;
    private String detalle = "";
    private ctrlSubidos controlador; // Agregar el controlador
    private Object[][] datos = new Object[3][5];

    /**
     * Creates new form jpSubidos
     */
    public jpSubidos() {
        initComponents();
        controlador = new ctrlSubidos(this, new Subidos()); // Inicializa el controlador aquí
        // Llama al método para cargar y mostrar los datos
        navegacionHospedaje();
        mostrarDatosHospedaje();
        mostrarDatosResta();
        // Aquí agregamos el mouse listener
        btnVer1.addMouseListener(controlador); // Vincula el listener para btnVer1
        btnVer2.addMouseListener(controlador); // Vincula el listener para btnVer2
        btnVer3.addMouseListener(controlador); // Vincula el listener para btnVer3
        lblprevH.addMouseListener(controlador); // Vincula el listener para lblprevH
        lblnextH.addMouseListener(controlador); // Vincula el listener para lblnextH
    }

    //Método para mostrar las imagenes de labels
    public void cargarImgNavegacionH() {
        lblprevH.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                try {
                    //Deactivamos el lbl de regresar
                    lblprevH.setEnabled(false);
                    // Cargar la imagen desde un archivo para los "botones" next o previous de navegacion
                    BufferedImage imgprev = ImageIO.read(getClass().getResource("/Img/previous_d.png"));
                    BufferedImage imgnext = ImageIO.read(getClass().getResource("/Img/next.png"));
                    // Redimensionar la imagen al tamaño actual del JLabel
                    Image imgRed1 = imgprev.getScaledInstance(lblprevH.getWidth(), lblprevH.getHeight(), Image.SCALE_AREA_AVERAGING);
                    Image imgRed2 = imgnext.getScaledInstance(lblnextH.getWidth(), lblnextH.getHeight(), Image.SCALE_AREA_AVERAGING);
                    // Asignar la imagen redimensionada al JLabel
                    lblprevH.setIcon(new ImageIcon(imgRed1));
                    lblnextH.setIcon(new ImageIcon(imgRed2));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    // Método para mostrar los datos en la vista
    public void mostrarDatosHospedaje() {
        //garantiza que el código se ejecute después de que el GUI esté visible.
        SwingUtilities.invokeLater(() -> {
        // Manejo de la excepción: mostrar una imagen por defecto y datos del array
        try {
            datos = controlador.MostrarHospedajeCtrl();
            /*Imagen por defecto*/
            BufferedImage imgDefault = ImageIO.read(getClass().getResource("/Img/default.jpg"));
            Image imgDefaultRedimensionada = imgDefault.getScaledInstance(lblimg1.getWidth(), lblimg1.getHeight(), Image.SCALE_AREA_AVERAGING);
            // Verificar si datos no está vacío
            if (!isDatosVacio(datos)) {
                // Asumiendo que hay al menos 3 registros para mostrar
                for (int i = 0; i < 3; i++) {
                    // Asignar el nombre del hospedaje a los JLabel correspondientes
                    String nombreHospedaje;
                    String id = null;  // Inicializa id

                    // Asegúrate de que estás dentro del rango de datos
                    if (i < datos.length) {
                        id = (String) datos[i][0]; // Obtener UUID
                        nombreHospedaje = (String) datos[i][1]; // Obtener nombre
                    } else {
                        nombreHospedaje = "No data"; // Asignar "No data" si no hay datos
                    }

                    // Asignar el UUID y el título
                    switch (i) {
                        case 0:
                            UUID1 = (id != null) ? id : "";
                            lbltitulo1.setText(nombreHospedaje);
                            break;
                        case 1:
                            UUID2 = (id != null) ? id : "";
                            lbltitulo2.setText(nombreHospedaje);
                            break;
                        case 2:
                            UUID3 = (id != null) ? id : "";
                            lbltitulo3.setText(nombreHospedaje);
                            break;
                    }
                    // Cargar la imagen
                    String urlImagen = (String) datos[i][4]; // Obtener la URL de la imagen
                    try {
                        BufferedImage imgOriginal = ImageIO.read(new URL(urlImagen)); // Cambia según cómo estés guardando las imágenes
                        Image imgRedimensionada = imgOriginal.getScaledInstance(lblimg1.getWidth(), lblimg1.getHeight(), Image.SCALE_AREA_AVERAGING);
                        // Asignar la imagen redimensionada a los JLabel correspondientes
                        if (i == 0) {
                            lblimg1.setIcon(new ImageIcon(imgRedimensionada));
                        } else if (i == 1) {
                            lblimg2.setIcon(new ImageIcon(imgRedimensionada));
                        } else if (i == 2) {
                            lblimg3.setIcon(new ImageIcon(imgRedimensionada));
                        }
                    } catch (IOException ex) {
                        if (i == 0) {
                            lblimg1.setIcon(new ImageIcon(imgDefaultRedimensionada));
                        } else if (i == 1) {
                            lblimg2.setIcon(new ImageIcon(imgDefaultRedimensionada));
                        } else if (i == 2) {
                            lblimg3.setIcon(new ImageIcon(imgDefaultRedimensionada));
                        }
                        System.out.println("No se pudo cargar la imagen desde la URL: " + urlImagen);
                    }
                }
            } else {
                // Si no hay datos, puedes establecer imágenes por defecto
                limpiarDatos(imgDefaultRedimensionada);
            }
            recalibrarH();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        });
    }
    
    
    
    
    // Método para mostrar los datos en la vista
    public void mostrarDatosResta() {
        //garantiza que el código se ejecute después de que el GUI esté visible.
        SwingUtilities.invokeLater(() -> {
        // Manejo de la excepción: mostrar una imagen por defecto y datos del array
        try {
            datos = controlador.MostrarHospedajeCtrl();
            /*Imagen por defecto*/
            BufferedImage imgDefault = ImageIO.read(getClass().getResource("/Img/default.jpg"));
            Image imgDefaultRedimensionada = imgDefault.getScaledInstance(lblimg1.getWidth(), lblimg1.getHeight(), Image.SCALE_AREA_AVERAGING);
            // Verificar si datos no está vacío
            if (!isDatosVacio(datos)) {
                // Asumiendo que hay al menos 3 registros para mostrar
                for (int i = 0; i < 3; i++) {
                    // Asignar el nombre del hospedaje a los JLabel correspondientes
                    String nombreHospedaje;
                    String id = null;  // Inicializa id

                    // Asegúrate de que estás dentro del rango de datos
                    if (i < datos.length) {
                        id = (String) datos[i][0]; // Obtener UUID
                        nombreHospedaje = (String) datos[i][1]; // Obtener nombre
                    } else {
                        nombreHospedaje = "No data"; // Asignar "No data" si no hay datos
                    }

                    // Asignar el UUID y el título
                    switch (i) {
                        case 0:
                            UUID1 = (id != null) ? id : "";
                            lbltitulo1.setText(nombreHospedaje);
                            break;
                        case 1:
                            UUID2 = (id != null) ? id : "";
                            lbltitulo2.setText(nombreHospedaje);
                            break;
                        case 2:
                            UUID3 = (id != null) ? id : "";
                            lbltitulo3.setText(nombreHospedaje);
                            break;
                    }
                    // Cargar la imagen
                    String urlImagen = (String) datos[i][4]; // Obtener la URL de la imagen
                    try {
                        BufferedImage imgOriginal = ImageIO.read(new URL(urlImagen)); // Cambia según cómo estés guardando las imágenes
                        Image imgRedimensionada = imgOriginal.getScaledInstance(lblimg1.getWidth(), lblimg1.getHeight(), Image.SCALE_AREA_AVERAGING);
                        // Asignar la imagen redimensionada a los JLabel correspondientes
                        if (i == 0) {
                            lblimg1.setIcon(new ImageIcon(imgRedimensionada));
                        } else if (i == 1) {
                            lblimg2.setIcon(new ImageIcon(imgRedimensionada));
                        } else if (i == 2) {
                            lblimg3.setIcon(new ImageIcon(imgRedimensionada));
                        }
                    } catch (IOException ex) {
                        if (i == 0) {
                            lblimg1.setIcon(new ImageIcon(imgDefaultRedimensionada));
                        } else if (i == 1) {
                            lblimg2.setIcon(new ImageIcon(imgDefaultRedimensionada));
                        } else if (i == 2) {
                            lblimg3.setIcon(new ImageIcon(imgDefaultRedimensionada));
                        }
                        System.out.println("No se pudo cargar la imagen desde la URL: " + urlImagen);
                    }
                }
            } else {
                // Si no hay datos, puedes establecer imágenes por defecto
                limpiarDatos(imgDefaultRedimensionada);
            }
            recalibrarH();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        });
    }
    
    
    

    private void limpiarDatos(Image imgDefaultRedimensionada) {
        // Si no hay datos, puedes establecer imágenes por defecto
        lblimg1.setIcon(new ImageIcon(imgDefaultRedimensionada));
        lblimg2.setIcon(new ImageIcon(imgDefaultRedimensionada));
        lblimg3.setIcon(new ImageIcon(imgDefaultRedimensionada));
        lbltitulo1.setText("No data");
        lbltitulo2.setText("No data");
        lbltitulo3.setText("No data");
        UUID1 = "";
        UUID2 = "";
        UUID3 = "";
    }

    private boolean isDatosVacio(Object[][] datos) {
        for (Object[] fila : datos) {
            for (Object elemento : fila) {
                if (elemento != null) {
                    return false; // Si hay al menos un elemento no nulo, el array no está vacío
                }
            }
        }
        return true; // Si todos los elementos son nulos, el array está vacío
    }

    private void recalibrarH() {
        lblimg1.repaint();
        lblimg1.revalidate();
        lblimg2.repaint();
        lblimg2.revalidate();
        lblimg3.repaint();
        lblimg3.revalidate();
        lbltitulo1.repaint();
        lbltitulo1.revalidate();
        lbltitulo2.repaint();
        lbltitulo2.revalidate();
        lbltitulo3.repaint();
        lbltitulo3.revalidate();
    }

    private void navegacionHospedaje() {
        double cantidad = controlador.ContadorHospedajeCtrol();
        cantidad = cantidad / 3;
        if (cantidad == 1) {
            //Desactivamos el lbl de siguiente
            lblnextH.setEnabled(false);
            // Cargar la imagen y mostrarla en lblugar
            try {
                /*Imagen desactiva para lbl regresar*/
                BufferedImage imgNextD = ImageIO.read(getClass().getResource("/Img/next_d.png"));
                Image imgNextDisabled = imgNextD.getScaledInstance(lblimg1.getWidth(), lblimg1.getHeight(), Image.SCALE_AREA_AVERAGING);
                lblnextH.setIcon(new ImageIcon(imgNextDisabled));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            cargarImgNavegacionH();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbImglugar = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tadescrip = new javax.swing.JTextArea();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        lblprecio = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        lblprevH = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblnextH = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblimg1 = new javax.swing.JLabel();
        btnVer1 = new javax.swing.JButton();
        lbltitulo1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblimg2 = new javax.swing.JLabel();
        btnVer2 = new javax.swing.JButton();
        lbltitulo2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblimg3 = new javax.swing.JLabel();
        btnVer3 = new javax.swing.JButton();
        lbltitulo3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lblnextR = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lblimg6 = new javax.swing.JLabel();
        btnVer6 = new javax.swing.JButton();
        lbltitulo6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblimg9 = new javax.swing.JLabel();
        btnVer5 = new javax.swing.JButton();
        lbltitulo5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lblimg4 = new javax.swing.JLabel();
        btnVer4 = new javax.swing.JButton();
        lbltitulo4 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        lblimg5 = new javax.swing.JLabel();
        btnVer8 = new javax.swing.JButton();
        lbltitulo8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        lblnextL = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        lblimg8 = new javax.swing.JLabel();
        btnVer9 = new javax.swing.JButton();
        lbltitulo9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblprevL = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        lblprevR1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        lblimg7 = new javax.swing.JLabel();
        btnVer7 = new javax.swing.JButton();
        lbltitulo7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 132, 0));
        jLabel3.setText("Lugar");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 50, 40));

        lbImglugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/default.jpg"))); // NOI18N
        lbImglugar.setText("jLabel20");
        jPanel1.add(lbImglugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 150, 150));

        lblnombre.setText("Nombre lugar");
        jPanel1.add(lblnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 120, -1));

        tadescrip.setColumns(20);
        tadescrip.setLineWrap(true);
        tadescrip.setRows(5);
        jScrollPane2.setViewportView(tadescrip);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 150, 150));

        jButton7.setBackground(new java.awt.Color(255, 132, 0));
        jButton7.setText("Editar");
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, -1, -1));

        jButton8.setBackground(new java.awt.Color(255, 132, 0));
        jButton8.setText("Eliminar");
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, -1, -1));

        lblprecio.setText("Precio");
        jPanel1.add(lblprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 190, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 132, 0));
        jLabel1.setText("Mis destinos");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 132, 0));
        jLabel2.setText("Gestiona, ajusta y asegurate que cada viaje inspire ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 132, 0));
        jLabel4.setText("Restaurantes");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jPanel2.setBackground(new java.awt.Color(250, 247, 202));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 132, 0));
        jLabel14.setText("Anterior");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        lblprevH.setText("prev");
        lblprevH.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(lblprevH, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 50, 50));
        lblprevH.getAccessibleContext().setAccessibleName("lblprevH");

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 70, 160));

        jPanel4.setBackground(new java.awt.Color(250, 247, 202));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblnextH.setText("next");
        lblnextH.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.add(lblnextH, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 50, 50));
        lblnextH.getAccessibleContext().setAccessibleName("lblnextH");
        lblnextH.getAccessibleContext().setAccessibleDescription("");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 132, 0));
        jLabel13.setText("Siguiente");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 70, 160));

        jPanel5.setBackground(new java.awt.Color(250, 247, 202));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblimg1.setText("lblimg1");
        lblimg1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel5.add(lblimg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 90));

        btnVer1.setBackground(new java.awt.Color(255, 132, 0));
        btnVer1.setText("Ver más...");
        jPanel5.add(btnVer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        lbltitulo1.setText("Titulo1");
        jPanel5.add(lbltitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, -1));
        lbltitulo1.getAccessibleContext().setAccessibleDescription("");

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 140, 160));

        jPanel6.setBackground(new java.awt.Color(250, 247, 202));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblimg2.setText("lblimg2");
        jPanel6.add(lblimg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 90));

        btnVer2.setBackground(new java.awt.Color(255, 132, 0));
        btnVer2.setText("Ver más...");
        jPanel6.add(btnVer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        lbltitulo2.setText("Titulo2");
        jPanel6.add(lbltitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, -1));
        lbltitulo2.getAccessibleContext().setAccessibleName("lbltitulo2");

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 140, 160));

        jPanel7.setBackground(new java.awt.Color(250, 247, 202));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblimg3.setText("lblimg3");
        jPanel7.add(lblimg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 90));

        btnVer3.setBackground(new java.awt.Color(255, 132, 0));
        btnVer3.setText("Ver más...");
        jPanel7.add(btnVer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        lbltitulo3.setText("Titulo3");
        jPanel7.add(lbltitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, -1));
        lbltitulo3.getAccessibleContext().setAccessibleName("lbltitulo3");

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 140, 160));

        jPanel12.setBackground(new java.awt.Color(250, 247, 202));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblnextR.setText("next2");
        lblnextR.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel12.add(lblnextR, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 50, 50));

        jLabel19.setText("Siguiente");
        jPanel12.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 70, 160));

        jPanel11.setBackground(new java.awt.Color(250, 247, 202));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblimg6.setText("lblimg1");
        jPanel11.add(lblimg6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 90));
        lblimg6.getAccessibleContext().setAccessibleName("lblimg6");

        btnVer6.setBackground(new java.awt.Color(255, 132, 0));
        btnVer6.setText("Ver más...");
        jPanel11.add(btnVer6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        lbltitulo6.setText("Titulo6");
        jPanel11.add(lbltitulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, -1));

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 140, 160));

        jPanel9.setBackground(new java.awt.Color(250, 247, 202));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblimg9.setText("lblimg1");
        jPanel9.add(lblimg9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 90));
        lblimg9.getAccessibleContext().setAccessibleName("lblimg5");

        btnVer5.setBackground(new java.awt.Color(255, 132, 0));
        btnVer5.setText("Ver más...");
        jPanel9.add(btnVer5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        lbltitulo5.setText("Titulo5");
        jPanel9.add(lbltitulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, -1));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 140, 160));

        jPanel10.setBackground(new java.awt.Color(250, 247, 202));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblimg4.setText("lblimg1");
        jPanel10.add(lblimg4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 90));
        lblimg4.getAccessibleContext().setAccessibleName("lblimg4");

        btnVer4.setBackground(new java.awt.Color(255, 132, 0));
        btnVer4.setText("Ver más...");
        jPanel10.add(btnVer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        lbltitulo4.setText("Titulo4");
        jPanel10.add(lbltitulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, -1));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 140, 160));

        jPanel15.setBackground(new java.awt.Color(250, 247, 202));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblimg5.setText("lblimg1");
        jPanel15.add(lblimg5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 90));

        btnVer8.setBackground(new java.awt.Color(255, 132, 0));
        btnVer8.setText("Ver más...");
        jPanel15.add(btnVer8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        lbltitulo8.setText("Titulo5");
        jPanel15.add(lbltitulo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, -1));

        jPanel3.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 140, 160));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 132, 0));
        jLabel5.setText("Hospedajes");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 132, 0));
        jLabel6.setText("Lugares turisticos");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 140, -1));

        jPanel13.setBackground(new java.awt.Color(250, 247, 202));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblnextL.setText("jLabel12");
        lblnextL.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel13.add(lblnextL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 50, 50));

        jLabel21.setText("Anterior");
        jPanel13.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jPanel3.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 70, 160));

        jPanel16.setBackground(new java.awt.Color(250, 247, 202));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblimg8.setText("lblimg1");
        jPanel16.add(lblimg8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 90));

        btnVer9.setBackground(new java.awt.Color(255, 132, 0));
        btnVer9.setText("Ver más...");
        jPanel16.add(btnVer9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        lbltitulo9.setText("Titulo5");
        jPanel16.add(lbltitulo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, -1));

        jPanel3.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, 140, 160));

        jPanel8.setBackground(new java.awt.Color(250, 247, 202));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblprevL.setText("jLabel12");
        lblprevL.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel8.add(lblprevL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 50, 50));

        jLabel17.setText("Anterior");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 70, 160));

        jPanel17.setBackground(new java.awt.Color(250, 247, 202));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblprevR1.setText("prevR");
        lblprevR1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel17.add(lblprevR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 50, 50));

        jLabel22.setText("Anterior");
        jPanel17.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jPanel3.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 70, 160));

        jPanel14.setBackground(new java.awt.Color(250, 247, 202));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblimg7.setText("lblimg1");
        jPanel14.add(lblimg7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 90));

        btnVer7.setBackground(new java.awt.Color(255, 132, 0));
        btnVer7.setText("Ver más...");
        jPanel14.add(btnVer7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        lbltitulo7.setText("Titulo4");
        jPanel14.add(lbltitulo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, -1));

        jPanel3.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 140, 160));

        jScrollPane1.setViewportView(jPanel3);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 640, 620));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnVer1;
    public javax.swing.JButton btnVer2;
    public javax.swing.JButton btnVer3;
    private javax.swing.JButton btnVer4;
    private javax.swing.JButton btnVer5;
    private javax.swing.JButton btnVer6;
    private javax.swing.JButton btnVer7;
    private javax.swing.JButton btnVer8;
    private javax.swing.JButton btnVer9;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lbImglugar;
    private javax.swing.JLabel lblimg1;
    private javax.swing.JLabel lblimg2;
    private javax.swing.JLabel lblimg3;
    private javax.swing.JLabel lblimg4;
    private javax.swing.JLabel lblimg5;
    private javax.swing.JLabel lblimg6;
    private javax.swing.JLabel lblimg7;
    private javax.swing.JLabel lblimg8;
    private javax.swing.JLabel lblimg9;
    public javax.swing.JLabel lblnextH;
    private javax.swing.JLabel lblnextL;
    private javax.swing.JLabel lblnextR;
    public javax.swing.JLabel lblnombre;
    public javax.swing.JLabel lblprecio;
    public javax.swing.JLabel lblprevH;
    private javax.swing.JLabel lblprevL;
    private javax.swing.JLabel lblprevR1;
    private javax.swing.JLabel lbltitulo1;
    private javax.swing.JLabel lbltitulo2;
    private javax.swing.JLabel lbltitulo3;
    private javax.swing.JLabel lbltitulo4;
    private javax.swing.JLabel lbltitulo5;
    private javax.swing.JLabel lbltitulo6;
    private javax.swing.JLabel lbltitulo7;
    private javax.swing.JLabel lbltitulo8;
    private javax.swing.JLabel lbltitulo9;
    public javax.swing.JTextArea tadescrip;
    // End of variables declaration//GEN-END:variables
}
