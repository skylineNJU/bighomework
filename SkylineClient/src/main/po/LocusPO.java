package main.po;

public class LocusPO extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderCode;
	private int arriveLobby1=0;
	private int arriveInterm1=0;
	private int arriveInterm2=0;
	private int arriveLobby2=0;
	private int isReceived=0;
	private String beginCity="";
	private String endCity="";
	
	
	public LocusPO(String orderCode){
		this.orderCode=orderCode;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public int getArriveLobby1() {
		return arriveLobby1;
	}

	public void setArriveLobby1(int arriveLobby1) {
		this.arriveLobby1 = arriveLobby1;
	}

	public int getArriveInterm1() {
		return arriveInterm1;
	}

	public void setArriveInterm1(int arriveInterm1) {
		this.arriveInterm1 = arriveInterm1;
	}

	public int getArriveInterm2() {
		return arriveInterm2;
	}

	public void setArriveInterm2(int arriveInterm2) {
		this.arriveInterm2 = arriveInterm2;
	}

	public int getArriveLobby2() {
		return arriveLobby2;
	}

	public void setArriveLobby2(int arriveLobby2) {
		this.arriveLobby2 = arriveLobby2;
	}

	public int getIsReceived() {
		return isReceived;
	}

	public void setIsReceived(int isReceived) {
		this.isReceived = isReceived;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getBeginCity() {
		return beginCity;
	}

	public void setBeginCity(String beginCity) {
		this.beginCity = beginCity;
	}

	public String getEndCity() {
		return endCity;
	}

	public void setEndCity(String endCity) {
		this.endCity = endCity;
	}
	
}
