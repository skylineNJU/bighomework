package test.bl_driver;


import java.util.ArrayList;

import main.vo.LobbyLoading;
import main.vo.PlaneLoadingVO;
import main.vo.TrainLoadingVO;
import  main.vo.TransVO;
import  main.vo.VehicleLoadingVO;
import main.State.TransType;
import  main.businesslogicservice.LoadBLService;
/**
 * 
 * @author delll
 *
 */
public class LoadBLService_Driver {
	public void drive(LoadBLService loadBLService){
		LobbyLoading vehicleLoadingInfo=new LobbyLoading("12112718111", "20130501", "19181716", "南京", "上海", "Mary", "Sue", "2", 700);
		if(loadBLService.loadVehicle(vehicleLoadingInfo)){
			System.out.println("---------Loading Vehicle Success!-------------");
		}

		
		VehicleLoadingVO vehicleLoadingvo=new VehicleLoadingVO("12112718111","20150201", "13141516", "E433", "南京", "上海", "Mary", "Sue", "2", 0);	
		if(loadBLService.loadCar(vehicleLoadingvo)){
			System.out.println("---------Loading Car Success!-------------");
		}
	
		PlaneLoadingVO planeLoadingvo=new PlaneLoadingVO("12112718111","20150201", "AA774", "E433", "南京", "上海", "Mary", "Sue", "2", 0);	
		if(loadBLService.loadPlane(planeLoadingvo)){
			System.out.println("---------Loading Plane Success!-------------");
		}
		TrainLoadingVO trainLoadingvo=new TrainLoadingVO("12112718111","20150201", "D3103", "E433", "南京", "上海", "Mary", "Sue", "2", 0);	
		if(loadBLService.loadTrain(trainLoadingvo)){
			System.out.println("---------Loading Train Success!-------------");
		}
	
		String codeList="13141516";
		ArrayList<LobbyLoading> lobbyLoadingArray=new ArrayList<LobbyLoading>();
		lobbyLoadingArray.add(vehicleLoadingInfo);
		if(loadBLService.inquireLoadVehicle(codeList)!=null){
			System.out.println("---------Inquire VehicleLoading Success!-------------");
		}
		
		if(loadBLService.inquireLoadCar(codeList)!=null){
			System.out.println("---------Inquire CarLoading Success!-------------");
		}
		
		if(loadBLService.inquireLoadPlane(codeList)!=null){
			System.out.println("---------Inquire PlaneLoading Success!-------------");
		}
		
		if(loadBLService.inquireLoadTrain(codeList)!=null){
			System.out.println("---------Inquire TrainLoading Success!-------------");
		}
		
	}
}
