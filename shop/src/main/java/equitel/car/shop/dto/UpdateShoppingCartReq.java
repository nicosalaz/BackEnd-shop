package equitel.car.shop.dto;

public class UpdateShoppingCartReq {
	private int idCart;
	private int amount;

	public int getIdCart() {
		return idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
