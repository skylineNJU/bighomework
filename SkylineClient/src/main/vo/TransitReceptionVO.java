package main.vo;

public class TransitReceptionVO extends ReceiptVO{
	private int receiveYear;//�������
	private int receiveMonth;//�����·�
	private int receiveDay;//������
	private String centerNumber;//��ת���ı��
	private String bar;//��ݵĵ���
	
	public TransitReceptionVO(String id, String da, String co,int a,int b,int c,String d,String e) {
		super(id, da, co);
		receiveYear=a;
		receiveMonth=b;
		receiveDay=c;
		centerNumber=d;
		bar=e;
		// TODO Auto-generated constructor stub
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
