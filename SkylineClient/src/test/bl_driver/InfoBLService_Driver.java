package bl_driver;

import vo.DriverVO;
import vo.InstitutionVO;
import vo.StaffVO;
import vo.VehicleVO;
import businesslogicservice.InfoBLService;

public class InfoBLService_Driver {
	
	InstitutionVO institution;
	StaffVO staff;
	VehicleVO vehicle;
	DriverVO driver;
	
	public void drive(InfoBLService infoBLService){
		institution=infoBLService.createNewInstitution("1", "A","111", "1010202111");
		if(institution != null){
			System.out.println("---------Creating NewInstitution Success!-------------");
		}
		
		if(infoBLService.deleteInstitution()){
			System.out.println("---------Delete Success!-------------");
		}
		
		institution=infoBLService.inquireInstitution("1012290101011");
		if(institution != null){
			System.out.println("---------Institution Showing!-------------");
		}
		
		institution=infoBLService.modifyInstitution("1", "A","111", "1010202111");
		if(institution != null){
			System.out.println("---------Modify Success!-------------");
		}
		
		staff =infoBLService.createNewStaff("sanan ", "account", "1", "12", "1010111111") ;
		if(staff  != null){
			System.out.println("---------Creating NewStaff Success!-------------");
		}
		
		if(infoBLService.deleteStaff()){
			System.out.println("---------Delete Success!-------------");
		}
		
		staff =infoBLService.inquireStaff("10110101011");
		if(staff  != null){
			System.out.println("---------Staff Showing!-------------");
		}
		
		staff =infoBLService.modifyStaff("aa", "account", "1", "12", "10100220201");
		if(staff  != null){
			System.out.println("---------Modify Success!-------------");
		}
		
		vehicle=infoBLService.createNewVehicle("A10111", "10102921", "32");
		if(vehicle != null){
			System.out.println("---------Creating NewVehicle Success!-------------");
		}
		
		if(infoBLService.deleteVehicle()){
			System.out.println("---------Delete Success!-------------");
		}
		
		vehicle=infoBLService. inquireVehicle("101002020111");
		if(vehicle != null){
			System.out.println("---------Vehicle Showing!-------------");
		}
		
		vehicle=infoBLService.modifyVehicle("A10001", "1919210011","44");
		if(vehicle != null){
			System.out.println("---------Modify Success!-------------");
		}
		
		
		
		driver=infoBLService.createNewDriver("zhangsan", "10110101001", "32", "33","12121221111", "ÄÐ", "set");
		if(driver != null){
			System.out.println("---------Creating NewDriver Success!-------------");
		}
		
		if(infoBLService.deleteDriver()){
			System.out.println("---------Delete Success!-------------");
		}
			
		driver=infoBLService.inquireDriver("1001020102102");
		if(driver != null){
			System.out.println("---------Driver Showing!-------------");
		}
		
		driver=infoBLService.modifyDriver("zhangsan", "10110101001", "32", "33","12121221111", "ÄÐ", "set");
		if(driver != null){
			System.out.println("---------Modify Success!-------------");
		}
	}
}
