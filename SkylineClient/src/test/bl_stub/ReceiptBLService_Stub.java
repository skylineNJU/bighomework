package test.bl_stub;

import java.util.ArrayList;

import  main.businesslogicservice.ReceiptBLService;
import  main.vo.ReceiptVO;

public class ReceiptBLService_Stub implements ReceiptBLService{

	@Override
	public boolean showReceiptList(ArrayList<ReceiptVO> receiptList) {
		System.out.println("��ʾ�ɹ���");
		return true;
	}

	@Override
	public boolean ApprovalReceipt(ArrayList<ReceiptVO> marked) {
		System.out.println("������ɣ�");
		return true;
	}

	@Override
	public boolean inquireReceiptList(ArrayList<ReceiptVO> receiptList) {
		System.out.println("��ѯ��ϣ�");
		return true;
	}

	@Override
	public boolean modifyReceipt(ReceiptVO receipt) {
		System.out.println("�޸ĳɹ���");
		return true;
	}

	@Override
	public boolean submitReceipt(String receiptCode) {
		System.out.println("�ύ�ɹ���");
		return true;
	}

	@Override
	public boolean save(String receiptCode) {
		System.out.println("����ɹ���");
		return true;
	}

	@Override
	public boolean delete(String[] receiptCode) {
		System.out.println("ɾ���ɹ���");
		return true;
	}
	
}
