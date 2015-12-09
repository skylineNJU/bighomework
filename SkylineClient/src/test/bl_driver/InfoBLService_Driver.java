package test.bl_driver;

import  main.vo.DriverVO;
import main.vo.IntermediateInfoVO;
import main.vo.LobbyInfoVO;
import  main.vo.StaffVO;
import  main.vo.VehicleVO;
import main.vo.WarehouseInfoVO;
import  main.businesslogicservice.InfoBLService;

/**
 * 
 * @author QiHan
 * 
 *
 */
public class InfoBLService_Driver {
	
	IntermediateInfoVO interm;
	StaffVO staff;
	VehicleVO vehicle;
	DriverVO driver;
	LobbyInfoVO lobby;
	WarehouseInfoVO warehouse;
	
	public void drive(InfoBLService infoBLService){
		interm  = new IntermediateInfoVO("shangahi", "3000", 0, 0);
		lobby = new LobbyInfoVO("shanghai", "2000", 0, 0);
		String city ="shanghai";
		warehouse = new WarehouseInfoVO(city, 0, 0, city, 0);
		String vehicleCode ="10102012012";
		staff= new StaffVO("Sun", null,null,null,null);
		vehicle = new VehicleVO("1", "32", null,null,null,null);
		driver = new DriverVO("Sun", "1232333","23", null,null,null,null);
		
		if(infoBLService.addNewIntermediate(interm)){
			System.out.println("---------add Success!-------------");
		}
		
		if(infoBLService.addNewWarehouse(warehouse)){
			System.out.println("---------add Success!-------------");
		}
		
		if(infoBLService.addNewLobby(lobby)){
			System.out.println("---------add Success!-------------");
		}
		
		if(infoBLService.inquireInterm(city) != null){
			System.out.println("---------inquire Success!-------------");
		}
		
		if(infoBLService.inquireLobby(city) != null){
			System.out.println("---------inquire Success!-------------");
		}
		
		if(infoBLService.modifyIntermediate(interm)){
			System.out.println("---------modify Success!-------------");
		}
		
		if(infoBLService.modifyLobby(lobby)){
			System.out.println("---------modify Success!-------------");
		}
		
		if(infoBLService.deleteIntermediate(interm)){
			System.out.println("---------delete Success!-------------");
		}
		
		if(infoBLService.deleteLobby(lobby)){
			System.out.println("---------delete Success!-------------");
		}
		
		if(infoBLService.deleteWarehouse(warehouse)){
			System.out.println("---------delete Success!-------------");
		}
		
		//新建职工档案，输入职工名称，职位，所在单位，职工年龄以及编号，系统显示保存后的职工信息
		if(infoBLService.createNewStaff(staff)){
			System.out.println("---------create Success!-------------");
		}
		
		//删除一个职工信息，系统显示删除成功
		if(infoBLService.deleteStaff("Sun")){
			System.out.println("---------delete Success!-------------");
		}
		
		
		//修改职工信息，系统显示修改后的职工信息
		if(infoBLService.modifyStaff(staff)){
			System.out.println("---------modify Success!-------------");
		}
		
		//新添车辆信息，输入车牌号（name），车辆代号（code），以及服役时间
		if(infoBLService.createNewVehicle(vehicle)){
			System.out.println("---------create Success!-------------");
		}
		
		//删除车辆信息，系统显示删除成功
		if(infoBLService.deleteVehicle(vehicleCode)){
			System.out.println("---------delete Success!-------------");
		}
		
		//修改车辆信息，系统显示修改后的车辆信息
		if(infoBLService.modifyVehicle(vehicle)){
			System.out.println("---------modify Success!-------------");
		}
		
		//新建一个司机信息，输入司机编号、姓名、出生日期、身份证号、手机 、性别、行驶证期限，系统显示司机信息
		if( infoBLService.createNewDriver(driver)){
			System.out.println("---------create Success!-------------");
		}
		
		//删除司机信息，系统显示删除成功
		if(infoBLService.deleteDriver("1")){
			System.out.println("---------delete Success!-------------");
		}
		
		//查询司机信息，输入司机编号，系统显示司机信息
		
		//修改司机信息，系统显示修改后的司机信息
		if(infoBLService.modifyDriver(driver)){
			System.out.println("---------modify Success!-------------");
		}

		if( infoBLService.inquireDriver("2131313") != null){
			System.out.println("---------inquire Success!-------------");
		}

		if( infoBLService.inquireStaff("2313213131") != null){
			System.out.println("---------inquire Success!-------------");
		}

		if(infoBLService.inquireVehicle( "213131") != null){
			System.out.println("---------inquire Success!-------------");
		}
	}
}
