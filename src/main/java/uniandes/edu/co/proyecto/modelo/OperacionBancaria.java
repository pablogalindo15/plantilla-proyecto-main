package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="OperacionesBancarias")
public class OperacionBancaria {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
//declaracion de variables
    private Integer id;
    private String tipoOperacion;
    private Integer valor;
    private String fecha;

//Constructor
    public OperacionBancaria(Integer id, String tipoOperacion, Integer valor, String fecha) {
        this.id = id;
        this.tipoOperacion = tipoOperacion;
        this.valor = valor;
        this.fecha = fecha;
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
    public String getTipoOperacion() {
        return tipoOperacion;
    }
    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
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



    
}
