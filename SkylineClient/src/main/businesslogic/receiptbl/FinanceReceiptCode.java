package main.businesslogic.receiptbl;

import main.data.receipt.ReceiptController;
import main.dataservice.receiptdataservice.FinanceReceiptDataService;
import main.po.FinanceReceipt;
import main.vo.FinanceReceiptVO;

public class FinanceReceiptCode {
	private String accountName;
	private String costCode;
	private String earnCode;
	private FinanceReceipt po;
	
	public FinanceReceiptCode(String accountName, String costCode, String earnCode) {
		super();
		this.setAccountName(accountName);
		this.setCostCode(costCode);
		this.setEarnCode(earnCode);
	}

	public void saveInfo(){
		po=new FinanceReceipt(accountName,costCode,earnCode);
		FinanceReceiptDataService service=new ReceiptController();
		service.saveFinanceCodes(po);
	}
	
	public FinanceReceiptVO inquireFinanceCode(){
		po=new FinanceReceipt(accountName,costCode,earnCode);
		FinanceReceiptDataService service=new ReceiptController();
		po=service.inquireFinanceReceipt(po);
		FinanceReceiptVO vo=new FinanceReceiptVO(po.getAccountName(),po.getCostCode(),po.getEarnCode());
		return vo;
		
	}
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getCostCode() {
		return costCode;
	}

	public void setCostCode(String costCode) {
		this.costCode = costCode;
	}

	public String getEarnCode() {
		return earnCode;
	}

	public void setEarnCode(String earnCode) {
		this.earnCode = earnCode;
	}
	
}
