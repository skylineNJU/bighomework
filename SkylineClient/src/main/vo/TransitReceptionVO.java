package main.vo;

public class TransitReceptionVO extends ReceiptVO{
	private String receiveYear;//接收年份
	private String receiveMonth;//接收月份
	private String receiveDay;//接收天
	private String centerNumber;//中转中心编号
	private String bar;//快递的单号
	
	public TransitReceptionVO(String ry,String rm, String rd,String cn,String bar,String co) {
		super(co);
		receiveYear=ry;
		receiveMonth=rm;
		receiveDay=rd;
		centerNumber=cn;
		bar=bar;
		co=co;
		// TODO Auto-generated constructor stub
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
