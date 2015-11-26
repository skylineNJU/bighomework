package main.vo;

//派送单VO
public class DistributeVO {
	private String orderCode;//订单号
	private String distributeCode;//派送单单号
	private String name;
	private String adress;
	private String phoneNumber;
	private String courierID;
	
	//无参数构造函数
	public DistributeVO(){}
	
	public DistributeVO(String orderCode, String distributeCode, String name,String adress,String phoneNumber,String courierID){
		this.orderCode=orderCode;
		this.distributeCode = distributeCode;
		this.name=name;
		this.adress=adress;
		this.phoneNumber=phoneNumber;
		this.courierID=courierID;
	}
	public void write(DistributeVO distributeVO){
		this.orderCode = distributeVO.getOrderCode();
		this.distributeCode = distributeVO.getDistributeCode();
		this.name = distributeVO.getName();
		this.adress = distributeVO.getAdress();
		this.phoneNumber = distributeVO.getPhoneNumber();
		this.courierID = distributeVO.getCourierID();
	}
	private String getCourierID() {
		return courierID;
	}
	public String getOrderCode() {
		return this.orderCode;
	}
	public String getName() {
		return this.name;
	}
	public String getAdress() {
		return this.adress;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public String getID() {
		return this.courierID;
	}
	public String getDistributeCode() {
		return this.distributeCode;
	}
}
