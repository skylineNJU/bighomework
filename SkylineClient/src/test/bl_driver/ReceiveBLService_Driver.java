package test.bl_driver;

import  main.vo.LobbyReceptionVO;
import  main.vo.OrderVO;
import  main.vo.OrderVO.PackageCost;
import  main.vo.OrderVO.Size;
import  main.vo.OrderVO.Type;
import  main.vo.TransitReceptionVO;
import  main.businesslogicservice.ReceiveBLService;

public class ReceiveBLService_Driver {
	public void drive(ReceiveBLService receiveBLService){
		OrderVO order = receiveBLService.createNewOrder("zhangsan", "nanjing", "null", "62251787", "lisi", "shanghai", "null", 
				"92816271",20,100, 200, "clothes", PackageCost.paperBox, Type.fast, Size.large, "1010202", "20110101", "201011");
		if(order != null){
			System.out.println("--------------Creating Order Success!-------------");
		}
		
		TransitReceptionVO transitReception =receiveBLService.createNewTransitReception("010101", "20010101", "20101001", "nanjing", 0);
		if(transitReception != null ){
			System.out.println("--------------Creating TransitReception Success!-------------");
		}
		
		LobbyReceptionVO lobbyReception =receiveBLService.createNewLobbyReception("20010101", "2110010101", "nanjing", 0);
		if(lobbyReception != null ){
			System.out.println("---------Creating LobbyReception Success!-------------");
		}
	}
}
