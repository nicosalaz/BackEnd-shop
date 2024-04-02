package equitel.car.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import equitel.car.shop.model.Provider;
import equitel.car.shop.service.ProviderService;
import equitel.car.shop.utils.PropertiesValue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = PropertiesValue.providerPath)
public class ProviderController {
	@Autowired
	private ProviderService providerService;
	@GetMapping()
	public ResponseEntity<?> allProvider() {
		ResponseEntity<?> response = new ResponseEntity<>(providerService.getAllProvider(),HttpStatus.OK);
		return response;
	}

}
