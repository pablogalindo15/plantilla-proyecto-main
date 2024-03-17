package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="operaciones_bancarias")
public class OperacionBancaria {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
//declaracion de variables
    private Integer id;

    @ManyToOne
    @JoinColumn(name="idClienteFK", referencedColumnName = "idCliente")
    private Cliente idClienteFK;

    private Integer valor;
    private String fecha;

//Constructor
    public OperacionBancaria(Integer id, String tipoOperacion, Integer valor, String fecha, Cliente idClienteFK) {
        this.id = id;
        this.valor = valor;
        this.fecha = fecha;
        this.idClienteFK=idClienteFK;
    }
//Contructor vacio
    public OperacionBancaria(){;}


//getter y setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getValor() {
        return valor;
    }
    public void setValor(Integer valor) {
        this.valor = valor;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public Cliente getIdClienteFK() {
        return idClienteFK;
    }
    public void setIdClienteFK(Cliente idClienteFK) {
        this.idClienteFK = idClienteFK;
    }

    

    
}
