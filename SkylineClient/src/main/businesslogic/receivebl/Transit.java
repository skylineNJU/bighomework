package main.businesslogic.receivebl;
import main.data.info.InfoDataController;
import main.dataservice.InfoDataService;
import main.dataservice.ReceiveDataService;
import main.po.CenterReceivePO;
import main.po.DriverInfoPO;
import main.vo.TransitReceptionVO;
public class Transit {

	private String receiveYear;//接收年份
	private String receiveMonth;//接收月份
	private String receiveDay;//接收天
	private String centerNumber;//中转中心编号
	private String bar;//快递的单号
	private CenterReceivePO po;
	
	public Transit(TransitReceptionVO tr){
		this.receiveYear=tr.getReceiveYear();
		this.receiveMonth=tr.getReceiveMonth();
		this.receiveDay=tr.getReceiveDay();
		this.centerNumber=tr.getCenterNumber();
		this.bar=tr.getBar();
	}
public Transit(String code){
		
	}
	
	public boolean saveInfo(){
		po=new CenterReceivePO(this.receiveYear,this.receiveMonth,this.receiveDay,this.centerNumber,this.bar);
		ReceiveDataService service=new ReceiveDataController();
		service.createNewDriver(po);
		return true;
		
	}
	
	public boolean modify(){
		return true;
	}
	public static boolean delete(String bar){
		return true;
	}
	public boolean inquireInfo(String bar){
		return true;
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
