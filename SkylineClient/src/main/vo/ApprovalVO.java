package main.vo;

public class ApprovalVO {
	private String kinds;
	private String code;
	
	
	public ApprovalVO(String kinds, String code) {
		super();
		this.kinds = kinds;
		this.code = code;
	}
	public String getKinds() {
		return kinds;
	}
	public void setKinds(String kinds) {
		this.kinds = kinds;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
