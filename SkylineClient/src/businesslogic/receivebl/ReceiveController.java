package businesslogic.receivebl;

import businesslogicservice.ReceiveBLService;
import vo.LobbyReceptionVO;
import vo.OrderVO;
import vo.OrderVO.PackageCost;
import vo.OrderVO.Size;
import vo.OrderVO.Type;
import vo.TransitReceptionVO;

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
