/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author fabri
 */
public class N_Cliente {
    private Conexion SQL = new Conexion ();
    private Connection cn =SQL.conectar();
    String sql="";
    
    
    public DefaultTableModel mostrar (String buscar) {
        DefaultTableModel modelo;
        
        String[] titulos={"Cod. Cliente","Nombre","Fecha de ingreso"};
        modelo=new DefaultTableModel(null,titulos);
        String [] registro =new String[3];
        
        sql=("sp_buscar_cliente'"+buscar+"'");
        
        try {
            Statement st =cn.createStatement ();
            ResultSet rs =st.executeQuery(sql);
            
            while (rs.next()) {
                registro[0]=rs.getString(1);
                registro[1]=rs.getString(2);
                registro[2]=rs.getString(3);
                modelo.addRow(registro);
            }
            return modelo;
            
        }   catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
            
        }
        
    } 
    
    public String generarCodigoCliente(Date fechaHora) {
            // Crear un objeto SimpleDateFormat con el formato deseado
            SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmmss");

            // Generar el código utilizando las iniciales "CLI-" y la fecha y hora formateada
            String codigo = "CLI-" + formato.format(fechaHora);

            return codigo;
    }
        
    public boolean insertar(Cliente dts) {
        sql=("{call sp_guardar_clientes (?, ?, ?)}");
        
        try {
            // Obtener la fecha y hora actual
            Date fechaHoraActual = new Date();
        
            // Generar el código del cliente
        String codigoCliente = generarCodigoCliente(fechaHoraActual);

        // Asignar el código al objeto Cliente
        dts.setCod(codigoCliente);

        // Preparar la sentencia SQL
        sql = "{call sp_guardar_clientes (?, ?, ?)}";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, dts.getCod());
        pst.setString(2, dts.getNom());

        // Convertir java.util.Date a java.sql.Timestamp
        Timestamp timestamp = new Timestamp(fechaHoraActual.getTime());
        pst.setTimestamp(3, timestamp);

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
    
    public boolean editar(Cliente dts) {
        sql=("{call sp_editar_clientes (?, ?, ?)}");
        
        try {
            PreparedStatement pst =cn.prepareStatement(sql);
            pst.setString(1,dts.getCod());
            pst.setString(2,dts.getNom());
            
            // Convertir java.util.Date a java.sql.Date
            java.util.Date utilDate = dts.getFechaHora();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            pst.setDate(3, sqlDate);
            
            int n = pst.executeUpdate();
            
            if (n != 0){
                return true;
            } else {
                return false;
            }
                 
            
        }   catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
    
    public boolean eliminar(Cliente dts) {
    sql = ("{call sp_eliminar_cliente (?)}");

    try {
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, dts.getCod());

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

    
    public int generarcodcliente(){
        String sql =("select max(COD_CLI) as id from CLIENTE");
        int coddd = 0;
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if (rs.next()) {
                coddd=rs.getInt("id")+1;
            }
        } catch (SQLException el) {
            JOptionPane.showMessageDialog(null, "error slq:"+ el.getMessage());
            return coddd;
        }
        return 0;
    }
}
