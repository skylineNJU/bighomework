package main.po;

import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class IntermediateReceipt extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accountName;
	private String intermReceiptCode;
	private String airLoadCode;
	private String railLoadCode;
	private String roadLoadCode;
	private String airLoadDate;
	private String railLoadDate;
	private String roadLoadDate;
	private String intermDate;
	public IntermediateReceipt(String accountName, String intermReceiptCode, String airLoadCode, String railLoadCode,
			String roadLoadCode, String airLoadDate, String railLoadDate, String roadLoadDate, String intermDate) {
		super();
		this.accountName = accountName;
		this.intermReceiptCode = intermReceiptCode;
		this.airLoadCode = airLoadCode;
		this.railLoadCode = railLoadCode;
		this.roadLoadCode = roadLoadCode;
		this.airLoadDate = airLoadDate;
		this.railLoadDate = railLoadDate;
		this.roadLoadDate = roadLoadDate;
		this.intermDate = intermDate;
	}
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		this.getDataFromBase();
		this.deleteFromDatabase();
		String content="'"+accountName+"','"+intermReceiptCode+"','"+airLoadCode+"','"
				+railLoadCode+"','"+roadLoadCode+"','"+airLoadDate+"','"+railLoadDate+"','"
				+roadLoadDate+"','"+intermDate+"'";
		writer.writeIntoSql("IntermediateReceipt", content);
	}
	
	public void deleteFromDatabase(){
		SqlDeleter deleter=new SqlDeleter();
		deleter.deleteData("CourrierReceipt","账户名",accountName);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("IntermediateReceipt");
		reader.findNext("账户名",accountName);
		if(intermReceiptCode!=null)
			this.intermReceiptCode=reader.getString("中转接收单单号")+" "+this.intermReceiptCode;
		else
			this.intermReceiptCode=reader.getString("中转接收单单号");
		
		if(airLoadCode!=null)
			this.airLoadCode=reader.getString("飞机装运单单号")+" "+this.airLoadCode;
		else
			this.airLoadCode=reader.getString("飞机装运单单号");
		
		if(railLoadCode!=null)
			this.railLoadCode=reader.getString("火车装运单单号")+" "+this.railLoadCode;
		else
			this.railLoadCode=reader.getString("火车装运单单号");
		
		if(roadLoadCode!=null)
			this.roadLoadCode=reader.getString("汽车装运单单号")+" "+this.roadLoadCode;
		else
			this.roadLoadCode=reader.getString("汽车装运单单号");
		
		if(airLoadDate!=null)
			this.airLoadDate=reader.getString("飞机装运单生成时间")+" "+this.airLoadDate;
		else
			this.airLoadDate=reader.getString("飞机装运单生成时间");
		
		if(railLoadDate!=null)
			this.railLoadDate=reader.getString("火车装运单生成时间")+" "+this.railLoadDate;
		else
			this.railLoadDate=reader.getString("火车装运单生成时间");
		
		if(roadLoadDate!=null)
			this.roadLoadDate=reader.getString("汽车装运单生成时间")+" "+this.roadLoadDate;
		else
			this.roadLoadDate=reader.getString("汽车装运单生成时间");
		
		if(intermDate!=null)
			this.intermDate=reader.getString("中转接收单生成时间")+" "+this.intermDate;
		else
			this.intermDate=reader.getString("中转接收单生成时间");
	}
}
