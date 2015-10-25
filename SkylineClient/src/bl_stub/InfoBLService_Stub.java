package bl_stub;

import businesslogicservice.InfoBLService;
import vo.DriverVO;
import vo.InstitutionVO;
import vo.StaffVO;
import vo.VehicleVO;

public class InfoBLService_Stub implements InfoBLService{
	InstitutionVO institution;
	StaffVO staff;
	VehicleVO vehicle;
	DriverVO driver;
	@Override
	public InstitutionVO createNewInstitution(String Category, String name, String position, String code) {
		// TODO Auto-generated method stub
		institution=new InstitutionVO(Category,name,position,code);
		return institution;
	}

	@Override
	public boolean deleteInstitution() {
		// TODO Auto-generated method stub
		System.out.println("这个B我给十分");
		return true;
	}

	@Override
	public InstitutionVO inquireInstitution(String code) {
		// TODO Auto-generated method stub
		institution=new InstitutionVO("这个B我给十分","这个B我给十分","这个B我给十分","这个B我给十分");
		return institution;
	}

	@Override
	public InstitutionVO modifyInstitution(String Category, String name, String position, String code) {
		// TODO Auto-generated method stub
		institution=new InstitutionVO("这个B我给十分","这个B我给十分","这个B我给十分","这个B我给十分");
		return institution;
	}

	@Override
	public StaffVO createNewStaff(String name, String job, String unit, String workage, String code) {
		// TODO Auto-generated method stub
		staff=new StaffVO(name,job,unit,workage,code);
		return staff;
	}

	@Override
	public boolean deleteStaff() {
		// TODO Auto-generated method stub
		System.out.println("吾有一友屌似卿");
		return false;
	}

	@Override
	public StaffVO inquireStaff(String code) {
		// TODO Auto-generated method stub
		staff=new StaffVO("name","job","unit","workage","code");
		return staff;
	}

	@Override
	public StaffVO modifyStaff(String name, String job, String unit, String workage, String code) {
		// TODO Auto-generated method stub
		staff=new StaffVO("name","job","unit","workage","code");
		return staff;
	}

	@Override
	public VehicleVO createNewVehicle(String name, String code, String age) {
		// TODO Auto-generated method stub
		vehicle=new VehicleVO(name,code,age);
		return vehicle;
	}

	@Override
	public boolean deleteVehicle() {
		// TODO Auto-generated method stub
		System.out.println("我有以友屌似卿");
		return true;
	}

	@Override
	public VehicleVO inquireVehicle(String code) {
		// TODO Auto-generated method stub
		vehicle=new VehicleVO("name",code,"age");
		return vehicle;
	}

	@Override
	public VehicleVO modifyVehicle(String name, String code, String age) {
		// TODO Auto-generated method stub
		vehicle=new VehicleVO("name",code,"age");
		return vehicle;
	}

	@Override
	public DriverVO createNewDriver(String name, String code, String age, String IDcode, String phoneNumber, String sex,
			String limit) {
		// TODO Auto-generated method stub
		driver=new DriverVO(name,code,age,IDcode,phoneNumber,sex,limit);
		return driver;
	}

	@Override
	public boolean deleteDriver() {
		// TODO Auto-generated method stub
		System.out.println("吾有一友屌似卿");
		return true;
	}

	@Override
	public DriverVO inquireDriver(String code) {
		// TODO Auto-generated method stub
		driver=new DriverVO("name",code,"age","IDcode","phoneNumber","sex","limit");
		return driver;
	}

	@Override
	public DriverVO modifyDriver(String name, String code, String age, String IDcode, String phoneNumber, String sex,
			String limit) {
		// TODO Auto-generated method stub
		driver=new DriverVO(name,code,age,IDcode,phoneNumber,sex,limit);
		return driver;
	}
	
}
