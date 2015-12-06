package main.po;

import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

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
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+roadFee+"','"+railFee+"','"+airFee+"'";
		writer.writeIntoSql("Fee", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("Fee");
		if(reader.hasNext()){
			this.railFee=reader.getDouble("火车装运费");
			this.airFee=reader.getDouble("飞机装运费");
			this.roadFee=reader.getDouble("汽车状运费");
		}
	}
	
	public void deleteFromDatabase(){
		SqlDeleter deleter=new SqlDeleter();
		deleter.deleteData("Fee","ID","");//删除所有的,这个地方没有写完
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
