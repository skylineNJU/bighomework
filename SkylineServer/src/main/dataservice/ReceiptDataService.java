package main.dataservice;

import main.po.ApprovalPO;
import main.po.CourrierReceiptPO;

//
public interface ReceiptDataService {
	
	public boolean saveReceiptCode(String account,String code);
	
	public CourrierReceiptPO getStaffReceipt(String account);
	
	public boolean delReceiptCode(String account,String code);
	
	public ApprovalPO getApprovalPO();
	
	public boolean removeApprovalPO(String code);
	
}
