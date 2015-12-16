package main.po;

public class ReceiptRecordPO extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String courrierCode;
	private String lobbyCode;
	private String intermediateCode;
	private String warehouseCode;
	private String financeCode;
	
	public ReceiptRecordPO(String courrierCode, String lobbyCode, String intermediateCode, String warehouseCode,
			String financeCode) {
		super();
		this.setCourrierCode(courrierCode);
		this.setLobbyCode(lobbyCode);
		this.setIntermediateCode(intermediateCode);
		this.setWarehouseCode(warehouseCode);
		this.setFinanceCode(financeCode);
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
