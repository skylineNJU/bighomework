package vo;

public class VehicleLoadingVO extends ReceiptVO{
	private String vehiclecode;
	private String from;
	private String to;
	private String monitor;
	private String escort;
	private String[] ordercode;
	private double fee;
	public VehicleLoadingVO(String id, String da, String co, String vehiclecode, String from, String to, String monitor,
			String escort, String[] ordercode, double fee) {
		super(id, da, co);
		this.vehiclecode=vehiclecode;
		this.from=from;
		this.to=to;
		this.monitor=monitor;
		this.escort=escort;
		this.ordercode=ordercode;
		this.fee=fee;
		// TODO Auto-generated constructor stub
	}
	public String getVehiclecode() {
		return vehiclecode;
	}
	public void setVehiclecode(String vehiclecode) {
		this.vehiclecode = vehiclecode;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMonitor() {
		return monitor;
	}
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	public String getEscort() {
		return escort;
	}
	public void setEscort(String escort) {
		this.escort = escort;
	}
	public String[] getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(String[] ordercode) {
		this.ordercode = ordercode;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}

}
