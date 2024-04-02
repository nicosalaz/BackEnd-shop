package equitel.car.shop.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import equitel.car.shop.model.DetailSaleV;
import equitel.car.shop.model.ShopException;
import equitel.car.shop.persistence.DetailSaleVRepository;
import equitel.car.shop.utils.PropertiesErrorValue;
import equitel.car.shop.utils.Utils;
@Service
public class DetailSaleVServiceImpl implements DetailSaleVService {
	@Autowired
	private DetailSaleVRepository detailSaleVRepository;
	@Override
	public List<DetailSaleV> getAllByIdVenta(Long idSale) throws ShopException {
		List<DetailSaleV> saleList = new ArrayList<DetailSaleV>();
		try {
			saleList = detailSaleVRepository.findAllByIdSale(idSale);
		} catch (Exception e) {
			Utils.callException(PropertiesErrorValue.CODE_ERROR_TECH, PropertiesErrorValue.MSG_ERROR_TECH, HttpStatus.CONFLICT,e.fillInStackTrace().toString());
		}
		return saleList;
	}

}
