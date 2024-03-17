package uniandes.edu.co.proyecto.repositorio;

import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Cuenta;
import java.util.Collection;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
    @Query(value = "SELECT * from cuentas", nativeQuery = true)
    Collection<Cuenta> darCuentas();

    @Query("SELECT * FROM cuentas WHERE idCuenta = :idCuenta")
    Cuenta darCuenta(@Param("idCuenta") int idCuenta);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentas (tipo, numeroCuenta, estado, idClienteFK, saldo) VALUES (:tipo, :numeroCuenta, :estado, :idClienteFK, :saldo)", nativeQuery = true)
    void insertarCuenta(@Param("tipo") String tipo, @Param("numeroCuenta") Integer numeroCuenta, @Param("estado") String estado, @Param("idClienteFK") Cliente idClienteFK, @Param("saldo") Integer saldo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentas SET tipo = :tipo, numeroCuenta = :numeroCuenta, estado = :estado, idClienteFK = :idClienteFK, saldo = :saldo WHERE idCuenta = :idCuenta", nativeQuery = true)
    void actualizarCuenta(@Param("tipo") String tipo, @Param("numeroCuenta") Integer numeroCuenta, @Param("estado") String estado, @Param("idClienteFK") Cliente idClienteFK, @Param("saldo") Integer saldo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentas WHERE idCuenta = :idCuenta", nativeQuery = true)
    void eliminarCuenta(@Param("idCuenta") Integer idCuenta);
}
