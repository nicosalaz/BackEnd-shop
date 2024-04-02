package equitel.car.shop.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity()
@Table(name = "VENTAS")
public class Sale implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VENTA")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "FK_EMPLEADO")
	private Employee fk_employee;
	@Column(name = "FECHA")
	private Timestamp nowDate;
	@Column(name = "TOTAL_VENTA")
	private int totalPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4724663751348572001L;

}
