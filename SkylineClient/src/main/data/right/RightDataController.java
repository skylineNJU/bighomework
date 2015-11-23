package main.data.right;

import main.dataservice.RightDataService;
import main.State.RightType;
import main.po.AccountPO;
import main.presentation.mainui.MainController;
import main.socketservice.Client;

public class RightDataController implements RightDataService{

	private Client client;
	public RightDataController(){
		client=MainController.getClient();
	}
	@Override
	public boolean initKeyWord(String account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delAccount(String account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeRight(AccountPO accountPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean readRight(String account, RightType rightType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AccountPO login(AccountPO accountInfo) {
		// TODO Auto-generated method stub
		accountInfo.setKey("Start");
		System.out.println(accountInfo.getID());
		client.wrightReceipt(accountInfo);
		accountInfo=(AccountPO) client.getResponse();
		System.out.println(accountInfo.getRight());
		return accountInfo;
	}

}
