package businesslogic.infobl;

import businesslogicservice.InfoBLService;
import vo.DriverVO;
import vo.InstitutionVO;
import vo.StaffVO;
import vo.VehicleVO;

public class InfoController implements InfoBLService {

	@Override
	public boolean createNewInstitution(InstitutionVO institutionInfo) {
		// TODO Auto-generated method stub
		Institution ins=new Institution(institutionInfo);
		return ins.saveInfo();
	}

	@Override
	public boolean deleteInstitution(String institutionCode) {
		// TODO Auto-generated method stub
		return Institution.delete(institutionCode);
	}

	@Override
	public boolean inquireInstitution(String code, InstitutionVO institutionInfo) {
		// TODO Auto-generated method stub
		Institution ins=new Institution(code);
		return institutionInfo.writeInstitutionVO(ins);
	}

	@Override
	public boolean modifyInstitution(InstitutionVO institutionInfo) {
		// TODO Auto-generated method stub
		Institution ins=new Institution(institutionInfo);
		return ins.modify();
	}

	@Override
	public boolean createNewStaff(StaffVO staffInfo) {
		// TODO Auto-generated method stub
		Staff staff=new Staff(staffInfo);
		return staff.saveInfo();
	}

	@Override
	public boolean deleteStaff(String staffCode) {
		// TODO Auto-generated method stub
		return Staff.delete(staffCode);
	}

	@Override
	public boolean inquireStaff(String staffCode,StaffVO staffInfo) {
		// TODO Auto-generated method stub
		Staff staff=new Staff(staffCode);
		return staffInfo.writeStaffInfo(staff);
	}

	@Override
	public boolean modifyStaff(StaffVO staffInfo) {
		// TODO Auto-generated method stub
		Staff staff=new Staff(staffInfo);
		return staff.modify();
	}

	@Override
	public boolean createNewVehicle(VehicleVO vehicleInfo) {
		// TODO Auto-generated method stub
		Vehicle vehicle=new Vehicle(vehicleInfo);
		return vehicle.saveInfo();
	}

	@Override
	public boolean deleteVehicle(String vehicleCode) {
		// TODO Auto-generated method stub
		return Vehicle.delete(vehicleCode);
	}

	@Override
	public boolean inquireVehicle(String code, VehicleVO vehicleInfo) {
		// TODO Auto-generated method stub
		Vehicle vehicle=new Vehicle(code);
		return vehicleInfo.writeVehicleInfo(vehicle);
	}

	@Override
	public boolean modifyVehicle(VehicleVO vehicleInfo) {
		// TODO Auto-generated method stub
		Vehicle vehicle=new Vehicle(vehicleInfo);
		return vehicle.modify();
	}

	@Override
	public boolean createNewDriver(DriverVO driverInfo) {
		// TODO Auto-generated method stub
		Driver driver=new Driver(driverInfo);
		return driver.saveInfo();
	}

	@Override
	public boolean deleteDriver(String driverCode) {
		// TODO Auto-generated method stub
		return Driver.delete(driverCode);
	}

	@Override
	public boolean inquireDriver(String code, DriverVO driverInfo) {
		// TODO Auto-generated method stub
		Driver driver=new Driver(code);
		return driverInfo.writeDriverInfo(driver);
	}

	@Override
	public boolean modifyDriver(DriverVO driverInfo) {
		// TODO Auto-generated method stub
		Driver driver=new Driver(driverInfo);
		return driver.modify();
	}

	

}
