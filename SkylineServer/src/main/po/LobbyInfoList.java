package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class LobbyInfoList extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private ArrayList<LobbyInfo> lobbyList=new ArrayList<LobbyInfo>();
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("LobbyInfo");
		while(reader.findNext("所属城市",city)){
			lobbyList.add(new LobbyInfo(city,reader.getString("机构编号"),
					reader.getInt("员工人数"),reader.getDouble("占地面积")));
		}
	}

}
