package main.vo;

import main.po.Message;

public class ReceiptVO extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	
	public ReceiptVO(String co){
		if(co!=null)
		this.code=co;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
	this.code = code;
	}
}
