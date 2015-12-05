package main.businesslogic.financebl;

import java.util.ArrayList;

import main.data.finance.FinanceDataController;
import main.dataservice.FinanceDataService;
import main.po.CollectionPO;
import main.po.LobbyEarnPO;
import main.vo.EarnVO;

public class LobbyEarn {
	
	public ArrayList<EarnVO> readLobbyEarn(String date,String unit){
		FinanceDataService finance = new FinanceDataController();
		LobbyEarnPO lobbyEarnPO = finance.readLobbyEarn(date, unit);
		ArrayList<CollectionPO> poList = lobbyEarnPO.getList();
		ArrayList<EarnVO> voList = new ArrayList<EarnVO>();
		for(CollectionPO collectionPO:poList){
			EarnVO earnVO = new EarnVO(collectionPO.getCollectionCode(), 
					collectionPO.getDate(), 
					collectionPO.getUnit(), 
					collectionPO.getBankAccount(),
					collectionPO.getMoney(), 
					collectionPO.getRemark(),
					collectionPO.getIsPaid());
			voList.add(earnVO);
		}
		return voList;
	}
}
