package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
    @Query(value = "SELECT * FROM prestamos", nativeQuery = true)
    Collection<Prestamo> darPrestamos();

    @Query(value = "SELECT * FROM prestamos WHERE idPrestamo = :idPrestamo", nativeQuery = true)
    Prestamo darPrestamo(@Param("idPrestamo") int idPrestamo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO prestamos (monto, interes, numeroCuotas,diaPagoCuotas, estado, tipo, idClienteFK) VALUES (:monto, :interes, :numeroCuotas, :diaPagoCuotas, :estado, :tipo, :idClienteFK)", nativeQuery = true)
    void insertarPrestamo(@Param("monto") Integer monto, @Param("interes") Integer interes, @Param("numeroCuotas") Integer numeroCuotas, @Param("diaPagoCuotas") Date diaPagoCuotas,@Param("estado") String estado, @Param("tipo") String tipo, @Param("idClienteFK") Integer idClienteFK);

    @Modifying
    @Transactional
    @Query(value = "UPDATE prestamos SET monto= :monto, interes= :interes, numeroCuotas= :numeroCuotas, diaPagoCuotas = :diaPagoCuotas, estado= :estado, tipo= :tipo, idClienteFK= :idClienteFK WHERE idPrestamo = :idPrestamo", nativeQuery = true)
    void actualizarPrestamo(@Param("monto") Integer monto, @Param("interes") Integer interes, @Param("numeroCuotas") Integer numeroCuotas, @Param("diaPagoCuotas") Date diaPagoCuotas,@Param("estado") String estado, @Param("tipo") String tipo, @Param("idClienteFK") Integer idClienteFK);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM prestamos WHERE idPrestamo = :idPrestamo", nativeQuery = true)
    void eliminarPrestamo(@Param("idPrestamo") Integer idPrestamo);
}
