package bl_driver;

import java.util.ArrayList;

import vo.ReceiptVO;
import businesslogicservice.ReceiptBLService;

public class ReceiptBLService_Driver {
	
	ArrayList<ReceiptVO> receiptlist;
	ReceiptVO receipt;
	
	public void drive(ReceiptBLService receiptBLService){
		receiptlist.clear();
		receiptlist=receiptBLService.showReceiptList();
		if(receiptlist != null){
			System.out.println("---------Receiptlist Showing!-------------");
		}
		
		receiptlist.clear();
		if(receiptBLService.ApprovalReceipt(receiptlist)){
			System.out.println("---------Receipts approvalling!-------------");
		}
		
		receiptlist.clear();
		receiptlist=receiptBLService.inquireReceiptList();
		if(receiptlist != null){
			System.out.println("-----------Getting Receiptlist!-------------");
		}
		
		if(receiptBLService.modifyReceipt( receipt)){
			System.out.println("---------Modifying Success!-------------");
		}
		
		if(receiptBLService.submitReceipt(receipt)){
			System.out.println("---------Submit Success!-------------");
		}
	}
}
