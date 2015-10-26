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
	public OrderVO createNewOrder(String name1, String position1, String unit1, String phoneNumber1, String name2,
			String position2, String unit2, String phoneNumber2, int number, double weight, double Volume, String name3,
			PackageCost pC, Type t, Size size, String id, String data, String code) {
		// TODO Auto-generated method stub
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
		LobbyReceive lobby=new LobbyReceive(date,code,from,condition,this.receiptcode);
		lobby.write();
		return null;
	}

}
