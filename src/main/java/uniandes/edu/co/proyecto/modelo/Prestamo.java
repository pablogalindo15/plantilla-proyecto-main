package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="prestamos")
public class Prestamo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
//declaracion variables
    private Integer idPrestamo;
    private Integer monto;
    private Integer interes;
    private Integer numeroCuotas;
    private Date diaPagoCuotas;
    private String estado;
    private String tipo;

    @ManyToOne
    @JoinColumn(name="idClienteFK", referencedColumnName = "idCliente")
    private Cliente idClienteFK;

//Constructor 
    public Prestamo(Integer monto, Integer interes, Integer numeroCuotas, Date diaPagoCuotas, String estado, String tipo, Cliente idClienteFK ){
        this.monto=monto;
        this.interes=interes;
        this.numeroCuotas=numeroCuotas;
        this.diaPagoCuotas = diaPagoCuotas;
        this.estado=estado;
        this.tipo=tipo;
        this.idClienteFK = idClienteFK;
    }
    
//Constructor vacio

public Prestamo() {}

    //Getters y setters 
    public Integer getId() {
        return idPrestamo;
    }
    public void setId(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
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
    public Date getDiaPagoCuotas() {
        return diaPagoCuotas;
    }
    public void setDiaPagoCuotas(Date diaPagoCuotas) {
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
    public void setIdClienteFK(Cliente idClienteFK) {
        this.idClienteFK = idClienteFK;
    }
    public Cliente getIdClienteFK() {
        return idClienteFK;
    }


    


    
}
