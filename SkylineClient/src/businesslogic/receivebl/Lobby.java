package businesslogic.receivebl;

import po.LobbyReceivePO;
import vo.LobbyReceptionVO;
public class Lobby {
	private String receiveYear;//Ӫҵ������ʱ�� 
	private String receiveMonth;//Ӫҵ������ʱ�� 
	private String receiveDay;//Ӫҵ������ʱ�� 
	private int condition;//���ﵽ��״̬
	private String expressBar;//expressBar��ʾ����
	private String receiptCode;
	private LobbyReceivePO po;
	
	public Lobby(LobbyReceptionVO lo){
		this.receiveYear=lo.getReceiveYear();
		this.receiveMonth=lo.getReceiveMonth();
		this.receiveDay=lo.getReceiveDay();
		this.condition=lo.getCondition();
		this.expressBar=lo.getExpressBar();
		this.receiptCode=lo.getReceiptCode();		
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