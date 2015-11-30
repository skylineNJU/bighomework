package main.data.load;

import java.util.List;

import main.dataservice.LoadDataService;
import main.po.LoadingInfoPO;
import main.po.LobbyLoadingList;
import main.po.PlaneLoadingPO;
import main.po.TrainLoadingPO;
import main.po.VehicleLoadingPO;
import main.presentation.mainui.MainController;
import main.socketservice.Client;
import main.vo.PlaneLoadingVO;

public class LoadDataController implements LoadDataService {
	private Client client;
	
	@Override
	public boolean readVehicleLoadBase(List<VehicleLoadingPO> vehicleLoadingPOList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delVehicleLoadBase(List<VehicleLoadingPO> loadList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean readTrainLoadBase(List<TrainLoadingPO> trainLoadingPOList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delTrainLoadBase(List<TrainLoadingPO> loadList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean readPlaneLoadBase(List<PlaneLoadingPO> planeLoadingPOList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delPlaneLoadBase(List<PlaneLoadingPO> loadList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean writeVehicleLoadBase(VehicleLoadingPO po) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		po.setKey("Save");
		client.wrightReceipt(po);
		return false;
	}

	@Override
	public boolean saveLobbyLoadingReceipt(LoadingInfoPO po) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		po.setKey("Save");
		System.out.println("save receipt");
		client.wrightReceipt(po);
		return false;
	}

	@Override
	public boolean writePlaneLoadBase(PlaneLoadingPO po) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		po.setKey("Save");
		client.wrightReceipt(po);
		return false;
	}

	@Override
	public boolean writeTrainLoadBase(TrainLoadingPO po) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		po.setKey("Save");
		client.wrightReceipt(po);
		return false;
	}

	@Override
	public LobbyLoadingList inquireLobbyLoadList(LobbyLoadingList po) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		po.setKey("Inquire");
		client.wrightReceipt(po);
		po=(LobbyLoadingList) client.getResponse();
		return po;
	}
	

}
