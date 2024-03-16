package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;


@Entity
@Table(name="Cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private String tipo;
    private Integer numeroCuenta;
    private Cliente cliente; 
    private String estado;

    

    public Cuenta( String tipo, Integer numeroCuenta, Cliente cliente, String estado) {
        this.tipo = tipo;
        this.numeroCuenta = numeroCuenta;
        this.cliente = cliente;
        this.estado = estado;
    }

    public Cuenta(){;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

    
}
