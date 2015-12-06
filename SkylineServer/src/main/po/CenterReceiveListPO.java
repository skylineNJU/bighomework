package main.po;

import java.util.ArrayList;

public class CenterReceiveListPO extends Message{

	private static final long serialVersionUID = 1L;
	private ArrayList<CenterReceivePO> list=new ArrayList<CenterReceivePO>();

	public ArrayList<CenterReceivePO> getList(){
		return list;
	}
	
	public void getDataFromBase(){
		for(CenterReceivePO po:list){
			po.getDataFromBase();
		}
	}
}