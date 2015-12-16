package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class UnitPO extends Message {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> poList = new ArrayList<String>();
	
	public ArrayList<String> getPoList() {
		return poList;
	}

	public void add(String unit) {
		poList.add(unit);
	}
	
	public void getDataFromBase(){
    	SqlReader reader=new SqlReader("AccountInfo");
    	while(reader.hasNext()){
    		String unit = reader.getString("À˘ Ùµ•Œª");
    		if(poList.indexOf(unit)==-1){
    			poList.add(unit);
    		}
    	}
    	reader.close();
    }
}
