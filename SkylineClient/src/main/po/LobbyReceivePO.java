package main.po;

import java.io.Serializable;

//营业厅收到快递后生产的一条收件单信息
public class LobbyReceivePO extends Receipt implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String receiveYear;//营业厅接收时间 
	private String receiveMonth;//营业厅接收时间 
	private String receiveDay;//营业厅接收时间 
	private String condition;//货物到达状态
	private String expressBar;//expressBar表示订单
	
	

	public LobbyReceivePO(String receiveYear, String receiveMonth, String receiveDay, String condition,
			String expressBar) {
		super();
		this.receiveYear = receiveYear;
		this.receiveMonth = receiveMonth;
		this.receiveDay = receiveDay;
		this.setCondition(condition);
		this.expressBar = expressBar;
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

	public String getExpressBar() {
		return expressBar;
	}


	public void setExpressBar(String expressBar) {
		this.expressBar = expressBar;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}

	
	
}
