package test.data_stub;

import java.util.ArrayList;
import java.util.List;

import  main.dataservice.ReceiptDataService;
import  main.po.ApprovalPO;
import  main.po.StaffReceiptPO;


public class ReceiptDataService_Stub implements ReceiptDataService {

	@Override
	public boolean saveReceiptCode(String account, String code) {
		System.out.println(account+"保存成功");
		return true;
	}

	@Override
	public boolean getStaffReceipt(String account, StaffReceiptPO staffReceiptPO) {
		System.out.println("获得"+account+"成功！");
		return true;
	}

	@Override
	public boolean delReceiptCode(String account, String code) {
		System.out.println("删除"+account+"成功！");
		return true;
	}

	@Override
	public boolean getApprovalPO(ApprovalPO approvalPO) {
		System.out.println("获得"+approvalPO.getCode()+"成功！");
		return true;
	}

	@Override
	public boolean removeApprovalPO(String code) {
		System.out.println("删除"+code+"成功！");
		return true;
	}

}
