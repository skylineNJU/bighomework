package PO;

//中转中心接收单
public class CenterReceiveListPO {
	
	private int receiveYear;//接收年份
	private int receiveMonth;//接收月份
	private int receiveDay;//接收天
	private int centerNumber;//中转中心编号
	private String bar;//快递的单号
	
	public CenterReceiveListPO(int receiveYear,int receiveMonth,int receiveDay,int centerNumber,String bar){
		this.receiveYear = receiveYear;
		this.receiveMonth = receiveMonth;
		this.receiveDay = receiveDay;
		this.centerNumber = centerNumber;
		this.bar = bar;
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

	public int getCenterNumber() {
		return centerNumber;
	}

	public String getBar() {
		return bar;
	}

}
