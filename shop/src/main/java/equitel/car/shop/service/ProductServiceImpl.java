package equitel.car.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import equitel.car.shop.dto.CreateOrUpdateProductReq;
import equitel.car.shop.dto.ResponseGeneric;
import equitel.car.shop.model.Product;
import equitel.car.shop.model.Provider;
import equitel.car.shop.model.ShopException;
import equitel.car.shop.persistence.ProductRepository;
import equitel.car.shop.persistence.ProviderRepository;
import equitel.car.shop.utils.PropertiesErrorValue;
import equitel.car.shop.utils.PropertiesValue;
import equitel.car.shop.utils.Utils;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProviderRepository providerRepository;
	@Override
	public List<Product> getAll() throws ShopException {
		List<Product> products = new ArrayList<Product>();
		try {
			products = productRepository.findAllByActive(PropertiesValue.valueActive);
		} catch (Exception e) {
			Utils.callException(PropertiesErrorValue.CODE_ERROR_TECH, PropertiesErrorValue.MSG_ERROR_TECH, HttpStatus.CONFLICT,e.fillInStackTrace().toString(),PropertiesValue.SERVICE_NAME_PROD_GET);
		}
		return products;
	}

	@Override
	public ResponseGeneric createProduct(CreateOrUpdateProductReq prod) throws ShopException {
		Product product = new Product();
		Provider provider = new Provider();
		ResponseGeneric responseGeneric = new ResponseGeneric();
		try {
			provider = providerRepository.findByNit((long) prod.getFkProvider());
			Utils.fillProduct(prod, product, provider);
			productRepository.save(product);
			responseGeneric.setCode(PropertiesValue.CODE_CREATE_USER);
			responseGeneric.setMsg(PropertiesValue.MSG_CREATE_PROD);
		} catch (Exception e) {
			Utils.callException(PropertiesErrorValue.CODE_ERROR_TECH, PropertiesErrorValue.MSG_ERROR_TECH, HttpStatus.CONFLICT,e.fillInStackTrace().toString(),PropertiesValue.SERVICE_NAME_PROD_ADD);
		}
		return responseGeneric;
	}

	@Override
	public ResponseGeneric updateProduct(CreateOrUpdateProductReq prod) throws ShopException {
		Product product = null;
		Provider provider = new Provider();
		ResponseGeneric responseGeneric = new ResponseGeneric();
		try {
			provider = providerRepository.findByNit((long) prod.getFkProvider());
			try {
				product = productRepository.findByIdAndActive(prod.getId(), PropertiesValue.valueActive);
				if (product.getId() != null) {
					Utils.fillProduct(prod, product, provider);
					productRepository.save(product);
					responseGeneric.setCode(PropertiesValue.CODE_SUCCESS);
					responseGeneric.setMsg(PropertiesValue.MSG_UPDATE_PROD);
				}
			} catch (Exception e) {
				Utils.callException(PropertiesErrorValue.CODE_NOT_FOUND_PROD, PropertiesErrorValue.MSG_NOT_FOUND_PROD, HttpStatus.CONFLICT,e.fillInStackTrace().toString(),PropertiesValue.SERVICE_NAME_PROD_UPT);
			}

		} catch (Exception e) {
			Utils.callException(PropertiesErrorValue.CODE_ERROR_TECH, PropertiesErrorValue.MSG_ERROR_TECH, HttpStatus.CONFLICT,e.fillInStackTrace().toString(),PropertiesValue.SERVICE_NAME_PROD_UPT);
		}
		return responseGeneric;
	}

	@Override
	public ResponseGeneric deleteProduct(Long id) throws ShopException {
		Product product = null;
		ResponseGeneric responseGeneric = new ResponseGeneric();
		product = productRepository.findByIdAndActive(id, PropertiesValue.valueActive);
		if (product != null) {
			product.setActive(0);
			productRepository.save(product);
			responseGeneric.setCode(PropertiesValue.CODE_SUCCESS);
			responseGeneric.setMsg(PropertiesValue.MSG_DELETE_PROD);
		}else {
			Utils.callException(PropertiesErrorValue.CODE_NOT_FOUND_PROD, PropertiesErrorValue.MSG_NOT_FOUND_PROD, HttpStatus.CONFLICT,"",PropertiesValue.SERVICE_NAME_PROD_DEL);
		}
		return responseGeneric;
	}

}
