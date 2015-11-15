package businesslogic.guestbl;

public class History {
	private String orderCode;
	private String arriveLobby1;//没到记为null
	private String arriveIntermediate1;//没到记为null
	private String arriveLobby2;//没到记为null
	private String arriveIntermediate2;//没到记为null
	private String create;
	public History(String orderCode){
		this.setOrderCode(orderCode);
		this.getHistoryInfo();
	}
	
	public boolean getHistoryInfo(){
		return true;
	}
	
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getArriveLobby1() {
		return arriveLobby1;
	}
	public void setArriveLobby1(String arriveLobby1) {
		this.arriveLobby1 = arriveLobby1;
	}
	public String getArriveIntermediate1() {
		return arriveIntermediate1;
	}
	public void setArriveIntermediate1(String arriveIntermediate1) {
		this.arriveIntermediate1 = arriveIntermediate1;
	}
	public String getArriveLobby2() {
		return arriveLobby2;
	}
	public void setArriveLobby2(String arriveLobby2) {
		this.arriveLobby2 = arriveLobby2;
	}
	public String getArriveIntermediate2() {
		return arriveIntermediate2;
	}
	public void setArriveIntermediate2(String arriveIntermediate2) {
		this.arriveIntermediate2 = arriveIntermediate2;
	}
	public String getCreate() {
		return create;
	}
	public void setCreate(String create) {
		this.create = create;
	}
}
