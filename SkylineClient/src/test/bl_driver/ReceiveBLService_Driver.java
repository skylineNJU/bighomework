package test.bl_driver;

import main.po.OrderPO.PackageCost;
import main.po.OrderPO.Size;
import main.po.Type;
import  main.vo.LobbyReceptionVO;
import  main.vo.OrderVO;
import  main.vo.OrderVO;
import  main.vo.TransitReceptionVO;
import  main.businesslogicservice.ReceiveBLService;

public class ReceiveBLService_Driver {
	public void drive(ReceiveBLService receiveBLService){
//		String co, String senderName, String senderAddress, String senderCom, String senderMobile,
//		String receiverName, String receiverAddress, String receiverCom, String receiverMobile, int num, double sum,
//		PackageCost packageCost, Type type, Size size, String cargoName, double weight, double height
		OrderVO order = new OrderVO("131415","zhangsan", "nanjing", "null", "62251787", "lisi", "shanghai", "null", 
				"92816271",20,100,PackageCost.paperBox, Type.fast, Size.large, "clothes",6.6,8.0);
		if(receiveBLService.createNewOrder(order)){
			System.out.println("--------------Creating Order Success!-------------");
		}
		String codes="010101010";
		if(receiveBLService.inquireOrderReceive(codes)!=null){
			System.out.println("--------------Inquiring Order Success!-------------");
		}
		
		
		TransitReceptionVO transitReception =new TransitReceptionVO(2015, 02, 01, "555555", "14151617","8888");
		if(receiveBLService.createNewTransitReception(transitReception) ){
			System.out.println("--------------Creating TransitReception Success!-------------");
		}
		
		if(receiveBLService.inquireTransitReception(codes)!=null){
			System.out.println("--------------Inquiring TransitReception Success!-------------");
		}
		
		LobbyReceptionVO lobbyReception =new LobbyReceptionVO("2001", "01", "02", "good","8888888","025");
		if(receiveBLService.createNewLobbyReception(lobbyReception)){
			System.out.println("---------Creating LobbyReception Success!-------------");
		}
		if(receiveBLService.inquireLobbyReceive(codes)!=null){
			System.out.println("--------------Inquiring LobbyRecepion Success!-------------");
		}
	}
}
