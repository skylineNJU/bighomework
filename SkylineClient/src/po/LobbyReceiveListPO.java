package po;

import java.util.List;

import State.expressType;

//营业厅收到快递后生产的一条收件单信息
public class LobbyReceiveListPO {
	
	private int receiveYear;//营业厅接收时间 
	private int receiveMonth;//营业厅接收时间 
	private int receiveDay;//营业厅接收时间 
	private int lobbyNumber;//营业厅编号
	private String expressBar;//expressBar表示订单
	
	public LobbyReceiveListPO(int receiveYear,int receiveMonth,int receiveDay,int lobbyNumber,String expressBar){
		this.receiveYear = receiveYear;
		this.receiveMonth = receiveMonth;
		this.receiveDay = receiveDay;
		this.lobbyNumber = lobbyNumber;
		this.expressBar = expressBar;
	}

	public int getReceiveYear() {
		return receiveYear;
	}

	public int getReceiveMonth() {
		return receiveMonth;
	}

	public int getReceiveDay() {
		return receiveDay;
	}

	public int getLobbyNumber() {
		return lobbyNumber;
	}

	public String getExpressBar() {
		return expressBar;
	}
	
}
