package mx.com.geekflu.escanor.bridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.geekflu.escanor.bridge.entity.InterfazRetail;

@Repository
public interface InterfazRetailRepository extends JpaRepository<InterfazRetail, Long>{

}
