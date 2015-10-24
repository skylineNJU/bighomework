package businesslogicservice;

import vo.DriverVO;
import vo.InstitutionVO;
import vo.StaffVO;
import vo.VehicleVO;

public interface InfoBLService {
	//新建一个机构，输入机构类别，名称，地理位置，编号，系统显示该机构信息
	public InstitutionVO createNewInstitution(String Category,String name,String position,String code);
	
	//删除一个信息，系统提示删除成功
	public boolean deleteInstitution();
	
	//查询机构，输入机构编号，系统显示机构信息
	public InstitutionVO inquireInstitution(String code);
	
	//修改机构，系统显示机构修改后的信息
	public InstitutionVO modifyInstitution(String Category,String name,String position,String code);
	
	//新建职工档案，输入职工名称，职位，所在单位，职工年龄以及编号，系统显示保存后的职工信息
	public StaffVO createNewStaff(String name,String job,String unit,String workage,String code);
	
	//删除一个职工信息，系统显示删除成功
	public boolean deleteStaff();
	
	//查询职工，输入职工编号，系统显示职工信息
	public StaffVO inquireStaff(String code);
	
	//修改职工信息，系统显示修改后的职工信息
	public StaffVO modifyStaff(String name,String job,String unit,String workage,String code);
	
	//新添车辆信息，输入车牌号（name），车辆代号（code），以及服役时间
	public VehicleVO createNewVehicle(String name,String code,String age);
	
	//删除车辆信息，系统显示删除成功
	public boolean deleteVehicle();
	
	//查询车辆信息，输入车辆代号，系统显示车辆信息
	public VehicleVO inquireVehicle(String code);
	
	//修改车辆信息，系统显示修改后的车辆信息
	public VehicleVO modifyVehicle(String name,String code,String age);
	
	//新建一个司机信息，输入司机编号、姓名、出生日期、身份证号、手机 、性别、行驶证期限，系统显示司机信息
	public DriverVO createNewDriver(String name,String code,String age,String IDcode
			,String phoneNumber,String sex,String limit);
	
	//删除司机信息，系统显示删除成功
	public boolean deleteDriver();
	
	//查询司机信息，输入司机编号，系统显示司机信息
	public DriverVO inquireDriver(String code);
	
	//修改司机信息，系统显示修改后的司机信息
	public DriverVO modifyDriver(String name,String code,String age,String IDcode
			,String phoneNumber,String sex,String limit);
}
