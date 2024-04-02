package equitel.car.shop.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import equitel.car.shop.model.Sale;
import equitel.car.shop.model.ShopException;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{
	@Query(value = "select * "
			+ "from ventas "
			+ "WHERE day(FECHA) = ?1 and month(FECHA) = ?2 and year(FECHA) = ?3", nativeQuery = true)
	public List<Sale> getByDateNow(int day, int month, int year);

}
