/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.Cliente;
import Datos.DetallePedido;
import Datos.Pedido;
import Datos.Productos;
import Logica.N_Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author fabri
 */
public class N_DetallePedido {
    
    
    private Conexion SQL = new Conexion();
    private Connection cn = SQL.conectar();
    private N_Pedido nPedido;
    String sql="";
    
    
    public String generarCodigoDetallePedido(Date fechaHora, Pedido pedido) {
    // Crear un objeto SimpleDateFormat con el formato deseado
    SimpleDateFormat formato = new SimpleDateFormat("HHmmss");
    

    String letrasIniciales = pedido.getNumPedido().substring(0, 7);
    String detpedcodigo = "DET-" + letrasIniciales + formato.format(fechaHora);
    
    return detpedcodigo;
    }
    
    public boolean insertar(
            DetallePedido dts,
            Pedido ped, 
            Cliente cli, 
            Date fechaHora,
            Productos prod
    ) 
    {
    sql = "{call sp_guardar_detalle_pedido (?, ?, ?, ?, ?, ?)}";
    try {
        
        //Asignar codigo de detalle de pedido generado a una variable
        String detpedcodigo1 = generarCodigoDetallePedido(fechaHora, ped);
        dts.setDetCod(detpedcodigo1);
        
        
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, dts.getDetCod());
            pst.setString(2, ped.getNumPedido());
     
            pst.setString(3, prod.getIdProducto());
            pst.setInt(4, dts.getCant());
            pst.setDouble(5, dts.getImporteUnit());
            pst.setDouble(6, dts.getImporteTot());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    
    
}
