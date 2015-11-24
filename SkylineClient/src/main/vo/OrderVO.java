package main.vo;

import main.po.Type;
import main.po.OrderPO.PackageCost;

public class OrderVO extends ReceiptVO{
	private String senderName;
	private String senderAddress;
	private String senderCom;
	//String sendertel;
	private String senderMobile;
	
	private String receiverName;
	private String receiverAddress;
	private String receiverCom;
	//String receivortel;
	private String receiverMobile;
	
	private String orderCode;
 	private int sum;
	public enum PackageCost{
		paperBox ,woodBox ,plasticPackage;
	}
	
	
	
	public enum Type{
		 fast,normal,cheap;
	}	  
	
	public enum Size{
		large,medium,small;	
	}//³ß´ç
	
	
	PackageCost packageCost;
	Type type;
	Size size;
	
	public OrderVO(String sn, String sa, String sc,
			String sm, String rn, String ra, String rc,
			String rm, String oc,int sum, 
			PackageCost pC,Type t,Size s, String co){
		
		super( co);
		senderName=sn;
		senderAddress=sa;
		senderCom=sc;
		senderMobile=sm;
		
		receiverName=rm;
		receiverAddress=ra;
		receiverCom=rc;
		receiverMobile=rm;
		orderCode=oc;
		sum=sum;
		packageCost=pC;
		 type=t;
		 size=s;
		co=co;
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

	public String getSenderMobile() {
		return senderMobile;
	}

	public void setSenderMobile(String senderMobile) {
		this.senderMobile = senderMobile;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverCom() {
		return receiverCom;
	}

	public void setReceiverCom(String receiverCom) {
		this.receiverCom = receiverCom;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
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

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}
	
	
	
}
