package equitel.car.shop.service;

import java.util.List;

import equitel.car.shop.model.DetailSaleV;
import equitel.car.shop.model.ShopException;

public interface DetailSaleVService {
	public List<DetailSaleV> getAllByIdVenta(Long idSale) throws ShopException;
}
