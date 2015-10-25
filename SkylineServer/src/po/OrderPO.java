package po;
import java.io.Serializable;


public class OrderPO implements Serializable{
	/*	寄件人姓名、住址、单位、电话、手机；
	             收件人姓名、住址、单位、电话、手机
	托运货物信息（原件数、实际重量、体积、内件品名、尺寸）
	包装费（纸箱、木箱、快递袋、其它）
	费用合计
	订单条形码号（10位数）
	经济快递、标准快递、特快


*/
	 	String senderName;
		String senderAddress;
		String senderCom;
		String sendertel;
		String senderMobile;
		
		String receivorName;
		String receivorAddress;
		String receivorCom;
		String receivortel;
		String receivorMobile;
		
		public enum PackageCost{
			paperBox ,woodBox ,plasticPackage;
		}
		
		public enum Type{
			 fast,normal,cheap;
		}	  
		
		PackageCost packageCost;
		Type type;
		
		int num;//原件数
		double weight;//实际重量
		double volume;//体积
		String cargoName;//内部品名
		
		public enum Size{
			large,medium,small;	
		}//尺寸
		
		Size size;
		String orderCode;//订单条形码
		int sum;//费用合计

		public OrderPO(String a,String b,String c,String d,String e,String f,String g ,String h,String i,String j,
		 PackageCost pC,Type t,int k,double l,double m,String n,Size s,String p,int q){
			 senderName = a;
			 senderAddress = b;
			 senderCom = c;
			 sendertel = d;
			 senderMobile = e;
			
			 receivorName = f;
			 receivorAddress = g;
			 receivorCom = h;
		     receivortel = i;
			 receivorMobile = j;
			
		     packageCost = pC;
			 type = t;
				 
			 num = k;
			 weight = l;
			 volume = m;
			 cargoName = n;
			 size = s;
			 orderCode = p;
			 sum = q;	
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

		public String getSendertel() {
			return sendertel;
		}

		public void setSendertel(String sendertel) {
			this.sendertel = sendertel;
		}

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

		public String getReceivortel() {
			return receivortel;
		}

		public void setReceivortel(String receivortel) {
			this.receivortel = receivortel;
		}

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

		public Type getType() {
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

		public int getSum() {
			return sum;
		}

		public void setSum(int sum) {
			this.sum = sum;
		} 
}
