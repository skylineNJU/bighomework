package main.vo;

public class LobbyReceptionVO extends ReceiptVO{
	private String receiveYear;//营业厅接收年份 
	private String receiveMonth;//营业厅接收月份 
	private String receiveDay;//营业厅接收日期
	private int condition;//货物到达状态
	private String expressBar;//expressBar表示订单
	private String receiptCode;

	
	public LobbyReceptionVO(String co, String receiveYear, String receiveMonth, String receiveDay, int condition,
			String expressBar, String receiptCode) {
		super(co);
		this.receiveYear = receiveYear;
		this.receiveMonth = receiveMonth;
		this.receiveDay = receiveDay;
		this.condition = condition;
		this.expressBar = expressBar;
		this.receiptCode = receiptCode;
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
