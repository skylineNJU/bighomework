package main.po;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

//记录每个人写过的单据的编码
public class CourrierReceiptPO extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String account;
	private String orderCode;
	private String buildDate;
	private String receiveCode;
	private String receiveDate;
	private String distributeCode;
	public CourrierReceiptPO(String account, String orderCode, String buildDate, String receiveCode, String receiveDate,
			String distributeCode) {
		super();
		this.account = account;
		this.orderCode = orderCode;
		this.buildDate = buildDate;
		this.receiveCode = receiveCode;
		this.receiveDate = receiveDate;
		this.distributeCode = distributeCode;
	}
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		getDataFromBase();
		String content="'"+account+"','"+orderCode+"','"+buildDate+"','"
				+receiveCode+"','"+receiveDate+"','"+distributeCode+"'";
		writer.writeIntoSql("CourrierReceipt", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("CourrierReceipt");
		reader.findNext("账户名",account);
		if(orderCode!=null)
			orderCode=reader.getString("订单单号")+" "+orderCode;
		else
			orderCode=reader.getString("订单单号");
		
		if(buildDate!=null)
			buildDate=reader.getString("订单创建日期")+" "+buildDate;
		else
			buildDate=reader.getString("订单创建日期");
		
		if(receiveDate!=null)
			receiveDate=reader.getString("收件单创建日期")+" "+receiveDate;
		else
			receiveDate=reader.getString("收件单创建日期");
		
		if(receiveCode!=null)
			receiveCode=reader.getString("接收单单号")+" "+receiveCode;
		else
			receiveCode=reader.getString("接收单单号");
		
		if(distributeCode!=null)
			distributeCode=reader.getString("派件单单号")+" "+distributeCode;
		else
			distributeCode=reader.getString("派件单单号");
		reader.close();
	}
}
