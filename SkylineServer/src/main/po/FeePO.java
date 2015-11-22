package main.po;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class FeePO extends Message {

	/**
	 * 
	 */
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
		String content="'费用',"+roadFee+","+railFee+","+airFee;
		writer.writeIntoSql("Fee", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("Fee");
		this.railFee=reader.getDouble("火车装运费");
		this.airFee=reader.getDouble("飞机装运费");
		this.roadFee=reader.getDouble("汽车状运费");
	}
}
