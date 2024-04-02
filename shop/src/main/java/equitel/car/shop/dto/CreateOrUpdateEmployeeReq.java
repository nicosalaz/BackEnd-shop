package equitel.car.shop.dto;

public class CreateOrUpdateEmployeeReq {
	private Long idEmpleado;
	private String name;
	private String lastName;
	private String user;
	private String password;
	private int fkRole;

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

	public int getFkRole() {
		return fkRole;
	}

	public void setFkRole(int fkRole) {
		this.fkRole = fkRole;
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

}
