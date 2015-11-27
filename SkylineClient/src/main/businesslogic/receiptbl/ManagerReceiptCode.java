package main.businesslogic.receiptbl;

import main.data.receipt.ReceiptController;
import main.dataservice.receiptdataservice.ApprovalReceiptDataService;
import main.po.ApprovalPO;
import main.vo.ApprovalVO;

public class ManagerReceiptCode {
	private String kinds;
	private String code;
	private ApprovalPO po;
	
	
	public ManagerReceiptCode(String kinds, String code) {
		super();
		this.setKinds(kinds);
		this.code = code;
	}



	public void saveInfo(){
		ApprovalReceiptDataService service=new ReceiptController();
		po=new ApprovalPO(code,kinds);
		service.saveApprovalCode(po);
	}
	
	public ApprovalVO inquire(){
		ApprovalReceiptDataService service=new ReceiptController();
		po=new ApprovalPO(code,kinds);
		po=service.inquireApprovalPO(po);
		ApprovalVO vo=new ApprovalVO(po.getKinds(),po.getCode());
		return vo;
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}



	public String getKinds() {
		return kinds;
	}



	public void setKinds(String kinds) {
		this.kinds = kinds;
	}
	
	
}
