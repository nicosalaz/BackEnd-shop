package equitel.car.shop.dto;

import java.util.List;

import equitel.car.shop.model.ShoppingCar;

public class CreateSaleReq {
	private int total;
	private int fkEmployee;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getFkEmployee() {
		return fkEmployee;
	}

	public void setFkEmployee(int fkEmployee) {
		this.fkEmployee = fkEmployee;
	}

}
