package main.businesslogic.loadbl;

import java.util.ArrayList;

import main.businesslogicservice.LoadBLService;
import main.vo.LobbyLoading;
import main.vo.PlaneLoadingVO;
import main.vo.TrainLoadingVO;
import main.vo.VehicleLoadingVO;

public class LoadController implements LoadBLService {

	@Override
	public boolean loadVehicle(LobbyLoading vehicleLoadingInfo) {
		// TODO Auto-generated method stub
		System.out.println("get a lobbyLoading mission");
		Load load=new Load();
		return load.loadVehicle(vehicleLoadingInfo);
	}

	@Override
	public boolean loadCar(VehicleLoadingVO vo) {
		// TODO Auto-generated method stub
		VehicleLoading loading=new VehicleLoading(vo);
		loading.saveInfo();
		return false;
	}

	@Override
	public boolean loadTrain(TrainLoadingVO vo) {
		// TODO Auto-generated method stub
		TrainLoading loading=new TrainLoading(vo);
		loading.saveInfo();
		return false;
	}

	@Override
	public boolean loadPlane(PlaneLoadingVO vo) {
		// TODO Auto-generated method stub
		PlaneLoading loading=new PlaneLoading(vo);
		loading.saveInfo();
		return false;
	}

	@Override
	public ArrayList<LobbyLoading> inquireLoadVehicle(String codeList) {
		// TODO Auto-generated method stub
		LobbyLoadListBL bl=new LobbyLoadListBL(codeList);
		return bl.inquire();
	}

	@Override
	public ArrayList<PlaneLoadingVO> inquireLoadPlane(String codeList) {
		// TODO Auto-generated method stub
		PlaneLoadListBL bl=new PlaneLoadListBL(codeList);
		
		return bl.inquire();
	}

	@Override
	public ArrayList<TrainLoadingVO> inquireLoadTrain(String codeList) {
		// TODO Auto-generated method stub
		TrainLoadListBL bl=new TrainLoadListBL(codeList);
		
		return bl.inquire();
	}

	@Override
	public ArrayList<VehicleLoadingVO> inquireLoadCar(String codeList) {
		// TODO Auto-generated method stub
		VehicleLoadListBL bl=new VehicleLoadListBL(codeList);
		return bl.inquire();
	}

	

	

}
