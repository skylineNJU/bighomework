package main.vo;

public class TransitReceptionVO extends ReceiptVO{
	private String receiveYear;//�������
	private String receiveMonth;//�����·�
	private String receiveDay;//������
	private String centerNumber;//��ת���ı��
	private String bar;//��ݵĵ���
	
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
