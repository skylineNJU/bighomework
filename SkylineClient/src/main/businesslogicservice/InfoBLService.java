package main.businesslogicservice;

import java.util.ArrayList;

import main.vo.DriverVO;
import main.vo.IntermediateInfoVO;
import main.vo.LobbyInfoVO;
import main.vo.StaffVO;
import main.vo.VehicleVO;
import main.vo.WarehouseInfoVO;

public interface InfoBLService {
	//新建一个机构，输入机构类别，名称，地理位置，编号，系统显示该机构信息
	public boolean addNewIntermediate(IntermediateInfoVO vo);
	
	public boolean addNewWarehouse(WarehouseInfoVO voList);
	
	public boolean addNewLobby(LobbyInfoVO vo);
	
	public IntermediateInfoVO inquireInterm(String city);
	
	public ArrayList<LobbyInfoVO> inquireLobby(String cityName);
	
	public boolean modifyIntermediate(IntermediateInfoVO vo);
	
	public boolean modifyLobby(LobbyInfoVO vo);
	
	public boolean deleteIntermediate(IntermediateInfoVO vo);
	
	public boolean deleteLobby(LobbyInfoVO vo);
	
	public boolean deleteWarehouse(WarehouseInfoVO vo);
	
	//新建职工档案，输入职工名称，职位，所在单位，职工年龄以及编号，系统显示保存后的职工信息
	public boolean createNewStaff(StaffVO staffInfo);
	
	//删除一个职工信息，系统显示删除成功
	public boolean deleteStaff(String staffCode);
	
	
	//修改职工信息，系统显示修改后的职工信息
	public boolean modifyStaff(StaffVO staffInfo);
	
	//新添车辆信息，输入车牌号（name），车辆代号（code），以及服役时间
	public boolean createNewVehicle(VehicleVO vehicleInfo);
	
	//删除车辆信息，系统显示删除成功
	public boolean deleteVehicle(String vehicleCode);
	
	//修改车辆信息，系统显示修改后的车辆信息
	public boolean modifyVehicle(VehicleVO vehicleInfo);
	
	//新建一个司机信息，输入司机编号、姓名、出生日期、身份证号、手机 、性别、行驶证期限，系统显示司机信息
	public boolean createNewDriver(DriverVO driverInfo);
	
	//删除司机信息，系统显示删除成功
	public boolean deleteDriver(String driverCode);
	
	//查询司机信息，输入司机编号，系统显示司机信息
	
	//修改司机信息，系统显示修改后的司机信息
	public boolean modifyDriver(DriverVO driverInfo);

	ArrayList<DriverVO> inquireDriver(String code);

	StaffVO inquireStaff(String staffCode);

	ArrayList<VehicleVO> inquireVehicle(String code);
}
