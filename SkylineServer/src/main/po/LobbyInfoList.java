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
	
	public ArrayList<LobbyInfo> getLobbyList() {
		return lobbyList;
	}

	public void setLobbyList(ArrayList<LobbyInfo> lobbyList) {
		this.lobbyList = lobbyList;
	}

	public void getDataFromBase(){
		SqlReader reader=new SqlReader("LobbyInfo");
		while(reader.findNext("��������",city)){
			System.out.println("find a lobby");
			lobbyList.add(new LobbyInfo(city,reader.getString("�������"),
					reader.getInt("Ա������"),reader.getDouble("ռ�����")));
		}
	}

	public void getAllDataFromBase(){
		SqlReader reader=new SqlReader("LobbyInfo");
		while(reader.hasNext()){
			lobbyList.add(new LobbyInfo(reader.getString("��������"),reader.getString("�������"),
					reader.getInt("Ա������"),reader.getDouble("ռ�����")));
		}
	}
}
