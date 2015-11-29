package main.presentation.mainui.memory;

public class Memory {
	protected String userName;
	protected String code;
		
	public Memory(String userName, String code) {
		super();
		this.userName = userName;
		this.code = code;
	}

	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public void setCode(String code){
		this.code=code;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public String getCode(){
		return code;
	}
}
