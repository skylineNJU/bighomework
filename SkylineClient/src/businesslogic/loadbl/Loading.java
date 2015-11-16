package businesslogic.loadbl;

import vo.VehicleLoadingVO;

public class Loading {
	private String vehiclecode;
	private String from;
	private String to;
	private String monitor;
	private String escort;
	private String[] ordercode;
	private double fee;
	
	public Loading(VehicleLoadingVO vehicleLoadingInfo){
		this.vehiclecode=vehicleLoadingInfo.getCode();
		this.from=vehicleLoadingInfo.getFrom();
		this.to=vehicleLoadingInfo.getTo();
		this.monitor=vehicleLoadingInfo.getMonitor();
		this.escort=vehicleLoadingInfo.getEscort();
		this.ordercode=vehicleLoadingInfo.getOrdercode();
		this.fee=vehicleLoadingInfo.getFee();
	}

	public boolean saveLoading(){
		return true;
	}
	public String getVehiclecode() {
		return vehiclecode;
	}


	public String getFrom() {
		return from;
	}


	public String getTo() {
		return to;
	}


	public String getMonitor() {
		return monitor;
	}

	public String getEscort() {
		return escort;
	}

	public void setEscort(String escort) {
		this.escort = escort;
	}

	public void setOrdercode(String[] ordercode) {
		this.ordercode = ordercode;
	}

	public double getFee() {
		return fee;
	}

}
