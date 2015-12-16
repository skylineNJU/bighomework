package main.po;

import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class FinanceReceipt extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accountName;
	private String costCode;
	private String earnCode;
	public FinanceReceipt(String accountName, String costCode, String earnCode) {
		super();
		this.accountName = accountName;
		this.costCode = costCode;
		this.earnCode = earnCode;
	}
	
	public void writeIntoDatabase(){
		this.getDataFromeBase();
		this.deleteFromDatabase();
		SqlWriter writer=new SqlWriter();
		String content="'"+accountName+"','"+costCode+"','"+earnCode+"'";
		writer.writeIntoSql("FinanceReceipt", content);
	}

	
	public void deleteFromDatabase(){
		SqlDeleter deleter=new SqlDeleter();
		deleter.deleteData("CourrierReceipt","�˺�",accountName);
	}
	
	public void getDataFromeBase(){
		SqlReader reader=new SqlReader("FinanceReceipt");
		if(reader.findNext("�˺�",accountName)){
		if(costCode!=null)
			this.costCode=reader.getString("֧��������")+" "+costCode;
		else
			this.costCode=reader.getString("֧��������");
		if(earnCode!=null)
			this.earnCode=reader.getString("������")+" "+earnCode;
		else
			this.earnCode=reader.getString("������");
		}
	}
}
