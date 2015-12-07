package main.businesslogic.receivebl;

import java.util.ArrayList;

import main.businesslogicservice.receiptblService.ReceiptCode;
import main.constructfactory.ConstructFactory;
import main.data.receive.ReceiveDataController;
import main.dataservice.ReceiveDataService;
import main.po.CourrierPO;
import main.po.DistributePO;
import main.po.LobbyReceivePO;
import main.vo.LobbyReceptionVO;
public class Lobby {
	private String receiveYear;//营业厅接收时间 
	private String receiveMonth;//营业厅接收时间 
	private String receiveDay;//营业厅接收时间 
	private String condition;//货物到达状态
	private String expressBar;//expressBar表示订单
	private String receiptCode;
	private String belong;
	private LobbyReceivePO po;
	public Lobby(LobbyReceptionVO lo){
		this.receiveYear=lo.getReceiveYear();
		this.receiveMonth=lo.getReceiveMonth();
		this.receiveDay=lo.getReceiveDay();
		this.condition=lo.getCondition();
		this.expressBar=lo.getExpressBar();
		this.receiptCode=lo.getCode();
		this.belong=lo.getBelong();
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
		this.createDistribute();
		return true;
	}
	
	public void createDistribute(){
		CourrierPO po=new CourrierPO(belong);
		ReceiveDataService service=new ReceiveDataController();
		po=service.getCourrierInfo(po);
		ArrayList<String> accountName=po.getCourrierAccountList();
		ArrayList<String> codes=po.getCourrierList();
		int x=0;
		for(String str:accountName){
			System.out.println("----------++++++-----+++++_-----"+str);
			String code=codes.get(x);
			String[] str1=code.split(" ");
			if(str1.length<101){
			DistributePO po1=new DistributePO(this.expressBar,
											  this.expressBar, 
											  this.expressBar, 
											  null,
											  null, 
											  str);
			ReceiptCode service0=ConstructFactory.calculateCode();
			String co=service0.calculCode(code,str);
			po1.setCode(co);
			ReceiveDataService service1=new ReceiveDataController();
			service1.saveDistribute(po1);
			break;
			}
			x++;
		}
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
