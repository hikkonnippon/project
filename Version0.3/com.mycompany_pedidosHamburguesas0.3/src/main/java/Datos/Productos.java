/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author fabri
 */
public class Productos {
    private String idProducto;
    private String descripcion;
    private Double precioVenta;
    private String ingredientes;
    private String estadoProducto;
    private String codCate;

    public Productos(String idProducto, String descripcion, Double precioVenta, String ingredientes, String estadoProducto, String codCate) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.ingredientes = ingredientes;
        this.estadoProducto = estadoProducto;
        this.codCate = codCate;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public String getCodCate() {
        return codCate;
    }

    public void setCodCate(String codCate) {
        this.codCate = codCate;
    }
    
    
}
