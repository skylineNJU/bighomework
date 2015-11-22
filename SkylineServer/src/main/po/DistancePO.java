package main.po;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class DistancePO extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cityName1;
	private String cityName2;
	private double distance;
	
	public DistancePO(String cityName1, String cityName2, double distance) {
		super();
		this.cityName1 = cityName1;
		this.cityName2 = cityName2;
		this.distance = distance;
	}
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content1="'"+cityName1+" "+cityName2+"','"+distance+"'";
		String content2="'"+cityName2+" "+cityName1+"','"+distance+"'";
		writer.writeIntoSql("Distance", content1);
		writer.writeIntoSql("Distance", content2);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("Distance");
		reader.findNext("≥« –√˚",cityName1+" "+cityName2);
		this.distance=reader.getDouble("æ‡¿Î");
		
	}
}
