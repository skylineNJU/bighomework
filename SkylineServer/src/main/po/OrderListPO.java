package main.po;

import java.util.ArrayList;

public class OrderListPO extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<OrderPO> poList=new ArrayList<OrderPO>();
	
	public void getDataFromBase(){
		for(OrderPO po:poList){
			po.getDataFromBase();
		}
	}
}
