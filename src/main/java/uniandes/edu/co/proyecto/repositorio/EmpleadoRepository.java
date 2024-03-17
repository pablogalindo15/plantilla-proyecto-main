package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    
    @Query(value = "SELECT empleados.id AS empleado_id, empleados.cargo, usuarios.nombre AS usuario_nombre " +
                   "FROM empleados INNER JOIN usuarios ON empleados.id = usuarios.id", nativeQuery = true)
    Collection<Empleado> darEmpleados();

    @Query(value = "SELECT empleados.id AS empleado_id, empleados.cargo, usuarios.id AS usuario_id " +
                   "FROM empleados INNER JOIN usuarios ON empleados.id = usuarios.id WHERE empleados.id = :idEmpleado", nativeQuery = true)
    Empleado darEmpleado(@Param("idEmpleado") Integer idEmpleado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO empleados (idEmpleado, cargo, idOficinaFK) VALUES (idUsuarios.nextval, :cargo, :idOficinaFK);" +
                   "INSERT INTO usuarios (idEmpleado, nombre) VALUES (idUsuarios.CURRVAL, :nombre)", nativeQuery = true)
    void insertarEmpleado(@Param("cargo") String cargo, @Param("idOficinaFK") Integer idOficinaFK, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE empleados SET cargo = :cargo, idOficinaFK = :idOficinaFK WHERE id = :id;" +
                   "UPDATE usuarios SET nombre = :nombre WHERE idEmpleado = :idEmpleado", nativeQuery = true)
    void actualizarEmpleado(@Param("cargo") String cargo, @Param("idOficinaFK") Integer idOficinaFK, @Param("nombre") String nombre, @Param("idEmpleado") Integer idEmpleado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM empleados WHERE idEmpleado = :idEmpleado;" +
                   "DELETE FROM usuarios WHERE idEmpleado = :idEmpleado", nativeQuery = true)
    void eliminarEmpleado(@Param("id") Integer id);
}
