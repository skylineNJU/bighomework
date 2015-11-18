package main.vo;

public class DistributeVO {
	private String orderCode;
	private String name;
	private String adress;
	private String phoneNumber;
	private String ID;
	public DistributeVO(){
		
	}
	public DistributeVO(String orderCode,String na,String ad,String pN,String id){
		this.orderCode=orderCode;
		name=na;
		adress=ad;
		phoneNumber=pN;
		ID=id;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public String getName() {
		return name;
	}
	public String getAdress() {
		return adress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getID() {
		return ID;
	}
}
