package logicservice;

import java.util.ArrayList;

import vo.ReceiptVO;

public interface ReceiptBLService {
	//ϵͳ��ʾδ�����ĵ����б�
	public ArrayList<ReceiptVO> showReceiptList();
	
	//���������ĵ��ݣ��ύ��ϵͳ��ʾ�����ɹ���δ�ɹ������ܾ����޸ĺ��ٱ�ǣ�
	public boolean ApprovalReceipt(ArrayList<ReceiptVO> marked);
	
	//��˾ְ���鿴�����б�
	//���ݱ��Ϊ ְ���˺�+��������+���ݴ�������
	public ArrayList<ReceiptVO> inquireReceiptList();
	
	//��˾ְ���޸ĵ���
	//ϵͳ��ʾ���浥��
	public boolean modifyReceipt(ReceiptVO receipt);
	
	//��˾ְ���ύ����
	public boolean submitReceipt(ReceiptVO receipt);
}
