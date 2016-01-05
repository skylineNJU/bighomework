package main.businesslogic.infobl;

import main.data.info.InfoDataController;
import main.dataservice.InfoDataService;
import main.po.CityPO;
import main.vo.CityVO;

public class CityInfoBL {
private CityPO cityInfo;

public CityInfoBL(CityVO vo){
	cityInfo=new CityPO();
		
	
}
public CityVO iniquire(){
  System.out.println("Start inquire city");
  InfoDataService service=new InfoDataController();
  CityPO poList=service.inquireCity(cityInfo);
 CityVO voList=new CityVO(poList.getCityName(),poList.getInsititutionNum());
 
return voList;
  
}

}
