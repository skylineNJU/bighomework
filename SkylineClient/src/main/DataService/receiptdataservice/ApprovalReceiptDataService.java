package main.dataservice.receiptdataservice;

import main.po.ApprovalPO;
import main.po.ReceiptRecordPO;

public interface ApprovalReceiptDataService {
	public void saveApprovalCode(ApprovalPO po);
	public ApprovalPO inquireApprovalPO(ApprovalPO po);
	
	public void saveReceiptRecord(ReceiptRecordPO po);
	public ReceiptRecordPO inquireReceiptRecord(ReceiptRecordPO po);
	public void approveReceipt(ReceiptRecordPO po);
}
