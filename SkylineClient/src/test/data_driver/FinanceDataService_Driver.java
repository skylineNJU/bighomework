package test.data_driver;


import main.dataservice.FinanceDataService;
import main.po.BankAccountPO;
import main.po.CollectionPO;
import main.po.CostPO;

public class FinanceDataService_Driver {
	CostPO readCost=new CostPO("null",1,"null","null",1,"null","null","null");
	CollectionPO collection=new CollectionPO(1,"null","null","null","null",1,"null");
	BankAccountPO bankAccount=new BankAccountPO("null",1);
	public void drive(FinanceDataService service){
		if(service.writeCost(readCost)){
			System.out.println("---------write success--------");
		}
		
		service.delCost(readCost);
		
		if(service.modifiyCost(readCost)){
			System.out.println("--------modifiCost success-------");
		}
		
		if(service.readCollection(null)){
			System.out.println("----------read success--------");
		}
		
		if(service.readCollection(null)){
			System.out.println("----------read success--------");
		}
		
		if(service.readCollection(null, null)){
			System.out.println("----------read success----------");
		}
		
		service.writeCollection(collection);
		
		if(service.modifiyCollection(collection)){
			System.out.println("----------modifiy success---------");
		}
		
		if(service.readBankAccount(null, bankAccount)){
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
