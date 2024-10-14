/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tipografias;


/**
 *
 * @author CAPITANA MARVEL
 */
import java.awt.Font;
import java.io.InputStream;
public class Fuentes {
    
    private Font font = null;
    public String Baloo = "Baloo-Regular.ttf";
    public String BBhaina = "BalooBahina2-Regular.ttf";
    
    /*font.Regular = 0, font.Negrita = 1, Font.Cursiva = 2*/
    
    public Font fuente( String fontName, int estilo, float tamanio)
    {
         try {
            //Se carga la fuente
            InputStream is =  getClass().getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception ex) {
            //Si existe un error se carga fuente por defecto ARIAL
            System.err.println(fontName + " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 14);            
        }
        Font tfont = font.deriveFont(estilo, tamanio);
        return tfont;
    }
}
    

