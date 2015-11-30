package main.data.finance;

import java.util.List;

import main.dataservice.FinanceDataService;
import main.po.BankAccountPO;
import main.po.BankList;
import main.po.CollectionPO;
import main.po.CostPO;
import main.presentation.mainui.MainController;
import main.socketservice.Client;


public class FinanceDataController implements FinanceDataService{

	Client client;
	@Override
	public boolean readCost(String Date, List<CostPO> costPOList) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean readCollection(List<CollectionPO> collectionPOList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean readCollection(String lobbyCode,
			List<CollectionPO> collectionPOList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean readCollection(String date1, String date2,
			List<CollectionPO> collectionPOList) {
		// TODO Auto-generated method stub
		return false;
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
