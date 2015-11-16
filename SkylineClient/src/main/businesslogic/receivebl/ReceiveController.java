package main.businesslogic.receivebl;

import main.businesslogicservice.ReceiveBLService;
import main.vo.LobbyReceptionVO;
import main.vo.OrderVO;
import main.vo.OrderVO.PackageCost;
import main.vo.OrderVO.Size;
import main.vo.OrderVO.Type;
import main.vo.TransitReceptionVO;

public class ReceiveController implements ReceiveBLService {
	String receiptcode="124321513";
	@Override
	public boolean createNewOrder(OrderVO orderInfo) {
		// TODO Auto-generated method stub
		Order order=new Order(orderInfo);
		return order.saveInfo();
	}

	@Override
	public boolean createNewTransitReception(TransitReceptionVO transitReceptionInfo) {
		// TODO Auto-generated method stub
		Transit transit=new Transit(transitReceptionInfo);
		
		return transit.saveInfo();
	}
	@Override
	public boolean createNewLobbyReception(LobbyReceptionVO lobbyReceptionInfo) {
		// TODO Auto-generated method stub
		Lobby lobby=new Lobby( lobbyReceptionInfo);
		
		return lobby.saveInfo();
	}

}
