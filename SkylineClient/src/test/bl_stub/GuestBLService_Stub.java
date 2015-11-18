package test.bl_stub;

import  main.businesslogicservice.GuestBLService;
import  main.vo.HistoryVO;

public class GuestBLService_Stub implements GuestBLService{
	HistoryVO history;
	@Override
	public HistoryVO showHistory(String code) {
		// TODO Auto-generated method stub
		history=new HistoryVO(code);
		return history;
	}

}
