package equitel.car.shop.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import equitel.car.shop.model.Employee;
import equitel.car.shop.model.Product;
import equitel.car.shop.model.ShoppingCar;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCar, Long>{
	public List<ShoppingCar> findByFkEmployeeAndActive(int fkEmployee,int active);
	public ShoppingCar findByIdAndActive(Long Id, int active);
	@Query(value = "SELECT * FROM carrito_de_compra WHERE FK_PRODUCTO=?1 AND FK_EMPLEADO=?2 AND ACTIVO=?3",nativeQuery = true)
	public ShoppingCar findItemByProductAndEmployee(Long fkProduct, Long fkEmployee,int active);
}
