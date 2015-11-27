package main.vo;

public class WarhouseReceiptVO {
	private String warehouseInCode=null;
	private String warehouseOutCode=null;
	private String belong=null;
	private String username=null;
	
	public WarhouseReceiptVO(String warehouseInCode, String warehouseOutCode, String belong, String username) {
		super();
		this.setWarehouseInCode(warehouseInCode);
		this.setWarehouseOutCode(warehouseOutCode);
		this.setBelong(belong);
		this.setUsername(username);
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
