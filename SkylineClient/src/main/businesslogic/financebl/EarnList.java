package main.businesslogic.financebl;

import java.util.ArrayList;

import main.data.finance.FinanceDataController;
import main.dataservice.FinanceDataService;
import main.po.CollectionPO;
import main.po.CollectionPOList;
import main.vo.EarnVO;

public class EarnList {
	
	
	public ArrayList<EarnVO> readEarnList(String date){
		FinanceDataService finance = new FinanceDataController();
		ArrayList<EarnVO> voList = new ArrayList<EarnVO>();
		CollectionPOList earnPOList = finance.readCollection(date);
		ArrayList<CollectionPO> poList = earnPOList.getList();
		for(CollectionPO collectionPO:poList){
			EarnVO earnVO = new EarnVO(collectionPO.getCollectionCode(), 
					collectionPO.getDate(), 
					collectionPO.getUnit(), 
					collectionPO.getBankAccount(),
					collectionPO.getMoney(), 
					collectionPO.getRemark());
			voList.add(earnVO);
		}
		return voList;
	}
	//写到数据库里面
	public boolean writeEarn(ArrayList<EarnVO> earnList){
		//TODO
		return true;
	}
}
