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
@Table(name = "DETALLE_VENTAS")
public class DetailSale implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DETALLE")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "FK_PRODUCTO")
	private Product fkProduct;
	@Column(name = "PRECIO")
	private int price;
	@Column(name = "CANTIDAD_PRODUCTO")
	private int amount;
	@ManyToOne
	@JoinColumn(name = "FK_VENTA")
	private Sale fkSale;
	
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

	public Sale getFkSale() {
		return fkSale;
	}

	public void setFkSale(Sale fkSale) {
		this.fkSale = fkSale;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7881379433463357414L;
}
