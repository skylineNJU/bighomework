package data_driver;

import dataService.RightDataService;
import po.AccountPO;

public class RightDataService_Driver {

	public boolean rightDataDrive(RightDataService rightDataService){
		
		String account = "1232456";
		AccountPO accountPO = new AccountPO("1212525", "1515", null);
		
		if(rightDataService.initKeyWord(account)){
			System.out.println("----initKeyWord succeed!----");
		}
		if(rightDataService.delAccount(account)){
			System.out.println("----delAccount succeed!----");
		}
		if(rightDataService.changeRight(accountPO)){
			System.out.println("----changeRight succeed!----");
		}
		if(rightDataService.readRight(account)!=null){
			System.out.println("----readRight succeed!----");
		}
		return true;
	}
}
