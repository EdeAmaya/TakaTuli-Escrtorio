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
public class LugarTuristico {
 
    
    
    String UUID_LugarTuristico;
    String Nombre_LugarTuristico;
    String Detalles_Lugar_Turistico;
    String Foto_Lugar_Turistico;
    String UUID_TipoLugarTuristico;
    
    
    public String getUUID_LugarTuristico() {
        return UUID_LugarTuristico;
    }

    public void setUUID_LugarTuristico(String UUID_LugarTuristico) {
        this.UUID_LugarTuristico = UUID_LugarTuristico;
    }

    public String getNombre_LugarTuristico() {
        return Nombre_LugarTuristico;
    }

    public void setNombre_LugarTuristico(String Nombre_LugarTuristico) {
        this.Nombre_LugarTuristico = Nombre_LugarTuristico;
    }

    public String getDetalles_Lugar_Turistico() {
        return Detalles_Lugar_Turistico;
    }

    public void setDetalles_Lugar_Turistico(String Detalles_Lugar_Turistico) {
        this.Detalles_Lugar_Turistico = Detalles_Lugar_Turistico;
    }

    public String getFoto_Lugar_Turistico() {
        return Foto_Lugar_Turistico;
    }

    public void setFoto_Lugar_Turistico(String Foto_Lugar_Turistico) {
        this.Foto_Lugar_Turistico = Foto_Lugar_Turistico;
    }

    public String getUUID_TipoLugarTuristico() {
        return UUID_TipoLugarTuristico;
    }

    public void setUUID_TipoLugarTuristico(String UUID_TipoLugarTuristico) {
        this.UUID_TipoLugarTuristico = UUID_TipoLugarTuristico;
    }
    
    
    
     public void GuardarLugarTuristico() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addHospedaje = conexion.prepareStatement("INSERT INTO tbLugarTuristico(UUID_LugarTuristico, Nombre_LugarTuristico, Detalles_Lugar_Turistico,UUID_TipoLugarTuristico ) VALUES (?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addHospedaje.setString(1, UUID.randomUUID().toString());
            addHospedaje.setString(2, getNombre_LugarTuristico());
            addHospedaje.setString(3, getDetalles_Lugar_Turistico());
            addHospedaje.setString(4, getUUID_TipoLugarTuristico());
 
            //Ejecutar la consulta
            addHospedaje.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
  
}
