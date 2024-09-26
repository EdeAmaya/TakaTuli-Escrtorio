
package Modelo;
//lol

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
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
    
    public String convertirSHA256(String password) {
	MessageDigest md = null;
	try {
		md = MessageDigest.getInstance("SHA-256");
	}
	catch (NoSuchAlgorithmException e) {
		System.out.println(e.toString());
		return null;
	}
	byte[] hash = md.digest(password.getBytes());
	StringBuffer sb = new StringBuffer();
 
	for(byte b : hash) {
		sb.append(String.format("%02x", b));
	}
 
	return sb.toString();
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
        
        public boolean iniciarSesion() {
        //Obtenemos la conexión a la base de datos
        Connection conexion = ClaseConexion.getConexion();
        boolean resultado = false;

        try {
            //Preparamos la consulta SQL para verificar el usuario
            String sql = "SELECT * FROM tbUsuario WHERE (Correo_Usuario = ? OR Nombre_Usuario = ?) AND Password_Usuario = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, getCorreo_Usuario());
            statement.setString(2, getCorreo_Usuario());
            statement.setString(3, getPassword_Usuario());

            //Ejecutamos la consulta
            ResultSet resultSet = statement.executeQuery();

            //Si hay un resultado, significa que el usuario existe y la contraseña es correcta
            if (resultSet.next()) {
                resultado = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error en el modelo: método iniciarSesion " + ex);
        }

        return resultado;
    }
        
        
        public boolean verificarCorreo() {
        //Obtenemos la conexión a la base de datos
        Connection conexion = ClaseConexion.getConexion();
        boolean resultado = false;

        try {
            //Preparamos la consulta SQL para verificar el usuario
            String sql = "SELECT * FROM tbUsuario WHERE Correo_Usuario = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, getCorreo_Usuario());

            //Ejecutamos la consulta
            ResultSet resultSet = statement.executeQuery();

            //Si hay un resultado, significa que el usuario existe y la contraseña es correcta
            if (resultSet.next()) {
                resultado = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error en el modelo: método iniciarSesion " + ex);
        }

        return resultado;
    }
        
    
    public static void enviarCorreo(String recipient, String subject, String content) {
        
        //1- Propiedades del servidor de correo
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com"); 
        properties.put("mail.smtp.port", "587");

        
        
        //2- Credenciales de la cuenta de correo
        final String myAccountEmail = "noseenose64@gmail.com";
        final String password = "ozvt qrxm vutj rvla";

        // Crear sesión
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        //3- Enviar el correo
        try {
            // Crear mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setText(content);

            // Enviar mensaje
            Transport.send(message);
            System.out.println("Correo enviado con éxito");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    } 
    
   public boolean ActualizarContraseña() {
    Connection conexion = ClaseConexion.getConexion();
    try {
        String sql = "UPDATE tbUsuario SET Password_Usuario = ? WHERE Correo_Usuario = ?";
        PreparedStatement updateUser = conexion.prepareStatement(sql);
        updateUser.setString(1, getPassword_Usuario()); // Aquí se obtiene la nueva contraseña
        updateUser.setString(2, getCorreo_Usuario()); // Aquí se obtiene el correo del modelo
        
         System.out.println("Correo: " + getCorreo_Usuario());
System.out.println("Nueva Contraseña: " + getPassword_Usuario());
        int rowsAffected = updateUser.executeUpdate();
        return rowsAffected > 0; // Retorna verdadero si se actualizó al menos una fila
     } catch (Exception e) {
        System.out.println("Error en el método de actualizar: " + e.getMessage());
        return false; // Retorna falso si hay un error
      }
    }
}

