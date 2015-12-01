package main.po;

import java.util.ArrayList;


public class VehicleLoadListPO extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<VehicleLoadingPO> loadList=new ArrayList<VehicleLoadingPO>();
	
	public ArrayList<VehicleLoadingPO> getLoadList() {
		return loadList;
	}

	public VehicleLoadListPO(String codeList){
		String[] codes=codeList.split(" ");
		for(int x=1;x<codes.length;x++){
			VehicleLoadingPO po=new VehicleLoadingPO("","","","","","","","", x);
			po.setCode(codes[x]);
			loadList.add(po);
		}
	}
}
