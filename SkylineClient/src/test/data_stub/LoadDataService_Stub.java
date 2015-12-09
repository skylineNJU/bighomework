package test.data_stub;

import main. dataservice.LoadDataService;
import main.po.LoadingInfoPO;
import main.po.LobbyLoadingList;
import main.po.PlaneLoadingListPO;
import  main.po.PlaneLoadingPO;
import main.po.TrainLoadListPO;
import main. po.TrainLoadingPO;
import main.po.VehicleLoadListPO;
import  main.po.VehicleLoadingPO;


public class LoadDataService_Stub implements LoadDataService {

	@Override
	public boolean writeVehicleLoadBase(VehicleLoadingPO po) {
		System.out.println("��������ת�˳ɹ���");
		return true;
	}

	@Override
	public boolean writeTrainLoadBase(TrainLoadingPO po) {
		System.out.println("������ת�˳ɹ���");
		return true;
	}

	@Override
	public boolean writePlaneLoadBase(PlaneLoadingPO po) {
		System.out.println("�����ɻ�ת�˳ɹ���");
		return true;
	}

	@Override
	public boolean saveLobbyLoadingReceipt(LoadingInfoPO po) {
		System.out.println("����ɹ�����");
		return true;
	}

	@Override
	public LobbyLoadingList inquireLobbyLoadList(LobbyLoadingList po) {
		LobbyLoadingList lobbyLoadingList = po;
		return lobbyLoadingList;
	}

	@Override
	public PlaneLoadingListPO inquirePlaneLoadList(PlaneLoadingListPO po) {
		PlaneLoadingListPO planeLoadingListPO = po;
		return planeLoadingListPO;
	}

	@Override
	public TrainLoadListPO inquireTrainLoadList(TrainLoadListPO po) {
		TrainLoadListPO trainLoadListPO = po;
		return trainLoadListPO;
	}

	@Override
	public VehicleLoadListPO inquireVehicleLoadList(VehicleLoadListPO po) {
		VehicleLoadListPO vehicleLoadListPO = po;
		return vehicleLoadListPO;
	}
	
}
