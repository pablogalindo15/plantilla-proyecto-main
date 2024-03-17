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
                   "FROM empleados INNER JOIN usuarios ON empleados.id = usuarios.id WHERE empleados.id = :id", nativeQuery = true)
    Empleado darEmpleado(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO empleados (id, cargo, idOficina) VALUES (idUsuarios.nextval, :cargo, :idOficina);" +
                   "INSERT INTO usuarios (id, nombre) VALUES (idUsuarios.CURRVAL, :nombre)", nativeQuery = true)
    void insertarEmpleado(@Param("cargo") String cargo, @Param("idOficina") Integer idOficina, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE empleados SET cargo = :cargo, idOficina = :idOficina WHERE id = :id;" +
                   "UPDATE usuarios SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarEmpleado(@Param("cargo") String cargo, @Param("idOficina") Integer idOficina, @Param("nombre") String nombre, @Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM empleados WHERE id = :id;" +
                   "DELETE FROM usuarios WHERE id = :id", nativeQuery = true)
    void eliminarEmpleado(@Param("id") Integer id);
}
