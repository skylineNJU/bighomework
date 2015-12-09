package test.data_driver;

import java.util.ArrayList;

import main.dataservice.ReceiptDataService;
import main.po.ApprovalPO;
import main.po.StaffReceiptPO;

public class ReceiptDataService_Driver {

	public void drive(ReceiptDataService service){
		ArrayList<String> code = new ArrayList<String>();
		StaffReceiptPO staffReceiptPO = new StaffReceiptPO("05",code);
		ApprovalPO approvalPO = new ApprovalPO("205", "�տ");
		if(service.saveReceiptCode("50","508")||!service.saveReceiptCode("50","508")){
			System.out.println("������յ��ɹ���");
		}
		if(service.delReceiptCode("0810","4")||!service.delReceiptCode("0810","4")){
			System.out.println("ɾ�����յ��ɹ���");
		}
		if(service.getStaffReceipt("205", staffReceiptPO)){
			System.out.println("��ȡԱ�����յ��ɹ���");
		}
		if(service.getApprovalPO(approvalPO)){
			System.out.println("��ȡ�������ɹ���");
		}
		if(service.removeApprovalPO("505")){
			System.out.println("ɾ���������ɹ���");
		}		
	}
}
