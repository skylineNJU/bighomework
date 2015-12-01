package main.po;

import java.util.ArrayList;

public class TrainLoadListPO extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<TrainLoadingPO> poList;
	
	public TrainLoadListPO(String codeList){
		poList=new ArrayList<TrainLoadingPO>();
		String[] codes=codeList.split(" ");
		for(int x=1;x<codes.length;x++){
			TrainLoadingPO po=new TrainLoadingPO("","","","","","","","", x);
			po.setCode(codes[x]);
			poList.add(po);
		}
	}

	public ArrayList<TrainLoadingPO> getPoList() {
		return poList;
	}
}
