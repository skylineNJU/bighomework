package main.vo;

public class TransitReceptionVO extends ReceiptVO{
	private int receiveYear;//接收年份
	private int receiveMonth;//接收月份
	private int receiveDay;//接收天
	private String centerNumber;//中转中心编号
	private String bar;//快递的单号
	
	

	public TransitReceptionVO(String co, int receiveYear, int receiveMonth, int receiveDay, String centerNumber,
			String bar) {
		super(co);
		this.receiveYear = receiveYear;
		this.receiveMonth = receiveMonth;
		this.receiveDay = receiveDay;
		this.centerNumber = centerNumber;
		this.bar = bar;
	}

	public int getReceiveYear() {
		return receiveYear;
	}

	public void setReceiveYear(int receiveYear) {
		this.receiveYear = receiveYear;
	}

	public int getReceiveMonth() {
		return receiveMonth;
	}

	public void setReceiveMonth(int receiveMonth) {
		this.receiveMonth = receiveMonth;
	}

	public int getReceiveDay() {
		return receiveDay;
	}

	public void setReceiveDay(int receiveDay) {
		this.receiveDay = receiveDay;
	}

	public String getCenterNumber() {
		return centerNumber;
	}

	public void setCenterNumber(String centerNumber) {
		this.centerNumber = centerNumber;
	}

	public String getBar() {
		return bar;
	}

	public void setBar(String bar) {
		this.bar = bar;
	}

	
	
	
	
}
