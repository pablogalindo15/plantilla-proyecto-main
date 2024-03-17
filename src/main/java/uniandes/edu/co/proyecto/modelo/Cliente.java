package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idCliente;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Usuario usuario;

    
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
        return idCliente;
    }
    public void setId(Integer id) {
        this.idCliente = id;
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
