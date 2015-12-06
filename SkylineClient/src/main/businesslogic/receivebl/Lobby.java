package main.businesslogic.receivebl;

import main.data.receive.ReceiveDataController;
import main.dataservice.ReceiveDataService;
import main.po.LobbyReceivePO;
import main.vo.LobbyReceptionVO;
public class Lobby {
	private String receiveYear;//营业厅接收时间 
	private String receiveMonth;//营业厅接收时间 
	private String receiveDay;//营业厅接收时间 
	private String condition;//货物到达状态
	private String expressBar;//expressBar表示订单
	private String receiptCode;
	private LobbyReceivePO po;
	
	public Lobby(LobbyReceptionVO lo){
		this.receiveYear=lo.getReceiveYear();
		this.receiveMonth=lo.getReceiveMonth();
		this.receiveDay=lo.getReceiveDay();
		this.condition=lo.getCondition();
		this.expressBar=lo.getExpressBar();
		this.receiptCode=lo.getCode();		
		}
	public boolean saveInfo(){
		po=new LobbyReceivePO(
				this.receiveYear,
				this.receiveMonth,
				this.receiveDay,
				this.condition,
				this.expressBar
				);
		po.setCode(receiptCode);
		ReceiveDataService service=new ReceiveDataController();
		service.writeLobbyReceiveOrder(po);
		return true;
	}
	
	public boolean modify(){
		return true;
	}
	public static boolean delete(String expressBar){
		return true;
	}
	public boolean inquireInfo(String expressBar){
		return true;
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

	public String getReceiptCode() {
		return receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}

	
}
