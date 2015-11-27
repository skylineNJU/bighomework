package main.businesslogic.receiptbl;

import main.data.receipt.ReceiptController;
import main.dataservice.receiptdataservice.CourrierReceiptDataService;
import main.po.CourrierReceiptPO;
import main.vo.CorrierReceiptVO;

public class CourrierReceiptCode {
	private String account;
	private String orderCode;
	private String buildDate;
	private String receiveCode;
	private String receiveDate;
	private String distributeCode;
	private CourrierReceiptPO po;
	public CourrierReceiptCode(String account, String orderCode, String buildDate, String receiveCode,
			String receiveDate, String distributeCode) {
		super();
		this.account = account;
		this.orderCode = orderCode;
		this.buildDate = buildDate;
		this.receiveCode = receiveCode;
		this.receiveDate = receiveDate;
		this.distributeCode = distributeCode;
	}
	
	public CourrierReceiptCode(String account,String code){
		this.account = account;
		this.orderCode = code;
		this.buildDate = null;
		this.receiveCode = null;
		this.receiveDate = null;
		this.distributeCode = null;
	}
	
	
	public void saveInfo(){
		po=new CourrierReceiptPO(this.account,this.orderCode,this.buildDate,this.receiveCode,this.receiveDate,this.distributeCode);
		CourrierReceiptDataService service=new ReceiptController();
		service.saveCodes(po);
	}
	
	public CorrierReceiptVO getReceiptCode(){
		po=new CourrierReceiptPO(account,null,null,null,null,null);
		CourrierReceiptDataService service=new ReceiptController();
		po=service.inquireCourrierCodes(po);
		CorrierReceiptVO vo=new CorrierReceiptVO(po.getAccount(),po.getOrderCode(),po.getBuildDate(),po.getReceiveCode(),
				po.getReceiveDate(),po.getDistributeCode());
		return vo;	
	}
}
