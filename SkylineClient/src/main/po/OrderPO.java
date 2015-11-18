package main.po;
import java.io.Serializable;


public class OrderPO extends Receipt implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*	飩у瘎浠朵汉濮撳悕銆佷綇鍧�銆佸崟浣嶃�佺數璇濄�佹墜鏈猴紱
飩�	             鏀朵欢浜哄鍚嶃�佷綇鍧�銆佸崟浣嶃�佺數璇濄�佹墜鏈�
飩�	鎵樿繍璐х墿淇℃伅锛堝師浠舵暟銆佸疄闄呴噸閲忋�佷綋绉�佸唴浠跺搧鍚嶃�佸昂瀵革級
飩�	鍖呰璐癸紙绾哥銆佹湪绠便�佸揩閫掕銆佸叾瀹冿級
飩�	璐圭敤鍚堣
飩�	璁㈠崟鏉″舰鐮佸彿锛�10浣嶆暟锛�
飩�	缁忔祹蹇�掋�佹爣鍑嗗揩閫掋�佺壒蹇�


*/
	 	String senderName;
		String senderAddress;
		String senderCom;
		//String sendertel;
		String senderMobile;
		
		String receivorName;
		String receivorAddress;
		String receivorCom;
		//String receivortel;
		String receivorMobile;
		
		public enum PackageCost{
			paperBox ,woodBox ,plasticPackage;
		}
		
		PackageCost packageCost;
		Type type;
		
		int num;//鍘熶欢鏁�
		double weight;//瀹為檯閲嶉噺
		double volume;//浣撶Н
		String cargoName;//鍐呴儴鍝佸悕
		
		public enum Size{
			large,medium,small;	
		}//灏哄
		
		Size size;
		String orderCode;//璁㈠崟鏉″舰鐮�
		int sum;//璐圭敤鍚堣

		public OrderPO(String a,String b,String c,String e,String f,String g ,String h,String j,
		 PackageCost pC,Type t,int k,double l,double m,String n,Size s,String p,int q){
			 senderName = a;
			 senderAddress = b;
			 senderCom = c;
			// sendertel = d;
			 senderMobile = e;
			
			 receivorName = f;
			 receivorAddress = g;
			 receivorCom = h;
		     //receivortel = i;
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

		public int getSum() {
			return sum;
		}

		public void setSum(int sum) {
			this.sum = sum;
		} 
}
