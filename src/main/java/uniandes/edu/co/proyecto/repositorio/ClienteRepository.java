package uniandes.edu.co.proyecto.repositorio;
import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(value = "SELECT clientes.*, usuarios.nombre FROM clientes INNER JOIN usuarios ON clientes.id = usuarios.id", nativeQuery = true)
    Collection<Cliente> darClientes();

    @Query(value = "SELECT clientes.*, usuarios.id FROM clientes INNER JOIN usuarios ON clientes.id = usuarios.id WHERE id = :id", nativeQuery = true)
    Cliente darCliente(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO clientes VALUES (idUsuarios.nextval, :capacidad, :profundidad, :horaInicio, :horaFin, :costoAdicional);" +
                    "INSERT INTO usuarios VALUES ((SELECT idUsuarios.CURRVAL FROM DUAL), :nombre)", nativeQuery = true)
    void insertarCliente(@Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("profundidad") Integer profundidad, @Param("horaInicio") Date horaInicio, @Param("horaFin") Date horaFin, @Param("costoAdicional") Double costoAdicional);

    @Modifying
    @Transactional
    @Query(value = "UPDATE clientes SET capacidad = :capacidad, profundidad = :profundidad, hora_inicio = :horaInicio, hora_fin = :horaFin, costo_adicional = :costoAdicional WHERE id = :id;" +
                    "UPDATE usuarios SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarCliente(@Param("id") Integer id, @Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("profundidad") Integer profundidad, @Param("horaInicio") Date horaInicio, @Param("horaFin") Date horaFin, @Param("costoAdicional") Double costoAdicional);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM clientes WHERE id = :id;" +
                    "DELETE FROM usuarios WHERE id = :id", nativeQuery = true)
    void eliminarCliente(@Param("id") Integer id);
}