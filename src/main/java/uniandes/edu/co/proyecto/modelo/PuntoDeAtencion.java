package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="puntos_de_atencion")

public class PuntoDeAtencion {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    
//Declaracion de Variables
    private Integer id;
    private String tipo;

//Constructor
    public PuntoDeAtencion(String tipo){
        this.tipo=tipo;
    }
//Constructor Vacio
    public PuntoDeAtencion(){;}

//Getters y setters
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

    

}
