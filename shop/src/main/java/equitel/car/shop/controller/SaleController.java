package equitel.car.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import equitel.car.shop.dto.CreateSaleReq;
import equitel.car.shop.model.ShopException;
import equitel.car.shop.service.ReportService;
import equitel.car.shop.service.SaleService;
import equitel.car.shop.utils.PropertiesValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = PropertiesValue.salePath)
public class SaleController {
	@Autowired
	private SaleService saleService;
	@Autowired
	private ReportService reportService;
	@PostMapping
	public ResponseEntity<?> insertSale(@RequestBody CreateSaleReq req) throws ShopException {
		return new ResponseEntity<>(saleService.addSale(req),HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<?> getAllSales() throws ShopException {
		return new ResponseEntity<>(saleService.getSales(),HttpStatus.CREATED);
	}
	@GetMapping(path = PropertiesValue.reportPath)
	public ResponseEntity<?> getReport() throws ShopException {
		return new ResponseEntity<>(reportService.getDayliReport(),HttpStatus.OK);
	}
	
}
