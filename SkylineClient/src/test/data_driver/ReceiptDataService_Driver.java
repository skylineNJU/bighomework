package test.data_driver;

import java.util.ArrayList;

import main.dataservice.ReceiptDataService;
import main.po.ApprovalPO;
import main.po.StaffReceiptPO;

public class ReceiptDataService_Driver {

	public void drive(ReceiptDataService service){
		ArrayList<String> code = new ArrayList<String>();
		StaffReceiptPO staffReceiptPO = new StaffReceiptPO("05",code);
		ApprovalPO approvalPO = new ApprovalPO("205", "收款单");
		if(service.saveReceiptCode("50","508")||!service.saveReceiptCode("50","508")){
			System.out.println("保存接收单成功！");
		}
		if(service.delReceiptCode("0810","4")||!service.delReceiptCode("0810","4")){
			System.out.println("删除接收单成功！");
		}
		if(service.getStaffReceipt("205", staffReceiptPO)){
			System.out.println("获取员工接收单成功！");
		}
		if(service.getApprovalPO(approvalPO)){
			System.out.println("获取审批单成功！");
		}
		if(service.removeApprovalPO("505")){
			System.out.println("删除审批单成功！");
		}		
	}
}
