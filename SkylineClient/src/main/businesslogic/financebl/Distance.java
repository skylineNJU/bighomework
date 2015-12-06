package main.businesslogic.financebl;

import java.util.ArrayList;

import main.data.finance.FinanceDataController;
import main.dataservice.FinanceDataService;
import main.po.DistancePO;
import main.vo.DistanceVO;

public class Distance {
	
	public DistanceVO getDistance(){
		int counter = 0;
		int cityNumber;
		int cityNumCounter = 0;
		FinanceDataService finance = new FinanceDataController();
		DistancePO distancePO = finance.readDistance();
		ArrayList<String[]> distanceList = distancePO.getCity();
		cityNumber = (int) Math.sqrt(distanceList.size());
		double[][] distance = new double[cityNumber][cityNumber];
		String[] cityName = new String[cityNumber];//假定数据库是正确的
		for(String[] string:distanceList){
			cityName[counter] = string[0];
			distance[counter][cityNumCounter] = Double.valueOf(string[2]);
			cityNumCounter++;
			if(cityNumCounter<cityNumber){}//表格没有换行
			else{
				counter++;
				cityNumCounter = 0;
			}
		}
		return new DistanceVO(cityName, distance);
	}
	
	public boolean writeDistance(DistanceVO distanceVO){
		FinanceDataService finance = new FinanceDataController();
		DistancePO distancePO = new DistancePO();
		ArrayList<String[]> distance = new ArrayList<String[]>(); 
		String[] city = distanceVO.getCity();
		double[][] cityDistance = distanceVO.getDistance();
		for(int i = 0;i<cityDistance.length;i++){
			for(int j = 0;j<cityDistance[i].length;j++){
				distance.add(new String[]{city[i],city[j],String.valueOf(cityDistance[i][j])});
			}
		}
		distancePO.setCity(distance);
		return finance.writeDistance(distancePO);
	}
	
	public boolean delDistance(DistanceVO distanceVO){
		DistancePO distancePO = new DistancePO();
		ArrayList<String[]> city = new ArrayList<String[]>();
		String[] cityName = distanceVO.getCity();
		for(String string:cityName){
			city.add(new String[]{string});
		}
		distancePO.setCity(city);
		FinanceDataService finance = new FinanceDataController();
		return finance.delDistance(distancePO);
	}
}
