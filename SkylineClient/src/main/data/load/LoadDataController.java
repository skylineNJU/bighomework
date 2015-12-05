package main.data.load;

import main.dataservice.LoadDataService;
import main.po.LoadingInfoPO;
import main.po.LobbyLoadingList;
import main.po.PlaneLoadingListPO;
import main.po.PlaneLoadingPO;
import main.po.TrainLoadListPO;
import main.po.TrainLoadingPO;
import main.po.VehicleLoadListPO;
import main.po.VehicleLoadingPO;
import main.presentation.mainui.MainController;
import main.socketservice.Client;

public class LoadDataController implements LoadDataService {
	private Client client;
	
	@Override
	public boolean writeVehicleLoadBase(VehicleLoadingPO po) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		po.setKey("Save");
		client.writeReceipt(po);
		return false;
	}

	@Override
	public boolean saveLobbyLoadingReceipt(LoadingInfoPO po) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		po.setKey("Save");
		System.out.println("save receipt");
		client.writeReceipt(po);
		return false;
	}

	@Override
	public boolean writePlaneLoadBase(PlaneLoadingPO po) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		po.setKey("Save");
		client.writeReceipt(po);
		return false;
	}

	@Override
	public boolean writeTrainLoadBase(TrainLoadingPO po) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		po.setKey("Save");
		client.writeReceipt(po);
		return false;
	}

	@Override
	public LobbyLoadingList inquireLobbyLoadList(LobbyLoadingList po) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		po.setKey("Inquire");
		client.writeReceipt(po);
		po=(LobbyLoadingList) client.getResponse();
		return po;
	}

	@Override
	public PlaneLoadingListPO inquirePlaneLoadList(PlaneLoadingListPO po) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		po.setKey("Inquire");
		client.writeReceipt(po);
		po=(PlaneLoadingListPO) client.getResponse();
		return po;
	}

	@Override
	public TrainLoadListPO inquireTrainLoadList(TrainLoadListPO po) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		po.setKey("Inquire");
		client.writeReceipt(po);
		po=(TrainLoadListPO) client.getResponse();
		return po;
	}

	@Override
	public VehicleLoadListPO inquireVehicleLoadList(VehicleLoadListPO po) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		po.setKey("Inquire");
		client.writeReceipt(po);
		po=(VehicleLoadListPO) client.getResponse();
		return po;
	}
}
