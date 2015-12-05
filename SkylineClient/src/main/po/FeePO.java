package main.po;

public class FeePO extends Message {
	private static final long serialVersionUID = 1L;
	private double roadFee;
	private double railFee;
	private double airFee;
	
	public FeePO(double roadFee, double railFee, double airFee) {
		super();
		this.roadFee = roadFee;
		this.railFee = railFee;
		this.airFee = airFee;
	}
	public double getRoadFee() {
		return roadFee;
	}
	public void setRoadFee(double roadFee) {
		this.roadFee = roadFee;
	}
	public double getRailFee() {
		return railFee;
	}
	public void setRailFee(double railFee) {
		this.railFee = railFee;
	}
	public double getAirFee() {
		return airFee;
	}
	public void setAirFee(double airFee) {
		this.airFee = airFee;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
