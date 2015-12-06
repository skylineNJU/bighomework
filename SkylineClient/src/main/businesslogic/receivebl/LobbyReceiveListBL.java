package main.businesslogic.receivebl;

import java.util.ArrayList;
import java.util.ListIterator;

import main.data.receive.ReceiveDataController;
import main.dataservice.ReceiveDataService;
import main.po.LobbyReceiveListPO;
import main.po.LobbyReceivePO;
import main.vo.LobbyReceptionVO;

public class LobbyReceiveListBL {
	private LobbyReceiveListPO po;
	
	public LobbyReceiveListBL(String codes){
		po=new LobbyReceiveListPO(codes);
	}
	
	public ArrayList<LobbyReceptionVO> inquire(){
		ArrayList<LobbyReceptionVO> voList=new ArrayList<LobbyReceptionVO>();
		ReceiveDataService service=new ReceiveDataController();
		po=service.readLobbyReceiveOrder(po);
	
		ArrayList<LobbyReceivePO> polist=po.getPoList();
		
		for(LobbyReceivePO p:polist){
			LobbyReceptionVO vo=new LobbyReceptionVO(
					p.getCode(),
					p.getReceiveYear(),
					p.getReceiveMonth(),
					p.getReceiveDay(),
					p.getCondition(),
					p.getExpressBar());
			voList.add(vo);
		}
		return voList;
	}
}
