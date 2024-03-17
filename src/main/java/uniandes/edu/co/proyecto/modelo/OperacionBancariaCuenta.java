package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    private String tipo;

    @ManyToOne
    @JoinColumn(name="idCuentaFK", referencedColumnName = "idCuenta")
    private Integer idCuentaFK;


    public OperacionBancariaCuenta(String tipo, Integer idCuentaFK) {
        this.tipo = tipo;
        this.idCuentaFK= idCuentaFK;
    }

    public Integer getIdCuentaFK() {
        return idCuentaFK;
    }

    public void setIdCuentaFK(Integer idCuentaFK) {
        this.idCuentaFK = idCuentaFK;
    }

    public OperacionBancariaCuenta(){;}

    public Integer getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    


//declaracion de variables
    
}
