package main.businesslogicservice.receiptblService;

import main.vo.CorrierReceiptVO;

public interface CourrierReceipt {
	public void saveOrderCode(String orderCode,String userName);
	
	public void saveReceiveCode(String ReceiveCode,String userName);
	
	public void saveDistributeCode(String DistributeCode,String userName);
	
	public CorrierReceiptVO getAllReceipt(String userName);
}
