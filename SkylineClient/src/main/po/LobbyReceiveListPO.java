package main.po;

import java.util.ArrayList;
import java.util.ListIterator;

public class LobbyReceiveListPO extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<LobbyReceivePO> poList=new ArrayList<LobbyReceivePO>();
	
	public ArrayList<LobbyReceivePO> getPoList() {
		return poList;
	}

	public LobbyReceiveListPO(String codes){
		String[] code=codes.split(" ");
		for(int x=1;x<code.length;x++){
			LobbyReceivePO po=new LobbyReceivePO("","","","","");
			po.setCode(code[x]);
			poList.add(po);
		}
	}
	

}
