package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name="oficinas")

public class Oficina {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

//declaracion de variables
    private Integer id;
    private String nombre;
    private String direccion;
    private Integer numeroPuntoAtencion;

//Constructor
    public Oficina(String nombre, String direccion, Integer numeroPuntoAtencion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroPuntoAtencion = numeroPuntoAtencion;
    }
//Constructor vacio
    public Oficina(){;}

//Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getNumeroPuntoAtencion() {
        return numeroPuntoAtencion;
    }

    public void setNumeroPuntoAtencion(Integer numeroPuntoAtencion) {
        this.numeroPuntoAtencion = numeroPuntoAtencion;
    }

    

    
    
    
}
