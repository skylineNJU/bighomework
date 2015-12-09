package test.bl_driver;

import  main.vo.HistoryVO;
import  main.businesslogicservice.GuestBLService;

public class GuestBLService_Driver {
	
	public void drive(GuestBLService guestBLService){
//		HistoryVO history =  guestBLService.showHistory("10.11 21:00<ÄÏ¾©>");
		String code="111111111111111111";
		HistoryVO history=new HistoryVO(code);
		if(guestBLService.showHistory(code, history)){
			System.out.println("----------History Showing-------------");
		}
		
	}
}
