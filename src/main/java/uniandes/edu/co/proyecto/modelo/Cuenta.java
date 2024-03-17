package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;


@Entity
@Table(name="cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idCuenta;
    private String tipo;
    private Integer numeroCuenta;
    private String estado;
    private Integer saldo;

    @ManyToOne
    @JoinColumn(name="idClienteFK", referencedColumnName = "idCliente")
    private Cliente idClienteFK;

    public Cuenta( String tipo, Integer numeroCuenta, String estado, Cliente idClienteFK, Integer saldo) {
        this.tipo = tipo;
        this.numeroCuenta = numeroCuenta;
        this.estado = estado;
        this.idClienteFK= idClienteFK;
        this.saldo=saldo;
      
    }

    public Cuenta(){;}

    public Integer getId() {
        return idCuenta;
    }

    public void setId(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setIdClienteFK(Cliente idClienteFK) {
        this.idClienteFK = idClienteFK;
    }
    public Cliente getIdClienteFK() {
        return idClienteFK;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }
    
    

    
}
