package equitel.car.shop.model;

import java.io.Serializable;

public class ResponseError implements Serializable {
	private String codeError;
	private String messageError;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = -7819839030423085420L;

}
