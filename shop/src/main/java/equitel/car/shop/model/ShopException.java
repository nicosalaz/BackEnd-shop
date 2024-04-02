package equitel.car.shop.model;

import org.springframework.http.HttpStatus;

public class ShopException extends Throwable {
	private String codeError;
	private String messageError;
	private HttpStatus status;
	private String response;
	private String serviceName;

	public ShopException(String codeError, String messageError, HttpStatus status, String response,
			String serviceName) {
		super();
		this.codeError = codeError;
		this.messageError = messageError;
		this.status = status;
		this.response = response;
		this.serviceName = serviceName;
	}

	public ShopException(String codeError, String messageError, HttpStatus status, String response) {
		super();
		this.codeError = codeError;
		this.messageError = messageError;
		this.status = status;
		this.response = response;
	}

	public String getCodeError() {
		return codeError;
	}

	public void setCodeError(String codeError) {
		this.codeError = codeError;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
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
	private static final long serialVersionUID = 4962214254644690301L;

}
