package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.OperacionBancaria;
import java.util.Collection;

public interface OperacionBancariaRepository extends JpaRepository<OperacionBancaria, Integer> {

    @Query("SELECT o FROM OperacionBancaria o WHERE o.idClienteFK.idCliente = :idCliente")
    Collection<OperacionBancaria> findByClienteId(Integer idCliente);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO operaciones_bancarias (fecha, valor, idCliente) VALUES (:fecha, :valor, :idCliente)", nativeQuery = true)
    void insertarOperacionBancaria(String fecha, Integer valor, Integer idCliente);

    @Modifying
    @Transactional
    @Query(value = "UPDATE operaciones_bancarias SET fecha = :fecha, valor = :valor, idCliente = :idCliente WHERE idOperacionBancaria = :id", nativeQuery = true)
    void actualizarOperacionBancaria(Integer id, String fecha, Integer valor, Integer idCliente);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM operaciones_bancarias WHERE idOperacionBancaria = :id", nativeQuery = true)
    void eliminarOperacionBancaria(Integer id);
}
