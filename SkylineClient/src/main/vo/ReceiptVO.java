package main.vo;

public class ReceiptVO {

	private String code=null;
	
	public ReceiptVO(String co){
		if(co!=null)
		code=co;
	}
	public void convert(ReceiptVO vo){
		
	}


	
	public String getCode() {

	return code;
	}
	public void setCode(String code) {
	this.code = code;
	}
	public void write(String id,String date,String code){		
		this.code = code;
	}
}
