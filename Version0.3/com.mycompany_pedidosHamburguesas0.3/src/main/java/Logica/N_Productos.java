package Logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Datos.Productos;

public class N_Productos {
    
    private Conexion SQL = new Conexion();
    private Connection cn = SQL.conectar();
    String sql = "";
    
    public boolean obtenerDatosProductos() {
        sql = "SELECT * FROM PRODUCTO";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                String idProducto = rs.getString("ID_PRODUCTO");
                String descripcion = rs.getString("DESCRIPCION");
                double precioVenta = rs.getDouble("PRECIO_VENTA");
                String ingredientes = rs.getString("INGREDIENTES");
                String estadoProducto = rs.getString("ESTADO_PRODUCTO");
                String codCategoria = rs.getString("COD_CATE");
                
                
                
                // Asignar los valores a las variables que necesites o realizar cualquier otra acción
                Productos producto = new Productos(idProducto, descripcion, precioVenta, ingredientes, estadoProducto, codCategoria);
                producto.setIdProducto(idProducto);
                producto.setDescripcion(descripcion);
                producto.setPrecioVenta(precioVenta);
                producto.setIngredientes(ingredientes);
                producto.setEstadoProducto(estadoProducto);
                producto.setCodCate(codCategoria);
                
                
            }
            
            rs.close();
            st.close();
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
}
