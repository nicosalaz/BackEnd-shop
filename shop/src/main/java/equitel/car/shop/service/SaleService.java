package equitel.car.shop.service;

import java.util.List;

import equitel.car.shop.dto.CreateSaleReq;
import equitel.car.shop.dto.ResponseGeneric;
import equitel.car.shop.model.DetailSaleV;
import equitel.car.shop.model.Sale;
import equitel.car.shop.model.ShopException;

public interface SaleService {
	public ResponseGeneric addSale(CreateSaleReq req) throws ShopException;
	public List<Sale> getSales() throws ShopException;
}
