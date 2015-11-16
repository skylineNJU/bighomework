package bl_driver;

import vo.LobbyReceptionVO;
import vo.OrderVO;
import vo.OrderVO.PackageCost;
import vo.OrderVO.Size;
import vo.OrderVO.Type;
import vo.TransitReceptionVO;
import businesslogicservice.ReceiveBLService;

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
