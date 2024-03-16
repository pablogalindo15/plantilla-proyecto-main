package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private Cuenta cuentaDestino;

//Constructor
    public Transferencia(Cuenta cuentaDestino){
        this.cuentaDestino=cuentaDestino;
    }

//Constructoir vacio
    public Transferencia(){;}

//Getters y Setters
    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    
}
