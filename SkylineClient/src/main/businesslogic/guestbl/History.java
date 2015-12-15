package main.businesslogic.guestbl;

import main.data.guest.GuestDataImpl;
import main.dataservice.guestservice.GuestDataService;
import main.po.LocusPO;
import main.vo.HistoryVO;

public class History {
	private String orderCode;
	public History(String orderCode){
		this.orderCode=orderCode;
	}
	
	public HistoryVO inquire(){
		LocusPO po=new LocusPO(orderCode);
		GuestDataService service=new GuestDataImpl();
		po=service.inquireLocus(po);
		HistoryVO vo=new HistoryVO(
				po.getOrderCode(),
				po.getArriveLobby1(),
				po.getArriveInterm1(),
				po.getArriveInterm2(),
				po.getArriveLobby2(),
				po.getIsReceived(),
				po.getBeginCity(),
				po.getEndCity());
		return vo;	
	}

}
