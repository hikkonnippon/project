package Logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Datos.Productos;
import java.util.ArrayList;
import java.util.List;

public class menu {
    
    private Conexion SQL = new Conexion();
    private Connection cn = SQL.conectar();
    String sql = "";
    
    public List<Productos> obtenerRegistrosProductos() {
        List<Productos> productos = new ArrayList<>();
        sql = "SELECT * FROM PRODUCTO";
        
        try (Statement stmt = cn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                String idProducto = rs.getString("ID_PRODUCTO");
                String descripcion = rs.getString("DESCRIPCION");
                double precioVenta = rs.getDouble("PRECIO_VENTA");
                String ingredientes = rs.getString("INGREDIENTES");
                String estadoProducto = rs.getString("ESTADO_PRODUCTO");
                String codCategoria = rs.getString("COD_CATE");
                
                Productos producto = new Productos(idProducto, descripcion, precioVenta, ingredientes, estadoProducto, codCategoria);
                productos.add(producto);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return productos;
    }
    
    public static void main(String[] args) {
        menu menu = new menu();
        List<Productos> productos = menu.obtenerRegistrosProductos();
        
        for (Productos producto : productos) {
            System.out.println("ID: " + producto.getIdProducto());
            System.out.println("Descripción: " + producto.getDescripcion());
            System.out.println("Precio de venta: " + producto.getPrecioVenta());
            // Imprimir los demás atributos según necesites
            System.out.println("------------------------------------");
        }
    }
}
