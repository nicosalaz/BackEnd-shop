package equitel.car.shop.service;

import java.util.List;

import equitel.car.shop.dto.CreateShoppingCarReq;
import equitel.car.shop.dto.ResponseGeneric;
import equitel.car.shop.dto.UpdateShoppingCartReq;
import equitel.car.shop.model.ShopException;
import equitel.car.shop.model.ShoppingCar;

public interface ShoppingCartService {
	public List<ShoppingCar> getAllProductsByEmployee(int fkEmployee) throws ShopException;
	public ResponseGeneric addShoppingCar(CreateShoppingCarReq req) throws ShopException;
	public ResponseGeneric updateAmount(UpdateShoppingCartReq req) throws ShopException;
	public ResponseGeneric deleteToShoppingCar(Long id) throws ShopException;
}
