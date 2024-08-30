
package Modelo;
//lol

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class User {
private String UUID_Usuario;
    
    private String Nombre_Usuario;
    private String Password_Usuario;
    private int Edad_Usuario;
    private String Telefono_Usuario;
    private String Correo_Usuario;
    private String DUI_Usuario;
    
    
    public String getUUID_Usuario() {
        return UUID_Usuario;
    }

    public void setUUID_Usuario(String UUID_Usuario) {
        this.UUID_Usuario = UUID_Usuario;
    }

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String Nombre_Usuario) {
        this.Nombre_Usuario = Nombre_Usuario;
    }

    public String getPassword_Usuario() {
        return Password_Usuario;
    }

    public void setPassword_Usuario(String Password_Usuario) {
        this.Password_Usuario = Password_Usuario;
    }

    public int getEdad_Usuario() {
        return Edad_Usuario;
    }

    public void setEdad_Usuario(int Edad_Usuario) {
        this.Edad_Usuario = Edad_Usuario;
    }

    public String getTelefono_Usuario() {
        return Telefono_Usuario;
    }

    public void setTelefono_Usuario(String Telefono_Usuario) {
        this.Telefono_Usuario = Telefono_Usuario;
    }

    public String getCorreo_Usuario() {
        return Correo_Usuario;
    }

    public void setCorreo_Usuario(String Correo_Usuario) {
        this.Correo_Usuario = Correo_Usuario;
    }

    public String getDUI_Usuario() {
        return DUI_Usuario;
    }

    public void setDUI_Usuario(String DUI_Usuario) {
        this.DUI_Usuario = DUI_Usuario;
    }
    
    
    
        public void GuardarUsuario() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addUsuario = conexion.prepareStatement("INSERT INTO tbUsuario(UUID_Usuario,Nombre_Usuario,Password_Usuario,Edad_Usuario,Telefono_Usuario,Correo_Usuario,DUI_Usuario) VALUES (?, ?, ?, ?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addUsuario.setString(1, UUID.randomUUID().toString());
            addUsuario.setString(2, getNombre_Usuario());
            addUsuario.setString(3, getPassword_Usuario());
            addUsuario.setInt(4, getEdad_Usuario());
            addUsuario.setString(5, getTelefono_Usuario());
            addUsuario.setString(6, getCorreo_Usuario());
            addUsuario.setString(7, getDUI_Usuario());
            
 
            //Ejecutar la consulta
            addUsuario.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
    
   
    
    
}
