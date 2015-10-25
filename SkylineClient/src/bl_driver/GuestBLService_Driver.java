package bl_driver;

import vo.HistoryVO;
import businesslogicservice.GuestBLService;

public class GuestBLService_Driver {
	
	public void drive(GuestBLService guestBLService){
		HistoryVO history =  guestBLService.showHistory("10.11 21:00<ÄÏ¾©>");
		if(history != null){
			System.out.println("----------History Showing-------------");
		}
		
	}
}
