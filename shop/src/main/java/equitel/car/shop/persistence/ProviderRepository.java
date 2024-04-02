package equitel.car.shop.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import equitel.car.shop.model.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long>{
	public List<Provider> findAllByActive(int active);
	public Provider findByNit(Long nit);
}
