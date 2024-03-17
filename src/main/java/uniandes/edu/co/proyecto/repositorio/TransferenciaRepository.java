package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {
    @Query(value = "SELECT t.*, ob.nombre FROM transferencias t INNER JOIN operaciones_bancarias ob ON t.id = ob.id", nativeQuery = true)
    Collection<Transferencia> darTransferencias();

    @Query(value = "SELECT t.*, ob.id FROM transferencias t INNER JOIN operaciones_bancarias ob ON t.id = ob.id WHERE t.id = :id", nativeQuery = true)
    Transferencia darTransferencia(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO transferencias (column1, column2) VALUES (:value1, :value2);", nativeQuery = true)
    void insertarTransferencia(@Param("value1") String value1, @Param("value2") String value2); 

    @Modifying
    @Transactional
    @Query(value = "UPDATE transferencias SET cuentaDestino = :cuentaDestino WHERE id = :id", nativeQuery = true)
    void actualizarTransferencia(@Param("cuentaDestino") String cuentaDestino, @Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM transferencias WHERE id = :id", nativeQuery = true)
    void eliminarTransferencia(@Param("id") Integer id);
}
