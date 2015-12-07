package main.vo;

public class LobbyReceptionVO extends ReceiptVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String receiveYear;//Ӫҵ��������� 
	private String receiveMonth;//Ӫҵ�������·� 
	private String receiveDay;//Ӫҵ����������
	private String condition;//���ﵽ��״̬
	private String expressBar;//expressBar��ʾ����
	private String belong;
	
	public LobbyReceptionVO(String co, String receiveYear, String receiveMonth, String receiveDay, String condition,
			String expressBar) {
		super(co);
		this.receiveYear = receiveYear;
		this.receiveMonth = receiveMonth;
		this.receiveDay = receiveDay;
		this.condition = condition;
		this.expressBar = expressBar;
	}

	public void setBelong(String belong){
		this.belong=belong;
	}
	
	public String getBelong(){
		return this.belong;
	}
	
	
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
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

	
}
