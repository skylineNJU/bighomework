package main.data.finance;


import main.dataservice.FinanceDataService;
import main.po.BankAccountPO;
import main.po.BankList;
import main.po.CollectionPO;
import main.po.CostPO;
import main.po.CostPOList;
import main.po.CollectionPOList;
import main.po.DistancePO;
import main.po.FeePO;
import main.po.SalaryPO;
import main.presentation.mainui.MainController;
import main.socketservice.Client;


public class FinanceDataController implements FinanceDataService{

	Client client;
	@Override
	public CostPOList readCost(String date) {
		client=MainController.getClient();
		CostPOList costPOList = new CostPOList();
		costPOList.getList().add(new CostPO(date, date, date, date, date, date, date));
		costPOList.setKey("Inquire");
		client.writeReceipt(costPOList);
		return (CostPOList) client.getResponse();
	}
	
	@Override
	public boolean writeCost(CostPO costPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delCost(CostPO costPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifiyCost(CostPO costPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CollectionPOList readCollection(String date) {
		client=MainController.getClient();
		CollectionPOList collectionPOList = new CollectionPOList();
		collectionPOList.getList().add(new CollectionPO(date, date, date, date, 0, date,date));
		collectionPOList.setKey("Inquire");
		client.writeReceipt(collectionPOList);
		return (CollectionPOList) client.getResponse();
	}

	@Override
	public boolean writeCollection(CollectionPO collectionPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifiyCollection(CollectionPO collectionPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BankList readBankAccount() {
		client=MainController.getClient();
		BankList bankList = new BankList();
		bankList.setKey("Inquire");
		client.writeReceipt(bankList);
		return (BankList) client.getResponse();
	}

	@Override
	public boolean writeBankAccount(BankAccountPO bankAccountPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DistancePO readDistance() {
		client=MainController.getClient();
		DistancePO distance = new DistancePO();
		distance.setKey("Inquire");
		client.wrightReceipt(distance);
		return (DistancePO) client.getResponse();//Ð´Ò»¸öPO£¬½ÐdistancePOlist
	}

	@Override
	public SalaryPO readSalary() {
		client=MainController.getClient();
		SalaryPO salary = new SalaryPO();
		salary.setKey("Inquire");
		client.wrightReceipt(salary);
		return (SalaryPO) client.getResponse();
	}

	@Override
	public FeePO readFee() {
		client=MainController.getClient();
		FeePO feePO = new FeePO(0, 0, 0);
		feePO.setKey("Inquire");
		client.wrightReceipt(feePO);
		return (FeePO)client.getResponse();
	}
}
