package uniandes.edu.co.proyecto.repositorio;

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

    @Query(value = "SELECT * FROM prestamos WHERE id = :id", nativeQuery = true)
    Prestamo darPrestamo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO prestamos (monto, interes, numeroCuotas, estado, tipo, idClienteFK) VALUES (:monto, :interes, :numeroCuotas, :estado, :tipo, :idClienteFK)", nativeQuery = true)
    void insertarPrestamo(@Param("monto") Integer monto, @Param("interes") Integer interes, @Param("numeroCuotas") Integer numeroCuotas, @Param("estado") String estado, @Param("tipo") String tipo, @Param("idClienteFK") Integer idClienteFK);

    @Modifying
    @Transactional
    @Query(value = "UPDATE prestamos SET monto= :monto, interes= :interes, numeroCuotas= :numeroCuotas, estado= :estado, tipo= :tipo, idClienteFK= :idClienteFK WHERE id = :id", nativeQuery = true)
    void actualizarPrestamo(@Param("monto") Integer monto, @Param("interes") Integer interes, @Param("numeroCuotas") Integer numeroCuotas, @Param("estado") String estado, @Param("tipo") String tipo, @Param("idClienteFK") Integer idClienteFK);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM prestamos WHERE id = :id", nativeQuery = true)
    void eliminarPrestamo(@Param("id") Integer id);
}
