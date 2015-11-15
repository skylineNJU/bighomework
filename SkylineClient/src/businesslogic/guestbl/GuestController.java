package businesslogic.guestbl;

import businesslogicservice.GuestBLService;
import vo.HistoryVO;

public class GuestController implements GuestBLService {

	
	@Override
	public boolean showHistory(String code, HistoryVO history) {
		// TODO Auto-generated method stub
		History his=new History(code);
		
		return false;
	}

	

}
