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
@Table (name="operaciones_bancarias_prestamos")
public class OperacionBancariaPrestamo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private OperacionBancaria OperacionBancaria;
    
    private String tipo;

    @ManyToOne
    @JoinColumn(name="idPrestamoFK", referencedColumnName = "idPrestamo")
    private Prestamo idPrestamoFK;


    public OperacionBancariaPrestamo(String tipo, Prestamo idPrestamoFK) {
        this.tipo = tipo;
        this.idPrestamoFK=idPrestamoFK;
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

    public OperacionBancaria getOperacionBancaria() {
        return OperacionBancaria;
    }

    public void setOperacionBancaria(OperacionBancaria operacionBancaria) {
        OperacionBancaria = operacionBancaria;
    }

    public Prestamo getIdPrestamoFK() {
        return idPrestamoFK;
    }

    public void setIdPrestamoFK(Prestamo idPrestamoFK) {
        this.idPrestamoFK = idPrestamoFK;
    }

    
    





    
}
