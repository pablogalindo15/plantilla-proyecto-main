package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Cuenta;
import java.util.Collection;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    @Query("SELECT c FROM Cuenta c WHERE c.idCuenta = :id")
    Cuenta findByIdCuenta(Integer id);

    @Query("SELECT c FROM Cuenta c WHERE c.idClienteFK.idCliente = :idCliente")
    Collection<Cuenta> findByClienteId(Integer idCliente);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Cuenta (tipoCuenta, numeroCuenta, estadoCuenta, idCliente, saldo) VALUES (:tipo, :numeroCuenta, :estado, :idClienteFK, :saldo)", nativeQuery = true)
    void insertarCuenta(String tipo, Integer numeroCuenta, String estado, Integer idClienteFK, Integer saldo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Cuenta SET tipoCuenta = :tipo, numeroCuenta = :numeroCuenta, estadoCuenta = :estado, idCliente = :idClienteFK, saldo = :saldo WHERE idCuenta = :id", nativeQuery = true)
    void actualizarCuenta(Integer id, String tipo, Integer numeroCuenta, String estado, Integer idClienteFK, Integer saldo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Cuenta WHERE idCuenta = :id", nativeQuery = true)
    void eliminarCuenta(Integer id);
}
