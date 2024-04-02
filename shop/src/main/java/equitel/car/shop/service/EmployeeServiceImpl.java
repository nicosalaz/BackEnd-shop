package equitel.car.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import equitel.car.shop.dto.AuthValid;
import equitel.car.shop.dto.CreateOrUpdateEmployeeReq;
import equitel.car.shop.dto.ResponseGeneric;
import equitel.car.shop.model.Employee;
import equitel.car.shop.model.Role;
import equitel.car.shop.model.ShopException;
import equitel.car.shop.persistence.EmployeeRepository;
import equitel.car.shop.persistence.RoleRepository;
import equitel.car.shop.utils.PropertiesErrorValue;
import equitel.car.shop.utils.PropertiesValue;
import equitel.car.shop.utils.Utils;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			employees = employeeRepository.findAllByActive(PropertiesValue.valueActive);
		} catch (Exception e) {
			System.err.println(e.fillInStackTrace());
		}
		return employees;
	}
	@Override
	public AuthValid authentication(String user, String password) throws ShopException {
		Employee employee = null;
		AuthValid authValid = null;
		employee = employeeRepository.findByUserAndPasswordAndActive(user, password,PropertiesValue.valueActive);
		if (employee != null) {
			authValid = new AuthValid(employee, employee.toString());
		}else {
			Utils.callException(PropertiesErrorValue.CODE_BAD_AUTH, PropertiesErrorValue.MSG_BAD_AUTH, HttpStatus.UNAUTHORIZED,"",PropertiesValue.SERVICE_NAME_EMP_GET);
		}
		return authValid;
	}
	@Override
	public ResponseGeneric create(CreateOrUpdateEmployeeReq createEmployee) throws ShopException {
		Employee employee = new Employee();
		Role role = null;
		ResponseGeneric createEmployeeResp = new ResponseGeneric();
		try {
			role = roleRepository.findByIdAndActive((long) createEmployee.getFkRole(), PropertiesValue.valueActive);
			Utils.fillEmployee(createEmployee, employee, role);
			employeeRepository.save(employee);
			createEmployeeResp.setCode(PropertiesValue.CODE_CREATE_USER);
			createEmployeeResp.setMsg(PropertiesValue.MSG_CREATE_USER);
		} catch (Exception e) {
			Utils.callException(PropertiesErrorValue.CODE_ERROR_TECH, PropertiesErrorValue.MSG_ERROR_TECH, HttpStatus.CONFLICT,e.fillInStackTrace().toString(), PropertiesValue.SERVICE_NAME_EMP_ADD);
		}
		return createEmployeeResp;
	}
	@Override
	public ResponseGeneric delete(Long id) throws ShopException {
		Employee employee = null;
		ResponseGeneric generic = new ResponseGeneric();
		employee = employeeRepository.findByidEmpleadoAndActive(id, PropertiesValue.valueActive);
		if (employee != null) {
			employee.setActive(0);
			employeeRepository.save(employee);
			generic.setCode(PropertiesValue.CODE_SUCCESS);
			generic.setMsg(PropertiesValue.MSG_DELETE_USER);
		}else {
			Utils.callException(PropertiesErrorValue.CODE_NOT_FOUND_USER, PropertiesErrorValue.MSG_NOT_FOUND_USER, HttpStatus.CONFLICT,"",PropertiesValue.SERVICE_NAME_EMP_DEL);
		}
		return generic;
	}
	@Override
	public ResponseGeneric update(CreateOrUpdateEmployeeReq updEmployee) throws ShopException {
		Employee employee = null;
		Role role = null;
		ResponseGeneric responseGeneric = new ResponseGeneric();
		role = roleRepository.findByIdAndActive((long) updEmployee.getFkRole(), PropertiesValue.valueActive);
		employee = employeeRepository.findByidEmpleadoAndActive(updEmployee.getIdEmpleado(), PropertiesValue.valueActive);
		if (employee != null) {
			employee.setName(updEmployee.getName());
			employee.setLastName(updEmployee.getLastName());
			employee.setUser(updEmployee.getUser());
			employee.setPassword(updEmployee.getPassword());
			employee.setFkRole(role);
			employeeRepository.save(employee);
			responseGeneric.setCode(PropertiesValue.CODE_SUCCESS);
			responseGeneric.setMsg(PropertiesValue.MSG_UPDATE_USER);
		}else {
			Utils.callException(PropertiesErrorValue.CODE_NOT_FOUND_USER, PropertiesErrorValue.MSG_NOT_FOUND_USER, HttpStatus.CONFLICT,"",PropertiesValue.SERVICE_NAME_EMP_UPT);
		}
		return responseGeneric;
	}
	@Override
	public Employee getById(Long id) throws ShopException {
		Employee employee = null;
		employee = employeeRepository.findByidEmpleadoAndActive(id, PropertiesValue.valueActive);
		if (employee == null) {
			Utils.callException(PropertiesErrorValue.CODE_NOT_FOUND_USER, PropertiesErrorValue.MSG_NOT_FOUND_USER, HttpStatus.CONFLICT,"",PropertiesValue.SERVICE_NAME_EMP_UPT);
		}
		return employee;
	}

}
