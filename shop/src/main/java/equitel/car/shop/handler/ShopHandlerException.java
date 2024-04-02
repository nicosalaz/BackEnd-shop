package equitel.car.shop.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import equitel.car.shop.model.ResponseError;
import equitel.car.shop.model.ShopException;
import equitel.car.shop.persistence.AuditRepository;
import equitel.car.shop.service.AuditService;
import equitel.car.shop.utils.PropertiesValue;
import equitel.car.shop.utils.Utils;

@RestControllerAdvice
public class ShopHandlerException {
	@Autowired
	private AuditService auditService;
	@ExceptionHandler
	public ResponseEntity<?> responseException(ShopException shopException){
		ResponseError responseError = new ResponseError();
		responseError.setCodeError(shopException.getCodeError());
		responseError.setMessageError(shopException.getMessageError());
		auditService.audit(shopException.getServiceName(), shopException.getStatus().value(), 
				PropertiesValue.gson.toJson(responseError)+" "+PropertiesValue.gson.toJson(shopException.getResponse()));
		return new ResponseEntity<>(responseError,shopException.getStatus());
	}
}
