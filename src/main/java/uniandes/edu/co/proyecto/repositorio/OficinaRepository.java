package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Oficina;
import java.util.Collection;

public interface OficinaRepository extends JpaRepository<Oficina, Integer> {

    @Query(value = "SELECT * FROM oficinas", nativeQuery = true)
    Collection<Oficina> darOficinas();

    @Query(value = "SELECT * FROM oficinas WHERE idOficina = :id", nativeQuery = true)
    Oficina darOficina(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO oficinas (nombre, direccion, numeroPuntosAtencion) VALUES (:nombre, :direccion, :numeroPuntosAtencion)", nativeQuery = true)
    void insertarOficina(@Param("nombre") String nombre, @Param("direccion") String direccion, @Param("numeroPuntosAtencion") Integer numeroPuntosAtencion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE oficinas SET nombre = :nombre, direccion = :direccion, numeroPuntosAtencion = :numeroPuntosAtencion WHERE idOficina = :id", nativeQuery = true)
    void actualizarOficina(@Param("id") Integer id, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("numeroPuntosAtencion") Integer numeroPuntosAtencion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM oficinas WHERE idOficina = :id", nativeQuery = true)
    void eliminarOficina(@Param("id") Integer id);
}
