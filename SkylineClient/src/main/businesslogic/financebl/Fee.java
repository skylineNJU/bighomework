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
	
	public boolean writeFee(FeeVO feeVO){
		FinanceDataService finance = new FinanceDataController();
		FeePO feePO = new FeePO(feeVO.getRoadFee(), feeVO.getRailFee(), feeVO.getAirFee());
		return finance.writeFee(feePO);
	}
	
	public boolean delFee(FeeVO feeVO){
		FinanceDataService finance = new FinanceDataController();
		FeePO feePO = new FeePO(feeVO.getRoadFee(), feeVO.getRailFee(), feeVO.getAirFee());
		return finance.delFee(feePO);
	}
}
