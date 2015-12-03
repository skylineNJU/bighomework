package main.data.finance;


import main.dataservice.FinanceDataService;
import main.po.BankAccountPO;
import main.po.BankList;
import main.po.CollectionPO;
import main.po.CostPO;
import main.po.CostPOList;
import main.po.CollectionPOList;
import main.presentation.mainui.MainController;
import main.socketservice.Client;


public class FinanceDataController implements FinanceDataService{

	Client client;
	@Override
	public CostPOList readCost(String date) {
		client=MainController.getClient();
		CostPOList costPOList = new CostPOList();
		costPOList.getList().add(new CostPO(date, date, date, date, date, date));
		costPOList.setKey("Inquire");
		client.wrightReceipt(costPOList);
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
		collectionPOList.getList().add(new CollectionPO(date, date, date, date, 0, date));
		collectionPOList.setKey("Inquire");
		client.wrightReceipt(collectionPOList);
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
		client.wrightReceipt(bankList);
		return (BankList) client.getResponse();
	}

	@Override
	public boolean writeBankAccount(BankAccountPO bankAccountPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delBankAccount(BankAccountPO bankAccountPO) {
		// TODO Auto-generated method stub
		return false;
	}

}
