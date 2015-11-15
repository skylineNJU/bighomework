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
		return null;
	}

	@Override
	public TransitReceptionVO createNewTransitReception(String CenterCode, String date, String ReceiptCode, String from,
			int condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LobbyReceptionVO createNewLobbyReception(String date, String code, String from, int condition) {
		// TODO Auto-generated method stub
		Lobby lobby=new Lobby(date,code,from,condition,this.receiptcode);
		lobby.write();
		return null;
	}

}
