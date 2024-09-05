package Modelo;

import Vista.frmHospedaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Hospedaje {
    
    String UUID_Hospedaje;
    String Nombre_Hospedaje;
    double Precio_Hospedaje;
    String Detalles_Hospedaje;
    
    
    public String getUUID_Hospedaje() {
        return UUID_Hospedaje;
    }

    public void setUUID_Hospedaje(String UUID_Hospedaje) {
        this.UUID_Hospedaje = UUID_Hospedaje;
    }

    public String getNombre_Hospedaje() {
        return Nombre_Hospedaje;
    }

    public void setNombre_Hospedaje(String Nombre_Hospedaje) {
        this.Nombre_Hospedaje = Nombre_Hospedaje;
    }

    public double getPrecio_Hospedaje() {
        return Precio_Hospedaje;
    }

    public void setPrecio_Hospedaje(double Precio_Hospedaje) {
        this.Precio_Hospedaje = Precio_Hospedaje;
    }

    public String getDetalles_Hospedaje() {
        return Detalles_Hospedaje;
    }

    public void setDetalles_Hospedaje(String Detalles_Hospedaje) {
        this.Detalles_Hospedaje = Detalles_Hospedaje;
    }
    
    
      public void GuardarHospedaje() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addHospedaje = conexion.prepareStatement("INSERT INTO tbHospedaje(UUID_Hospedaje, Nombre_Hospedaje, Precio_Hospedaje, Detalles_Hospedaje) VALUES (?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addHospedaje.setString(1, UUID.randomUUID().toString());
            addHospedaje.setString(2, getNombre_Hospedaje());
            addHospedaje.setDouble(3, getPrecio_Hospedaje());
            addHospedaje.setString(4, getDetalles_Hospedaje());
 
            //Ejecutar la consulta
            addHospedaje.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
      
      
       public void MostrarHospedaje(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloPinulito = new DefaultTableModel();
        modeloPinulito.setColumnIdentifiers(new Object[]{"UUID_Hospedaje", "Nombre_Hospedaje", "Precio_Hospedaje", "Detalles_Hospedaje"});
        try {
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("SELECT * FROM tbHospedaje");
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloPinulito.addRow(new Object[]{rs.getString("UUID_Hospedaje"), 
                    rs.getString("Nombre_Hospedaje"), 
                    rs.getDouble("Precio_Hospedaje"), 
                    rs.getString("Detalles_Hospedaje")});
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloPinulito);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
       
       
       
          public void EliminarHospedaje(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada

        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            String sql = "delete from tbHospedaje where UUID_Hospedaje = ?";
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
                String sql = "update tbHospedaje set Nombre_Hospedaje= ?, Precio_Hospedaje = ?, Detalles_Hospedaje = ? where UUID_Hospedaje = ?";
                PreparedStatement updateUser = conexion.prepareStatement(sql);

                updateUser.setString(1, getNombre_Hospedaje());
                updateUser.setDouble(2, getPrecio_Hospedaje());
                updateUser.setString(3, getDetalles_Hospedaje());
                updateUser.setString(4, miUUId);
                updateUser.executeUpdate();

            } catch (Exception e) {
                System.out.println("este es el error en el metodo de actualizar" + e);
            }
        } else {
            System.out.println("no");
        }
    }
             
             
             public void limpiarHospedaje(frmHospedaje vista) {
        vista.txtNombreH.setText("");
        vista.txtPrecioH1.setText("");
        vista.txtDescripcionH.setText("");
        
        }
             
                public void cargarDatosTabla(frmHospedaje vista) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vista.jtbHospedaje.getSelectedRow();

        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUIDDeTb = vista.jtbHospedaje.getValueAt(filaSeleccionada, 0).toString();
            String NombreDeTB = vista.jtbHospedaje.getValueAt(filaSeleccionada, 1).toString();
            String EdadDeTb = vista.jtbHospedaje.getValueAt(filaSeleccionada, 2).toString();
            String EspecialidadDeTB = vista.jtbHospedaje.getValueAt(filaSeleccionada, 3).toString();

            // Establece los valores en los campos de texto
            vista.txtNombreH.setText(NombreDeTB);
            vista.txtPrecioH1.setText(EdadDeTb);
            vista.txtDescripcionH.setText(EspecialidadDeTB);
        }
    }
  
    
}
