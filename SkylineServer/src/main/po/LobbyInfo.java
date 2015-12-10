package main.po;

import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class LobbyInfo extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private String lobbyCode;
	private int staffNum;
	private double area;
	
	public LobbyInfo(String city, String lobbyCode, int staffNum, double area) {
		super();
		this.city = city;
		this.lobbyCode = lobbyCode;
		this.staffNum = staffNum;
		this.area = area;
	}
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+this.city+"','"+this.lobbyCode+"',"+staffNum+","+area;
		
		writer.writeIntoSql("LobbyInfo", content);
	}
	
	public void deleteFromDatabase(){
		SqlDeleter deleter=new SqlDeleter();
		deleter.deleteData("LobbyInfo","所属城市",city);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("LobbyInfo");
		if(reader.findNext("所属城市",city)){
			this.lobbyCode=reader.getString("机构编号");
			this.staffNum=reader.getInt("员工人数");
			this.area=reader.getDouble("占地面积");
		}
	}

}
