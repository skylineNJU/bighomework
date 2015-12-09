package main.businesslogic.loadbl;

import main.businesslogic.financebl.UpdateBank;
import main.data.load.LoadDataController;
import main.dataservice.LoadDataService;
import main.po.TrainLoadingPO;
import main.vo.TrainLoadingVO;

public class TrainLoading{
	private String loadingDate;//装运日期
	private String trainNum;//中转中心汽运编号
	private String trainTourNum;//车次号
	private String departure;//出发地
	private String destination;//到达地
	private String monitor;//监装员
	private String store;//押送员
	private String shipment;//装箱托运区号
	private double freight;//运费
	private String code;
	private TrainLoadingPO po;
	private String belong;
	
	public TrainLoading(TrainLoadingVO vo){
		this.loadingDate=vo.getLoadingDate();
		this.trainNum=vo.getCarNum();
		this.trainTourNum=vo.getCarTourNum();
		this.departure=vo.getDeparture();
		this.destination=vo.getDestination();
		this.monitor=vo.getMonitor();
		this.store=vo.getGuard();
		this.shipment=vo.getShipment();
		this.freight=vo.getFreight();
		this.code=vo.getCode();
		this.belong=vo.getBelong();
	}
	
	public void saveInfo(){
		po=new TrainLoadingPO(loadingDate,trainNum,trainTourNum,departure,
				destination,monitor,store,shipment,freight);
		po.setCode(code);
		LoadDataService service=new LoadDataController();
		service.writeTrainLoadBase(po);
		UpdateBank updateBank=new UpdateBank();
		updateBank.updateMoney(belong, freight);
	}
}
