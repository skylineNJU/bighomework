package main.businesslogic.infobl;

import java.util.ArrayList;

import main.businesslogicservice.InfoBLService;
import main.vo.DriverVO;
import main.vo.IntermediateInfoVO;
import main.vo.LobbyInfoVO;
import main.vo.StaffVO;
import main.vo.VehicleVO;
import main.vo.WarehouseInfoVO;

public class InfoController implements InfoBLService {


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
		Vehicle ve=new Vehicle(vehicleCode);
		return ve.delete();
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

	@Override
	public boolean addNewIntermediate(IntermediateInfoVO vo) {
		// TODO Auto-generated method stub
		IntermediateInfoBL bl=new IntermediateInfoBL(vo);
		bl.saveInfo();
		return false;
	}


	

	@Override
	public boolean addNewWarehouse(WarehouseInfoVO voList) {
		// TODO Auto-generated method stub
		WarehouseInfoBL bl=new WarehouseInfoBL(voList);
		bl.saveInfo();
		return false;
	}

	@Override
	public boolean addNewLobby(LobbyInfoVO vo) {
		// TODO Auto-generated method stub
		LobbyInfoBL bl=new LobbyInfoBL(vo);
		bl.saveInfo();
		return false;
	}

	@Override
	public ArrayList<LobbyInfoVO> inquireLobby(String cityName) {
		// TODO Auto-generated method stub
		LobbyInfoBL bl=new LobbyInfoBL(cityName);
		
		return bl.inquire();
	}

	@Override
	public IntermediateInfoVO inquireInterm(String city) {
		// TODO Auto-generated method stub
		IntermediateInfoBL bl=new IntermediateInfoBL(new IntermediateInfoVO(city, city, 0, 0));
		
		return bl.inquire();
	}

	@Override
	public boolean modifyIntermediate(IntermediateInfoVO vo) {
		// TODO Auto-generated method stub
		IntermediateInfoBL bl=new IntermediateInfoBL(vo);
		bl.modify();
		return false;
	}

	@Override
	public boolean modifyLobby(LobbyInfoVO vo) {
		// TODO Auto-generated method stub
		LobbyInfoBL bl=new LobbyInfoBL(vo);
		bl.modify();
		return false;
	}

	@Override
	public boolean deleteIntermediate(IntermediateInfoVO vo) {
		// TODO Auto-generated method stub
		IntermediateInfoBL bl=new IntermediateInfoBL(vo);
		bl.delete();
		return false;
	}

	@Override
	public boolean deleteLobby(LobbyInfoVO vo) {
		// TODO Auto-generated method stub
		LobbyInfoBL bl=new LobbyInfoBL(vo);
		bl.modify();
		return false;
	}

	@Override
	public boolean deleteWarehouse(WarehouseInfoVO vo) {
		// TODO Auto-generated method stub
		WarehouseInfoBL bl=new WarehouseInfoBL(vo);
		bl.delete();
		return false;
	}

	

}
