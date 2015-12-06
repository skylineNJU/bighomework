package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class DistancePO extends Message {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<String[]> city = new ArrayList<String[]>();
	
	public ArrayList<String[]> getCity() {
		return city;
	}
	public void setCity(ArrayList<String[]> city) {
		this.city = city;
	}

	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		for(String[] string:city){
			String content = "'"+string[0]+"','"+string[1]+"','"+string[2]+"'";
			writer.writeIntoSql("Distance", content);
		}
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("Distance");
		while(reader.hasNext()){
			city.add(new String[]{reader.getString("城市名1"),
					reader.getString("城市名2"),
					String.valueOf(reader.getDouble("距离"))}
			);
		}
	}
}
