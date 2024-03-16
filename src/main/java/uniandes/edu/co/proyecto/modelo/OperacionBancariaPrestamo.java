package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="operaciones_bancarias_prestamos")
public class OperacionBancariaPrestamo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private String tipo;

    public OperacionBancariaPrestamo(String tipo) {
        this.tipo = tipo;
    }

    public OperacionBancariaPrestamo(){;}

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
