package main.presentation.mainui.memory;

import main.vo.ReceiptRecordVO;

public class ReceiptRecordMemory extends Memory {
	
	private String courrierCode;
	private String lobbyCode;
	private String intermediateCode;
	private String warehouseCode;
	private String financeCode;
	
	
	public ReceiptRecordMemory(String userName,String code,ReceiptRecordVO vo){
		super(userName,code);
		this.courrierCode=vo.getCourrierCode();
		this.lobbyCode=vo.getLobbyCode();
		this.intermediateCode=vo.getIntermediateCode();
		this.warehouseCode=vo.getWarehouseCode();
		this.financeCode=vo.getFinanceCode();
	}


	public String getCourrierCode() {
		return courrierCode;
	}


	public void setCourrierCode(String courrierCode) {
		this.courrierCode = courrierCode;
	}


	public String getLobbyCode() {
		return lobbyCode;
	}


	public void setLobbyCode(String lobbyCode) {
		this.lobbyCode = lobbyCode;
	}


	public String getIntermediateCode() {
		return intermediateCode;
	}


	public void setIntermediateCode(String intermediateCode) {
		this.intermediateCode = intermediateCode;
	}


	public String getWarehouseCode() {
		return warehouseCode;
	}


	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}


	public String getFinanceCode() {
		return financeCode;
	}


	public void setFinanceCode(String financeCode) {
		this.financeCode = financeCode;
	}
	
	
}
