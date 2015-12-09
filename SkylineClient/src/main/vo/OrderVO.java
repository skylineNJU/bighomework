package main.vo;

import main.po.OrderPO.PackageCost;
import main.po.OrderPO.Size;
import main.po.Type;

public class OrderVO extends ReceiptVO{
	private String senderName;
	private String senderAddress;
	private String senderCom;
	private String senderMobile;
	
	private String receiverName;
	private String receiverAddress;
	private String receiverCom;
	private String receiverMobile;
	
	private int num;
 	private double sum;
	private PackageCost packageCost;
	private Type type;
	private Size size;
	private String cargoName;
	private double weight;
	private double volumn;
	private String orderCode;



	public OrderVO(String co, String senderName, String senderAddress, String senderCom, String senderMobile,
			String receiverName, String receiverAddress, String receiverCom, String receiverMobile, int num, double sum,
			PackageCost packageCost, Type type, Size size, String cargoName, double weight, double height) {
		super(co);
		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.senderCom = senderCom;
		this.senderMobile = senderMobile;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.receiverCom = receiverCom;
		this.receiverMobile = receiverMobile;
		this.num = num;
		this.setSum(sum);
		this.packageCost = packageCost;
		this.type = type;
		this.size = size;
		this.setCargoName(cargoName);
		this.setWeight(weight);
		this.setHeight(height);
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCargoName() {
		return cargoName;
	}

	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return volumn;
	}

	public void setHeight(double height) {
		this.volumn = height;
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

	public void setSum(double sum) {
		this.sum = sum;
	}
	
	
	
}
