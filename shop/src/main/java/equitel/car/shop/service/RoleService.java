package equitel.car.shop.service;

import java.util.List;

import equitel.car.shop.model.Role;
import equitel.car.shop.model.ShopException;

public interface RoleService {
	public List<Role> getAllRoles() throws ShopException;
}
