package main.po;

import java.util.ArrayList;

public class LobbyLoadingList extends Message {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<LoadingInfoPO> loadList=new ArrayList<LoadingInfoPO>();

	public LobbyLoadingList(String codeList){
		String[] list=codeList.split(" ");
		for(int x=1;x<list.length;x++){
			LoadingInfoPO po=new LoadingInfoPO("","","","","","","",0);
			po.setCode(list[x]);
			loadList.add(po);
		}
	}

	public ArrayList<LoadingInfoPO> getLoadList() {
		return loadList;
	}
}
