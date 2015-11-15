package dataservice;

import po.DriverInfoPO;
import po.InstitutionPO;
import po.VehicleInfoPO;
import po.WorkerPO;

	//机构管理
	//人员管理
	//车辆信息管理
	//驾驶员信息管理
public interface InfoDataService {

	//--------------机构管理--------------------
	
	//从数据库里面读取某类别的机构信息
	//category 为机构的类别
	public boolean readInstitution(String code,InstitutionPO institutionPO);
	
	//增加某类别的机构
	//新建一个机构，输入机构类别，名称，地理位置，编号
	//数据库存储该机构信息
	public boolean addInstitution(InstitutionPO institutionPO);
	
	//删除某机构
	//输入机构的编码，数据库将删除该机构
	public boolean delInstitution(String code);
	
	//修改某机构的信息，（个人认为不能修改机构的等级，即不能将营业厅改为中转中心，其他信息可修改）
	//String name,String position,String code表示要修改的部分，如果不修改，则和之前的信息一样
	public boolean modifyInstitution(InstitutionPO institutionPO);
	
	//新建职工档案，输入职工名称，职位，所在单位，职工年龄以及编号
	//数据库将保存该员工信息
	public boolean createNewStaff(WorkerPO workerPO);
		
	//数据库删除该员工信息
	//account为员工的账户
	public boolean deleteStaff(String account);
		
	//数据库返回该账户的信息
	//account为该员工的账户
	public boolean inquireStaff(String account,WorkerPO workerPO);
		
	//修改职工信息
	//account为该员工的账户，account不可以被修改
	//String modifyName,String modifyJob,String modifyUnit,String modifyWorkage表示要修改的内容
	public boolean modifyStaff(WorkerPO workerPO);
		
	//将新添的车辆信息保存至数据库，输入车牌号（name），车辆代号（code），以及服役时间
	public boolean createNewVehicle(VehicleInfoPO vehicleInfoPO);
		
	//删除车辆信息
	//code表示车辆代号
	public boolean deleteVehicle(String code);
		
	//查询车辆信息，输入车辆代号 数据库中查询该代号的车辆信息
	public boolean readVehicle(String code,VehicleInfoPO vehicleInfoPO);
	
	//修改车辆信息
	public boolean modifyVehicle(VehicleInfoPO vehicleInfoPO);
		
	//新建一个司机信息，输入司机编号、姓名、出生日期、身份证号、手机 、性别、行驶证期限
	public boolean createNewDriver(DriverInfoPO driveInfoPO);
		
	//删除司机信息
	public boolean deleteDriver();
		
	//查询司机信息，输入司机编号
	public boolean inquireDriver(String code,DriverInfoPO driverInfoPO);
		
	//修改司机信息
	public boolean modifyDriver(DriverInfoPO driveInfoPO);
}
