package main.presentation.mainui.memory;

public class WarehouseMemory extends Memory {
	private String warehouseInCode=null;
	private String warehouseOutCode=null;
	private String warehouseInDate=null;
	private String warehouseOutDate=null;
	
	
	public WarehouseMemory(String userName, String code, String warehouseInCode,String warehouseInDate, String warehouseOutCode,String warehouseOutDate) {
		super(userName, code);
		this.warehouseInCode = warehouseInCode;
		this.warehouseOutCode = warehouseOutCode;
		this.warehouseInDate = warehouseInDate;
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
	
	
}
