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
		while(reader.findNext("��������",city)){
			lobbyList.add(new LobbyInfo(city,reader.getString("�������"),
					reader.getInt("Ա������"),reader.getDouble("ռ�����")));
		}
	}

}
