package data_stub;

import dataservice.InfoDataService;
import po.DriverInfoPO;
import po.InstitutionPO;
import po.VehicleInfoPO;
import po.WorkerPO;


public class InfoDataService_Stub implements InfoDataService{
	//--------------机构管理--------------------
	
		//从数据库里面读取某类别的机构信息
		//category 为机构的类别
		public InstitutionPO readInstitution(String code) {
			System.out.println("read Succeed!\n");
			InstitutionPO institutionPO = new InstitutionPO("123", "日天大元帅", "叶良辰", code);
			return institutionPO;
		}
		
		//增加某类别的机构
		//新建一个机构，输入机构类别，名称，地理位置，编号
		//数据库存储该机构信息
		public boolean addInstitution(InstitutionPO institutionPO) {
			System.out.println("add Succeed!\n");
			return true;
		}
		
		//删除某机构
		//输入机构的编码，数据库将删除该机构
		public boolean delInstitution(String code) {
			System.out.println("delete Succeed!\n");
			return true;
		}
		
		//修改某机构的信息，（个人认为不能修改机构的等级，即不能将营业厅改为中转中心，其他信息可修改）
		//String name,String position,String code表示要修改的部分，如果不修改，则和之前的信息一样
		public InstitutionPO modifyInstitution(InstitutionPO institutionPO) {
			System.out.println("modify Succeed!\n");
			return institutionPO;
		}
		
		//新建职工档案，输入职工名称，职位，所在单位，职工年龄以及编号
		//数据库将保存该员工信息
		public boolean createNewStaff(WorkerPO workerPO) {
			System.out.println("creat Succeed!\n");
			return true;
		}
			
		//数据库删除该员工信息
		//account为员工的账户
		public boolean deleteStaff(String account) {
			System.out.println("delete Succeed!\n");
			return true;		
		}
			
		//数据库返回该账户的信息
		//account为该员工的账户
		public WorkerPO inquireStaff(String account) {
			System.out.println("Succeed!\n");
			WorkerPO workerPO = new WorkerPO("赵日天", "日天大元帅", "123", 18);
			return workerPO;
		}
			
		//修改职工信息
		//account为该员工的账户，account不可以被修改
		//String modifyName,String modifyJob,String modifyUnit,String modifyWorkage表示要修改的内容
		public WorkerPO modifyStaff(WorkerPO workerPO) {
			System.out.println("modify Succeed!\n");
			return workerPO;
			
		}
			
		//将新添的车辆信息保存至数据库，输入车牌号（name），车辆代号（code），以及服役时间
		public boolean createNewVehicle(VehicleInfoPO vehicleInfoPO) {
			System.out.println("add Succeed!\n");
			return true;	
		}
			
		//删除车辆信息
		//code表示车辆代号
		public boolean deleteVehicle(String code) {
			System.out.println("delete Succeed!\n");
			return true;
		}
			
		//查询车辆信息，输入车辆代号 数据库中查询该代号的车辆信息
		public VehicleInfoPO readVehicle(String code) {
			System.out.println("read Succeed!\n");
			VehicleInfoPO vehicleInfoPO = new VehicleInfoPO(0, 0, 0, 0, code, 0);
			return vehicleInfoPO;
		}
		
		//修改车辆信息
		public VehicleInfoPO modifyVehicle(VehicleInfoPO vehicleInfoPO) {
			System.out.println("modify Succeed!/n");
			return vehicleInfoPO;
		}
			
		//新建一个司机信息，输入司机编号、姓名、出生日期、身份证号、手机 、性别、行驶证期限
		public boolean createNewDriver(DriverInfoPO driveInfoPO) {
			System.out.println("creat Succeed!\n");
			return true;	
		}
			
		//删除司机信息
		public void deleteDriver(){
			System.out.println("删除刘钦成功!\n");
		}
			
		//查询司机信息，输入司机编号
		public DriverInfoPO inquireDriver(String code) {
			System.out.println("inquire Succeed!\n");
			DriverInfoPO driverInfoPO = new DriverInfoPO(0, "刘钦", "1986-04-16", "43023222266666666", "13813813813", "南京大学", "男", "2012-12-12");
			return driverInfoPO;
		}
			
		//修改司机信息
		public DriverInfoPO modifyDriver(DriverInfoPO driveInfoPO) {
			System.out.println("modify Succeed!\n");
			DriverInfoPO driverInfoPO = new DriverInfoPO(0, "刘钦", "1986-04-16", "43023222266666666", "13813813813", "南京大学", "男", "2012-12-12");
			return driverInfoPO;
		}
}
