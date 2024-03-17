package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.OperacionBancariaCuenta;

public interface OperacionBancariaCuentaRepository extends JpaRepository<OperacionBancariaCuenta, Integer> {
    @Query(value = "SELECT operaciones_bancarias_cuentas.id AS operacionBancariaCuenta_id, operaciones_bancarias_cuentas.tipo, operaciones_bancarias.nombre AS usuario_nombre " +
                   "FROM operaciones_bancarias_cuentas INNER JOIN operaciones_bancarias ON operaciones_bancarias_cuentas.id = operaciones_bancarias.id", nativeQuery = true)
    Collection<OperacionBancariaCuenta> darOperacionBancariaCuentas();

    @Query(value = "SELECT operaciones_bancarias_cuentas.id AS operacionBancariaCuenta_id, operaciones_bancarias_cuentas.tipo, operaciones_bancarias.id AS usuario_id " +
                   "FROM operaciones_bancarias_cuentas INNER JOIN operaciones_bancarias ON operaciones_bancarias_cuentas.id = operaciones_bancarias.id WHERE operaciones_bancarias_cuentas.id = :id", nativeQuery = true)
    OperacionBancariaCuenta daroperacionBancariaCuenta(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO operaciones_bancarias_cuentas (id, tipo, idCuentaFK) VALUES (idoperaciones_bancarias_cuentas.nextval, :tipo, :idCuentaFK)", nativeQuery = true)
    void insertaroperacionBancariaCuenta(@Param("tipo") String tipo, @Param("idCuentaFK") Integer idCuentaFK);


    @Modifying
    @Transactional
    @Query(value = "UPDATE operaciones_bancarias_cuentas SET tipo = :tipo, idCuentaFK = :idCuentaFK WHERE id = :id;" +
                   "UPDATE operaciones_bancarias SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizaroperacionBancariaCuenta(@Param("tipo") String tipo, @Param("idCuentaFK") Integer idCuentaFK, @Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM operaciones_bancarias_cuentas WHERE id = :id;" +
                   "DELETE FROM operaciones_bancarias WHERE id = :id", nativeQuery = true)
    void eliminaroperacionBancariaCuenta(@Param("id") Integer id);
}
