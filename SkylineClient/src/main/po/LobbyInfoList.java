package main.po;

import java.util.ArrayList;

public class LobbyInfoList extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private ArrayList<LobbyInfo> lobbyList=new ArrayList<LobbyInfo>();
	
	public LobbyInfoList(String city){
		this.setCity(city);
	}

	public ArrayList<LobbyInfo> getLobbyList() {
		return lobbyList;
	}

	public void setLobbyList(ArrayList<LobbyInfo> lobbyList) {
		this.lobbyList = lobbyList;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
