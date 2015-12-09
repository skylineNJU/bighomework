package test.data_driver;


import main.dataservice.FinanceDataService;
import main.po.BankAccountPO;
import main.po.CollectionPO;
import main.po.CostPO;
import main.po.DistancePO;
import main.po.FeePO;
import main.po.SalaryPO;

public class FinanceDataService_Driver {
	CostPO readCost=new CostPO("123456","444","Normal","20150101","666","777","888");
	CollectionPO collection=new CollectionPO("12345","2015","1","666",1,"good","0.6");
	BankAccountPO bankAccount=new BankAccountPO("null",1);
	SalaryPO salaryPO=new SalaryPO();
	DistancePO distancePO=new DistancePO();
	FeePO feePO=new FeePO(122,333,444);
	String date="20150101";
	String unit="111";
	public void drive(FinanceDataService service){
		if(service.delFee(feePO)){
			System.out.println("---------Delete Fee Success!-----------");
		}
		if(service.delCollection(collection)){
			System.out.println("---------Delete Collection Success!-----------");
		}
		if(service.delDistance(distancePO)){
			System.out.println("---------Delete Collection Success!-----------");
		}
		if(service.deleteCost(readCost)){
			System.out.println("---------Delete Cost Success!-----------");
		}
		if(service.modifyBalance(bankAccount)){
			System.out.println("---------Modify Balance Success!-----------");
		}
		if(service.delSalary(salaryPO)){
			System.out.println("---------Modify Balance Success!-----------");			
		}
		if(service.readSalary()!=null){
			System.out.println("---------Read Salary Success!-----------");
		}
		if(service.readFee()!=null){
			System.out.println("---------Read Fee Success!-----------");
		}
		if(service.readLobbyEarn(date, unit)!=null){
			System.out.println("---------Read LobbyEarn Success!-----------");
		}
		if(service.readCost(date)!=null){
			System.out.println("---------Read Cost Success!-----------");
		}
		if(service.writeCost(readCost)){
			System.out.println("---------Write Cost Success!-----------");
		}
		if(service.modifiyCost(readCost)){
			System.out.println("---------Modify Cost Success!-----------");
		}
		if(service.readCollection(date)!=null){
			System.out.println("---------Read Collection Success!-----------");
		}
		if(service.writeCollection(collection)){
			System.out.println("---------Write Collection Success!-----------");
		}
		if(service.modifiyCollection(collection)){
			System.out.println("---------Modify Collection Success!-----------");
		}
		if(service.readBankAccount()!=null){
			System.out.println("---------Read BankAccount Success!-----------");
		}
		if(service.writeBankAccount(bankAccount)){
			System.out.println("---------Write BankAccount Success!-----------");
		}
		if(service.writeSalary(salaryPO)){
			System.out.println("---------Write Salary Success!-----------");
		}
		if(service.readDistance()!=null){
			System.out.println("---------Read Distance Success!-----------");
		}
		if(service.writeFee(feePO)){
			System.out.println("---------Write Fee Success!-----------");
		}
		if(service.writeDistance(distancePO)){
			System.out.println("---------Write Distance Success!-----------");
		}
	}
}
