package test.bl_driver;

import java.util.ArrayList;

import main.businesslogicservice.ReceiptBLService;
import main.vo.ReceiptVO;

public class ReceiptBLService_Driver {
	
	ArrayList<ReceiptVO> receiptlist;
	ReceiptVO receipt;
	String receiptCode="13141516";
	String[] reCo={"13141516","555555"};
	
	public void drive(ReceiptBLService receiptBLService){
		receiptlist.clear();
		if(receiptBLService.showReceiptList(receiptlist)){
			System.out.println("---------Receiptlist Showing!-------------");
		}
		
		receiptlist.clear();
		if(receiptBLService.ApprovalReceipt(receiptlist)){
			System.out.println("---------Receipts approvalling!-------------");
		}
		
		receiptlist.clear();
		
		if(receiptBLService.inquireReceiptList(receiptlist)){
			System.out.println("-----------Inquiring Receiptlist!-------------");
		}
		
		if(receiptBLService.modifyReceipt( receipt)){
			System.out.println("---------Modifying Success!-------------");
		}
		
		if(receiptBLService.submitReceipt(receiptCode)){
			System.out.println("---------Submit Success!-------------");
		}
		
		if(receiptBLService.save(receiptCode)){
			System.out.println("---------Save Success!-------------");
		}
		if(receiptBLService.delete(reCo)){
			System.out.println("---------Delete Success!-------------");
		}
	}
}