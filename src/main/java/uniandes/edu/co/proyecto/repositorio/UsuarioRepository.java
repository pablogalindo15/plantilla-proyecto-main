package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Usuario;
import java.util.Collection;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM usuarios", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT * FROM usuarios WHERE id = :id", nativeQuery = true)
    Usuario darUsuario(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (numeroDocumento, tipoDocumento, nombre, direccionFisica, direccionElectronica, telefono, ciudad, clave, login, nacionalidad, departamento, codigoPostal) VALUES (:numeroDocumento, :tipoDocumento, :nombre, :direccionFisica, :direccionElectronica, :telefono, :ciudad, :clave, :login, :nacionalidad, :departamento, :codigoPostal)", nativeQuery = true)
    void insertarUsuario(@Param("numeroDocumento") Integer numeroDocumento, @Param("tipoDocumento") String tipoDocumento, @Param("nombre") String nombre, @Param("direccionFisica") String direccionFisica, @Param("direccionElectronica") String direccionElectronica, @Param("telefono") Integer telefono, @Param("ciudad") String ciudad, @Param("clave") String clave, @Param("login") String login, @Param("nacionalidad") String nacionalidad, @Param("departamento") String departamento, @Param("codigoPostal") String codigoPostal);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET numeroDocumento = :numeroDocumento, tipoDocumento = :tipoDocumento, nombre = :nombre, direccionFisica = :direccionFisica, direccionElectronica = :direccionElectronica, telefono = :telefono, ciudad = :ciudad, clave = :clave, login = :login, nacionalidad = :nacionalidad, departamento = :departamento, codigoPostal = :codigoPostal WHERE id = :id", nativeQuery = true)
    void actualizarUsuario(@Param("id") Integer id, @Param("numeroDocumento") Integer numeroDocumento, @Param("tipoDocumento") String tipoDocumento, @Param("nombre") String nombre, @Param("direccionFisica") String direccionFisica, @Param("direccionElectronica") String direccionElectronica, @Param("telefono") Integer telefono, @Param("ciudad") String ciudad, @Param("clave") String clave, @Param("login") String login, @Param("nacionalidad") String nacionalidad, @Param("departamento") String departamento, @Param("codigoPostal") String codigoPostal);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE id = :id", nativeQuery = true)
    void eliminarUsuario(@Param("id") Integer id);
}
