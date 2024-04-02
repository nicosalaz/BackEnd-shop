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

import equitel.car.shop.dto.CreateOrUpdateProductReq;
import equitel.car.shop.model.ShopException;
import equitel.car.shop.service.ProductService;
import equitel.car.shop.utils.PropertiesValue;



@RestController
@RequestMapping(path = PropertiesValue.productPath)
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping
	public ResponseEntity<?> findProducts() throws ShopException {
		return new ResponseEntity<>(productService.getAll(),HttpStatus.OK);
	}
	@PostMapping()
	public ResponseEntity<?> createProd(@RequestBody CreateOrUpdateProductReq prod) throws ShopException {
		return new ResponseEntity<>(productService.createProduct(prod),HttpStatus.CREATED);
	}
	@PatchMapping
	public ResponseEntity<?> updateProd(@RequestBody CreateOrUpdateProductReq entity) throws ShopException {
		return new ResponseEntity<>(productService.updateProduct(entity),HttpStatus.OK);
	}
	@DeleteMapping
	public ResponseEntity<?> getMethodName(@RequestParam Long id) throws ShopException {
		return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
	}
	
	
	
}
