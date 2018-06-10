package mx.com.geekflu.escanor.bridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.geekflu.escanor.bridge.entity.CatProperty;

/**
 * 
 * @author darklatiz
 *
 */
@Repository
public interface CatPropertyRepository extends JpaRepository<CatProperty, Short> {

}