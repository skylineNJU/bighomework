package dataservice;

import po.ApprovalPO;
import po.StaffReceiptPO;

//
public interface ReceiptDataService {
	
	public boolean saveReceiptCode(String account,String code);
	
	public StaffReceiptPO getStaffReceipt(String account);
	
	public boolean delReceiptCode(String account,String code);
	
	public ApprovalPO getApprovalPO();
	
	public boolean removeApprovalPO(String code);
	
}
