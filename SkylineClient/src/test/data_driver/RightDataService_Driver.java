package test.data_driver;

import main.dataservice.RightDataService;
import main.po.AccountListPO;
import main.po.AccountPO;
import main.po.Rights;
/**
 * 
 * @author QiHan
 * 
 *
 */
public class RightDataService_Driver {

	public boolean rightDataDrive(RightDataService rightDataService){
		
		String account = "1232456";
		AccountPO accountPO = new AccountPO(account, "12345678",Rights.STOREHOUSE, null);
		AccountListPO accountlist = new AccountListPO();
		accountlist.add(accountPO);
		
		
		
		
		if(rightDataService.initKeyWord(account)){
			System.out.println("----initKeyWord succeed!----");
		}
		if(rightDataService.delAccount(account)){
			System.out.println("----delAccount succeed!----");
		}
		if(rightDataService.changeRight(accountPO)){
			System.out.println("----changeRight succeed!----");
		}
		if(rightDataService.inquireAccountList(accountlist) != null){
			System.out.println("----inqure succeed!----");
		}
		if(rightDataService.login(accountPO ) != null){
			System.out.println("----login in succeed!----");
		}
		if(rightDataService.writeAccount(accountPO) ){
			System.out.println("----write account succeed!----");
		}
		if(rightDataService.modifyAcount(accountPO)){
			System.out.println("----modify account succeed!----");
		}
		if(rightDataService.delAccount(accountPO)){
			System.out.println("----delete account succeed!----");
		}

		return true;
	}
}
