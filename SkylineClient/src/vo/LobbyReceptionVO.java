package vo;

public class LobbyReceptionVO extends ReceiptVO{
	private String receiveYear;//Ӫҵ������ʱ�� 
	private String receiveMonth;//Ӫҵ������ʱ�� 
	private String receiveDay;//Ӫҵ������ʱ�� 
	private int condition;//���ﵽ��״̬
	private String expressBar;//expressBar��ʾ����
	private String receiptCode;

	public LobbyReceptionVO(String id,String da,String co,String a, String b, String c,int d,String e,String f) {
		super(id, da, co);
		receiveYear=a;
		receiveMonth=b;
		receiveDay=c;
		condition=d;
		expressBar=e;
		receiptCode=f;
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
