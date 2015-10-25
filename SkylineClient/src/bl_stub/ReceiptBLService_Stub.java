package bl_stub;

import java.util.ArrayList;

import businesslogicservice.ReceiptBLService;
import vo.ReceiptVO;

public class ReceiptBLService_Stub implements ReceiptBLService{
	ArrayList<ReceiptVO> receipt=new ArrayList<ReceiptVO>();
	@Override
	public ArrayList<ReceiptVO> showReceiptList() {
		// TODO Auto-generated method stub
		ReceiptVO re=new ReceiptVO("123","321","213");
		receipt.clear();
		receipt.add(re);
		return receipt;
	}

	@Override
	public boolean ApprovalReceipt(ArrayList<ReceiptVO> marked) {
		// TODO Auto-generated method stub
		System.out.println("我有一友屌似卿");
		return false;
	}

	@Override
	public ArrayList<ReceiptVO> inquireReceiptList() {
		// TODO Auto-generated method stub
		ReceiptVO re=new ReceiptVO("123","321","213");
		receipt.clear();
		receipt.add(re);
		return receipt;
	}

	@Override
	public boolean modifyReceipt(ReceiptVO receipt) {
		// TODO Auto-generated method stub
		System.out.println("我有一友屌似卿时");
		return false;
	}

	@Override
	public boolean submitReceipt(ReceiptVO receipt) {
		// TODO Auto-generated method stub
		System.out.println("我有一友屌似卿啊");
		return false;
	}

}
