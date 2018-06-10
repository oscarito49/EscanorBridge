package mx.com.geekflu.escanor.bridge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.com.geekflu.escanor.bridge.entity.Pipe;

@Repository
public interface PipeRepository extends JpaRepository<Pipe, Long> {
	
	@Query("Select p from Pipe p where p.interfazRetail.id = :idInterfazRetail")
	List<Pipe> findByInterfazRetailId(@Param("idInterfazRetail") Long id);

}
