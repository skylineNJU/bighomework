package main.businesslogic.loadbl;

import main.businesslogic.financebl.UpdateBank;
import main.data.load.LoadDataController;
import main.dataservice.LoadDataService;
import main.po.VehicleLoadingPO;
import main.vo.VehicleLoadingVO;

public class VehicleLoading{
	private String loadingDate;//װ������
	private String carNum;//��ת�������˱��
	private String carTourNum;//���κ�
	private String departure;//������
	private String destination;//�����
	private String monitor;//��װԱ
	private String guard;//Ѻ��Ա
	private String shipment;//װ����������
	private double freight;//�˷�
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
