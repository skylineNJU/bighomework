package main.data.guest;

import main.dataservice.guestservice.GuestDataService;
import main.po.LocusPO;
import main.presentation.mainui.MainController;
import main.socketservice.Client;

public class GuestDataImpl implements GuestDataService {

	Client client;
	public GuestDataImpl(){
		client=MainController.getClient();
	}
	@Override
	public LocusPO inquireLocus(LocusPO po) {
		// TODO Auto-generated method stub
		po.setKey("Inquire");
		client.writeReceipt(po);
		return (LocusPO) client.getResponse();
	}

}
