package main.po;

import java.util.ArrayList;

public class UnitPO extends Message {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> poList = new ArrayList<String>();

	public ArrayList<String> getPoList() {
		return poList;
	}

	public void add(String unit) {
		poList.add(unit);
	}
}
