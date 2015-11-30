package main.po;

import java.util.ArrayList;

public class DistributePOList extends Message{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<DistributePO> distributeList = new ArrayList<DistributePO>();
	
	public void add(DistributePO distributePO){
		distributeList.add(distributePO);
	}
	
	public ArrayList<DistributePO> getList(){
		return distributeList;
	}
}
