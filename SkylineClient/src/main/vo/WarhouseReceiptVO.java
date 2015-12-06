package main.vo;

public class WarhouseReceiptVO {
	private String warehouseInCode=null;
	private String warehouseOutCode=null;
	private String warehouseInDate=null;
	private String warehouseOutDate=null;
	private String belong=null;
	private String username=null;
	
	public WarhouseReceiptVO(String warehouseInCode, String warehouseInDate,String warehouseOutCode,String warehouseOutDate, String belong, String username) {
		super();
		this.setWarehouseInCode(warehouseInCode);
		this.setWarehouseOutCode(warehouseOutCode);
		this.setWarehouseInDate(warehouseInDate);
		this.setWarehouseOutDate(warehouseOutDate);
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
