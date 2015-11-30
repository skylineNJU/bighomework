package main.po;

import java.util.ArrayList;

public class LobbyLoadingList extends Message {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<LoadingInfoPO> loadList=new ArrayList<LoadingInfoPO>();

	public ArrayList<LoadingInfoPO> getLoadList() {
		return loadList;
	}
	
	public void getDataFromBase(){
		for(LoadingInfoPO po:loadList){
			po.getDataFromBase();
		}
	}
}
