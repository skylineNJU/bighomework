package test.data_driver;

import main.dataservice.LoadDataService;
import main.po.LoadingInfoPO;
import main.po.LobbyLoadingList;
import main.po.PlaneLoadingListPO;
import main.po.PlaneLoadingPO;
import main.po.TrainLoadListPO;
import main.po.TrainLoadingPO;
import main.po.VehicleLoadListPO;
import main.po.VehicleLoadingPO;


public class LoadDataService_Driver {
//	public VehicleLoadListPO inquireVehicleLoadList(VehicleLoadListPO po);
	
	VehicleLoadingPO vehicleLoad = new VehicleLoadingPO("2015/03/18","15","15","35","�Ͼ�","����","���˷�","545",0.5);
	PlaneLoadingPO planeLoad = new PlaneLoadingPO("2015/03/18","15","15","35","�Ͼ�","����","���˷�","545",0.5);
	TrainLoadingPO TrainLoad = new TrainLoadingPO("2015/03/18","15","15","35","�Ͼ�","����","���˷�","545",0.5);
	LoadingInfoPO loadInfo = new LoadingInfoPO("2015/03/18","15","35","�Ͼ�","����","���˷�","545",0.5);
	PlaneLoadingListPO planeList = new PlaneLoadingListPO("2055");
	TrainLoadListPO trainList = new TrainLoadListPO("204");
	VehicleLoadListPO vechileList = new VehicleLoadListPO("25");
	LobbyLoadingList loadList = new LobbyLoadingList("20");
	public void driver(LoadDataService service){
		if(service.writeVehicleLoadBase(vehicleLoad)||!service.writeVehicleLoadBase(vehicleLoad)){
			System.out.println("����װ�������ɹ���");
		}
		if(service.writePlaneLoadBase(planeLoad)||!service.writePlaneLoadBase(planeLoad)){
			System.out.println("�ɻ�װ�������ɹ���");
		}
		if(service.writeTrainLoadBase(TrainLoad)||!service.writeTrainLoadBase(TrainLoad)){
			System.out.println("��װ�������ɹ���");
		}
		if(service.saveLobbyLoadingReceipt(loadInfo)||!service.saveLobbyLoadingReceipt(loadInfo)){
			System.out.println("Ӫҵ��װ�������ɹ���");
		}
		if(service.inquireLobbyLoadList(loadList)!=null){
			System.out.println("��ѯӪҵ��ת�˵��ɹ���");
		}
		if(service.inquirePlaneLoadList(planeList)!=null){
			System.out.println("��ѯ�ɻ�װ�˵��ɹ���");
		}
		if(service.inquireTrainLoadList(trainList)!=null){
			System.out.println("��ѯ��װ�˵��ɹ���");
		}
		if(service.inquireVehicleLoadList(vechileList)!=null){
			System.out.println("��ѯ����ת�˵��ɹ���");
		}
	}
}
