package test.data_stub;

import java.util.ArrayList;
import java.util.List;

import  main.dataservice.ReceiptDataService;
import  main.po.ApprovalPO;
import  main.po.StaffReceiptPO;


public class ReceiptDataService_Stub implements ReceiptDataService {

	@Override
	public boolean saveReceiptCode(String account, String code) {
		System.out.println(account+"����ɹ�");
		return true;
	}

	@Override
	public boolean getStaffReceipt(String account, StaffReceiptPO staffReceiptPO) {
		System.out.println("���"+account+"�ɹ���");
		return true;
	}

	@Override
	public boolean delReceiptCode(String account, String code) {
		System.out.println("ɾ��"+account+"�ɹ���");
		return true;
	}

	@Override
	public boolean getApprovalPO(ApprovalPO approvalPO) {
		System.out.println("���"+approvalPO.getCode()+"�ɹ���");
		return true;
	}

	@Override
	public boolean removeApprovalPO(String code) {
		System.out.println("ɾ��"+code+"�ɹ���");
		return true;
	}

}
