package main.timetask;

import java.util.Calendar;

import main.po.CourrierReceiptPO;
import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;

public class ClearCourrierReceipt {
	private int Ordercounter=0;
	private int Receiptcounter=0;
	public void excute(){
		SqlReader reader=new SqlReader("CourrierReceipt");
		while(reader.hasNext()){
			String accountName=reader.getString("账户名");
			String orderCode=reader.getString("订单单号");
			String orderDate=reader.getString("订单创建日期");
			String receiveCode=reader.getString("收件单单号");
			String receiveDate=reader.getString("收件单创建日期");
			System.out.println(accountName);
			this.clearReceipt(orderCode,orderDate,"OrderReceive","单据号",this.Ordercounter);
			this.clearReceipt(receiveCode,receiveDate,"Receive","接收单单号",this.Receiptcounter);
			orderCode="0"+orderCode.substring(1+19*Ordercounter,orderCode.length());
			orderDate="0"+orderDate.substring(1+11*Ordercounter,orderDate.length());
			receiveCode="1"+receiveCode.substring(1+19*Receiptcounter,receiveCode.length());
			receiveDate="0"+receiveDate.substring(1+11*Receiptcounter,receiveDate.length());
			CourrierReceiptPO po=new CourrierReceiptPO(accountName,orderCode,orderDate,receiveCode,receiveDate,null);
			po.modify();
			Ordercounter=0;
			Receiptcounter=0;
		}	
		reader.close();
		
	}
	
	private void clearReceipt(String codes,String dates,String listName,String attribute,int counter){
		SqlDeleter deleter=new SqlDeleter();
		String singleDate[]=dates.split(" ");
		String singleCodes[]=codes.split(" ");
		Calendar now=Calendar.getInstance();
		now.add(Calendar.MONTH,-2);
		Calendar record=Calendar.getInstance();
		
		for(int x=1;x<singleDate.length;x++){
			String[] date=singleDate[x].split("/");
			record.set(Integer.parseInt(date[0]),Integer.parseInt(date[1]), Integer.parseInt(date[2]));
			if(now.compareTo(record)>=0){
				deleter.deleteData(listName,attribute,singleCodes[x]);
			}else{
				counter=x;
				break;
			}
		}
		
	}
	
}
