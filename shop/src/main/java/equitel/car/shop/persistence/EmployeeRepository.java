package equitel.car.shop.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import equitel.car.shop.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	public List<Employee> findAllByActive(int active);
	public Employee findByUserAndPasswordAndActive(String user,String password ,int active);
	public Employee findByidEmpleadoAndActive(Long idEmpleado, int active);
}
