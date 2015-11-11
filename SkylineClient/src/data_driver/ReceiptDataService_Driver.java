package data_driver;

import dataService.ReceiptDataService;

public class ReceiptDataService_Driver {
public void drive(ReceiptDataService receiptDataService){
	if(receiptDataService.saveReceiptCode("000004000005", "12121415")){
		System.out.println("---------Saving ReceiptCode Success!-------------");
	}
	if(receiptDataService.getStaffReceipt("00030000005")!=null){
		System.out.println("---------Getting StaffReceipt Success!-------------");
	}
	if(receiptDataService.delReceiptCode("000001000003", "14151617")){
		System.out.println("---------Deleting ReceiptCode Success!-------------");
	}
	if(receiptDataService.getApprovalPO()!=null){
		System.out.println("---------Getting Approval Success!-------------");
	}
	if(receiptDataService.removeApprovalPO("1214171618")){
		System.out.println("---------Removing Approval Success!-------------");
	}
}

}
