package equitel.car.shop.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity()
@Table(name = "EMPLEADOS")
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpleado;
	@Column(name = "NOMBRE")
	private String name;
	@Column(name = "APELLIDOS")
	private String lastName;
	@Column(name = "USUARIO")
	private String user;
	@Column(name = "CLAVE")
	@JsonIgnore
	private String password;
	@ManyToOne
	@JoinColumn(name = "FK_ROL")
	private Role fkRole;
	@Column(name = "ACTIVO")
	private int active;

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getFkRole() {
		return fkRole;
	}

	public void setFkRole(Role fkRole) {
		this.fkRole = fkRole;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return idEmpleado + "," + name + "," + lastName + "," + user + ","+ fkRole.getId() + "," + active;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3832180975040692508L;

}
