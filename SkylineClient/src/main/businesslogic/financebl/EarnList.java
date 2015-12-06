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
					collectionPO.getRemark(),
					collectionPO.getIsPaid());
			voList.add(earnVO);
		}
		return voList;
	}
	//写到数据库里面
	public boolean writeEarn(EarnVO earnVO){
		FinanceDataService finance = new FinanceDataController();
		CollectionPO collectionPO = new CollectionPO(earnVO.getCollectionCode(), 
				earnVO.getDate(), earnVO.getUnit(), earnVO.getBankAccount(), 
				earnVO.getMoney(), earnVO.getRemark(), earnVO.getIsPaid()
				);
		return finance.writeCollection(collectionPO);
	}
	
	public boolean delEarn(EarnVO earnVO){
//		String collectionCode,String date,String unit,String bankAccount,double money,String remark,String isPaid
		CollectionPO collectionPO = new CollectionPO(earnVO.getCollectionCode(),
				earnVO.getDate(),earnVO.getUnit(),earnVO.getBankAccount(),
				earnVO.getMoney(),earnVO.getRemark(),earnVO.getIsPaid()
				);
		FinanceDataService finance = new FinanceDataController();
		return finance.delCollection(collectionPO);
	}
}
