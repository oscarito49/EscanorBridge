package mx.com.geekflu.escanor.bridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.geekflu.escanor.bridge.entity.CatAccion;

@Repository
public interface CatAccionRepository extends JpaRepository<CatAccion, Long> {

}
