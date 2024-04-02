package equitel.car.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import equitel.car.shop.dto.CreateShoppingCarReq;
import equitel.car.shop.dto.ResponseGeneric;
import equitel.car.shop.dto.UpdateShoppingCartReq;
import equitel.car.shop.model.Employee;
import equitel.car.shop.model.Product;
import equitel.car.shop.model.ShopException;
import equitel.car.shop.model.ShoppingCar;
import equitel.car.shop.persistence.EmployeeRepository;
import equitel.car.shop.persistence.ProductRepository;
import equitel.car.shop.persistence.ShoppingCartRepository;
import equitel.car.shop.utils.PropertiesErrorValue;
import equitel.car.shop.utils.PropertiesValue;
import equitel.car.shop.utils.Utils;

@Service
public class ShoppingCarServiceImpl implements ShoppingCartService {
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<ShoppingCar> getAllProductsByEmployee(int fkEmployee) throws ShopException {
		List<ShoppingCar> cart = new ArrayList<ShoppingCar>();
		List<Product> products = new ArrayList<Product>();
		try {
			cart = shoppingCartRepository.findByFkEmployeeAndActive(fkEmployee, PropertiesValue.valueActive);
		} catch (Exception e) {
			Utils.callException(PropertiesErrorValue.CODE_ERROR_TECH, PropertiesErrorValue.MSG_ERROR_TECH,
					HttpStatus.CONFLICT, e.fillInStackTrace().toString());
		}
		return cart;
	}

	@Override
	public ResponseGeneric addShoppingCar(CreateShoppingCarReq req) throws ShopException {
		Product product = null;
		Employee employee = null;
		ShoppingCar shoppingCar = new ShoppingCar();
		ResponseGeneric responseGeneric = new ResponseGeneric();
		try {
			product = productRepository.findByIdAndActive((long) req.getFkProduct(), PropertiesValue.valueActive);
			if (product == null) {
				Utils.callException(PropertiesErrorValue.CODE_NOT_FOUND_PROD, PropertiesErrorValue.MSG_NOT_FOUND_PROD,
						HttpStatus.CONFLICT, null);
			}
			employee = employeeRepository.findByidEmpleadoAndActive((long) req.getFkEmployee(),
					PropertiesValue.valueActive);
			if (employee == null) {
				Utils.callException(PropertiesErrorValue.CODE_NOT_FOUND_USER, PropertiesErrorValue.MSG_NOT_FOUND_USER,
						HttpStatus.CONFLICT, null);
			}
			shoppingCar = shoppingCartRepository.findItemByProductAndEmployee(product.getId(), employee.getIdEmpleado(),PropertiesValue.valueActive);
			if (shoppingCar != null) {
				shoppingCar.setAmount(shoppingCar.getAmount() + 1);
				shoppingCar.setPrice(shoppingCar.getAmount()*shoppingCar.getFkProduct().getPrice());
				shoppingCartRepository.save(shoppingCar);
			} else {
				shoppingCar = new ShoppingCar();
				Utils.fillShoppingCar(shoppingCar, product, req);
				shoppingCartRepository.save(shoppingCar);
			}
			responseGeneric.setCode(PropertiesValue.CODE_CREATE_USER);
			responseGeneric.setMsg(PropertiesValue.MSG_ADD_PROD);
		} catch (Exception e) {
			Utils.callException(PropertiesErrorValue.CODE_ERROR_TECH, PropertiesErrorValue.MSG_ERROR_TECH,
					HttpStatus.CONFLICT, e.getMessage());
		}
		return responseGeneric;
	}

	@Override
	public ResponseGeneric updateAmount(UpdateShoppingCartReq req) throws ShopException {
		ShoppingCar shoppingCar = null;
		ResponseGeneric responseGeneric = new ResponseGeneric();
		try {
			shoppingCar = shoppingCartRepository.findByIdAndActive((long) req.getIdCart(), PropertiesValue.valueActive);
			if (!shoppingCar.equals(null)) {
				shoppingCar.setAmount(req.getAmount());
				shoppingCar.setPrice(req.getAmount() * shoppingCar.getFkProduct().getPrice());
				shoppingCartRepository.save(shoppingCar);
				responseGeneric.setCode(PropertiesValue.CODE_SUCCESS);
				responseGeneric.setMsg(PropertiesValue.MSG_UPDATE_CART);
			}
		} catch (Exception e) {
			Utils.callException(PropertiesErrorValue.CODE_NOT_FOUND_CART, PropertiesErrorValue.MSG_NOT_FOUND_CART,
					HttpStatus.CONFLICT, e.fillInStackTrace().toString());
		}
		return responseGeneric;
	}

	@Override
	public ResponseGeneric deleteToShoppingCar(Long id) throws ShopException {
		ShoppingCar shoppingCar = null;
		ResponseGeneric responseGeneric = new ResponseGeneric();
		try {
			shoppingCar = shoppingCartRepository.findByIdAndActive((long) id, PropertiesValue.valueActive);
			if (!shoppingCar.equals(null)) {
				shoppingCar.setActive(0);
				shoppingCartRepository.save(shoppingCar);
				responseGeneric.setCode(PropertiesValue.CODE_SUCCESS);
				responseGeneric.setMsg(PropertiesValue.MSG_DELETE_CART);
			}
		} catch (Exception e) {
			Utils.callException(PropertiesErrorValue.CODE_NOT_FOUND_CART, PropertiesErrorValue.MSG_NOT_FOUND_CART,
					HttpStatus.CONFLICT, e.fillInStackTrace().toString());
		}
		return responseGeneric;
	}

}
