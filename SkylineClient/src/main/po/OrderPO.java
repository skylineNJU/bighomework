package main.po;
import java.io.Serializable;


public class OrderPO extends Receipt implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 	private String senderName;
		private String senderAddress;
		private String senderCom;
		//String sendertel;
		private String senderMobile;
		
		private String receivorName;
		private String receivorAddress;
		private String receivorCom;
		//String receivortel;
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
		
		public enum Size{
			large,medium,small;	
		}
		
		private Size size;
		private String orderCode;
		private double sum;
		
		

		public OrderPO(String senderName, String senderAddress, String senderCom, String senderMobile,
				String receivorName, String receivorAddress, String receivorCom, String receivorMobile,
				PackageCost packageCost, Type type, int num, double weight, double volume, String cargoName, Size size,
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
			this.size = size;
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

		public Size getSize() {
			return size;
		}

		public void setSize(Size size) {
			this.size = size;
		}

		public String getOrderCode() {
			return orderCode;
		}

		public void setOrderCode(String orderCode) {
			this.orderCode = orderCode;
		}

		public double getSum() {
			return sum;
		}

		public void setSum(int sum) {
			this.sum = sum;
		} 
}
