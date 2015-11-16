package main.businesslogic.receiptbl;

import java.util.ArrayList;

import main.vo.ReceiptVO;

public class Receipt {
	
	public boolean showReceiptList(ArrayList<ReceiptVO> receiptList){
		
		return true;
	}
	
	public boolean saveRecipt(ReceiptVO receipt){
		return true;
	}
	
	public boolean saveReciptCode(String receiptCode){
		return true;
	}
	
	public boolean submitReciptCode(String receiptCode){
		return true;
	}
	
	public boolean inquireReceiptList(ArrayList<ReceiptVO> receiptList){
		return true;
	}
	
	public boolean ApprovalReceipt(ArrayList<ReceiptVO> marked){
		return true;
	}
	
	public boolean delete(String[] receiptCode) {
		return true;
	}
}
