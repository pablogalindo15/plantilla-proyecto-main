package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name="empleados")
public class Empleado {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Usuario usuario;
    
    private String cargo;

    public Empleado(String cargo){
        this.cargo=cargo;
    }

    public Empleado(){;}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
}
