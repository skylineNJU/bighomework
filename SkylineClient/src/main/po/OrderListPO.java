package main.po;

import java.util.ArrayList;

public class OrderListPO extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<OrderPO> poList=new ArrayList<OrderPO>();
	public OrderListPO(String codes){
		String[] code=codes.split(" ");
		for(int x=1;x<code.length;x++){
			OrderPO po=new OrderPO("","","","","","","","", null, null,0,0,0,"", null,"",0);
			po.setCode(code[x]);
			poList.add(po);
		}
	}
	
	public ArrayList<OrderPO> getPoList(){
		return this.poList;
	}
}
