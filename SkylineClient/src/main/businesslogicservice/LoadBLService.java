package main.businesslogicservice;

import java.util.ArrayList;

import main.vo.LobbyLoading;
import main.vo.PlaneLoadingVO;
import main.vo.TrainLoadingVO;
import main.vo.VehicleLoadingVO;

public interface LoadBLService {

	public boolean loadVehicle(LobbyLoading vehicleLoadingInfo);
	
	public boolean loadCar(VehicleLoadingVO vo);
	
	public boolean loadTrain(TrainLoadingVO vo);
	
	public boolean loadPlane(PlaneLoadingVO vo);
	
	public ArrayList<LobbyLoading> inquireLoadVehicle(String codeList);
	
	public ArrayList<PlaneLoadingVO> inquireLoadPlane(String codeList);
	
	public ArrayList<TrainLoadingVO> inquireLoadTrain(String codeList);
	
	public ArrayList<VehicleLoadingVO> inquireLoadCar(String codeList);
	
}
