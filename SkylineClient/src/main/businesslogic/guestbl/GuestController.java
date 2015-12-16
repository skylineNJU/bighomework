package main.businesslogic.guestbl;

import main.businesslogicservice.GuestBLService;
import main.vo.HistoryVO;

public class GuestController implements GuestBLService {

	
	@Override
	public HistoryVO showHistory(String code) {
		// TODO Auto-generated method stub
		History his=new History(code);
		
		return his.inquire();
	}

	

}
