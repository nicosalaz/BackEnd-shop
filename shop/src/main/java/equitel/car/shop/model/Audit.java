package equitel.car.shop.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity()
@Table(name = "AUDITORIA")
public class Audit implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AUDITORIA")
	private Long id;
	@Column(name = "SERVICIO")
	private String service;
	@Column(name = "FECHA")
	private Timestamp nowDate;
	@Column(name = "ESTADO")
	private int state;
	@Column(name = "RESPUESTA")
	private String response;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Timestamp getNowDate() {
		return nowDate;
	}

	public void setNowDate(Timestamp nowDate) {
		this.nowDate = nowDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -3958275541324449076L;
}
