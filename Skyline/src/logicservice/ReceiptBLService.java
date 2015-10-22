package logicservice;

import java.util.ArrayList;

import vo.ReceiptVO;

public interface ReceiptBLService {
	//系统显示未审批的单据列表
	public ArrayList<ReceiptVO> showReceiptList();
	
	//标记审批后的单据，提交，系统提示审批成功（未成功的由总经理修改后，再标记）
	public boolean ApprovalReceipt(ArrayList<ReceiptVO> marked);
	
	//公司职工查看单据列表
	//单据编号为 职工账号+单据日期+单据创建次序
	public ArrayList<ReceiptVO> inquireReceiptList();
	
	//公司职工修改单据
	//系统显示保存单据
	public boolean modifyReceipt(ReceiptVO receipt);
	
	//公司职工提交单据
	public boolean submitReceipt(ReceiptVO receipt);
}
