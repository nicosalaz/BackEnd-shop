package equitel.car.shop.dto;

import java.io.Serializable;

import equitel.car.shop.model.Employee;

public class AuthValid implements Serializable {
	private Employee employee;
	private String privateEmployee;

	public AuthValid(Employee employee, String privateEmployee) {
		this.employee = employee;
		this.privateEmployee = privateEmployee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getPrivateEmployee() {
		return privateEmployee;
	}

	public void setPrivateEmployee(String privateEmployee) {
		this.privateEmployee = privateEmployee;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6051035302024608994L;

}
