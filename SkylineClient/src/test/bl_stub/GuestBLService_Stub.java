package test.bl_stub;

import  main.businesslogicservice.GuestBLService;
import  main.vo.HistoryVO;

public class GuestBLService_Stub implements GuestBLService{
	HistoryVO history;
	@Override
	public boolean showHistory(String code,HistoryVO history) {
		// TODO Auto-generated method stub
		history=new HistoryVO(code);
		return true;
	}

}
