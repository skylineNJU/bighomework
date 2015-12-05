package main.vo;

public class FeeVO {
	private double roadFee;
	private double railFee;
	private double airFee;
	public FeeVO(double roadFee, double railFee, double airFee) {
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
}
