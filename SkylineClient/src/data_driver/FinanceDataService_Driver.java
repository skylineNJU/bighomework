package data_driver;


import dataService.FinanceDataService;
import po.BankAccountPO;
import po.CollectionPO;
import po.CostPO;

public class FinanceDataService_Driver {
	CostPO readCost=new CostPO("null",1,"null","null",1,"null","null","null");
	CollectionPO collection=new CollectionPO(1,"null","null","null","null",1,"null");
	BankAccountPO bankAccount=new BankAccountPO("null",1);
	public void drive(FinanceDataService service){
		if(service.writeCost(readCost)){
			System.out.println("---------write success--------");
		}
		
		service.delCost(readCost);
		
		if(service.modifiyCost(readCost)!=null){
			System.out.println("--------modifiCost success-------");
		}
		
		if(service.readCollection()!=null){
			System.out.println("----------read success--------");
		}
		
		if(service.readCollection(null)!=null){
			System.out.println("----------read success--------");
		}
		
		if(service.readCollection(null, null)!=null){
			System.out.println("----------read success----------");
		}
		
		service.writeCollection(collection);
		
		if(service.modifiyCollection(collection)!=null){
			System.out.println("----------modifiy success---------");
		}
		
		if(service.readBankAccount(null)!=null){
			System.out.println("---------read success---------");
		}
		
		if(service.writeBankAccount(bankAccount)){
			System.out.println("---------write success--------");
		}
		
		if(service.delBankAccount(bankAccount)){
			System.out.println("-----------delete success---------");
		}
	}
}
