package data_stub;

import java.util.ArrayList;
import java.util.List;

import dataservice.LoadDataService;
import po.PlaneLoadingPO;
import po.TrainLoadingPO;
import po.VehicleLoadingPO;


public class LoadDataService_Stub implements LoadDataService {
	
	    //填写装运表到数据库
		//centerNumber表示出发的中转中心
		@Override
		public boolean writeVehicleLoadBase(List<VehicleLoadingPO> loadList,String centerNumber){
			System.out.println("write Succeed!/n");
			return true;
		}
		
		//从数据库读取装运信息  LoadList是装运信息
		@Override
		public List<VehicleLoadingPO> readVehicleLoadBase(){
			VehicleLoadingPO vehicleLoadingPO = new VehicleLoadingPO("2012/02/23", "01235", "1203", "南京", "北京", "刘钦", "刘小钦", "101", "20");
			List<VehicleLoadingPO> vehicleList = new ArrayList<VehicleLoadingPO>();
			vehicleList.clear();
			vehicleList.add(vehicleLoadingPO);
			System.out.println("Succeed!/n");
			return vehicleList;
		}
		
		//删除数据库里的装运信息  loadList为要删除的装运信息
		@Override
		public boolean delVehicleLoadBase(List<VehicleLoadingPO> loadList){
			System.out.println("delete Succeed!/n");
			return true;
		}
		@Override
		public boolean writeTrainLoadBase(List<TrainLoadingPO> loadList,String centerNumber){
			System.out.println("write Succeed!/n");
			return true;
		}
		
		//从数据库读取装运信息  LoadList是装运信息
		@Override
		public List<TrainLoadingPO> readTrainLoadBase(){
			TrainLoadingPO trainLoadingPO = new TrainLoadingPO("2013/08/16", "015", "302", "北京", "南京", "刘钦", "62", "32", "20");
			List<TrainLoadingPO> trainList = new ArrayList<TrainLoadingPO>();
			System.out.println("Succeed!/n");
			trainList.clear();
			trainList.add(trainLoadingPO);
			return trainList;	
		}
		
		//删除数据库里的装运信息  loadList为要删除的装运信息
		@Override
		public boolean delTrainLoadBase(List<TrainLoadingPO> loadList){
			System.out.println("delete Succeed!/n");
			return true;
		}
		
		@Override
		public boolean writePlaneLoadBase(List<PlaneLoadingPO> loadList,String centerNumber){
			System.out.println("write Succeed!/n");
			return true;	
		}
		
		//从数据库读取装运信息  LoadList是装运信息
		@Override
		public List<PlaneLoadingPO> readPlaneLoadBase(){
			PlaneLoadingPO planeLoadingPO = new PlaneLoadingPO("2013/08/09", "230", "CZ23028", "北京", "南京", "刘钦", "023", "023", "02");
			List<PlaneLoadingPO> planeList = new ArrayList<PlaneLoadingPO>();
			planeList.clear();
			planeList.add(planeLoadingPO);
			System.out.println("Succeed!/n");
			return planeList;
		}
		
		//删除数据库里的装运信息  loadList为要删除的装运信息
		@Override
		public boolean delPlaneLoadBase(List<PlaneLoadingPO> loadList){
			System.out.println("delete Succeed!/n");
			return true;
		}
}
