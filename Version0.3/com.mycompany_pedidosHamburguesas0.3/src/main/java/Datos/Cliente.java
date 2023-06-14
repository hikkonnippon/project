
package Datos;

import java.util.Date;

public class Cliente {
    //Definiendo variables
    private String nom;
    private String cod;
    private Date fechaHora;
    
    //Creando el constructor
    public Cliente() {
    }

    public Cliente(String nom, String cod, Date fechaHora) {
        this.nom = nom;
        this.cod = cod;
        this.fechaHora = fechaHora;
    }
   
    //Creando los getters and setters
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCod() {
        return cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }
    public Date getFechaHora() {
        return fechaHora;
    }
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
}


