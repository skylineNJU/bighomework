package main.businesslogic.guestbl.mocktest;

import main.businesslogic.guestbl.History;

public class MockHistory extends History {

	public MockHistory(String orderCode) {
		super(orderCode);
		// TODO Auto-generated constructor stub
	}

	public boolean getHistoryInfo(){
		if(this.getOrderCode().equals("1228853904")){
		this.setCreate("已生成");
		this.setArriveIntermediate1("南京市栖霞区营业厅");
		this.setArriveLobby1("南京市中转中心");
		this.setArriveLobby2(null);
		this.setArriveLobby2(null);
		return true;
		}else{
			return false;
		}
	}
}
