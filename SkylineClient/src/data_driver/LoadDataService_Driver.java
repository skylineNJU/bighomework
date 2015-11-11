package data_driver;

import dataService.LoadDataService;

public class LoadDataService_Driver {
public void drive(LoadDataService loadDataService){
	if(loadDataService.writeVehicleLoadBase(null, "12345678")){
		System.out.println("---------Writing VehicleLoadBase Success!-------------");
			}
	if(loadDataService.readVehicleLoadBase()!=null){
		System.out.println("---------Reading VehicleLoadBase Success!-------------");
	}
	if(loadDataService.delVehicleLoadBase(null)){
		System.out.println("---------Deleting VehicleLoadBase Success!-------------");
	}
	if(loadDataService.writeTrainLoadBase(null, "123456789")){
		System.out.println("---------Writing TrainLoadBase Success!-------------");
	}
	if(loadDataService.readTrainLoadBase()!=null){
		System.out.println("---------Reading TrainLoadBase Success!-------------");
	}
	if(loadDataService.delTrainLoadBase(null)){
		System.out.println("---------Deleting TrainLoadBase Success!-------------");
	}
	if(loadDataService.writePlaneLoadBase(null, "123456789")){
		System.out.println("---------Writing PlaneLoadBase Success!-------------");
	}
	if(loadDataService.readPlaneLoadBase()!=null){
		System.out.println("---------Reading PlaneLoadBase Success!-------------");
	}
	if(loadDataService.delPlaneLoadBase(null)){
		System.out.println("---------Deleting PlaneLoadBase Success!-------------");
	}
}
}
