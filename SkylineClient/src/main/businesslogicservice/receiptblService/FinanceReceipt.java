package main.businesslogicservice.receiptblService;

import main.vo.FinanceReceiptVO;

public interface FinanceReceipt {
	public void saveCostCode(String userName,String costCode);
	public void saveEarnCode(String userName,String earnCode);
	public FinanceReceiptVO getFinanceCode(String name);
}
