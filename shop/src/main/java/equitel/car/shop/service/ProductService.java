package equitel.car.shop.service;

import java.util.List;

import equitel.car.shop.dto.CreateOrUpdateProductReq;
import equitel.car.shop.dto.ResponseGeneric;
import equitel.car.shop.model.Product;
import equitel.car.shop.model.ShopException;

public interface ProductService {
	public List<Product> getAll()throws ShopException;
	public ResponseGeneric createProduct(CreateOrUpdateProductReq prod) throws ShopException;
	public ResponseGeneric updateProduct(CreateOrUpdateProductReq prod) throws ShopException;
	public ResponseGeneric deleteProduct(Long id) throws ShopException;
}
