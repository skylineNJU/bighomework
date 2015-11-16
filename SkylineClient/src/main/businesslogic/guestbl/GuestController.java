package main.businesslogic.guestbl;

import main.businesslogicservice.GuestBLService;
import main.vo.HistoryVO;

public class GuestController implements GuestBLService {

	
	@Override
	public boolean showHistory(String code, HistoryVO history) {
		// TODO Auto-generated method stub
		History his=new History(code);
		
		return false;
	}

	

}
