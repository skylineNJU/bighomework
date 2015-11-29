package main.presentation.mainui.memory;

public class ManagerMemory extends Memory{
	private String kinds;
	private String codes;
	public ManagerMemory(String userName, String code, String kinds, String code2) {
		super(userName, code);
		this.setKinds(kinds);
		setCodes(code2);
	}
	public String getKinds() {
		return kinds;
	}
	public void setKinds(String kinds) {
		this.kinds = kinds;
	}
	public String getCodes() {
		return codes;
	}
	public void setCodes(String codes) {
		this.codes = codes;
	}
	
	
}
