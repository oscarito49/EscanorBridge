package mx.com.geekflu.escanor.bridge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.com.geekflu.escanor.bridge.entity.DetalleProperty;

@Repository
public interface DetallePropertyRepository
	extends JpaRepository<DetalleProperty, Long>{

	@Query("select dp From DetalleProperty dp where dp.pipe.id = :idPipe")
	List<DetalleProperty> findDetallePropertyByIdPipe(@Param("idPipe") Long idPipe);
	
}
