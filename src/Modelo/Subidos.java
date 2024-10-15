/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edeni
 */
public class Subidos {
    Integer Contador = 0;
    String UUID_Hospedaje;
    String Nombre_Hospedaje;
    double Precio_Hospedaje;
    String Detalles_Hospedaje;
    String Fotos_Hospedaje;

    public void setContador(Integer setcontador) {
        this.Contador = setcontador;
    }
    
    public Integer getContador() {
        return Contador;
    }
    
    public String getFotos_Hospedaje() {
        return Fotos_Hospedaje;
    }

    public String getUUID_Hospedaje() {
        return UUID_Hospedaje;
    }
    
    public String getNombre_Hospedaje() {
        return Nombre_Hospedaje;
    }
    
    public double getPrecio_Hospedaje() {
        return Precio_Hospedaje;
    }
    
    public String getDetalles_Hospedaje() {
        return Detalles_Hospedaje;
    }
    
    public Object[][] MostrarHospedaje() {
        // Creamos una variable de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        Object[][] datos = new Object[3][5]; // Cambia el tamaño según sea necesario
        try {
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM tbhospedaje ORDER BY Nombre_Hospedaje ASC OFFSET " + getContador() + " ROWS FETCH NEXT 3 ROWS ONLY");
            System.out.println(getContador());
            int index = 0;
            while (rs.next() && index < 3) { // Asegúrate de no sobrepasar el tamaño del array
                // Asignar los datos al array
                datos[index][0] = rs.getString("UUID_Hospedaje");
                datos[index][1] = rs.getString("Nombre_Hospedaje");
                datos[index][2] = rs.getDouble("Precio_Hospedaje");
                datos[index][3] = rs.getString("Detalles_Hospedaje");
                datos[index][4] = rs.getString("Fotos_Hospedaje");
                index++;
            }
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, método mostrar " + e);
        }
        return datos; // Retorna el array con los datos
    }
    
    public Integer ContadorHospedaje(){
        int cantidad = 0;
        Connection conexion = ClaseConexion.getConexion();
        try{
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM tbhospedaje");
            if(rs.next() == true){
                cantidad = rs.getInt(1);
            }
        } catch (Exception e){
            System.out.println("Este es el error en el modelo, método mostrar " + e);
        }
        return cantidad;
    }
}
