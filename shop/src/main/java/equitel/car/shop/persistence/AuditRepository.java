package equitel.car.shop.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import equitel.car.shop.model.Audit;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Long>{
	
}
