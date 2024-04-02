package equitel.car.shop.dto;

import java.io.Serializable;

public class AuthRequest implements Serializable {
	private String user;
	private String password;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = -547280532449775258L;

}
