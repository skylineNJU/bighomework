package main.businesslogic.loadbl;
import main.businesslogic.financebl.UpdateBank;
import main.data.load.LoadDataController;
import main.dataservice.LoadDataService;
import main.po.PlaneLoadingPO;
import main.vo.PlaneLoadingVO;
public class PlaneLoading{
	private String loadingDate;//װ������
	private String flightNum;//��ת����
	private String planeNum;//
	private String departure;//������
	private String destination;//�����
	private String monitor;//��װԱ
	private String store;//Ѻ��Ա
	private String shipment;//װ����������
	private double freight;//�˷�
	private String code;
	private PlaneLoadingPO po;
	private String belong;
	
	public PlaneLoading(PlaneLoadingVO loadInfo){
		loadingDate=loadInfo.getLoadingDate();
		this.flightNum=loadInfo.getCarTourNum();
		this.planeNum=loadInfo.getCarNum();
		this.departure=loadInfo.getDeparture();
		this.destination=loadInfo.getDestination();
		this.monitor=loadInfo.getMonitor();
		this.store=loadInfo.getGuard();
		this.shipment=loadInfo.getShipment();
		this.freight=loadInfo.getFreight();
		this.code=loadInfo.getCode();
		this.belong=loadInfo.getBelong();
	}
	
	public void saveInfo(){
		po=new PlaneLoadingPO(loadingDate,flightNum,planeNum,departure,
				destination,monitor,store,shipment,freight);
		po.setCode(code);
		LoadDataService service=new LoadDataController();
		service.writePlaneLoadBase(po);

		UpdateBank updateBank=new UpdateBank();
		updateBank.updateMoney(belong, freight);
	}
}
