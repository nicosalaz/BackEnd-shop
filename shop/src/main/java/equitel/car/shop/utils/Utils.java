package equitel.car.shop.utils;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;

import equitel.car.shop.dto.CreateOrUpdateEmployeeReq;
import equitel.car.shop.dto.CreateOrUpdateProductReq;
import equitel.car.shop.dto.CreateSaleReq;
import equitel.car.shop.dto.CreateShoppingCarReq;
import equitel.car.shop.model.DetailSale;
import equitel.car.shop.model.Employee;
import equitel.car.shop.model.Product;
import equitel.car.shop.model.Provider;
import equitel.car.shop.model.Role;
import equitel.car.shop.model.Sale;
import equitel.car.shop.model.ShopException;
import equitel.car.shop.model.ShoppingCar;

public class Utils {
	
	public static void callException(String code, String msg, HttpStatus status,String response, String serviceName) throws ShopException {
		throw new ShopException(code, msg, status,response,serviceName);
	}
	public static void callException(String code, String msg, HttpStatus status,String response) throws ShopException {
		throw new ShopException(code, msg, status,response);
	}
	
	public static void fillEmployee(CreateOrUpdateEmployeeReq crReq, Employee employee, Role role) throws ShopException {
		try {
			employee.setName(crReq.getName());
			employee.setLastName(crReq.getLastName());
			employee.setUser(crReq.getUser());
			employee.setPassword(crReq.getPassword());
			employee.setFkRole(role);
			employee.setActive(PropertiesValue.valueActive);
		} catch (Exception e) {
			callException(PropertiesErrorValue.CODE_ERROR_TECH, PropertiesErrorValue.MSG_ERROR_TECH, HttpStatus.CONFLICT,e.fillInStackTrace().toString());
		}
	}
	
	public static void fillProduct(CreateOrUpdateProductReq prod, Product product, Provider provider) throws ShopException {
		try {
			product.setActive(PropertiesValue.valueActive);
			product.setDescription(prod.getDescription());
			product.setExistence(prod.getExistence());
			product.setFkProvider(provider);
			product.setModel(prod.getModel());
			product.setName(prod.getName());
			product.setPrice(prod.getPrice());
		} catch (Exception e) {
			callException(PropertiesErrorValue.CODE_ERROR_TECH, PropertiesErrorValue.MSG_ERROR_TECH, HttpStatus.CONFLICT,e.fillInStackTrace().toString());
		}
	}
	
	public static void fillShoppingCar(ShoppingCar car, Product product,CreateShoppingCarReq req) throws ShopException {
		try {
			car.setActive(PropertiesValue.valueActive);
			car.setAmount(req.getAmount());
			car.setFkEmployee(req.getFkEmployee());
			car.setFkProduct(product);
			car.setPrice(req.getAmount()*product.getPrice());
		} catch (Exception e) {
			callException(PropertiesErrorValue.CODE_ERROR_TECH, PropertiesErrorValue.MSG_ERROR_TECH, HttpStatus.CONFLICT,e.fillInStackTrace().toString());
		}
	}
	
	public static void fillSale(Sale sale,CreateSaleReq req,Employee employee) throws ShopException {
		try {
			sale.setFk_employee(employee);
			sale.setTotalPrice(req.getTotal());
			sale.setNowDate(new Timestamp(System.currentTimeMillis()));
		} catch (Exception e) {
			callException(PropertiesErrorValue.CODE_ERROR_TECH, PropertiesErrorValue.MSG_ERROR_TECH, HttpStatus.CONFLICT,e.fillInStackTrace().toString());
		}
	}
	
	public static void fillDetailSale(DetailSale detailSale,Sale sale,ShoppingCar cart) throws ShopException {
		try {
			detailSale.setFkSale(sale);
			detailSale.setFkProduct(cart.getFkProduct());
			detailSale.setAmount(cart.getAmount());
			detailSale.setPrice(cart.getPrice());
		} catch (Exception e) {
			callException(PropertiesErrorValue.CODE_ERROR_TECH, PropertiesErrorValue.MSG_ERROR_TECH, HttpStatus.CONFLICT,e.fillInStackTrace().toString());
		}
	}

}
