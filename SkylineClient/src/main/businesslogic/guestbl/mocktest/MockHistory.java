package main.businesslogic.guestbl.mocktest;

import main.businesslogic.guestbl.History;

public class MockHistory extends History {

	public MockHistory(String orderCode) {
		super(orderCode);
		// TODO Auto-generated constructor stub
	}

	public boolean getHistoryInfo(){
		if(this.getOrderCode().equals("1228853904")){
		this.setCreate("������");
		this.setArriveIntermediate1("�Ͼ�����ϼ��Ӫҵ��");
		this.setArriveLobby1("�Ͼ�����ת����");
		this.setArriveLobby2(null);
		this.setArriveLobby2(null);
		return true;
		}else{
			return false;
		}
	}
}
