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
    private String tipo;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private OperacionBancaria OperacionBancaria;

    @ManyToOne
    @JoinColumn(name="idCuentaFK", referencedColumnName = "idCuenta")
    private Cuenta idCuentaFK;

    

    private String tipoOperacionCuenta;

    public OperacionBancariaCuenta(String tipoOperacionCuenta, Cuenta idCuentaFK, String tipo) {
        this.tipoOperacionCuenta = tipoOperacionCuenta;
        this.idCuentaFK=idCuentaFK;
        this.tipo=tipo;
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

    public OperacionBancaria getOperacionBancaria() {
        return OperacionBancaria;
    }

    public void setOperacionBancaria(OperacionBancaria operacionBancaria) {
        OperacionBancaria = operacionBancaria;
    }

    public Cuenta getIdCuentaFK() {
        return idCuentaFK;
    }

    public void setIdCuentaFK(Cuenta idCuentaFK) {
        this.idCuentaFK = idCuentaFK;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    
    


//declaracion de variables
    
}
