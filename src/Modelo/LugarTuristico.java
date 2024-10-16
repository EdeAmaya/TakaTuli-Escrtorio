/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import javax.swing.JTable;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.JSONObject;

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
            PreparedStatement addHospedaje = conexion.prepareStatement("INSERT INTO tbLugarTuristico(UUID_LugarTuristico, Nombre_LugarTuristico, Detalles_Lugar_Turistico, Fotos_Lugar_Turistico , UUID_TipoLugarTuristico ) VALUES (?, ?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addHospedaje.setString(1, UUID.randomUUID().toString());
            addHospedaje.setString(2, getNombre_LugarTuristico());
            addHospedaje.setString(3, getDetalles_Lugar_Turistico());
            addHospedaje.setString(4, getFoto_Lugar_Turistico());
            addHospedaje.setString(5, getUUID_TipoLugarTuristico());
 
            //Ejecutar la consulta
            addHospedaje.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
     
     
       public void EliminarLugarTuristico(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada

        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            String sql = "delete from tbLugarTuristico where UUID_LugarTuristico = ?";
            PreparedStatement deleteEstudiante = conexion.prepareStatement(sql);
            deleteEstudiante.setString(1, miId);
            deleteEstudiante.executeUpdate();
        } catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
        }
    }
       
       
           public void ActualizarHospedaje(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) {
            //Obtenemos el id de la fila seleccionada
            String miUUId = tabla.getValueAt(filaSeleccionada, 0).toString();

            try {
                //Ejecutamos la Query
                String sql = "update tbLugarTuristico set Nombre_LugarTuristico= ?, Detalles_Lugar_Turistico = ?, Fotos_Lugar_Turistico = ?, UUID_TipoLugarTuristico = ? where UUID_LugarTuristico = ?";
                PreparedStatement updateUser = conexion.prepareStatement(sql);

                updateUser.setString(1, getNombre_LugarTuristico());
                updateUser.setString(2, getDetalles_Lugar_Turistico());
                updateUser.setString(3, getFoto_Lugar_Turistico());
                updateUser.setString(4, getUUID_TipoLugarTuristico());
                updateUser.setString(5, miUUId);
                updateUser.executeUpdate();

            } catch (Exception e) {
                System.out.println("este es el error en el metodo de actualizar" + e);
            }
        } else {
            System.out.println("no");
        }
    }
           
           
           
              public String subirImagenImgBB(File imageFile) throws IOException, ParseException {
        String apiKey = "79e54927db95eac867263fd0bf4d6e0e"; // Reemplaza con tu API Key
        String uploadUrl = "https://api.imgbb.com/1/upload";

        // Crear un cliente HTTP
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost uploadFile = new HttpPost(uploadUrl);

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody("key", apiKey);
        builder.addBinaryBody("image", imageFile);

        uploadFile.setEntity(builder.build());

        CloseableHttpResponse response = httpClient.execute(uploadFile);
        String jsonResponse = EntityUtils.toString(response.getEntity());

        JSONObject responseObject = new JSONObject(jsonResponse);
        String uploadedUrl = responseObject.getJSONObject("data").getString("url");

        response.close();
        return uploadedUrl;
    }
  
}
