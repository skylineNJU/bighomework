package main.po;

import java.util.ArrayList;

public class CostPOList extends Message{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<CostPO> cost = new ArrayList<CostPO>();
	
	public void add(CostPO costPO){
		cost.add(costPO);
	}
	public ArrayList<CostPO> getList(){
		return cost;
	}
}
