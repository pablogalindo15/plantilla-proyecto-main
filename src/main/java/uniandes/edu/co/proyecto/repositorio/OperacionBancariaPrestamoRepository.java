package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.OperacionBancariaPrestamo;

public interface OperacionBancariaPrestamoRepository extends JpaRepository<OperacionBancariaPrestamo, Integer> {
    @Query(value = "SELECT operaciones_bancarias_prestamos.id AS operacionBancariaPrestamo_id, operaciones_bancarias_prestamos.tipo, operaciones_bancarias.nombre AS usuario_nombre " +
                   "FROM operaciones_bancarias_prestamos INNER JOIN operaciones_bancarias ON operaciones_bancarias_prestamos.id = operaciones_bancarias.id", nativeQuery = true)
    Collection<OperacionBancariaPrestamo> darOperacionBancariaPrestamos();

    @Query(value = "SELECT operaciones_bancarias_prestamos.id AS operacionBancariaPrestamo_id, operaciones_bancarias_prestamos.tipo, operaciones_bancarias.id AS usuario_id " +
                   "FROM operaciones_bancarias_prestamos INNER JOIN operaciones_bancarias ON operaciones_bancarias_prestamos.id = operaciones_bancarias.id WHERE operaciones_bancarias_prestamos.id = :id", nativeQuery = true)
    OperacionBancariaPrestamo daroperacionBancariaPrestamo(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO operaciones_bancarias_prestamos (id, tipo, idPrestamoFK) VALUES (idoperaciones_bancarias_prestamos.nextval, :tipo, :idPrestamoFK)", nativeQuery = true)
    void insertaroperacionBancariaPrestamo(@Param("tipo") String tipo, @Param("idPrestamoFK") Integer idPrestamoFK);


    @Modifying
    @Transactional
    @Query(value = "UPDATE operaciones_bancarias_prestamos SET tipo = :tipo, idPrestamoFK = :idPrestamoFK WHERE id = :id;" +
                   "UPDATE operaciones_bancarias SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizaroperacionBancariaPrestamo(@Param("tipo") String tipo, @Param("idPrestamoFK") Integer idPrestamoFK, @Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM operaciones_bancarias_prestamos WHERE id = :id;" +
                   "DELETE FROM operaciones_bancarias WHERE id = :id", nativeQuery = true)
    void eliminaroperacionBancariaPrestamo(@Param("id") Integer id);
}
