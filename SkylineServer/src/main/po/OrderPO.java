package main.po;
import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;


public class OrderPO extends Receipt implements Serializable{
		/**
		 * 
	 	 */
		private static final long serialVersionUID = 1L;
	 	private String senderName;
		private String senderAddress;
		private String senderCom;
		private String senderMobile;
		
		private String receivorName;
		private String receivorAddress;
		private String receivorCom;
		private String receivorMobile;
		
		public enum PackageCost{
			paperBox ,woodBox ,plasticPackage;
		}
		
		private PackageCost packageCost;
		private Type type;
		private int num;
		private double weight;
		
		private double volume;
		private String cargoName;
		private String orderCode;
		private double sum;

		public void writeIntoDatabase(){
			SqlWriter writer=new SqlWriter();
			String typename=type.name();
			String packageCostName=packageCost.name();
			String content="'"+super.getCode()
						  +"','"+orderCode
						  +"','"+senderName
						  +"','"+senderAddress					 
						  +"','"+senderMobile
						  +"','"+receivorName
						  +"','"+receivorAddress
						  +"','"+receivorMobile
						  +"','"+typename
						  +"','"+packageCostName
						  +"','"+cargoName
						  +"',"+num
						  +","+weight
						  +","+volume
						  +","+sum
						  +",'"+senderCom
						  +"','"+receivorCom
						  +"'";
			writer.writeIntoSql("OrderReceive", content);
			LocusPO po=new LocusPO(this.orderCode,this.senderAddress,this.receivorAddress);
			po.writeIntoDataBase();
		}
		
		public void getDataFromBase(){
			SqlReader reader=new SqlReader("OrderReceive");
			if(reader.findNext("单据号",this.getCode())){
			this.orderCode=reader.getString("订单号");
			System.out.println("this "+orderCode);
			this.senderName=reader.getString("寄件人姓名");
			this.senderAddress=reader.getString("寄件人住址");
			this.senderCom=reader.getString("寄件人单位");
			this.senderMobile=reader.getString("寄件人电话号码");
			this.receivorName=reader.getString("收件人姓名");
			this.receivorAddress=reader.getString("收件人住址");
			this.receivorCom=reader.getString("收件人单位");
			this.receivorMobile=reader.getString("收件人电话号码");
			this.num=reader.getInt("寄件数量");
			this.weight=reader.getDouble("寄件总重");
			this.volume=reader.getDouble("寄件体积");
			this.cargoName=reader.getString("货物名");
			this.packageCost=PackageCost.valueOf(reader.getString("包装"));
			this.type=Type.valueOf(reader.getString("货运方式"));
			this.sum=reader.getDouble("费用");
			}
		}
		
}
