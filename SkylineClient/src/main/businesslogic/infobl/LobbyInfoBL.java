package main.businesslogic.infobl;

import java.util.ArrayList;

import main.data.info.InfoDataController;
import main.dataservice.InfoDataService;
import main.po.LobbyInfo;
import main.po.LobbyInfoList;
import main.vo.LobbyInfoVO;

public class LobbyInfoBL {
	private LobbyInfo info;
	private LobbyInfoList infoList;
	public LobbyInfoBL(LobbyInfoVO vo){
		info=new LobbyInfo(vo.getCity(),
				           vo.getLobbyCode(),
				           vo.getStaffNum(),
				           vo.getArea());
	}
	public LobbyInfoBL(String city){
		infoList=new LobbyInfoList(city);
	}
	public void saveInfo(){
		InfoDataService service=new InfoDataController();
		service.addLobby(info);
	}
	
	public void delete(){
		InfoDataService service=new InfoDataController();
		service.deleteLobby(info);
	}
	
	public void modify(){
		InfoDataService service=new InfoDataController();
		service.modifyLobby(info);
	}
	public ArrayList<LobbyInfoVO> inquire(){
		InfoDataService service=new InfoDataController();
		infoList=service.inquireLobby(infoList);
		ArrayList<LobbyInfo> poList=infoList.getLobbyList();
		ArrayList<LobbyInfoVO> voList=new ArrayList<LobbyInfoVO>();
		for(LobbyInfo po:poList){
			voList.add(new LobbyInfoVO(po.getCity(),
					po.getLobbyCode(),
					po.getStaffNum(),
					po.getArea()));
		}
		return voList;
		
	}
}
