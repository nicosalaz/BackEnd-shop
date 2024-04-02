package equitel.car.shop.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import equitel.car.shop.model.DetailSale;

@Repository
public interface DetailSaleRepository extends JpaRepository<DetailSale, Long>{
	@Query(value = "select * "
			+ "from detalle_ventas "
			+ "where FK_VENTA = ?1",nativeQuery = true)
	public List<DetailSale> getDetailsByIdSale(Long fkVenta);
}
