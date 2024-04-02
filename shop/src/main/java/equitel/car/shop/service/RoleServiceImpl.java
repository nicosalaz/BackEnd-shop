package equitel.car.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import equitel.car.shop.model.Role;
import equitel.car.shop.model.ShopException;
import equitel.car.shop.persistence.RoleRepository;
import equitel.car.shop.utils.PropertiesErrorValue;
import equitel.car.shop.utils.PropertiesValue;
import equitel.car.shop.utils.Utils;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public List<Role> getAllRoles() throws ShopException {
		List<Role> roleList = null;
		try {
			roleList = roleRepository.findAllByActive(PropertiesValue.valueActive);
			if (roleList == null) {
				Utils.callException(PropertiesErrorValue.CODE_ERROR_TECH, PropertiesErrorValue.MSG_ERROR_TECH, 
						HttpStatus.CONFLICT, "", PropertiesValue.SERVICE_NAME_ROLE_GET);
			}
		} catch (Exception e) {
			Utils.callException(PropertiesErrorValue.CODE_ERROR_TECH, PropertiesErrorValue.MSG_ERROR_TECH, 
					HttpStatus.CONFLICT, e.getMessage(), PropertiesValue.SERVICE_NAME_ROLE_GET);
		}
		return roleList;
	}

}
