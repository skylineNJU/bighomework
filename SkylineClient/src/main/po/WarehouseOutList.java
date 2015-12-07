package main.po;

import java.util.ArrayList;

	public class WarehouseOutList extends Message{

		private static final long serialVersionUID = 1L;
		private ArrayList<WarehouseOutPO> WarehouseOutlist = new ArrayList<WarehouseOutPO>();
		
		public WarehouseOutList(String codeList){
			String[] codes=codeList.split(" ");
			for(int x=1;x<codes.length;x++){
				WarehouseOutPO po=new WarehouseOutPO(codeList,null,0,0,0);
				po.setCode(codes[x]);
			}
		}
		
		
		public void add(WarehouseOutPO po){
			WarehouseOutlist.add(po);
		}
		
		public ArrayList<WarehouseOutPO> getlist(){
			return WarehouseOutlist;	
		}
	}
