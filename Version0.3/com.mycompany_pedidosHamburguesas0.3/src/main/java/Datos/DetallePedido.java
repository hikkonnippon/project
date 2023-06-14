/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author fabri
 */
public class DetallePedido {
    private String detCod;
    private String numPedido;
    private String idProducto;
    private int cant;
    private double importeUnit;
    private double importeTot;

    public DetallePedido(String detCod, String numPedido, String idProducto, int cant, double importeUnit, double importeTot) {
        this.detCod = detCod;
        this.numPedido = numPedido;
        this.idProducto = idProducto;
        this.cant = cant;
        this.importeUnit = importeUnit;
        this.importeTot = importeTot;
    }

    public String getDetCod() {
        return detCod;
    }

    public void setDetCod(String detCod) {
        this.detCod = detCod;
    }

    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getImporteUnit() {
        return importeUnit;
    }

    public void setImporteUnit(double importeUnit) {
        this.importeUnit = importeUnit;
    }

    public double getImporteTot() {
        return importeTot;
    }

    public void setImporteTot(double importeTot) {
        this.importeTot = importeTot;
    }

    

}
