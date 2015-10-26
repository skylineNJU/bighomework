package businesslogic.receiptbl;

import java.util.ArrayList;

import businesslogicservice.ReceiptBLService;
import vo.ReceiptVO;

public class ReceiptController implements ReceiptBLService {

	@Override
	public ArrayList<ReceiptVO> showReceiptList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ApprovalReceipt(ArrayList<ReceiptVO> marked) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<ReceiptVO> inquireReceiptList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyReceipt(ReceiptVO receipt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean submitReceipt(ReceiptVO receipt) {
		// TODO Auto-generated method stub
		return false;
	}

}
