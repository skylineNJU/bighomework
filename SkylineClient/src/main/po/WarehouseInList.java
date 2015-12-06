package main.po;

import java.util.ArrayList;

public class WarehouseInList extends Message{

	private static final long serialVersionUID = 1L;
	private ArrayList<WarehouseInPO>WarehouseInlist=new ArrayList<WarehouseInPO>();
	
	public WarehouseInList(String codeList){
		String[] codes=codeList.split(" ");
		for(int x=1;x<codes.length;x++){
			WarehouseInPO po=new WarehouseInPO(codes[x],null,0,0,0);
			po.setCode(codes[x]);
		}
	}
	
	
	public void add(WarehouseInPO po){
		WarehouseInlist.add(po);
	}
	
	public ArrayList<WarehouseInPO> getlist(){
		return WarehouseInlist;	
	}
}
