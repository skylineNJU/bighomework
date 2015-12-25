package main.po;

import java.util.ArrayList;

public class LobbyReceiveListPO extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<LobbyReceivePO> poList=new ArrayList<LobbyReceivePO>();
	
	
	public void getDataFromBase(){
		for(LobbyReceivePO po:poList){
			po.getDataFromBase();
		}
	}
	

}
