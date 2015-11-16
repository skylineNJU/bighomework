package po;

import java.io.Serializable;

//营业厅收到快递后生产的一条收件单信息
public class LobbyReceivePO extends Message implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String receiveYear;//营业厅接收时间 
	private String receiveMonth;//营业厅接收时间 
	private String receiveDay;//营业厅接收时间 
	private int condition;//货物到达状态
	private String expressBar;//expressBar表示订单
	private String receiptCode;
	
	
	public LobbyReceivePO(String receiveYear,String receiveMonth,String receiveDay,int co,String expressBar,String receiptC){
		this.receiveYear = receiveYear;
		this.receiveMonth = receiveMonth;
		this.receiveDay = receiveDay;
		this.condition = co;
		this.expressBar = expressBar;
		this.receiptCode=receiptC;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
