package vo;

public class TransVO extends ReceiptVO{
	private TransType type;
	private String Transcode;
	private String Vehiclecode;
	private String from;
	private String to;
	private String compartment;
	private String monitor;
	private String[] ordercode;
	public TransVO(String id, String da, String co,TransType type, String Transcode, String Vehiclecode, String from,
			String to, String compartment, String monitor, String[] ordercode) {
		super(id, da, co);
		this.type=type;
		this.Transcode=Transcode;
		this.Vehiclecode=Vehiclecode;
		this.from=from;
		this.to=to;
		this.compartment=compartment;
		this.monitor=monitor;
		this.ordercode=ordercode;
		// TODO Auto-generated constructor stub
	}
	public TransType getType() {
		return type;
	}
	public void setType(TransType type) {
		this.type = type;
	}
	public String getTranscode() {
		return Transcode;
	}
	public void setTranscode(String transcode) {
		Transcode = transcode;
	}
	public String getVehiclecode() {
		return Vehiclecode;
	}
	public void setVehiclecode(String vehiclecode) {
		Vehiclecode = vehiclecode;
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
	public String getCompartment() {
		return compartment;
	}
	public void setCompartment(String compartment) {
		this.compartment = compartment;
	}
	public String getMonitor() {
		return monitor;
	}
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	public String[] getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(String[] ordercode) {
		this.ordercode = ordercode;
	}

}
