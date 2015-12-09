package test.data_driver;

import main.dataservice.ReceiveDataService;
import main.po.CenterReceiveListPO;
import main.po.CenterReceivePO;
import main.po.DistributePO;
import main.po.LobbyReceiveListPO;
import main.po.LobbyReceivePO;
import main.po.OrderListPO;
import main.po.OrderPO;
import main.po.OrderPO.Size;
import main.po.OrderPO.PackageCost;
/**
 * 
 * @author QiHan
 * 
 *
 */
public class ReceiveDataService_Driver {
	
	public boolean receiveDataDrive(ReceiveDataService receiveDataService){
		OrderPO orderPO = new OrderPO("201515","asdas","sads","sadsad","sadsd","sdasd", "sadsad" , "sadsd",PackageCost.paperBox, null ,20,20.1,20.2,"dsadasd",Size.small,"sadsad",20);
		String orderBar = "2051560";
		CenterReceivePO centerReceivePO = new CenterReceivePO(2015, 10, 30, "0100", orderBar);
		LobbyReceivePO lobbyReceivePO = new LobbyReceivePO("2014","3","28",null,orderBar);
		DistributePO distributePO = new DistributePO("121323", "23131","Sun", "shanghai","18263738990","Winter");
		OrderListPO orderlist= new OrderListPO(orderBar);
		CenterReceiveListPO centerlist = new  CenterReceiveListPO(orderBar);	
		LobbyReceiveListPO lobbylist = new  LobbyReceiveListPO(orderBar);	
		
		if(receiveDataService.writeOrder(orderPO)){
			System.out.println("----writeOrder succeed!----");
		}
		if(receiveDataService.readOrder(orderlist)!=null){
			System.out.println("----readOrder succeed!----");
		}
		if(receiveDataService.delOrder(orderBar)){
			System.out.println("----delOrder succeed!----");
		}
		if(receiveDataService.modifiyOrder(orderPO)){
			System.out.println("----modifiyOrder succeed!----");
		}
		if(receiveDataService.writeCenterOrder(centerReceivePO)){
			System.out.println("----writeCenterOrder succeed!----");
		}
		if(receiveDataService.readCenterOrder(centerlist)!=null){
			System.out.println("----readCenterOrder succeed!----");
		}
		if(receiveDataService.delCenterOrder(orderBar)){
			System.out.println("----delCenterOrder succeed!----");
		}
		if(receiveDataService.modifiyCenterOrder(centerReceivePO)){
			System.out.println("----modifiyCenterOrder succeed!----");
		}
		if(receiveDataService.writeLobbyReceiveOrder(lobbyReceivePO)){
			System.out.println("----writeLobbyReceiveOrder succeed!----");
		}
		if(receiveDataService.readLobbyReceiveOrder( lobbylist)!=null){
			System.out.println("----readLobbyReceiveOrder succeed!----");
		}
		if(receiveDataService.delLobbyReceiveOrder(lobbyReceivePO)){
			System.out.println("----delLobbyReceiveOrder succeed!----");
		}
		if(receiveDataService.modifiyLobbyReceiveOrder(lobbyReceivePO)){
			System.out.println("----modifiyLobbyReceiveOrder succeed!----");
		}
		if(receiveDataService.writeDistributeOrder(distributePO)){
			System.out.println("----writeDistributeOrder succeed!----");
		}
		if(receiveDataService.readDistributeOrder(orderBar,distributePO)){
			System.out.println("----readDistributeOrder succeed!----");
		}
		if(receiveDataService.delDistributeOrder(orderBar)){
			System.out.println("----delDistributeOrder succeed!----");
		}
		if(receiveDataService.modifiyDistributeOrder(distributePO)){
			System.out.println("----modifiyDistributeOrder succeed!----");
		}
		return true;
	}
}
