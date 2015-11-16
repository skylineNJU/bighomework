package main.businesslogic.receiptbl;

import java.util.ArrayList;

import main.businesslogicservice.ReceiptBLService;
import main.vo.ReceiptVO;

public class ReceiptController implements ReceiptBLService {

	@Override
	public boolean showReceiptList(ArrayList<ReceiptVO> receiptList) {
		// TODO Auto-generated method stub
		return new Receipt().showReceiptList(receiptList);
	}

	@Override
	public boolean ApprovalReceipt(ArrayList<ReceiptVO> marked) {
		// TODO Auto-generated method stub
		
		return new Receipt().ApprovalReceipt(marked);
	}

	@Override
	public boolean inquireReceiptList(ArrayList<ReceiptVO> receiptList) {
		// TODO Auto-generated method stub
		return new Receipt().inquireReceiptList(receiptList);
	}

	@Override
	public boolean modifyReceipt(ReceiptVO receipt) {
		// TODO Auto-generated method stub
		
		return new Receipt().saveRecipt(receipt);
	}

	@Override
	public boolean submitReceipt(String receiptCode) {
		// TODO Auto-generated method stub
		
		return new Receipt().submitReciptCode(receiptCode);
	}

	@Override
	public boolean save(String receiptCode) {
		// TODO Auto-generated method stub		
		return new Receipt().saveReciptCode(receiptCode);
	}

	@Override
	public boolean delete(String[] receiptCode) {
		// TODO Auto-generated method stub
		return new Receipt().delete(receiptCode);
	}

}
