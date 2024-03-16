package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente extends Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
     
    private Integer id;
    private String tipoCliente;
    private String estadoCliente;

    //contrsuctor
    public Cliente(String tipoCliente, String estadoCliente){
        this.tipoCliente=tipoCliente;
        this.estadoCliente=estadoCliente;
    }

    //constructor vacio
    public Cliente(){;}

    //getters y setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTipoCliente() {
        return tipoCliente;
    }
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    public String getEstadoCliente() {
        return estadoCliente;
    }
    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }    
    

    
}
