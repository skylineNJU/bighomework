package main.po;

import java.util.ArrayList;

public class DistancePO extends Message {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<String[]> city = new ArrayList<String[]>();

	public ArrayList<String[]> getCity() {
		return city;
	}

	public void setCity(ArrayList<String[]> city) {
		this.city = city;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}