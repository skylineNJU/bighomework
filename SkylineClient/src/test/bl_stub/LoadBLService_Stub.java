package test.bl_stub;

import java.util.ArrayList;

import main.businesslogicservice.LoadBLService;
import main.vo.LobbyLoading;
import main.vo.PlaneLoadingVO;
import main.vo.TrainLoadingVO;
import main.vo.TransVO;
import main.vo.VehicleLoadingVO;


public class LoadBLService_Stub implements LoadBLService{

	LobbyLoading lobbyLoading = new LobbyLoading("65125", "2013/06/18", "053151615", "A", "����", "���˷�", "����", "����֪�����������ʲô", 0);
	PlaneLoadingVO planeLoadingVO = new PlaneLoadingVO("2605", "2013/06/18", "51", "51", "A", "�Ϻ�", "���˷�", "015", "5142", 0);
	TrainLoadingVO trainLoadingVO = new TrainLoadingVO("2005", "2013/07/18", "38", "11", "B", "�Ϻ�", "���˷�", "445", "5142", 5.26);
	VehicleLoadingVO vehicleLoadingVO  = new VehicleLoadingVO("2605", "2013/06/18", "51", "51", "A", "�Ϻ�", "���˷�", "015", "5142", 0);
	@Override
	public boolean loadVehicle(LobbyLoading vehicleLoadingInfo) {
		System.out.println("װ������ɹ���");
		return true;
	}
	@Override
	public boolean loadCar(VehicleLoadingVO vo) {
		System.out.println("����װ������ɹ���");
		return true;
	}
	@Override
	public boolean loadTrain(TrainLoadingVO vo) {
		System.out.println("��װ������ɹ���");
		return true;
	}
	@Override
	public boolean loadPlane(PlaneLoadingVO vo) {
		System.out.println("�ɻ�װ�˹���ɹ���");
		return true;
	}
	@Override
	public ArrayList<LobbyLoading> inquireLoadVehicle(String codeList) {
		ArrayList<LobbyLoading> lobbyLoad = new ArrayList<LobbyLoading>();
		lobbyLoad.add(lobbyLoading);
		return lobbyLoad;
	}
	@Override
	public ArrayList<PlaneLoadingVO> inquireLoadPlane(String codeList) {
		ArrayList<PlaneLoadingVO> planeLoad = new ArrayList<PlaneLoadingVO>();
		planeLoad.add(planeLoadingVO);
		return planeLoad;
	}
	@Override
	public ArrayList<TrainLoadingVO> inquireLoadTrain(String codeList) {
		ArrayList<TrainLoadingVO> trainLoad = new ArrayList<TrainLoadingVO>();
		trainLoad.add(trainLoadingVO);
		return trainLoad;
	}
	@Override
	public ArrayList<VehicleLoadingVO> inquireLoadCar(String codeList) {
		ArrayList<VehicleLoadingVO> voList = new ArrayList<VehicleLoadingVO>();
		voList.add(vehicleLoadingVO);
		return voList;
	}
	
}
