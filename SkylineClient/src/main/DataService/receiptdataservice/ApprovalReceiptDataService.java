package main.dataservice.receiptdataservice;

import main.po.ApprovalPO;

public interface ApprovalReceiptDataService {
	public void saveApprovalCode(ApprovalPO po);
	public ApprovalPO inquireApprovalPO(ApprovalPO po);
}
