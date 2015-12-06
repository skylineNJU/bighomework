package main.businesslogic.financebl;

import java.util.ArrayList;

import main.data.finance.FinanceDataController;
import main.dataservice.FinanceDataService;
import main.po.CostPO;
import main.po.CostPOList;
import main.vo.CostVO;

public class CostList {
	
	public ArrayList<CostVO> readCostList(String date) {
		FinanceDataService financeData = new FinanceDataController();
		CostPOList costPOList = financeData.readCost(date);
		ArrayList<CostPO> poList = costPOList.getList();
		ArrayList<CostVO> voList = new ArrayList<CostVO>();
		voList.clear();
		for(CostPO costPO:poList){
			CostVO costVO = new CostVO(date, 
					costPO.getCostCode(), 
					costPO.getBankAccount(), 
					Double.valueOf(costPO.getFee()), 
					costPO.getRemark(),
					costPO.getCostType(),
					costPO.getIsPaid());
			voList.add(costVO);
		}
		return voList;
	}

	public boolean writeCostList(CostVO costVO) {
		FinanceDataService finance = new FinanceDataController();
		CostPO costPO = new CostPO(costVO.getBankAccount(), String.valueOf(costVO.getCost()), 
				costVO.getCostType(), costVO.getDate(), costVO.getComment(), 
				costVO.getCostCode(), costVO.getIsPaid());
		finance.writeCost(costPO);
		return true;
	}
	
	public boolean deleteCost(CostVO costVO){
		CostPO costPO = new CostPO(costVO.getBankAccount(), String.valueOf(costVO.getCost()), 
				costVO.getCostType(), costVO.getDate(), costVO.getComment(), costVO.getCostCode(), costVO.getIsPaid()
				);
		FinanceDataService finance = new FinanceDataController();
		return finance.deleteCost(costPO);
	}
}
