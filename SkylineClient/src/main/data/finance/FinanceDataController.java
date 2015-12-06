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
import main.po.LobbyEarnPO;
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
		client=MainController.getClient();
		costPO.setKey("Save");
		client.writeReceipt(costPO);
		return true;
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
		client=MainController.getClient();
		collectionPO.setKey("Save");
		client.writeReceipt(collectionPO);
		return true;
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
		client=MainController.getClient();
		bankAccountPO.setKey("Save");
		client.writeReceipt(bankAccountPO);
		return true;
	}

	@Override
	public DistancePO readDistance() {
		client=MainController.getClient();
		DistancePO distance = new DistancePO();
		distance.setKey("Inquire");
		client.writeReceipt(distance);
		return (DistancePO) client.getResponse();//Ð´Ò»¸öPO£¬½ÐdistancePOlist
	}

	@Override
	public SalaryPO readSalary() {
		client=MainController.getClient();
		SalaryPO salary = new SalaryPO();
		salary.setKey("Inquire");
		client.writeReceipt(salary);
		return (SalaryPO) client.getResponse();
	}

	@Override
	public FeePO readFee() {
		client=MainController.getClient();
		FeePO feePO = new FeePO(0, 0, 0);
		feePO.setKey("Inquire");
		client.writeReceipt(feePO);
		return (FeePO)client.getResponse();
	}

	@Override
	public LobbyEarnPO readLobbyEarn(String date,String unit) {
		client=MainController.getClient();
		LobbyEarnPO lobbyEarnPO = new LobbyEarnPO();
		lobbyEarnPO.getList().add(new CollectionPO(date, date, unit, unit, 0, unit, unit));
		lobbyEarnPO.setKey("Inquire");
		client.writeReceipt(lobbyEarnPO);
		return (LobbyEarnPO)client.getResponse();
	}

	@Override
	public boolean writeSalary(SalaryPO salaryPO) {
		client=MainController.getClient();
		salaryPO.setKey("Save");
		client.writeReceipt(salaryPO);
		return true;
	}

	@Override
	public boolean writeFee(FeePO feePO) {
		client=MainController.getClient();
		feePO.setKey("Save");
		client.writeReceipt(feePO);
		return true;
	}

	@Override
	public boolean writeDistance(DistancePO distancePO) {
		client=MainController.getClient();
		distancePO.setKey("Save");
		client.writeReceipt(distancePO);
		return true;
	}

	@Override
	public boolean modifyBalance(BankAccountPO bankPO) {
		client=MainController.getClient();
		bankPO.setKey("Delete");
		client.writeReceipt(bankPO);
		writeBankAccount(bankPO);
		return true;
	}

	@Override
	public boolean deleteCost(CostPO costPO) {
		client=MainController.getClient();
		costPO.setKey("Delete");
		client.writeReceipt(costPO);
		return true;
	}

	@Override
	public boolean delDistance(DistancePO distancePO) {
		client=MainController.getClient();
		distancePO.setKey("Delete");
		client.writeReceipt(distancePO);
		return true;
	}

	@Override
	public boolean delCollection(CollectionPO collectionPO) {
		client=MainController.getClient();
		collectionPO.setKey("Delete");
		client.writeReceipt(collectionPO);
		return true;
	}

	@Override
	public boolean delFee(FeePO feePO) {
		client=MainController.getClient();
		feePO.setKey("Delete");
		client.writeReceipt(feePO);
		return true;
	}

	@Override
	public boolean delSalary(SalaryPO salaryPO) {
		client=MainController.getClient();
		salaryPO.setKey("Delete");
		client.writeReceipt(salaryPO);
		return true;
	}
}
