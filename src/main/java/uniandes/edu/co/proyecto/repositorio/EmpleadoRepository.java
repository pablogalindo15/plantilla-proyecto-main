package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    @Query(value = "SELECT empleados.*, usuarios.nombre FROM empleados INNER JOIN usuarios ON empleados.id = usuarios.id", nativeQuery = true)
    Collection<Empleado> darEmpleados();

    @Query(value = "SELECT empleados.*, usuarios.id FROM empleados INNER JOIN usuarios ON empleados.id = usuarios.id WHERE id = :id", nativeQuery = true)
    Empleado darEmpleado(@Param("idEmpleado") Integer idEmpleado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO empleados VALUES (idUsuarios.nextval, :cargo, :idOficina);" +
                    "INSERT INTO usuarios VALUES ((SELECT idUsuarios.CURRVAL FROM DUAL), :nombre)", nativeQuery = true)
    void insertarEmpleado(@Param("cargo") String cargo, @Param("idOficina") Integer idOficina);

    @Modifying
    @Transactional
    @Query(value = "UPDATE empleados SET cargo= : cargo, idOficina = :idOficina  WHERE idEmpleado = :idEmpleado;" +
                    "UPDATE usuarios SET nombre = :nombre WHERE idEmpleado = :idEmpleado", nativeQuery = true)
    void actualizarEmpleado(@Param("cargo") String cargo, @Param("idOficina") Integer idOficina);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM empleados WHERE idEmpleado = :idEmpleado;" +
                    "DELETE FROM usuarios WHERE idEmpleado = :idEmpleado", nativeQuery = true)
    void eliminarEmpleado(@Param("idEmpleado") Integer idEmpleado);
}