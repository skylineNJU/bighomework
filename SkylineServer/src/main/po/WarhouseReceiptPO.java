package main.po;

import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

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

	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		this.getDataFromBase();
		this.deleteFromDatabase();
		String content="'"+username+"','"+warehouseInCode+"','"+warehouseOutCode+"','"+
		belong+"','"+warehouseInDate+"','"+warehouseOutDate+"'";
		System.out.println("_))))))))))))))):::"+content);
		writer.writeIntoSql("WarhouseReceipt", content);
		System.out.println("++++++++++++++++++:::"+warehouseInDate);
		System.out.println("++++++++++++++++++:::"+warehouseOutDate);
	}
	
	public void deleteFromDatabase(){
		SqlDeleter deleter=new SqlDeleter();
		deleter.deleteData("WarhouseReceipt","账户名",username);
	}
	
	public void getDataFromBase(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>:::"+warehouseInCode+" "+warehouseInDate+" "+warehouseOutCode+" "+warehouseOutDate+" "+belong);
		SqlReader reader=new SqlReader("WarhouseReceipt");
		reader.findNext("账户名",username);
		if(this.warehouseInCode==null)
			warehouseInCode=reader.getString("入库单单号");
		else
			warehouseInCode=reader.getString("入库单单号")+" "+warehouseInCode;
		
		if(this.warehouseInDate==null)
			warehouseInDate=reader.getString("入库时间");
		else
			warehouseInDate=reader.getString("入库时间")+" "+warehouseInDate;
		
		if(this.warehouseOutCode==null)
			warehouseOutCode=reader.getString("出库单单号");
		else
			warehouseOutCode=reader.getString("出库单单号")+" "+warehouseOutCode;
		
		
		if(this.warehouseOutDate==null)
			warehouseOutDate=reader.getString("出库时间");
		else
			warehouseOutDate=reader.getString("出库时间")+" "+warehouseOutDate;
		
		if(this.belong==null)
			belong=reader.getString("仓库编号");
		else
			belong=reader.getString("仓库编号")+" "+belong;
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<:::"+warehouseInCode+" "+warehouseInDate+" "+warehouseOutCode+" "+warehouseOutDate+" "+belong);
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
