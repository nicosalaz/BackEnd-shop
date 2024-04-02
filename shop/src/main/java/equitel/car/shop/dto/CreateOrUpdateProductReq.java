package equitel.car.shop.dto;

public class CreateOrUpdateProductReq {
	private Long id;
	private String name;
	private String description;
	private int price;
	private String model;
	private int existence;
	private int fkProvider;

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

	public int getFkProvider() {
		return fkProvider;
	}

	public void setFkProvider(int fkProvider) {
		this.fkProvider = fkProvider;
	}

}
