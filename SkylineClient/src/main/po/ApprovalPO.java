package main.po;

import java.util.List;

//审批未通过单号
public class ApprovalPO extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String kinds;
	public ApprovalPO(String code, String kinds) {
		super();
		this.setCode(code);
		this.setKinds(kinds);
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getKinds() {
		return kinds;
	}
	public void setKinds(String kinds) {
		this.kinds = kinds;
	}
	
	
	
}
