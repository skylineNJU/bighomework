package main.data.load;

import java.util.List;

import main.dataservice.LoadDataService;
import main.po.LoadingInfoPO;
import main.po.PlaneLoadingPO;
import main.po.TrainLoadingPO;
import main.po.VehicleLoadingPO;
import main.presentation.mainui.MainController;
import main.socketservice.Client;

public class LoadDataController implements LoadDataService {
	private Client client=MainController.getClient();
	
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
	public boolean writeTrainLoadBase(List<TrainLoadingPO> loadList, String centerNumber) {
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
	public boolean writePlaneLoadBase(List<PlaneLoadingPO> loadList, String centerNumber) {
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
		return false;
	}

	@Override
	public boolean saveLobbyLoadingReceipt(LoadingInfoPO po) {
		// TODO Auto-generated method stub
		po.setKey("Save");
		System.out.println("save receipt");
		client.wrightReceipt(po);
		return false;
	}
	

}
