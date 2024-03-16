package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="prestamos")
public class Prestamo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
//declaracion variables
    private Integer id;
    private Integer monto;
    private Integer interes;
    private Integer numeroCuotas;
    private String diaPagoCuotas;
    private String estado;
    private String tipo;

//Constructor 
    public Prestamo(Integer monto, Integer interes, Integer numeroCuotas, String diaPagoCuotas, String estado, String tipo ){
        this.monto=monto;
        this.interes=interes;
        this.numeroCuotas=numeroCuotas;
        this.diaPagoCuotas = diaPagoCuotas;
        this.estado=estado;
        this.tipo=tipo;
    }
//Constructor vacio
    public Prestamo(){;}

//Getters y setters 
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getMonto() {
        return monto;
    }
    public void setMonto(Integer monto) {
        this.monto = monto;
    }
    public Integer getInteres() {
        return interes;
    }
    public void setInteres(Integer interes) {
        this.interes = interes;
    }
    public Integer getNumeroCuotas() {
        return numeroCuotas;
    }
    public void setNumeroCuotas(Integer numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }
    public String getDiaPagoCuotas() {
        return diaPagoCuotas;
    }
    public void setDiaPagoCuotas(String diaPagoCuotas) {
        this.diaPagoCuotas = diaPagoCuotas;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    


    
}
