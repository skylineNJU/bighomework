package businesslogic.loadbl;

public class IntermediateLoading {
	private String Transcode;
	private String Vehiclecode;
	private String from;
	private String to;
	private String compartment;
	private String monitor;
	private String[] ordercode;
	
	public boolean saveLoading(){
		submitFee();
		return true;
	}
	
	public boolean submitFee(){
		return true;
	}
	public String getTranscode() {
		return Transcode;
	}

	public String getVehiclecode() {
		return Vehiclecode;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getCompartment() {
		return compartment;
	}

	public String getMonitor() {
		return monitor;
	}

	public String[] getOrdercode() {
		return ordercode;
	}

}
