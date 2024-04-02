package equitel.car.shop.service;

import java.util.List;

import equitel.car.shop.dto.AuthValid;
import equitel.car.shop.dto.CreateOrUpdateEmployeeReq;
import equitel.car.shop.dto.ResponseGeneric;
import equitel.car.shop.model.Employee;
import equitel.car.shop.model.ShopException;

public interface EmployeeService {
	public List<Employee> getAllEmployee();
	public Employee getById(Long id) throws ShopException;
	public AuthValid authentication(String user, String password) throws ShopException;
	public ResponseGeneric create(CreateOrUpdateEmployeeReq employee) throws ShopException;
	public ResponseGeneric update(CreateOrUpdateEmployeeReq employee) throws ShopException;
	public ResponseGeneric delete(Long id) throws ShopException;
}
