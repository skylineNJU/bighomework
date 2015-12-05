package main.businesslogic.infobl;

import java.util.ArrayList;

import main.businesslogicservice.InfoBLService;
import main.vo.DriverVO;
import main.vo.InstitutionVO;
import main.vo.StaffVO;
import main.vo.VehicleVO;

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
	public StaffVO inquireStaff(String staffCode) {
		// TODO Auto-generated method stub
		Staff staff=new Staff(staffCode);
		StaffVO vo=new StaffVO(null,null,null,null,null);
		vo.writeStaffInfo(staff);
		return vo;
		
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
	public ArrayList<VehicleVO> inquireVehicle(String code) {
		// TODO Auto-generated method stub
		Vehicle vehicle=new Vehicle(code);
		ArrayList<VehicleVO> vehicleList=vehicle.inquire();
		return vehicleList;
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
		Driver dr=new Driver(driverCode);
		return dr.delete();
	}

	@Override
	public boolean modifyDriver(DriverVO driverInfo) {
		// TODO Auto-generated method stub
		Driver driver=new Driver(driverInfo);
		return driver.modify();
	}

	@Override
	public ArrayList<DriverVO> inquireDriver(String code) {
		// TODO Auto-generated method stub
		Driver driver=new Driver(code);
		ArrayList<DriverVO> volist=driver.inquire(code);
		return volist;
	}

	

}
