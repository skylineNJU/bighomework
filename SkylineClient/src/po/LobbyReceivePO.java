package po;

import java.io.Serializable;

//营业厅收到快递后生产的一条收件单信息
public class LobbyReceivePO extends Message implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int receiveYear;//营业厅接收时间 
	private int receiveMonth;//营业厅接收时间 
	private int receiveDay;//营业厅接收时间 
	private int condition;//货物到达状态
	private String expressBar;//expressBar表示订单
	private String receiptCode;
	
	
	public LobbyReceivePO(int receiveYear,int receiveMonth,int receiveDay,int co,String expressBar,String receiptC){
		this.receiveYear = receiveYear;
		this.receiveMonth = receiveMonth;
		this.receiveDay = receiveDay;
		this.condition = co;
		this.expressBar = expressBar;
		this.receiptCode=receiptC;
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
		return condition;
	}

	public String getExpressBar() {
		return expressBar;
	}

	public String getReceiptCode() {
		return receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}
	
}
