package main.data.info;

import main.dataservice.InfoDataService;
import main.po.DriverInfoPO;
import main.po.DriverList;
import main.po.InstitutionPO;
import main.po.VehicleInfoPO;
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
		client.wrightReceipt(workerPO);
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
		client.wrightReceipt(workerPO);
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
		return false;
	}

	@Override
	public boolean deleteVehicle(String code) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean readVehicle(String code, VehicleInfoPO vehicleInfoPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyVehicle(VehicleInfoPO vehicleInfoPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createNewDriver(DriverInfoPO driverInfoPO) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		driverInfoPO.setKey("Save");
		client.wrightReceipt(driverInfoPO);
		return false;
	}

	@Override
	public boolean deleteDriver() {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public boolean modifyDriver(DriverInfoPO driveInfoPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DriverList inquireDriver(DriverList driverlist) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		System.out.println(driverlist.getlist().get(0).getCarunit());
		driverlist.setKey("Inquire");
		client.wrightReceipt(driverlist);
		driverlist=(DriverList) client.getResponse();
		System.out.println(driverlist.getlist().get(0).getName());
		return driverlist;
	}

}
