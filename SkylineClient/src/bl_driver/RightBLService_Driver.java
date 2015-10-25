package bl_driver;

import vo.AccountVO;
import vo.RightVO;
import businesslogicservice.RightBLService;

public class RightBLService_Driver {
	public void drive(RightBLService rightBLService){
		RightVO right = rightBLService.login("951181827", "1212122");
		if(right != null){
			System.out.println("-----------Login Success!-------------");
		}
		
		AccountVO account =rightBLService.createNewAccount("101020", "199102", RightVO.Lobby); 
		if(account != null){
			System.out.println("----------CreatingNewAccount Success!------------");
		}
		
		if(rightBLService.modifyCode("101000001", "10122211111")){
			System.out.println("----------ModifyingCode Success!------------");
		}
		
		if(rightBLService.initCode("12010201")){
			System.out.println("-----------InitalizingCode Success!------------");
		}
	}
}
