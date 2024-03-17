package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.PuntoDeAtencion;

public interface PuntoDeAtencionRepository extends JpaRepository<PuntoDeAtencion, Integer> {
   

    @Query(value = "SELECT * FROM puntos_de_atencion", nativeQuery = true)
    Collection<PuntoDeAtencion> darPuntoDeAtencions();

    @Query(value = "SELECT * FROM puntos_de_atencion WHERE id = :id", nativeQuery = true)
    PuntoDeAtencion darPuntoDeAtencion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO puntos_de_atencion (tipo, idOficinaPK) VALUES (:tipo, :idOficinaPK)", nativeQuery = true)
    void insertarPuntoDeAtencion(@Param("tipo") String tipo, @Param("idOficinaPK") Integer idOficinaPK);

    @Modifying
    @Transactional
    @Query(value = "UPDATE puntos_de_atencion SET tipo= :tipo, idOficinaPK= :idOficinaPK WHERE id = :id", nativeQuery = true)
    void actualizarPuntoDeAtencion(@Param("tipo") String tipo, @Param("idOficinaPK") Integer idOficinaPk);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM puntos_de_atencion WHERE id = :id", nativeQuery = true)
    void eliminarPuntoDeAtencion(@Param("id") Integer id);
    
}
