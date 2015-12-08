package test.bl_driver;

import main.po.Rights;
import main.vo.AccountVO;
import  main.businesslogicservice.RightBLService;

public class RightBLService_Driver {
	public void drive(RightBLService rightBLService){
		AccountVO account = new AccountVO(Rights.ACCOUNT,"张三","141516","6666");
		if(rightBLService.login(account)){
			System.out.println("-----------Login Success!-------------");
		}
		
		
		if(rightBLService.createNewAccount(account)){
			System.out.println("----------CreatingNewAccount Success!------------");
		}
		if(rightBLService.inquireAccount("77777", account)){
			System.out.println("----------InquireAccount Success!------------");
		}
		
		if(rightBLService.modifyCode("101000001", "10122211111")){
			System.out.println("----------ModifyingCode Success!------------");
		}
		
		if(rightBLService.initCode("12010201")){
			System.out.println("-----------InitalizingCode Success!------------");
		}
		if(rightBLService.inquireAccount("7777")!=null){
			System.out.println("----------Inquiring Account Success!------------");
		}
		if(rightBLService.deleteAccount("张三")){
			System.out.println("----------Delete Account Success!------------");
		}
		if(rightBLService.modifyAccount(account)){
			System.out.println("----------Modify Account Success!------------");
		}
		if(rightBLService.inquireAccount()!=null){
			System.out.println("----------Inquiring Account Success!------------");
		}
	}
}
