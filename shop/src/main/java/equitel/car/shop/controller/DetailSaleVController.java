package equitel.car.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import equitel.car.shop.model.ShopException;
import equitel.car.shop.persistence.DetailSaleVRepository;
import equitel.car.shop.service.DetailSaleVService;
import equitel.car.shop.utils.PropertiesValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = PropertiesValue.detailSalePath)
public class DetailSaleVController {
	@Autowired
	private DetailSaleVService detailSaleVService;
	@GetMapping()
	public ResponseEntity<?> getSalesById(@RequestParam Long idSale) throws ShopException {
		return new ResponseEntity<>(detailSaleVService.getAllByIdVenta(idSale),HttpStatus.OK);
	}
//	@GetMapping(path = PropertiesValue.reportPath)
//	public ResponseEntity<?> generateDayliReport() throws ShopException {
//		return new ResponseEntity<>(detailSaleVService.getAllBynowDate(),HttpStatus.OK);
//	}
	
}
