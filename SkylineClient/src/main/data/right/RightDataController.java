package main.data.right;

import main.dataservice.RightDataService;
import main.State.RightType;
import main.po.AccountListPO;
import main.po.AccountPO;
import main.po.PlaneLoadingPO;
import main.po.VehicleLoadListPO;
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
	public boolean writeAccount(AccountPO po) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		po.setKey("Save");
		client.writeReceipt(po);
		return false;
	}
	@Override
	public boolean delAccount(String account) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override 
public boolean delAccount(AccountPO po ){
		po.setKey("Delete");
		System.out.println("-------------begin delete");
		client=MainController.getClient();
		client.writeReceipt(po);
		return false;
	}
	@Override
	public boolean changeRight(AccountPO accountPO) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		accountPO.setKey("Modify");
		client.writeReceipt(accountPO);
		return false;
		
	}

	@Override
	public AccountListPO inquireAccountList(AccountListPO po) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		po.setKey("Inquire");
		client.writeReceipt(po);
		po=(AccountListPO) client.getResponse();
		return po;
		
	}

	@Override
	public AccountPO login(AccountPO accountInfo) {
		// TODO Auto-generated method stub
		accountInfo.setKey("Start");
		System.out.println(accountInfo.getID());
		client.writeReceipt(accountInfo);
		accountInfo=(AccountPO) client.getResponse();
		System.out.println(accountInfo.getRight());
		return accountInfo;
	}
	@Override
	public boolean modifyAcount(AccountPO accountPO) {
		// TODO Auto-generated method stub
		System.out.println("modify begain");
		client=MainController.getClient();
		accountPO.setKey("Modify");
		client.writeReceipt(accountPO);
		return false;
	
	}


}
