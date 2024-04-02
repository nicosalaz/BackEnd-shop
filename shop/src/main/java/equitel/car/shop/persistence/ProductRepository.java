package equitel.car.shop.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import equitel.car.shop.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	public List<Product> findAllByActive(int active);
	public Product findByIdAndActive(Long id, int active);
}
