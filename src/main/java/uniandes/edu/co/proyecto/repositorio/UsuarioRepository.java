package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Usuario;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Utiliza consultas nativas para obtener todos los usuarios.
    // Considera cambiar a JPQL o métodos derivados del nombre si no necesitas especificidades de una consulta nativa.
    @Query(value = "SELECT * FROM usuarios", nativeQuery = true)
    List<Usuario> darUsuarios();

    // Obtiene un usuario por su ID utilizando una consulta nativa.
    @Query(value = "SELECT * FROM usuarios WHERE id = :id", nativeQuery = true)
    Usuario darUsuario(@Param("id") int id);

    // Inserta un nuevo usuario en la base de datos. 
    // La anotación @Transactional asegura que la operación se maneje dentro de una transacción.
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (numeroDocumento, tipoDocumento, nombre, direccionFisica, direccionElectronica, telefono, ciudad, clave, login, nacionalidad, departamento, codigoPostal) VALUES (:numeroDocumento, :tipoDocumento, :nombre, :direccionFisica, :direccionElectronica, :telefono, :ciudad, :clave, :login, :nacionalidad, :departamento, :codigoPostal)", nativeQuery = true)
    void insertarUsuario(@Param("numeroDocumento") Integer numeroDocumento, @Param("tipoDocumento") String tipoDocumento, @Param("nombre") String nombre, @Param("direccionFisica") String direccionFisica, @Param("direccionElectronica") String direccionElectronica, @Param("telefono") Integer telefono, @Param("ciudad") String ciudad, @Param("clave") String clave, @Param("login") String login, @Param("nacionalidad") String nacionalidad, @Param("departamento") String departamento, @Param("codigoPostal") String codigoPostal);

    // Actualiza un usuario existente. La operación es transaccional.
    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET numeroDocumento = :numeroDocumento, tipoDocumento = :tipoDocumento, nombre = :nombre, direccionFisica = :direccionFisica, direccionElectronica = :direccionElectronica, telefono = :telefono, ciudad = :ciudad, clave = :clave, login = :login, nacionalidad = :nacionalidad, departamento = :departamento, codigoPostal = :codigoPostal WHERE id = :id", nativeQuery = true)
    void actualizarUsuario(@Param("id") Integer id, @Param("numeroDocumento") Integer numeroDocumento, @Param("tipoDocumento") String tipoDocumento, @Param("nombre") String nombre, @Param("direccionFisica") String direccionFisica, @Param("direccionElectronica") String direccionElectronica, @Param("telefono") Integer telefono, @Param("ciudad") String ciudad, @Param("clave") String clave, @Param("login") String login, @Param("nacionalidad") String nacionalidad, @Param("departamento") String departamento, @Param("codigoPostal") String codigoPostal);

    // Elimina un usuario por su ID. La anotación @Transactional garantiza la integridad de la operación.
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE id = :id", nativeQuery = true)
    void eliminarUsuario(@Param("id") Integer id);
}
