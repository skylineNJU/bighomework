package main.businesslogic.receiptbl;

import main.data.receipt.ReceiptController;
import main.dataservice.receiptdataservice.WarehouseReceiptDataService;
import main.po.WarhouseReceiptPO;
import main.vo.WarhouseReceiptVO;

public class WarehouseReceiptCode {
	private String warehouseInCode;
	private String warehouseOutCode;
	private String warehouseInDate;
	private String warehouseOutDate;
	private String belong;
	private String username;
	private WarhouseReceiptPO po;
	
	public WarehouseReceiptCode(WarhouseReceiptVO vo){
		this.warehouseInCode=vo.getWarehouseInCode();
		this.warehouseOutCode=vo.getWarehouseOutCode();
		this.warehouseInDate=vo.getWarehouseInDate();
		this.warehouseOutDate=vo.getWarehouseOutDate();
		this.belong=vo.getBelong();
		this.username=vo.getUsername();
	}
	

	public WarehouseReceiptCode(String warehouseInCode,String warehouseInDate, String warehouseOutCode,String warehouseOutDate, String belong, String username) {
		super();
		this.setWarehouseInCode(warehouseInCode);
		this.setWarehouseOutCode(warehouseOutCode);
		this.setWarehouseInDate(warehouseInDate);
		this.setWarehouseOutDate(warehouseOutDate);
		this.setBelong(belong);
		this.setUsername(username);
	}

	public void saveInfo(){
		po=new WarhouseReceiptPO(this.warehouseInCode,this.warehouseInDate,this.warehouseOutCode,this.warehouseOutDate,this.belong,this.username);
		WarehouseReceiptDataService service=new ReceiptController();
		service.saveWarehouseReceipt(po);
	}
	
	public WarhouseReceiptVO inquire(){
		po=new WarhouseReceiptPO(this.warehouseInCode,this.warehouseInDate,this.warehouseOutCode,this.warehouseOutDate,this.belong,this.username);
		WarehouseReceiptDataService service=new ReceiptController();
		po=service.inquireWarehouseReceipt(po);
		WarhouseReceiptVO vo=new WarhouseReceiptVO(po.getWarehouseInCode(),po.getWarehouseInDate(),po.getWarehouseOutCode(),po.getWarehouseOutDate(),po.getBelong(),po.getUsername());
		
		return vo;		
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
