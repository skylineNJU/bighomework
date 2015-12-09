package main.dataservice;

import main.po.DriverInfoPO;
import main.po.DriverList;
import main.po.IntermediateInfo;
import main.po.LobbyInfo;
import main.po.LobbyInfoList;
import main.po.StaffListPO;
import main.po.VehicleInfoPO;
import main.po.VehicleListPO;
import main.po.WarehouseInfo;
import main.po.WorkerPO;

	//机构管理
	//人员管理
	//车辆信息管理
	//驾驶员信息管理
public interface InfoDataService {
	
	public StaffListPO readStaff(String unitCode);
	
	//从数据库里面读取某类别的机构信息
	//category 为机构的类别
	public boolean addLobby(LobbyInfo po);
	
	public LobbyInfoList inquireLobby(LobbyInfoList po);
	
	public IntermediateInfo inquireInterm(IntermediateInfo po);
	//增加某类别的机构
	//新建一个机构，输入机构类别，名称，地理位置，编号
	//数据库存储该机构信息
	public boolean addIntermediate(IntermediateInfo po);
	
	public boolean addWarehouse(WarehouseInfo po);
	
	//删除某机构
	//输入机构的编码，数据库将删除该机构
	public boolean modifyIntermediate(IntermediateInfo po);
	
	public boolean modifyLobby(LobbyInfo po);
	
	public boolean deleteIntermediate(IntermediateInfo po);
	
	public boolean deleteLobby(LobbyInfo po);
	
	public boolean deleteWarehouse(WarehouseInfo po);
	
	
	//新建职工档案，输入职工名称，职位，所在单位，职工年龄以及编号
	//数据库将保存该员工信息
	public boolean createNewStaff(WorkerPO workerPO);
		
	//数据库删除该员工信息
	//account为员工的账户
	public boolean deleteStaff(String account);
		
		
	//修改职工信息
	//account为该员工的账户，account不可以被修改
	//String modifyName,String modifyJob,String modifyUnit,String modifyWorkage表示要修改的内容
	public boolean modifyStaff(WorkerPO workerPO);
		
	//将新添的车辆信息保存至数据库，输入车牌号（name），车辆代号（code），以及服役时间
	public boolean createNewVehicle(VehicleInfoPO vehicleInfoPO);
		
	//删除车辆信息
	//code表示车辆代号
	public boolean deleteVehicle(VehicleInfoPO po);
		
	
	//修改车辆信息
	public boolean modifyVehicle(VehicleInfoPO vehicleInfoPO);
		
	//新建一个司机信息，输入司机编号、姓名、出生日期、身份证号、手机 、性别、行驶证期限
	public boolean createNewDriver(DriverInfoPO driveInfoPO);
		
	//删除司机信息
	public boolean deleteDriver(DriverInfoPO po);
		
	//查询司机信息，输入司机编号
	public DriverList inquireDriver(DriverList driverlist);
		
	//修改司机信息
	public boolean modifyDriver(DriverInfoPO driveInfoPO);

	public WorkerPO inquireStaff(WorkerPO workerPO);

	public VehicleListPO readVehicle(VehicleListPO vehiclelist);


}
