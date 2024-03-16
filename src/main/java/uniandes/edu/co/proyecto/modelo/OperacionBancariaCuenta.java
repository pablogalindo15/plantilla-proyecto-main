package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
@Entity
@Table(name="operaciones_bancarias_cuentas")
public class OperacionBancariaCuenta {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @PrimaryKeyJoinColumn
    private OperacionBancaria OperacionBancaria;

    private String tipoOperacionCuenta;

    public OperacionBancariaCuenta(String tipoOperacionCuenta) {
        this.tipoOperacionCuenta = tipoOperacionCuenta;
    }

    public OperacionBancariaCuenta(){;}

    public Integer getId() {
        return id;
    }

    public String getTipoOperacionCuenta() {
        return tipoOperacionCuenta;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTipoOperacionCuenta(String tipoOperacionCuenta) {
        this.tipoOperacionCuenta = tipoOperacionCuenta;
    }
    
    


//declaracion de variables
    
}
