package main.po;

import java.io.Serializable;

//Ӫҵ���յ���ݺ�������һ���ռ�����Ϣ
public class LobbyReceivePO extends Receipt implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String receiveYear;//Ӫҵ������ʱ�� 
	private String receiveMonth;//Ӫҵ������ʱ�� 
	private String receiveDay;//Ӫҵ������ʱ�� 
	private String condition;//���ﵽ��״̬
	private String expressBar;//expressBar��ʾ����
	
	

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
