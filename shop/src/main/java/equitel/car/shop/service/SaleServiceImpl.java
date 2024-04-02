package equitel.car.shop.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import equitel.car.shop.dto.CreateSaleReq;
import equitel.car.shop.dto.ResponseGeneric;
import equitel.car.shop.model.DetailSale;
import equitel.car.shop.model.DetailSaleV;
import equitel.car.shop.model.Employee;
import equitel.car.shop.model.Product;
import equitel.car.shop.model.Sale;
import equitel.car.shop.model.ShopException;
import equitel.car.shop.model.ShoppingCar;
import equitel.car.shop.persistence.DetailSaleRepository;
import equitel.car.shop.persistence.EmployeeRepository;
import equitel.car.shop.persistence.ProductRepository;
import equitel.car.shop.persistence.SaleRepository;
import equitel.car.shop.persistence.ShoppingCartRepository;
import equitel.car.shop.utils.PropertiesErrorValue;
import equitel.car.shop.utils.PropertiesValue;
import equitel.car.shop.utils.Utils;
@Service
public class SaleServiceImpl implements SaleService {
	@Autowired
	private SaleRepository saleRepository;
	@Autowired
	private ShoppingCartService cartService;
	@Autowired
	private DetailSaleRepository detailSaleRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	@Override
	public ResponseGeneric addSale(CreateSaleReq req) throws ShopException {
		Sale sale = new Sale();
		ResponseGeneric responseGeneric = new ResponseGeneric();
		DetailSale detailSale = null;
		Employee employee = null;
		Product product = null;
		List<DetailSaleV> detailSaleVList = null;
		try {
			employee = employeeRepository.findByidEmpleadoAndActive((long) req.getFkEmployee(), PropertiesValue.valueActive);
			List<ShoppingCar> cart = cartService.getAllProductsByEmployee(req.getFkEmployee());
			if (!cart.isEmpty()) {
				Utils.fillSale(sale, req,employee);
				saleRepository.save(sale);
				for (ShoppingCar shoppingCar : cart) {
					detailSale = new DetailSale();
					product = productRepository.findByIdAndActive(shoppingCar.getFkProduct().getId(), PropertiesValue.valueActive);
					product.setExistence(product.getExistence()-shoppingCar.getAmount());
					productRepository.save(product);
					Utils.fillDetailSale(detailSale, sale, shoppingCar);
					detailSaleRepository.save(detailSale);
					shoppingCar.setActive(0);
					shoppingCartRepository.save(shoppingCar);
				}
//				detailSaleVList = detailSaleVService.getAllByIdVenta(sale.getId());
				responseGeneric.setCode(PropertiesValue.CODE_CREATE_USER);
				responseGeneric.setMsg(PropertiesValue.MSG_ADD_SALE);
				
			}
		} catch (Exception e) {
			Utils.callException(PropertiesErrorValue.CODE_ERROR_TECH, PropertiesErrorValue.MSG_ERROR_TECH, HttpStatus.CONFLICT,e.fillInStackTrace().toString(),PropertiesValue.SERVICE_NAME_SALE_ADD);
		}
		return responseGeneric;
	}
	@Override
	public List<Sale> getSales() throws ShopException {
		List<Sale> sales = null;
		try {
			sales = saleRepository.findAll();
		} catch (Exception e) {
			Utils.callException(PropertiesErrorValue.CODE_ERROR_TECH, PropertiesErrorValue.MSG_ERROR_TECH, HttpStatus.CONFLICT,e.fillInStackTrace().toString(),PropertiesValue.SERVICE_NAME_SALE_ADD);
		}
		return sales;
	}

}
