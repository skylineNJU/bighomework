package main.presentation.mainui.memory;

public class WarehouseMemory extends Memory {
	private String warehouseInCode=null;
	private String warehouseOutCode=null;
	
	
	public WarehouseMemory(String userName, String code, String warehouseInCode, String warehouseOutCode) {
		super(userName, code);
		this.warehouseInCode = warehouseInCode;
		this.warehouseOutCode = warehouseOutCode;
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
	
}
