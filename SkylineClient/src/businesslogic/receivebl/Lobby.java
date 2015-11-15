package businesslogic.receivebl;

import po.LobbyReceivePO;
import vo.LobbyReceptionVO;
public class Lobby {
	private String receiveYear;//营业厅接收时间 
	private String receiveMonth;//营业厅接收时间 
	private String receiveDay;//营业厅接收时间 
	private int condition;//货物到达状态
	private String expressBar;//expressBar表示订单
	private String receiptCode;
	private LobbyReceivePO po;
	
	public Lobby(LobbyReceptionVO lo){
		this.receiveYear=lo.getReceiveYear();
		this.receiveMonth=lo.getReceiveMonth();
		this.receiveDay=lo.getReceiveDay();
		this.condition=lo.getCondition();
		this.expressBar=lo.getExpressBar();
		this.receiptCode=lo.getReceiptCode();		
		}

	public String getReceiveYear() {
		return receiveYear;
	}

	public void setReceiveYear(String receiveYear) {
		this.receiveYear = receiveYear;
	}

	public String getReceiveMonth() {
		return receiveMonth;
	}

	public void setReceiveMonth(String receiveMonth) {
		this.receiveMonth = receiveMonth;
	}

	public String getReceiveDay() {
		return receiveDay;
	}

	public void setReceiveDay(String receiveDay) {
		this.receiveDay = receiveDay;
	}

	public int getCondition() {
		return condition;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}

	public String getExpressBar() {
		return expressBar;
	}

	public void setExpressBar(String expressBar) {
		this.expressBar = expressBar;
	}

	public String getReceiptCode() {
		return receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}

	
}
