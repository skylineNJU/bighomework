package test.bl_stub;

import java.util.ArrayList;

import  main.businesslogicservice.InfoBLService;
import  main.vo.DriverVO;
import main.vo.IntermediateInfoVO;
import main.vo.LobbyInfoVO;
import  main.vo.StaffVO;
import  main.vo.VehicleVO;
import main.vo.WarehouseInfoVO;

public class InfoBLService_Stub implements InfoBLService{

	StaffVO staffVO = new StaffVO("乘风快递", "快递员", "10215", "2015/02/13", "2013");
	IntermediateInfoVO intermediateInfoVO = new IntermediateInfoVO("南京", "20135", 188.23, 32);
	LobbyInfoVO lobbyInfoVO = new LobbyInfoVO("南京", "5659", 36, 1825.48);
	DriverVO driverVO = new DriverVO("豆乘风", "2015", "2015/03/04", "251168135165", "10151818186", "男", "18616");
	VehicleVO vehicleVO = new VehicleVO("58685", "486486", "5156", "4516156", "2013/04/15", "3年");
	@Override
	public ArrayList<StaffVO> readStaff(String unitCode) {
		ArrayList<StaffVO> voList = new ArrayList<StaffVO>();
		voList.add(staffVO);
		return voList;
	}

	@Override
	public boolean addNewIntermediate(IntermediateInfoVO vo) {
		System.out.println("新增中转中心成功！");
		return true;
	}

	@Override
	public boolean addNewWarehouse(WarehouseInfoVO voList) {
		System.out.println("新增中转仓库成功！");
		return true;
	}

	@Override
	public boolean addNewLobby(LobbyInfoVO vo) {
		System.out.println("新增营业厅成功！");
		return true;
	}

	@Override
	public IntermediateInfoVO inquireInterm(String city) {
		return intermediateInfoVO;
	}

	@Override
	public ArrayList<LobbyInfoVO> inquireLobby(String cityName) {
		ArrayList<LobbyInfoVO> voList = new ArrayList<LobbyInfoVO>();
		voList.add(lobbyInfoVO);
		return voList;
	}

	@Override
	public boolean modifyIntermediate(IntermediateInfoVO vo) {
		System.out.println("修改中转中心成功！");
		return true;
	}

	@Override
	public boolean modifyLobby(LobbyInfoVO vo) {
		System.out.println("修改营业厅成功！");
		return true;
	}

	@Override
	public boolean deleteIntermediate(IntermediateInfoVO vo) {
		System.out.println("删除中转中心成功！");
		return true;
	}

	@Override
	public boolean deleteLobby(LobbyInfoVO vo) {
		System.out.println("删除营业厅成功！");
		return true;
	}

	@Override
	public boolean deleteWarehouse(WarehouseInfoVO vo) {
		System.out.println("删除仓库成功！");
		return true;
	}

	@Override
	public boolean createNewStaff(StaffVO staffInfo) {
		System.out.println("新增员工"+staffInfo.getName()+"成功！");
		return true;
	}

	@Override
	public boolean deleteStaff(String staffCode) {
		System.out.println("删除"+staffCode+"员工成功！");
		return true;
	}

	@Override
	public boolean modifyStaff(StaffVO staffInfo) {
		System.out.println("修改员工"+staffInfo.getCode()+"成功！");
		return true;
	}

	@Override
	public boolean createNewVehicle(VehicleVO vehicleInfo) {
		System.out.println("新增车辆"+vehicleInfo.getCarID()+"成功！");
		return true;
	}

	@Override
	public boolean deleteVehicle(String vehicleCode) {
		System.out.println("删除"+vehicleCode+"成功！");
		return true;
	}

	@Override
	public boolean modifyVehicle(VehicleVO vehicleInfo) {
		System.out.println("修改车辆"+vehicleInfo.getCarID()+"成功！");
		return true;
	}

	@Override
	public boolean createNewDriver(DriverVO driverInfo) {
		System.out.println("新增司机"+driverInfo.getCode()+"成功！");
		return true;
	}

	@Override
	public boolean deleteDriver(String driverCode) {
		System.out.println("删除司机"+driverCode+"成功！");
		return true;
	}

	@Override
	public boolean modifyDriver(DriverVO driverInfo) {
		System.out.println("修改司机"+driverInfo.getCode()+"成功！");
		return true;
	}

	@Override
	public ArrayList<DriverVO> inquireDriver(String code) {
		ArrayList<DriverVO> voList = new ArrayList<DriverVO>();
		voList.add(driverVO);
		return voList;
	}

	@Override
	public ArrayList<VehicleVO> inquireVehicle(String code) {
		ArrayList<VehicleVO> voList = new ArrayList<VehicleVO>();
		voList.add(vehicleVO);
		return voList;
	}

	@Override
	public StaffVO inquireStaff(String staffCode) {
		return staffVO;
	}
	
}
