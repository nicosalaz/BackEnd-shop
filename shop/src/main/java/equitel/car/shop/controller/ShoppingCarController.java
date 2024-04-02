package equitel.car.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import equitel.car.shop.dto.CreateShoppingCarReq;
import equitel.car.shop.dto.UpdateShoppingCartReq;
import equitel.car.shop.model.ShopException;
import equitel.car.shop.service.ShoppingCartService;
import equitel.car.shop.utils.PropertiesValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(path = PropertiesValue.shoppingCarPath)
public class ShoppingCarController {
	@Autowired
	private ShoppingCartService cartService;
	@GetMapping
	public ResponseEntity<?> getShoppingCar(@RequestParam int fkEmployee) throws ShopException {
		return new ResponseEntity<>(cartService.getAllProductsByEmployee(fkEmployee),HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<?> addCar(@RequestBody CreateShoppingCarReq req) throws ShopException {
		return new ResponseEntity<>(cartService.addShoppingCar(req),HttpStatus.OK);
	}
	@PatchMapping
	public ResponseEntity<?> updateCar(@RequestBody UpdateShoppingCartReq req) throws ShopException {
		return new ResponseEntity<>(cartService.updateAmount(req),HttpStatus.OK);
	}
	@DeleteMapping
	public ResponseEntity<?> deleteItemCart(@RequestParam Long id) throws ShopException {
		return new ResponseEntity<>(cartService.deleteToShoppingCar(id),HttpStatus.OK);
	}
	
	

}
