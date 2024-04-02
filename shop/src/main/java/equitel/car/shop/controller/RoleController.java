package equitel.car.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import equitel.car.shop.model.ShopException;
import equitel.car.shop.service.RoleService;
import equitel.car.shop.utils.PropertiesValue;

@RestController
@RequestMapping(path = PropertiesValue.rolePath)
public class RoleController {
	@Autowired
	private RoleService roleService;
	@GetMapping
	public ResponseEntity<?> getRoles() throws ShopException {
		return new ResponseEntity<>(roleService.getAllRoles(),HttpStatus.OK);
	}
	
}
