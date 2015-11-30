package main.businesslogic.loadbl;

import main.data.load.LoadDataController;
import main.dataservice.LoadDataService;
import main.po.TrainLoadingPO;
import main.vo.TrainLoadingVO;

public class TrainLoading{
	private String loadingDate;//װ������
	private String trainNum;//��ת�������˱��
	private String trainTourNum;//���κ�
	private String departure;//������
	private String destination;//�����
	private String monitor;//��װԱ
	private String store;//Ѻ��Ա
	private String shipment;//װ����������
	private double freight;//�˷�
	private String code;
	private TrainLoadingPO po;
	
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
	}
	
	public void saveInfo(){
		po=new TrainLoadingPO(loadingDate,trainNum,trainTourNum,departure,
				destination,monitor,store,shipment,freight);
		po.setCode(code);
		LoadDataService service=new LoadDataController();
		service.writeTrainLoadBase(po);
	}
}
