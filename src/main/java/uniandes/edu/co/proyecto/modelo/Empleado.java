package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="empleados")
public class Empleado {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idEmpleado;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Usuario usuario;
    
    private String cargo;
    @ManyToOne
    @JoinColumn(name="idOficinaFK", referencedColumnName = "idOficina")
    private Oficina idOficinaFK;



    public Empleado(String cargo, Oficina idOficinaFK){
        this.cargo=cargo;
        this.idOficinaFK=idOficinaFK;
    }

    public Empleado(){;}
    
    public Oficina getIdOficinaFK() {
        return idOficinaFK;
    }

    public void setIdOficinaFK(Oficina idOficinaFK) {
        this.idOficinaFK = idOficinaFK;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
}
