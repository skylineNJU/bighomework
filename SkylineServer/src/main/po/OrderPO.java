package main.po;
import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;


public class OrderPO extends Receipt implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 	String senderName;
		String senderAddress;
		String senderCom;
		String senderMobile;
		
		String receivorName;
		String receivorAddress;
		String receivorCom;
		String receivorMobile;
		
		public enum PackageCost{
			paperBox ,woodBox ,plasticPackage;
		}
		
		PackageCost packageCost;
		Type type;
		int num;
		double weight;
		double volume;
		String cargoName;
		String orderCode;
		double sum;

		public void writeIntoDatabase(){
			SqlWriter writer=new SqlWriter();
			String content="'"+super.getCode()+"','"+orderCode+"','"
					+senderName+"','"+senderAddress+"','"+senderCom+"','"
					+receivorName+"','"+receivorAddress+"','"+receivorCom+"'"
					+num+","+weight+","+volume+",'"+type.name()+"','"+packageCost.name()+"',"+sum+",'"
					+cargoName+"'";
			writer.writeIntoSql("Order", content);
		}
		
		public void getDataFromBase(){
			SqlReader reader=new SqlReader("Order");
			reader.findNext("单据号",this.getCode());
			this.orderCode=reader.getString("订单号");
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
		
	
		public OrderPO(String senderName, String senderAddress, String senderCom, String senderMobile,
				String receivorName, String receivorAddress, String receivorCom, String receivorMobile,
				PackageCost packageCost, Type type, int num, double weight, double volume, String cargoName,
				String orderCode, double sum) {
			super();
			this.senderName = senderName;
			this.senderAddress = senderAddress;
			this.senderCom = senderCom;
			this.senderMobile = senderMobile;
			this.receivorName = receivorName;
			this.receivorAddress = receivorAddress;
			this.receivorCom = receivorCom;
			this.receivorMobile = receivorMobile;
			this.packageCost = packageCost;
			this.type = type;
			this.num = num;
			this.weight = weight;
			this.volume = volume;
			this.cargoName = cargoName;
			this.orderCode = orderCode;
			this.sum = sum;
		}


		public String getSenderName() {
			return senderName;
		}

		public void setSenderName(String senderName) {
			this.senderName = senderName;
		}

		public String getSenderAddress() {
			return senderAddress;
		}

		public void setSenderAddress(String senderAddress) {
			this.senderAddress = senderAddress;
		}

		public String getSenderCom() {
			return senderCom;
		}

		public void setSenderCom(String senderCom) {
			this.senderCom = senderCom;
		}

//		public String getSendertel() {
//			return sendertel;
//		}
//
//		public void setSendertel(String sendertel) {
//			this.sendertel = sendertel;
//		}

		public String getSenderMobile() {
			return senderMobile;
		}

		public void setSenderMobile(String senderMobile) {
			this.senderMobile = senderMobile;
		}

		public String getReceivorName() {
			return receivorName;
		}

		public void setReceivorName(String receivorName) {
			this.receivorName = receivorName;
		}

		public String getReceivorAddress() {
			return receivorAddress;
		}

		public void setReceivorAddress(String receivorAddress) {
			this.receivorAddress = receivorAddress;
		}

		public String getReceivorCom() {
			return receivorCom;
		}

		public void setReceivorCom(String receivorCom) {
			this.receivorCom = receivorCom;
		}

//		public String getReceivortel() {
//			return receivortel;
//		}
//
//		public void setReceivortel(String receivortel) {
//			this.receivortel = receivortel;
//		}

		public String getReceivorMobile() {
			return receivorMobile;
		}

		public void setReceivorMobile(String receivorMobile) {
			this.receivorMobile = receivorMobile;
		}

		public PackageCost getPackageCost() {
			return packageCost;
		}

		public void setPackageCost(PackageCost packageCost) {
			this.packageCost = packageCost;
		}


		public Type getOrderType() {

			return type;
		}

		public void setType(Type type) {
			this.type = type;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}

		public double getVolume() {
			return volume;
		}

		public void setVolume(double volume) {
			this.volume = volume;
		}

		public String getCargoName() {
			return cargoName;
		}

		public void setCargoName(String cargoName) {
			this.cargoName = cargoName;
		}

		public String getOrderCode() {
			return orderCode;
		}

		public void setOrderCode(String orderCode) {
			this.orderCode = orderCode;
		}

	
}
