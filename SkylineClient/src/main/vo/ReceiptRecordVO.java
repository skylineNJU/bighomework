package main.vo;

public class ReceiptRecordVO {
	private String courrierCode;
	private String lobbyCode;
	private String intermediateCode;
	private String warehouseCode;
	private String financeCode;
	
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

	public ReceiptRecordVO(String courrierCode, String lobbyCode, String intermediateCode, String warehouseCode,
			String financeCode) {
		super();
		this.courrierCode = courrierCode;
		this.lobbyCode = lobbyCode;
		this.intermediateCode = intermediateCode;
		this.warehouseCode = warehouseCode;
		this.financeCode = financeCode;
	}
	
	
}
