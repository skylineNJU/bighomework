package main.businesslogic.receiptbl;

import main.data.receipt.ReceiptController;
import main.dataservice.receiptdataservice.ApprovalReceiptDataService;
import main.po.ReceiptRecordPO;
import main.vo.ReceiptRecordVO;

public class ReceiptRecordBL {
	private ReceiptRecordPO po;
	
	public void saveRecord(){
		ApprovalReceiptDataService service=new ReceiptController();
		service.saveReceiptRecord(po);
	}
	public void submitCourrierReceipt(String code){
		po=new ReceiptRecordPO(code,null,null,null,null);
		saveRecord();
	}
	
	public void submitLobbyReceipt(String code){
		po=new ReceiptRecordPO(null,code,null,null,null);
		saveRecord();
	}
	
	public void submitIntermediateReceipt(String code){
		po=new ReceiptRecordPO(null,null,code,null,null);
		saveRecord();
	}
	
	public void submitWarhouseReceipt(String code){
		po=new ReceiptRecordPO(null,null,null,code,null);
		saveRecord();
	}
	
	public void submitFinanceReceipt(String code){
		po=new ReceiptRecordPO(null,null,null,null,code);
		saveRecord();
	}
	
	public ReceiptRecordVO inquireReceiptRecord(){
		ApprovalReceiptDataService service=new ReceiptController();
		po=new ReceiptRecordPO(null,null,null,null,null);
		po= service.inquireReceiptRecord(po);
		ReceiptRecordVO vo=new ReceiptRecordVO(
				po.getCourrierCode(),
				po.getLobbyCode(),
				po.getIntermediateCode(),
				po.getWarehouseCode(),
				po.getFinanceCode());
		return vo;
	}
	
	public void approveReceipt(ReceiptRecordVO vo){
		po=new ReceiptRecordPO(vo.getCourrierCode(),
				vo.getLobbyCode(),
				vo.getIntermediateCode(),
				vo.getWarehouseCode(),
				vo.getFinanceCode());
		ApprovalReceiptDataService service=new ReceiptController();
		service.approveReceipt(po);
	}
}
