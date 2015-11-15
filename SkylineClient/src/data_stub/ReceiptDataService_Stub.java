package data_stub;

import java.util.ArrayList;
import java.util.List;

import dataservice.ReceiptDataService;
import po.ApprovalPO;
import po.StaffReceiptPO;


public class ReceiptDataService_Stub implements ReceiptDataService {
	
	public boolean saveReceiptCode(String account,String code){
		System.out.println("save Succeed!/n");
		return true;
	}
	
	public StaffReceiptPO getStaffReceipt(String account){
		StaffReceiptPO staffReceiptPO = new StaffReceiptPO(account, null);
		System.out.println("Succeed!/n");
		return staffReceiptPO;
	}
	
	public boolean delReceiptCode(String account,String code){
		System.out.println("delete Succeed!/n");
		return true;
	}
	
	public ApprovalPO getApprovalPO(){
		List<String> codeList = new ArrayList<String>();
		codeList.clear();
		codeList.add("0260559");
		System.out.println("Succeed!/n");
		ApprovalPO approvalPO = new ApprovalPO(codeList);
		return approvalPO;
	}
	//........
	public boolean removeApprovalPO(String code){
		System.out.println("remove Succeed!/n");
		return true;
	}
}
