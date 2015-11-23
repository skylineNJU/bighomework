package main.vo;

//���͵�VO
public class DistributeVO {
	private String orderCode;//������
	private String distributeCode;//���͵�����
	private String name;
	private String adress;
	private String phoneNumber;
	private String courierID;
	public DistributeVO(){
		
	}
	public DistributeVO(String orderCode, String distributeCode, String name,String adress,String phoneNumber,String courierID){
		this.orderCode=orderCode;
		this.distributeCode = distributeCode;
		this.name=name;
		this.adress=adress;
		this.phoneNumber=phoneNumber;
		this.courierID=courierID;
	}
	public void write(DistributeVO distributeVO){
		distributeVO.orderCode = orderCode;
		distributeVO.distributeCode = distributeCode;
		distributeVO.name = name;
		distributeVO.adress = adress;
		distributeVO.phoneNumber = phoneNumber;
		distributeVO.courierID = courierID;
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
