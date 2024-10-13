/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

/**
 *
 * @author jluis
 */
public class Restaurante {

    
    String UUID_Restaurante;
    String Nombre_Restaurante;
    String Menu_Restaurante;
    String Foto_Menu;
    String Foto_Restaurante;
    
    
    public String getUUID_Restaurante() {
        return UUID_Restaurante;
    }

    public void setUUID_Restaurante(String UUID_Restaurante) {
        this.UUID_Restaurante = UUID_Restaurante;
    }

    public String getNombre_Restaurante() {
        return Nombre_Restaurante;
    }

    public void setNombre_Restaurante(String Nombre_Restaurante) {
        this.Nombre_Restaurante = Nombre_Restaurante;
    }

    public String getMenu_Restaurante() {
        return Menu_Restaurante;
    }

    public void setMenu_Restaurante(String Menu_Restaurante) {
        this.Menu_Restaurante = Menu_Restaurante;
    }

    public String getFoto_Menu() {
        return Foto_Menu;
    }

    public void setFoto_Menu(String Foto_Menu) {
        this.Foto_Menu = Foto_Menu;
    }

    public String getFoto_Restaurante() {
        return Foto_Restaurante;
    }

    public void setFoto_Restaurante(String Foto_Restaurante) {
        this.Foto_Restaurante = Foto_Restaurante;
    }
    
    public void GuardarRestaurante() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addHospedaje = conexion.prepareStatement("INSERT INTO tbRestaurante(UUID_Restaurante, Nombre_Restaurante, Menu_Restaurante) VALUES (?, ?, ?)");
            //Establecer valores de la consulta SQL
            addHospedaje.setString(1, UUID.randomUUID().toString());
            addHospedaje.setString(2, getNombre_Restaurante());
            addHospedaje.setString(3, getMenu_Restaurante());
            
 
            //Ejecutar la consulta
            addHospedaje.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
    
}
