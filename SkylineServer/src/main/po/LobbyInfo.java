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
		deleter.deleteData("LobbyInfo","��������",city);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("LobbyInfo");
		if(reader.findNext("��������",city)){
			this.lobbyCode=reader.getString("�������");
			this.staffNum=reader.getInt("Ա������");
			this.area=reader.getDouble("ռ�����");
		}
	}

}
