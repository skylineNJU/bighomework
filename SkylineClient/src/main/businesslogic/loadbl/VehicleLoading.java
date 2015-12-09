package main.businesslogic.loadbl;

import main.businesslogic.financebl.UpdateBank;
import main.data.load.LoadDataController;
import main.dataservice.LoadDataService;
import main.po.VehicleLoadingPO;
import main.vo.VehicleLoadingVO;

public class VehicleLoading{
	private String loadingDate;//装运日期
	private String carNum;//中转中心汽运编号
	private String carTourNum;//车次号
	private String departure;//出发地
	private String destination;//到达地
	private String monitor;//监装员
	private String guard;//押送员
	private String shipment;//装箱托运区号
	private double freight;//运费
	private String code;
	private VehicleLoadingPO po;
	private String belong;
	
	public VehicleLoading(VehicleLoadingVO loadingInfo){
		this.loadingDate=loadingInfo.getLoadingDate();
		this.carNum=loadingInfo.getCarNum();
		this.carTourNum=loadingInfo.getCarTourNum();
		this.departure=loadingInfo.getDeparture();
		this.destination=loadingInfo.getDestination();
		this.monitor=loadingInfo.getMonitor();
		this.guard=loadingInfo.getGuard();
		this.shipment=loadingInfo.getShipment();
		this.freight=loadingInfo.getFreight();
		this.code=loadingInfo.getCode();
		this.belong=loadingInfo.getBelong();
	}
	
	public void saveInfo(){
		po=new VehicleLoadingPO(loadingDate,carNum,carTourNum,departure,
				destination,monitor,guard,shipment,freight);
		po.setCode(code);
		LoadDataService service=new LoadDataController();
		service.writeVehicleLoadBase(po);
		
		UpdateBank updateBank=new UpdateBank();
		updateBank.updateMoney(belong, freight);
	}
}
