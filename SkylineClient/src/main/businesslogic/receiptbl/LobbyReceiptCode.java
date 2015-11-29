package main.businesslogic.receiptbl;

import main.data.receipt.ReceiptController;
import main.dataservice.receiptdataservice.LobbyReceiptDataService;
import main.po.LobbyReceiptPO;
import main.vo.LobbyLoading;
import main.vo.LobbyReceiptVO;

public class LobbyReceiptCode {
	private String accountName;
	private String receiveCode;
	private String earnCode;
	private String receiveDate;
	private String earnDate;
	private String lobbyLoading;
	private LobbyReceiptPO po;
	
	
	public LobbyReceiptCode(String accountName, String receiveCode, String earnCode, String receiveDate,
			String earnDate, String lobbyLoading) {
		super();
		this.accountName = accountName;
		this.receiveCode = receiveCode;
		this.earnCode = earnCode;
		this.receiveDate = receiveDate;
		this.earnDate = earnDate;
		this.lobbyLoading = lobbyLoading;
	}

	public void saveInfo(){
		LobbyReceiptDataService service=new ReceiptController();
		po=new LobbyReceiptPO(accountName,receiveCode,earnCode,receiveDate,earnDate,lobbyLoading);
		service.saveLobbyCode(po);
	}
	
	public LobbyReceiptVO inquireLobbyCode(){
		LobbyReceiptDataService service=new ReceiptController();
		po=new LobbyReceiptPO(accountName,receiveCode,earnCode,receiveDate,earnDate,lobbyLoading);
		po=service.inquireLobbyReceipt(po);
		LobbyReceiptVO vo=new LobbyReceiptVO(po.getAccountName(),po.getReceiveCode(),
				po.getEarnCode(),po.getReceiveDate(),po.getEarnDate(),po.getLobbyLoading());
		return vo;
	}
	
	
	
	
	
	
	
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getReceiveCode() {
		return receiveCode;
	}
	public void setReceiveCode(String receiveCode) {
		this.receiveCode = receiveCode;
	}
	public String getEarnCode() {
		return earnCode;
	}
	public void setEarnCode(String earnCode) {
		this.earnCode = earnCode;
	}
	public String getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}
	public String getEarnDate() {
		return earnDate;
	}
	public void setEarnDate(String earnDate) {
		this.earnDate = earnDate;
	}
	
}
