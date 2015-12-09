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
	
	VehicleLoadingPO vehicleLoad = new VehicleLoadingPO("2015/03/18","15","15","35","南京","刘钦","豆乘风","545",0.5);
	PlaneLoadingPO planeLoad = new PlaneLoadingPO("2015/03/18","15","15","35","南京","刘钦","豆乘风","545",0.5);
	TrainLoadingPO TrainLoad = new TrainLoadingPO("2015/03/18","15","15","35","南京","刘钦","豆乘风","545",0.5);
	LoadingInfoPO loadInfo = new LoadingInfoPO("2015/03/18","15","35","南京","刘钦","豆乘风","545",0.5);
	PlaneLoadingListPO planeList = new PlaneLoadingListPO("2055");
	TrainLoadListPO trainList = new TrainLoadListPO("204");
	VehicleLoadListPO vechileList = new VehicleLoadListPO("25");
	LobbyLoadingList loadList = new LobbyLoadingList("20");
	public void driver(LoadDataService service){
		if(service.writeVehicleLoadBase(vehicleLoad)||!service.writeVehicleLoadBase(vehicleLoad)){
			System.out.println("车辆装车新增成功！");
		}
		if(service.writePlaneLoadBase(planeLoad)||!service.writePlaneLoadBase(planeLoad)){
			System.out.println("飞机装车新增成功！");
		}
		if(service.writeTrainLoadBase(TrainLoad)||!service.writeTrainLoadBase(TrainLoad)){
			System.out.println("火车装车新增成功！");
		}
		if(service.saveLobbyLoadingReceipt(loadInfo)||!service.saveLobbyLoadingReceipt(loadInfo)){
			System.out.println("营业厅装车新增成功！");
		}
		if(service.inquireLobbyLoadList(loadList)!=null){
			System.out.println("查询营业厅转运单成功！");
		}
		if(service.inquirePlaneLoadList(planeList)!=null){
			System.out.println("查询飞机装运单成功！");
		}
		if(service.inquireTrainLoadList(trainList)!=null){
			System.out.println("查询火车装运单成功！");
		}
		if(service.inquireVehicleLoadList(vechileList)!=null){
			System.out.println("查询汽车转运单成功！");
		}
	}
}
