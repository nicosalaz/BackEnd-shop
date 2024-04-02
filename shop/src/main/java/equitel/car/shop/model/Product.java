package equitel.car.shop.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity()
@Table(name = "PRODUCTOS")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUCTO")
	private Long id;
	@Column(name = "NOMBRE")
	private String name;
	@Column(name = "DESCRIPCION")
	private String description;
	@Column(name = "VALOR")
	private int price;
	@Column(name = "MODELO")
	private String model;
	@Column(name = "EXISTENCIA")
	private int existence;
	@Column(name = "ACTIVO")
	private int active;
	@ManyToOne(optional = true,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_PROVEEDOR")
	private Provider fkProvider;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getExistence() {
		return existence;
	}

	public void setExistence(int existence) {
		this.existence = existence;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Provider getFkProvider() {
		return fkProvider;
	}

	public void setFkProvider(Provider fkProvider) {
		this.fkProvider = fkProvider;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4450931364116966569L;

}
