package main.po;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class WarhouseReceiptPO extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String warehouseInCode;
	private String warehouseOutCode;
	private String belong;
	private String username;
	
	

	public WarhouseReceiptPO(String warehouseInCode, String warehouseOutCode, String belong, String username) {
		super();
		this.warehouseInCode = warehouseInCode;
		this.warehouseOutCode = warehouseOutCode;
		this.setBelong(belong);
		this.setUsername(username);
	}

	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		this.getDataFromBase();
		String content="'"+username+"','"+warehouseInCode+"','"+warehouseOutCode+"','"+
		belong+"'";
		writer.writeIntoSql("WarhouseReceipt", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("WarhouseReceipt");
		reader.findNext("账户名",username);
		if(this.warehouseInCode==null)
			warehouseInCode=reader.getString("入库单单号");
		else
			warehouseInCode=reader.getString("入库单单号")+" "+warehouseInCode;
		
		if(this.warehouseOutCode==null)
			warehouseOutCode=reader.getString("出库单单号");
		else
			warehouseOutCode=reader.getString("出库单单号")+" "+warehouseOutCode;
		
		if(this.belong==null)
			belong=reader.getString("仓库编号");
		else
			belong=reader.getString("仓库编号")+" "+belong;
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
