package test.bl_stub;

import java.util.ArrayList;

import  main.businesslogicservice.ReceiptBLService;
import  main.vo.ReceiptVO;

public class ReceiptBLService_Stub implements ReceiptBLService{

	@Override
	public boolean showReceiptList(ArrayList<ReceiptVO> receiptList) {
		System.out.println("显示成功！");
		return true;
	}

	@Override
	public boolean ApprovalReceipt(ArrayList<ReceiptVO> marked) {
		System.out.println("审批完成！");
		return true;
	}

	@Override
	public boolean inquireReceiptList(ArrayList<ReceiptVO> receiptList) {
		System.out.println("查询完毕！");
		return true;
	}

	@Override
	public boolean modifyReceipt(ReceiptVO receipt) {
		System.out.println("修改成功！");
		return true;
	}

	@Override
	public boolean submitReceipt(String receiptCode) {
		System.out.println("提交成功！");
		return true;
	}

	@Override
	public boolean save(String receiptCode) {
		System.out.println("保存成功！");
		return true;
	}

	@Override
	public boolean delete(String[] receiptCode) {
		System.out.println("删除成功！");
		return true;
	}
	
}
