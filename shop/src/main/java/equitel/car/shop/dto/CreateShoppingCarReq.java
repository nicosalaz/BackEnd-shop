package equitel.car.shop.dto;

public class CreateShoppingCarReq {
	private int fkProduct;
	private int fkEmployee;
	private int amount;

	public int getFkProduct() {
		return fkProduct;
	}

	public void setFkProduct(int fkProduct) {
		this.fkProduct = fkProduct;
	}

	public int getFkEmployee() {
		return fkEmployee;
	}

	public void setFkEmployee(int fkEmployee) {
		this.fkEmployee = fkEmployee;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
