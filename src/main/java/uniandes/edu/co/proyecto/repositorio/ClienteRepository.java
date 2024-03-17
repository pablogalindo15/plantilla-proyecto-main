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
    @Query(value = "INSERT INTO clientes VALUES (idUsuarios.nextval, :tipoCliente, :estadoCliente);" +
                    "INSERT INTO usuarios VALUES ((SELECT idUsuarios.CURRVAL FROM DUAL), :nombre)", nativeQuery = true)
    void insertarCliente(@Param("tipoCliente") String tipoCliente, @Param("estadoCliente") String estadoCliente);

    @Modifying
    @Transactional
    @Query(value = "UPDATE clientes SET tipoCliente= :tipoCliente, estadoCliente = :estadoCliente WHERE id = :id;" +
                    "UPDATE usuarios SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarCliente(@Param("tipoCliente") String tipoCliente, @Param("estadoCliente") String estadoCliente);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM clientes WHERE id = :id;" +
                    "DELETE FROM usuarios WHERE id = :id", nativeQuery = true)
    void eliminarCliente(@Param("id") Integer id);
}