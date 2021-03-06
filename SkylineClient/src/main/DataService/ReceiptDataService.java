package main.dataservice;

import main.po.ApprovalPO;
import main.po.StaffReceiptPO;


public interface ReceiptDataService {
	
	public boolean saveReceiptCode(String account,String code);
	
	public boolean getStaffReceipt(String account,StaffReceiptPO staffReceiptPO);
	
	public boolean delReceiptCode(String account,String code);
	
	public boolean getApprovalPO(ApprovalPO approvalPO);

	public boolean removeApprovalPO(String code);
	
}
