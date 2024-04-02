package equitel.car.shop.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import equitel.car.shop.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	public Role findByIdAndActive(Long id, int active);
	public List<Role> findAllByActive(int active);
}
