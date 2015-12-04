package main.po;

import java.util.ArrayList;

public class CenterReceiveListPO extends Message{

	private static final long serialVersionUID = 1L;
	private ArrayList<CenterReceivePO> list=new ArrayList<CenterReceivePO>();
	public CenterReceiveListPO(String codeList){
		String[] codes=codeList.split(" ");
		for(int x=1;x<codes.length;x++){
			CenterReceivePO po=new CenterReceivePO(0,0,0,"","");
			po.setCode(codes[x]);
			list.add(po);
		}
	}
	public ArrayList<CenterReceivePO> getList(){
		return list;
	}
}
