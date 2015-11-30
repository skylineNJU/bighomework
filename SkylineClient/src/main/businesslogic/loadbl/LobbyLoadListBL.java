package main.businesslogic.loadbl;

import java.util.ArrayList;

import main.data.load.LoadDataController;
import main.dataservice.LoadDataService;
import main.po.LoadingInfoPO;
import main.po.LobbyLoadingList;
import main.vo.LobbyLoading;

public class LobbyLoadListBL {
	private LobbyLoadingList po;
	
	public LobbyLoadListBL(String codeList){
		po=new LobbyLoadingList(codeList);
	}
	
	public ArrayList<LobbyLoading> inquire(){
		ArrayList<LobbyLoading> list=new ArrayList<LobbyLoading>();
		LoadDataService service=new LoadDataController();
		po=service.inquireLobbyLoadList(po);
		ArrayList<LoadingInfoPO> ll=po.getLoadList();
		for(LoadingInfoPO lfo:ll){
			LobbyLoading vo=new LobbyLoading(lfo.getCode(),lfo.getLoadingDate(),lfo.getAutoMobileNum(),
					lfo.getDeparture(),lfo.getDestination(),lfo.getMonitor(),lfo.getGuard(),lfo.getShipment(),
					lfo.getFreight());
			list.add(vo);
		}
		return list;
		
	}
}
