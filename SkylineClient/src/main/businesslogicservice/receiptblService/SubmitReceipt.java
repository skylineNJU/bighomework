package main.businesslogicservice.receiptblService;

import main.vo.ApprovalVO;

public interface SubmitReceipt {
	public void submit(String code,String kind);
	public ApprovalVO getApproval();
}
