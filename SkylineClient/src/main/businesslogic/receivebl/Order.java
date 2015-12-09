package main.businesslogic.receivebl;
import java.text.SimpleDateFormat;
import java.util.Date;

import main.businesslogic.financebl.Distance;
import main.businesslogic.financebl.Fee;
import main.data.receive.ReceiveDataController;
import main.dataservice.ReceiveDataService;
import main.po.OrderPO;
import main.po.Type;
import main.po.OrderPO.PackageCost;
import main.po.OrderPO.Size;
import main.vo.DistanceVO;
import main.vo.FeeVO;
import main.vo.OrderVO;

public class Order {
	private String senderName;
	private String senderAddress;
	private String senderCom;
	private String senderMobile;
	
	private String receivorName;
	private String receivorAddress;
	private String receivorCom;
	private String receivorMobile;

	private PackageCost packageCost;
	private Type type;
	
	private int num;
	private double weight;
	private double volume;
	private String cargoName;
	
	private Size size;
	private String orderCode;
	private double sum;
	private String code;
	
	public Order(OrderVO or){
		this.senderName=or.getSenderName();
		this.senderAddress=or.getSenderAddress();
		this.senderCom=or.getSenderCom();
		this.senderMobile=or.getSenderMobile();
		this.receivorName=or.getReceiverName();
		this.receivorAddress=or.getReceiverAddress();
		this.receivorCom=or.getReceiverCom();
		this.receivorMobile=or.getReceiverMobile();
		this.packageCost=or.getPackageCost();
		this.type=or.getType();
		this.num=or.getNum();
		this.weight=or.getWeight();
		this.volume=or.getWeight();
		this.cargoName=or.getCargoName();
		this.size=or.getSize();
		this.sum=or.getSum();
		this.code=or.getCode();
	}
	
	public void createOrderCode(){
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date(currentTime);
		String da=formatter.format(date);
		da=da.substring(2);
		int random=(int)(Math.random()*100);
		orderCode=packageCost.name().charAt(0)+""+type.name().charAt(0)+"-"+da+"-"+String.format("%02d",random);
	}
	public boolean saveInfo(){
		createOrderCode();
		calculateFee();
		OrderPO po=new OrderPO(senderName, senderAddress, senderCom, senderMobile, 
							   receivorName,receivorAddress,receivorCom,receivorMobile, 
							   packageCost, type, num,weight, volume, cargoName, size,orderCode,sum);
		po.setCode(code);
		System.out.println(code);
		System.out.println(orderCode);
		ReceiveDataService service=new ReceiveDataController();
		service.writeOrder(po);
		return true;
	}
	
	public void calculateFee(){
		Distance dis=new Distance();
		DistanceVO vo=dis.getDistance();
		String[] cityName=vo.getCity();
		double[][] distance=vo.getDistance();
		int x,y;
		for(x=0;x<cityName.length;x++){
			if(cityName[x].equals(this.senderAddress))
				break;
		}
		
		for(y=0;y<cityName.length;y++){
			if(cityName[y].equals(this.receivorAddress)){
				break;
			}
		}
		double juLi=distance[x][y];
		Fee fee=new Fee();
		FeeVO fvo=fee.getFee();
		double per=0;
		switch(this.type){
		case cheap:
			per=fvo.getRailFee();
			break;
		case fast:
			per=fvo.getAirFee();
			break;
		case normal:
			per=fvo.getRoadFee();
			break;
		default:
			break;
		
		}
		switch(this.size){
		case large:
			this.sum=juLi*per*this.volume/5000;
			break;
		case medium:
			this.sum=juLi*per*this.weight*1.5;
			break;
		case small:
			this.sum=juLi*per*this.weight;
			break;
		default:
			this.sum=0;
			break;
		}
		
	}
	public boolean modify(){
		return true;
	}
//	public static boolean delete(String institutionCode){
//		return true;
//	}
//	private boolean inquireInfo(String code){
//		return true;
//	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderAddress() {
		return senderAddress;
	}
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	public String getSenderCom() {
		return senderCom;
	}
	public void setSenderCom(String senderCom) {
		this.senderCom = senderCom;
	}
	public String getSenderMobile() {
		return senderMobile;
	}
	public void setSenderMobile(String senderMobile) {
		this.senderMobile = senderMobile;
	}
	public String getReceivorName() {
		return receivorName;
	}
	public void setReceivorName(String receivorName) {
		this.receivorName = receivorName;
	}
	public String getReceivorAddress() {
		return receivorAddress;
	}
	public void setReceivorAddress(String receivorAddress) {
		this.receivorAddress = receivorAddress;
	}
	public String getReceivorCom() {
		return receivorCom;
	}
	public void setReceivorCom(String receivorCom) {
		this.receivorCom = receivorCom;
	}
	public String getReceivorMobile() {
		return receivorMobile;
	}
	public void setReceivorMobile(String receivorMobile) {
		this.receivorMobile = receivorMobile;
	}
	
	
}
