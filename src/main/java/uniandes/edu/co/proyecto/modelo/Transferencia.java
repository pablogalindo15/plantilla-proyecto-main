package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name="transferencias")

public class Transferencia {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
//Declaracion de variables
    private Integer id;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private OperacionBancariaCuenta OperacionBancariaCuenta;

    private Integer cuentaDestino;

//Constructor
    public Transferencia(Integer cuentaDestino){
        this.cuentaDestino=cuentaDestino;}

//Constructoir vacio
    public Transferencia(){;}

//Getters y Setters
    public Integer getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Integer cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    
}
