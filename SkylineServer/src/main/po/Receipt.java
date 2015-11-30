package main.po;

public class Receipt extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
