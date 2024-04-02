package equitel.car.shop.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity()
@Table(name = "detalle_venta_v")
public class DetailSaleV {
	@Id
	@Column(name = "ID_VENTA")
	private Long idSale;
	@Column(name = "ID_DETALLE")
	private Long idDetail;
	@ManyToOne
	@JoinColumn(name = "FK_EMPLEADO")
	private Employee fk_employee;
	@Column(name = "FECHA")
	private Timestamp nowDate;
	@ManyToOne
	@JoinColumn(name = "FK_PRODUCTO")
	private Product fkProduct;
	@Column(name = "CANTIDAD_PRODUCTO")
	private int amount;
	@Column(name = "PRECIO")
	private int price;
//	@Column(name = "NOMBRE_EMPLEADO")
//	private String nameEmployee;
//	@Column(name = "NOMBRE")
//	private String nameProd;

	public Long getIdSale() {
		return idSale;
	}

	public void setIdSale(Long idSale) {
		this.idSale = idSale;
	}

	public Long getIdDetail() {
		return idDetail;
	}

	public void setIdDetail(Long idDetail) {
		this.idDetail = idDetail;
	}

	public Employee getFk_employee() {
		return fk_employee;
	}

	public void setFk_employee(Employee fk_employee) {
		this.fk_employee = fk_employee;
	}

	public Timestamp getNowDate() {
		return nowDate;
	}

	public void setNowDate(Timestamp nowDate) {
		this.nowDate = nowDate;
	}

	public Product getFkProduct() {
		return fkProduct;
	}

	public void setFkProduct(Product fkProduct) {
		this.fkProduct = fkProduct;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

//	public String getNameEmployee() {
//		return nameEmployee;
//	}
//
//	public void setNameEmployee(String nameEmployee) {
//		this.nameEmployee = nameEmployee;
//	}
//
//	public String getNameProd() {
//		return nameProd;
//	}
//
//	public void setNameProd(String nameProd) {
//		this.nameProd = nameProd;
//	}

}
