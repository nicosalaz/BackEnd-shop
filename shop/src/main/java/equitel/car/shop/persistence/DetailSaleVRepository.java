package equitel.car.shop.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import equitel.car.shop.model.DetailSaleV;
@Repository
public interface DetailSaleVRepository extends JpaRepository<DetailSaleV, Long> {
	public List<DetailSaleV> findAllByIdSale(Long idSale);
	
}
