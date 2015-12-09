package test.data_driver;


import main.dataservice.InfoDataService;
import main.po.DriverInfoPO;
import main.po.DriverList;
import main.po.InstitutionPO;
import main.po.IntermediateInfo;
import main.po.LobbyInfo;
import main.po.LobbyInfoList;
import main.po.VehicleInfoPO;
import main.po.VehicleListPO;
import main.po.WarehouseInfo;
import main.po.WorkerPO;

public class InfoDataService_Driver {
	InstitutionPO institution=new InstitutionPO("kind","good","11111","Mary");
	WorkerPO worker=new WorkerPO("Jack","Manager","333","30","171819");
	VehicleInfoPO vehicleInfo=new VehicleInfoPO("4444","5555","6666","7777","20150701","1");
	LobbyInfo lobbyInfo=new LobbyInfo("12121415", "000", 0, 0);
	LobbyInfoList lobbyInfoList=new LobbyInfoList("shanghai");
	IntermediateInfo intermediateInfo=new IntermediateInfo("2333", "2333", 0, 0);
	WarehouseInfo warehouseInfo=new WarehouseInfo("23333", 0, 0, "23333", 0);
	VehicleListPO vehicleListPO=new VehicleListPO();
	DriverInfoPO driveInfo=new DriverInfoPO("66666","","","","","","","");
	DriverList driverList=new DriverList();
	String unitNum="23333";
	String account="141250029";
	public void drive(InfoDataService service){
		if(service.readStaff(unitNum) != null){
			System.out.println("---------Read Staff Success!-----------");
		}
		if(service.deleteStaff("sa")){
			System.out.println("---------Delete Staff Success!-----------");
		}
		if(service.addLobby(lobbyInfo)){
			System.out.println("---------Add Lobby Success!-----------");
		}
		if(service.inquireLobby(lobbyInfoList)!=null){
			System.out.println("---------Inquire Lobby Success!-----------");
		}
		
		if(service.inquireInterm(intermediateInfo)!=null){
			System.out.println("---------Inquire Interm Success!-----------");
		}
		if(service.addIntermediate(intermediateInfo)){
			System.out.println("---------Add Interm Success!-----------");
		}
		if(service.addWarehouse(warehouseInfo)){
			System.out.println("---------Add Warehouse Success!-----------");
		}
		if(service.modifyIntermediate(intermediateInfo)){
			System.out.println("---------Modify Interm Success!-----------");
		}
		if(service.modifyLobby(lobbyInfo)){
			System.out.println("---------Modify Lobby Success!-----------");
		}
		if(service.deleteIntermediate(intermediateInfo)){
			System.out.println("---------Delete Interm Success!-----------");
		}
		if(service.deleteLobby(lobbyInfo)){
			System.out.println("---------Delete Lobby Success!-----------");	
		}
		if(service.deleteWarehouse(warehouseInfo)){
			System.out.println("---------Delete Warehouse Success!-----------");
		}
		if(service.createNewStaff(worker)){
			System.out.println("---------Create New Staff Success!-----------");
		}
		if(service.deleteStaff(account)){
			System.out.println("---------Delete Staff Success!-----------");
		}
		if(service.modifyStaff(worker)){
			System.out.println("---------Modify Staff Success!-----------");
		}
		if(service.createNewVehicle(vehicleInfo)){
			System.out.println("---------Create New Vehicle Success!-----------");
		}
		if(service.deleteVehicle(vehicleInfo)){
			System.out.println("---------Delete Vehicle Success!-----------");
		}
		if(service.modifyVehicle(vehicleInfo)){
			System.out.println("---------Modify Vehicle Success!-----------");
		}
		if(service.createNewDriver(driveInfo)){
			System.out.println("---------Create New Driver Success!-----------");
		}
		if(service.deleteDriver(driveInfo)){
			System.out.println("---------Delete Driver Success!-----------");
		}
		if(service.inquireDriver(driverList)!=null){
			System.out.println("---------Inquire Driver Success!-----------");
		}
		if(service.modifyDriver(driveInfo)){
			System.out.println("---------Modify Driver Success!-----------");
		}
		if(service.inquireStaff(worker)!=null){
			System.out.println("---------Inquire Staff Success!-----------");
		}
		if(service.readVehicle(vehicleListPO)!=null){
			System.out.println("---------Read Vehicle Success!-----------");
		}
	}
}