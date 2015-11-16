package po;

import java.io.Serializable;

//Ӫҵ���յ���ݺ�������һ���ռ�����Ϣ
public class LobbyReceivePO extends Message implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String receiveYear;//Ӫҵ������ʱ�� 
	private String receiveMonth;//Ӫҵ������ʱ�� 
	private String receiveDay;//Ӫҵ������ʱ�� 
	private int condition;//���ﵽ��״̬
	private String expressBar;//expressBar��ʾ����
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
