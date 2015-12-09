package test.data_stub;

import  main.dataservice.InfoDataService;
import  main.po.DriverInfoPO;
import main.po.DriverList;
import  main.po.InstitutionPO;
import main.po.IntermediateInfo;
import main.po.LobbyInfo;
import main.po.LobbyInfoList;
import main.po.StaffListPO;
import  main.po.VehicleInfoPO;
import main.po.VehicleListPO;
import main.po.WarehouseInfo;
import  main.po.WorkerPO;


public class InfoDataService_Stub implements InfoDataService{
	//--------------机构管理--------------------
	

	@Override
	public boolean addLobby(LobbyInfo po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LobbyInfoList inquireLobby(LobbyInfoList po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IntermediateInfo inquireInterm(IntermediateInfo po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addIntermediate(IntermediateInfo po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addWarehouse(WarehouseInfo po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyIntermediate(IntermediateInfo po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyLobby(LobbyInfo po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteIntermediate(IntermediateInfo po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLobby(LobbyInfo po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteWarehouse(WarehouseInfo po) {
		// TODO Auto-generated method stub
		return false;
	}
	//新建职工档案，输入职工名称，职位，所在单位，职工年龄以及编号
	//数据库将保存该员工信息
	@Override
	public boolean createNewStaff(WorkerPO workerPO) {
		// TODO Auto-generated method stub
		return false;
	}
	//数据库删除该员工信息
	//account为员工的账户
	@Override
	public boolean deleteStaff(String account) {
		// TODO Auto-generated method stub
		return false;
	}
	//修改职工信息
	//account为该员工的账户，account不可以被修改
	//String modifyName,String modifyJob,String modifyUnit,String modifyWorkage表示要修改的内容
	@Override
	public boolean modifyStaff(WorkerPO workerPO) {
		// TODO Auto-generated method stub
		return false;
	}
	//将新添的车辆信息保存至数据库，输入车牌号（name），车辆代号（code），以及服役时间
	@Override
	public boolean createNewVehicle(VehicleInfoPO vehicleInfoPO) {
		// TODO Auto-generated method stub
		return false;
	}
	//删除车辆信息
	//code表示车辆代号
	@Override
	public boolean deleteVehicle(VehicleInfoPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyVehicle(VehicleInfoPO vehicleInfoPO) {
		// TODO Auto-generated method stub
		return false;
	}
	//新建一个司机信息，输入司机编号、姓名、出生日期、身份证号、手机 、性别、行驶证期限
	@Override
	public boolean createNewDriver(DriverInfoPO driveInfoPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDriver(DriverInfoPO po) {
		// TODO Auto-generated method stub
		return false;
	}
	//查询司机信息，输入司机编号
	@Override
	public DriverList inquireDriver(DriverList driverlist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyDriver(DriverInfoPO driveInfoPO) {
		// TODO Auto-generated method stub
		return false;
	}
	//数据库返回该账户的信息
	//account为该员工的账户
	@Override
	public WorkerPO inquireStaff(WorkerPO workerPO) {
		// TODO Auto-generated method stub
		return null;
	}
	//查询车辆信息，输入车辆代号 数据库中查询该代号的车辆信息
	@Override
	public VehicleListPO readVehicle(VehicleListPO vehiclelist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffListPO readStaff(String unitCode) {
		// TODO Auto-generated method stub
		return null;
	}


}
