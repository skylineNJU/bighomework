package main.po;

import java.io.Serializable;

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String key;
	
	
	public void writeIntoDatabase() {
	}
	
	public void getDataFromBase(){
		
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

}
