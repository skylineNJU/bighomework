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
		
		//�½�ְ������������ְ�����ƣ�ְλ�����ڵ�λ��ְ�������Լ���ţ�ϵͳ��ʾ������ְ����Ϣ
		if(infoBLService.createNewStaff(staff)){
			System.out.println("---------create Success!-------------");
		}
		
		//ɾ��һ��ְ����Ϣ��ϵͳ��ʾɾ���ɹ�
		if(infoBLService.deleteStaff("Sun")){
			System.out.println("---------delete Success!-------------");
		}
		
		
		//�޸�ְ����Ϣ��ϵͳ��ʾ�޸ĺ��ְ����Ϣ
		if(infoBLService.modifyStaff(staff)){
			System.out.println("---------modify Success!-------------");
		}
		
		//��������Ϣ�����복�ƺţ�name�����������ţ�code�����Լ�����ʱ��
		if(infoBLService.createNewVehicle(vehicle)){
			System.out.println("---------create Success!-------------");
		}
		
		//ɾ��������Ϣ��ϵͳ��ʾɾ���ɹ�
		if(infoBLService.deleteVehicle(vehicleCode)){
			System.out.println("---------delete Success!-------------");
		}
		
		//�޸ĳ�����Ϣ��ϵͳ��ʾ�޸ĺ�ĳ�����Ϣ
		if(infoBLService.modifyVehicle(vehicle)){
			System.out.println("---------modify Success!-------------");
		}
		
		//�½�һ��˾����Ϣ������˾����š��������������ڡ����֤�š��ֻ� ���Ա���ʻ֤���ޣ�ϵͳ��ʾ˾����Ϣ
		if( infoBLService.createNewDriver(driver)){
			System.out.println("---------create Success!-------------");
		}
		
		//ɾ��˾����Ϣ��ϵͳ��ʾɾ���ɹ�
		if(infoBLService.deleteDriver("1")){
			System.out.println("---------delete Success!-------------");
		}
		
		//��ѯ˾����Ϣ������˾����ţ�ϵͳ��ʾ˾����Ϣ
		
		//�޸�˾����Ϣ��ϵͳ��ʾ�޸ĺ��˾����Ϣ
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
