package main.po;

import java.util.ArrayList;

	public class WarehouseOutList extends Message{

		private static final long serialVersionUID = 1L;
		private ArrayList<WarehouseOutPO> WarehouseOutlist = new ArrayList<WarehouseOutPO>();
		
		public WarehouseOutList(String codeList){
			System.out.println("Codelist++++++++::::::::::"+codeList);
			String[] codes=codeList.split(" ");
			System.out.println(")))))))))))):::length:::::::::::::::"+codes.length);
			for(int x=1;x<codes.length;x++){
				WarehouseOutPO po=new WarehouseOutPO(codes[x],null,0,0,0);
				po.setCode(codes[x]);
				WarehouseOutlist.add(po);
			}
		}
		
		
		public void add(WarehouseOutPO po){
			WarehouseOutlist.add(po);
		}
		
		public ArrayList<WarehouseOutPO> getlist(){
			return WarehouseOutlist;	
		}
	}
