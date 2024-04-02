package equitel.car.shop.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity()
@Table(name = "CARRITO_DE_COMPRA")
public class ShoppingCar implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CARRITO")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "FK_PRODUCTO")
	private Product fkProduct;
	@Column(name = "PRECIO")
	private int price;
	@Column(name = "CANTIDAD")
	private int amount;
	@Column(name = "ACTIVO")
	private int active;
	@Column(name = "FK_EMPLEADO")
	private int fkEmployee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getFkProduct() {
		return fkProduct;
	}

	public void setFkProduct(Product fkProduct) {
		this.fkProduct = fkProduct;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getFkEmployee() {
		return fkEmployee;
	}

	public void setFkEmployee(int fkEmployee) {
		this.fkEmployee = fkEmployee;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8394014135640917653L;

}
