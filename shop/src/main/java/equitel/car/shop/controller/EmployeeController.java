package equitel.car.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import equitel.car.shop.dto.AuthRequest;
import equitel.car.shop.dto.AuthValid;
import equitel.car.shop.dto.CreateOrUpdateEmployeeReq;
import equitel.car.shop.dto.ResponseGeneric;
import equitel.car.shop.model.ShopException;
import equitel.car.shop.service.EmployeeService;
import equitel.car.shop.utils.PropertiesValue;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = PropertiesValue.employeePath)
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping()
	public ResponseEntity<?> allEmployee() {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(employeeService.getAllEmployee(),HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(path = PropertiesValue.employeeGetPath)
	public ResponseEntity<?> getMethodName(@RequestParam Long idEmpleado) throws ShopException {
		return new ResponseEntity<>(employeeService.getById(idEmpleado),HttpStatus.OK);
	}
	
	
	@PostMapping(path = PropertiesValue.employeeAuthPath)
	public ResponseEntity<?> auth(@Valid @RequestBody AuthRequest authRequest) throws ShopException{
		AuthValid authValid = employeeService.authentication(authRequest.getUser(), authRequest.getPassword());
		return new ResponseEntity<>(authValid,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<?> createEmployee(@RequestBody CreateOrUpdateEmployeeReq employee) throws ShopException{
		ResponseGeneric creResp = employeeService.create(employee);
		return new ResponseEntity<>(creResp,HttpStatus.CREATED);
	}
	
	@PatchMapping
	public ResponseEntity<?> updateEmployee(@RequestBody CreateOrUpdateEmployeeReq employeeReq) throws ShopException{
		ResponseGeneric response = employeeService.update(employeeReq);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@DeleteMapping
	public ResponseEntity<?> deleteEmployee(@RequestParam Long id) throws ShopException{
		ResponseGeneric creResp = employeeService.delete(id);
		return new ResponseEntity<>(creResp,HttpStatus.OK);
		
	}
	
}
