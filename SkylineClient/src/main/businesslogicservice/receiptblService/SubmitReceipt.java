package main.businesslogicservice.receiptblService;

import main.vo.ApprovalVO;
import main.vo.ReceiptRecordVO;

public interface SubmitReceipt {
	public void submit(String code,String kind);
	public ApprovalVO getApproval();
	public void submitCourrierReceipt(String code);
	public void submitLobbyReceipt(String code);
	public void submitIntermediateReceipt(String code);
	public void submitWarhouseReceipt(String code);
	public void submitFinanceReceipt(String code);
	public ReceiptRecordVO inquireReceiptRecord();
	public void approveReceipt(ReceiptRecordVO vo);
}
