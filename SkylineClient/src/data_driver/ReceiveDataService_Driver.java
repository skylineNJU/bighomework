package data_driver;

import dataService.ReceiveDataService;
import po.CenterReceivePO;
import po.DistributePO;
import po.LobbyReceivePO;
import po.OrderPO;
import po.OrderPO.Size;
import po.OrderPO.PackageCost;

public class ReceiveDataService_Driver {
	
	public boolean receiveDataDrive(ReceiveDataService receiveDataService){
		OrderPO orderPO = new OrderPO("201515","asdas","sads","sadsad","sadsd","sdasd", "sadsad" , "sadsd","dsaddd","dsadsad",
				PackageCost.paperBox, null ,20,20.1,20.2,"dsadasd",Size.small,"sadsad",20);
		String orderBar = "2051560";
		CenterReceivePO centerReceivePO = new CenterReceivePO(2015, 10, 30, 2, orderBar);
		LobbyReceivePO lobbyReceivePO = new LobbyReceivePO(2014,3,28,56,orderBar,orderBar);
		DistributePO distributePO = new DistributePO("2015/02/26", "СѕЧе", orderBar);
		
		if(receiveDataService.writeOrder(orderPO)){
			System.out.println("----writeOrder succeed!----");
		}
		if(receiveDataService.readOrder(orderBar)!=null){
			System.out.println("----readOrder succeed!----");
		}
		if(receiveDataService.delOrder(orderBar)){
			System.out.println("----delOrder succeed!----");
		}
		if(receiveDataService.modifiyOrder(orderPO)!=null){
			System.out.println("----modifiyOrder succeed!----");
		}
		if(receiveDataService.writeCenterOrder(centerReceivePO)){
			System.out.println("----writeCenterOrder succeed!----");
		}
		if(receiveDataService.readCenterOrder(orderBar)!=null){
			System.out.println("----readCenterOrder succeed!----");
		}
		if(receiveDataService.delCenterOrder(orderBar)){
			System.out.println("----delCenterOrder succeed!----");
		}
		if(receiveDataService.modifiyCenterOrder(centerReceivePO)!=null){
			System.out.println("----modifiyCenterOrder succeed!----");
		}
		if(receiveDataService.writeLobbyReceiveOrder(lobbyReceivePO)){
			System.out.println("----writeLobbyReceiveOrder succeed!----");
		}
		if(receiveDataService.readLobbyReceiveOrder(orderBar)!=null){
			System.out.println("----readLobbyReceiveOrder succeed!----");
		}
		if(receiveDataService.delLobbyReceiveOrder(lobbyReceivePO)){
			System.out.println("----delLobbyReceiveOrder succeed!----");
		}
		if(receiveDataService.modifiyLobbyReceiveOrder(lobbyReceivePO)!=null){
			System.out.println("----modifiyLobbyReceiveOrder succeed!----");
		}
		if(receiveDataService.writeDistributeOrder(distributePO)){
			System.out.println("----writeDistributeOrder succeed!----");
		}
		if(receiveDataService.readDistributeOrder(orderBar)!=null){
			System.out.println("----readDistributeOrder succeed!----");
		}
		if(receiveDataService.delDistributeOrder(orderBar)){
			System.out.println("----delDistributeOrder succeed!----");
		}
		if(receiveDataService.modifiyDistributeOrder(distributePO)!=null){
			System.out.println("----modifiyDistributeOrder succeed!----");
		}
		return true;
	}
}
