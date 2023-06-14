/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.Cliente;
import Datos.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author fabri
 */
public class N_Pedido {
    
    private Conexion SQL = new Conexion();
    private Connection cn = SQL.conectar();
    
    String sql="";
    
    public String generarNumeroPedido(Date fechaHora, Cliente cliente) {
    // Crear un objeto SimpleDateFormat con el formato deseado
    SimpleDateFormat formato = new SimpleDateFormat("HHmmss");

    String letrasIniciales = cliente.getNom().substring(0, 3);
    String pedcodigo = "PED-" + letrasIniciales + formato.format(fechaHora);

            return pedcodigo;
        }
    
    public boolean insertar(Pedido dts, Cliente cli, Date fechaHora) {
        sql=("{call sp_guardar_clientes (?, ?, ?)}");

        try {
            
        // Obtener la fecha y hora actual
        Date fechaHoraActual = new Date();
        
        // Generar el código numero de pedido
        String numeroPedido = generarNumeroPedido(fechaHora, cli);

        // Asignar el código al objeto Pedido
        dts.setNumPedido(numeroPedido);

        // Preparar la sentencia SQL
        sql = "{call sp_guardar_clientes (?, ?, ?)}";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, dts.getNumPedido());
        
        // Convertir java.util.Date a java.sql.Timestamp
        Timestamp timestamp = new Timestamp(fechaHoraActual.getTime());
        pst.setTimestamp(2, timestamp);
        pst.setString(3, cli.getCod());
        
        int n = pst.executeUpdate();

        if (n != 0) {
            return true;
        } else {
            return false;
        }
        } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);
        return false;
        }
    }
}
