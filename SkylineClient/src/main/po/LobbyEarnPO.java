package main.po;

import java.util.ArrayList;

public class LobbyEarnPO extends Message {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<CollectionPO> poList = new ArrayList<CollectionPO>();
	
	public void add(CollectionPO collectionPO) {
		poList.add(collectionPO);
	}
	
	public ArrayList<CollectionPO> getList() {
		return poList;
	}

}
