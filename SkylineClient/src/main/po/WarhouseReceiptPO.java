package main.po;

public class WarhouseReceiptPO extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String warehouseInCode;
	private String warehouseOutCode;
	private String warehouseInDate;
	private String warehouseOutDate;
	private String belong;
	private String username;
	
	

	public WarhouseReceiptPO(String warehouseInCode, String warehouseInDate,String warehouseOutCode, String warehouseOutDate,String belong, String username) {
		super();
		this.warehouseInCode = warehouseInCode;
		this.warehouseOutCode = warehouseOutCode;
		this.warehouseInDate = warehouseInDate;
		this.warehouseOutDate = warehouseOutDate;
		this.setBelong(belong);
		this.setUsername(username);
	}

	
	public String getWarehouseInDate() {
		return warehouseInDate;
	}


	public void setWarehouseInDate(String warehouseInDate) {
		this.warehouseInDate = warehouseInDate;
	}


	public String getWarehouseOutDate() {
		return warehouseOutDate;
	}


	public void setWarehouseOutDate(String warehouseOutDate) {
		this.warehouseOutDate = warehouseOutDate;
	}


	public String getWarehouseInCode() {
		return warehouseInCode;
	}
	public void setWarehouseInCode(String warehouseInCode) {
		this.warehouseInCode = warehouseInCode;
	}
	public String getWarehouseOutCode() {
		return warehouseOutCode;
	}
	public void setWarehouseOutCode(String warehouseOutCode) {
		this.warehouseOutCode = warehouseOutCode;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
