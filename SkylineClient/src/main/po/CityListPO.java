package main.po;

import java.util.ArrayList;

public class CityListPO extends Message{

	private static final long serialVersionUID = 1L;
	private ArrayList<CityPO> list=new ArrayList<CityPO>();
	
	public  CityListPO(){
		
	}
	public ArrayList<CityPO> getList(){
		return list;
	}
	public void add(CityPO po) {
		// TODO Auto-generated method stub
		list.add(po);
	}
	
}
