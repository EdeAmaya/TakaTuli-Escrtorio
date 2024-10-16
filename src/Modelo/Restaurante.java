package Modelo;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
            PreparedStatement addRestaurante = conexion.prepareStatement("INSERT INTO tbRestaurante(UUID_Restaurante, Nombre_Restaurante, Menu_Restaurante, Foto_Menu, Fotos_Restaurante) VALUES (?, ?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addRestaurante.setString(1, UUID.randomUUID().toString());
            addRestaurante.setString(2, getNombre_Restaurante());
            addRestaurante.setString(3, getMenu_Restaurante());
            addRestaurante.setString(4, getFoto_Menu());
            addRestaurante.setString(5,getFoto_Restaurante());
            
            
 
            //Ejecutar la consulta
            addRestaurante.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
    
    /*
        public void MostrarRestaurante(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloPinulito = new DefaultTableModel();
        modeloPinulito.setColumnIdentifiers(new Object[]{"UUID_Restaurante", "Nombre_Restaurante", "Menu_Restaurante", "Foto_Menu", "Fotos_Restaurante"});
        try {
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("SELECT * FROM tbRestaurante");
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloPinulito.addRow(new Object[]{rs.getString("UUID_Restaurante"),
                    rs.getString("Nombre_Restaurante"),
                    rs.getString("Menu_Restaurante"),
                    rs.getString("Foto_Menu"),
                    rs.getString("Fotos_Restaurante")
                });
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloPinulito);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
        
      */  
           public void EliminarRestaurante(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada

        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            String sql = "delete from tbRestaurante where UUID_Restaurante = ?";
            PreparedStatement deleteEstudiante = conexion.prepareStatement(sql);
            deleteEstudiante.setString(1, miId);
            deleteEstudiante.executeUpdate();
        } catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
        }
    }
           
           
           
        public void ActualizarRestaurante(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) {
            //Obtenemos el id de la fila seleccionada
            String miUUId = tabla.getValueAt(filaSeleccionada, 0).toString();

            try {
                //Ejecutamos la Query
                String sql = "update tbRestaurante set Nombre_Restaurante= ?, Menu_Restaurante = ?, Foto_Menu = ?, Fotos_Restaurante = ?  where UUID_Restaurante = ?";
                PreparedStatement updateUser = conexion.prepareStatement(sql);

                updateUser.setString(1, getNombre_Restaurante());
                updateUser.setString(2, getMenu_Restaurante());
                updateUser.setString(3, getFoto_Menu());
                updateUser.setString(4, getFoto_Restaurante());
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
