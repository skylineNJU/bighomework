package main.businesslogic.financebl;

import main.data.finance.FinanceDataController;
import main.dataservice.FinanceDataService;
import main.po.FeePO;
import main.vo.FeeVO;

public class Fee {
	
	public FeeVO getFee(){
		FinanceDataService finance = new FinanceDataController();
		FeePO feePO = finance.readFee();
		FeeVO feeVO = new FeeVO(feePO.getRoadFee(), feePO.getRailFee(), feePO.getAirFee());
		return feeVO;
	}

}
