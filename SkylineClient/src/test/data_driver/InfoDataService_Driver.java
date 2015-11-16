package data_driver;


import dataService.InfoDataService;
import po.DriverInfoPO;
import po.InstitutionPO;
import po.VehicleInfoPO;
import po.WorkerPO;

public class InfoDataService_Driver {
	InstitutionPO institution=new InstitutionPO("","","","");
	WorkerPO worker=new WorkerPO("","","",1);
	VehicleInfoPO vehicleInfo=new VehicleInfoPO(1,1,1,1,"",1);
	DriverInfoPO driveInfo=new DriverInfoPO(1,"","","","","","","");
	public void drive(InfoDataService service){
		if(service.readInstitution(null)!=null){
			System.out.println("----------read success-------");
		}
		
		if(service.addInstitution(institution)){
			System.out.println("--------add success--------");
		}
		
		if(service.delInstitution(null)){
			System.out.println("---------delete success--------");
		}
		
		if(service.modifyInstitution(institution)!=null){
			System.out.println("-------modify success--------");
		}
		
		if(service.createNewStaff(worker)){
			System.out.println("---------create success---------");
		}
		
		if(service.deleteStaff(null)){
			System.out.println("--------delete success--------");
		}
		
		if(service.inquireDriver(null)!=null){
			System.out.println("--------inquire success---------");
		}
		
		if(service.modifyStaff(worker)!=null){
			System.out.println("---------modify success--------");
		}
		
		if(service.createNewVehicle(vehicleInfo)){
			System.out.println("-------create success---------");
		}
		
		if(service.deleteVehicle(null)){
			System.out.println("--------delete success-------");
		}
		
		if(service.readVehicle(null)!=null){
			System.out.println("----------read success-------");
		}
		
		if(service.modifyVehicle(vehicleInfo)!=null){
			System.out.println("---------modify vehicle--------");
		}
		
		if(service.createNewDriver(driveInfo)){
			System.out.println("--------create success--------");
		}
		
		if(service.inquireDriver(null)!=null){
			System.out.println("----------inquire success------");
		}
		
		service.deleteDriver();
		
		if(service.modifyDriver(driveInfo)!=null){
			System.out.println("---------- modify success----------");
		}
	}
}