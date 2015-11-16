package main.businesslogic.receiptbl.mocktest;

import java.util.ArrayList;

import main.businesslogic.receiptbl.Receipt;
import main.vo.ReceiptVO;
import main.vo.VehicleLoadingVO;

public class MockReceipt extends Receipt {
public boolean showReceiptList(ArrayList<ReceiptVO> receiptList){
	String orderCodes[]={
			"1324124123",
			"3241324442"
	};
		ReceiptVO receipt=new VehicleLoadingVO("1234123121","2015-01-01","31223412",
				"12413432","南京栖霞","南京金牛","张三",
				"李四",orderCodes,50);
		receiptList.add(receipt);
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
		String orderCodes[]={
				"1324124123",
				"3241324442"
		};
			ReceiptVO receipt=new VehicleLoadingVO("1234123121","2015-01-01","31223412",
					"12413432","南京栖霞","南京金牛","张三",
					"李四",orderCodes,50);
			receiptList.add(receipt);
		return true;
	}
	
	public boolean ApprovalReceipt(ArrayList<ReceiptVO> marked){
		return true;
	}
	
	public boolean delete(String[] receiptCode) {
		return true;
	}
}
