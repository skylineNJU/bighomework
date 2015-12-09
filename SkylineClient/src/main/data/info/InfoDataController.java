package main.data.info;

import main.dataservice.InfoDataService;
import main.po.DriverInfoPO;
import main.po.DriverList;
import main.po.InstitutionPO;
import main.po.IntermediateInfo;
import main.po.LobbyInfo;
import main.po.LobbyInfoList;
import main.po.StaffListPO;
import main.po.VehicleInfoPO;
import main.po.VehicleListPO;
import main.po.WarehouseInfo;
import main.po.WorkerPO;
import main.presentation.mainui.MainController;
import main.socketservice.Client;

public class InfoDataController implements InfoDataService {

	Client client;
	@Override
	public StaffListPO readStaff(String unitCode) {
		StaffListPO poList = new StaffListPO();
		WorkerPO workerPO = new WorkerPO(unitCode, unitCode, unitCode, unitCode, unitCode);
		poList.add(workerPO);
		client=MainController.getClient();
		poList.setKey("Inquire");
		client.writeReceipt(poList);
		return (StaffListPO)client.getResponse();
	}

	@Override
	public boolean createNewStaff(WorkerPO workerPO) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		workerPO.setKey("Save");
		client.writeReceipt(workerPO);
		return false;
	}

	@Override
	public boolean deleteStaff(String account) {
		WorkerPO workerPO = new WorkerPO(account, account, account, account, account);
		client=MainController.getClient();
		workerPO.setKey("Delete");
		client.writeReceipt(workerPO);
		return true;
	}

	@Override
	public WorkerPO inquireStaff(WorkerPO workerPO) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		workerPO.setKey("Inquire");
		client.writeReceipt(workerPO);
		return (WorkerPO) client.getResponse();
	}

	@Override
	public boolean createNewVehicle(VehicleInfoPO vehicleInfoPO) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		vehicleInfoPO.setKey("Save");
		client.writeReceipt(vehicleInfoPO);
		return false;
	}


	@Override
	public VehicleListPO readVehicle(VehicleListPO vehiclelist) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		vehiclelist.setKey("Inquire");
		client.writeReceipt(vehiclelist);
		vehiclelist=(VehicleListPO) client.getResponse();
		return vehiclelist;
	}

	@Override
	public boolean modifyVehicle(VehicleInfoPO vehicleInfoPO) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		vehicleInfoPO.setKey("Modify");
		client.writeReceipt(vehicleInfoPO);
		return false;
	}

	@Override
	public boolean createNewDriver(DriverInfoPO driverInfoPO) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		driverInfoPO.setKey("Save");
		client.writeReceipt(driverInfoPO);
		return false;
	}


	@Override
	public boolean modifyDriver(DriverInfoPO driveInfoPO) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		driveInfoPO.setKey("Modify");
		client.writeReceipt(driveInfoPO);
		return false;
	}

	@Override
	public DriverList inquireDriver(DriverList driverlist) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		System.out.println(driverlist.getlist().get(0).getCarunit());
		driverlist.setKey("Inquire");
		client.writeReceipt(driverlist);
		driverlist=(DriverList) client.getResponse();
		return driverlist;
	}

	@Override
	public boolean deleteDriver(DriverInfoPO po) {
		// TODO Auto-generated method stub
		po.setKey("Delete");
		System.out.println("-------------begin delete");
		client=MainController.getClient();
		client.writeReceipt(po);
		return false;
	}

	@Override
	public boolean deleteVehicle(VehicleInfoPO po) {
		// TODO Auto-generated method stub
		po.setKey("Delete");
		client=MainController.getClient();
		client.writeReceipt(po);
		return false;
	}


	@Override
	public boolean addIntermediate(IntermediateInfo po) {
		// TODO Auto-generated method stub
		po.setKey("Save");
		client=MainController.getClient();
		client.writeReceipt(po);
		return false;
	}


	@Override
	public boolean addWarehouse(WarehouseInfo po) {
		// TODO Auto-generated method stub
		po.setKey("Save");
		client=MainController.getClient();
		client.writeReceipt(po);
		return false;
	}

	@Override
	public boolean addLobby(LobbyInfo po) {
		// TODO Auto-generated method stub
		po.setKey("Save");
		client=MainController.getClient();
		client.writeReceipt(po);
		return false;
	}

	@Override
	public LobbyInfoList inquireLobby(LobbyInfoList po) {
		// TODO Auto-generated method stub
		po.setKey("Inquire");
		client=MainController.getClient();
		client.writeReceipt(po);
		return (LobbyInfoList) client.getResponse();
	}

	@Override
	public IntermediateInfo inquireInterm(IntermediateInfo po) {
		// TODO Auto-generated method stub
		po.setKey("Inquire");
		client=MainController.getClient();
		client.writeReceipt(po);
		return (IntermediateInfo) client.getResponse();
	}

	@Override
	public boolean modifyIntermediate(IntermediateInfo po) {
		// TODO Auto-generated method stub
		po.setKey("Modify");
		client=MainController.getClient();
		client.writeReceipt(po);
		return false;
	}

	@Override
	public boolean modifyLobby(LobbyInfo po) {
		// TODO Auto-generated method stub
		po.setKey("Modify");
		client=MainController.getClient();
		client.writeReceipt(po);
		return false;
	}

	@Override
	public boolean deleteIntermediate(IntermediateInfo po) {
		// TODO Auto-generated method stub
		po.setKey("Delete");
		client=MainController.getClient();
		client.writeReceipt(po);
		return false;
	}

	@Override
	public boolean deleteLobby(LobbyInfo po) {
		// TODO Auto-generated method stub
		po.setKey("Delete");
		client=MainController.getClient();
		client.writeReceipt(po);
		return false;
	}
	
	public boolean deleteWarehouse(WarehouseInfo po) {
		// TODO Auto-generated method stub
		po.setKey("Delete");
		client=MainController.getClient();
		client.writeReceipt(po);
		return false;
	}
	@Override
	public boolean modifyStaff(WorkerPO workerPO) {
		// TODO Auto-generated method stub
		return false;
	}

}
