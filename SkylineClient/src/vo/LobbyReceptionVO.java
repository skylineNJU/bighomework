package vo;

public class LobbyReceptionVO extends ReceiptVO{
	private String receiveYear;//营业厅接收时间 
	private String receiveMonth;//营业厅接收时间 
	private String receiveDay;//营业厅接收时间 
	private int condition;//货物到达状态
	private String expressBar;//expressBar表示订单
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
