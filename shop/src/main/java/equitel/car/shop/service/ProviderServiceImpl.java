package equitel.car.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import equitel.car.shop.model.Provider;
import equitel.car.shop.persistence.ProviderRepository;
import equitel.car.shop.utils.PropertiesValue;

@Service
public class ProviderServiceImpl implements ProviderService {
	@Autowired
	private ProviderRepository providerRepository;
	@Override
	public List<Provider> getAllProvider() {
		List<Provider> providers = new ArrayList<Provider>();
		try {
			providers = providerRepository.findAllByActive(PropertiesValue.valueActive);
		} catch (Exception e) {
			System.err.println(e.fillInStackTrace().toString());
		}
		return providers;
	}

}
