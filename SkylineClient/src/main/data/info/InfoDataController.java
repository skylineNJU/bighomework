package main.data.info;

import main.dataservice.InfoDataService;
import main.po.DriverInfoPO;
import main.po.DriverList;
import main.po.InstitutionPO;
import main.po.VehicleInfoPO;
import main.po.VehicleListPO;
import main.po.WorkerPO;
import main.presentation.mainui.MainController;
import main.socketservice.Client;

public class InfoDataController implements InfoDataService {

	Client client;
	@Override
	public boolean readInstitution(String code, InstitutionPO institutionPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addInstitution(InstitutionPO institutionPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delInstitution(String code) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyInstitution(InstitutionPO institutionPO) {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return false;
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
	public boolean modifyStaff(WorkerPO workerPO) {
		// TODO Auto-generated method stub
		return false;
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

}
