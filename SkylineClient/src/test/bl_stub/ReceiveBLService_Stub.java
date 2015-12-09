package test.bl_stub;

import java.util.ArrayList;

import main.po.Type;
import main.po.OrderPO.PackageCost;
import main.po.OrderPO.Size;
import  main.vo.LobbyReceptionVO;
import  main.vo.OrderVO;
import  main.vo.TransitReceptionVO;
import  main.businesslogicservice.ReceiveBLService;
/**
 * 
 * @author QiHan
 * 
 *
 */
public class ReceiveBLService_Stub implements ReceiveBLService{

	@Override
	public boolean createNewOrder(OrderVO orderInfo) {
		// TODO Auto-generated method stub
		orderInfo = new OrderVO("12312313", null, null, null, null,null,null, null,null, 0, 0,
				PackageCost.valueOf(null, null), Type.cheap, Size.medium, null, 0, 0);
		if(orderInfo.getCode()!=null){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean createNewTransitReception(TransitReceptionVO transitReceptionInfo) {
		// TODO Auto-generated method stub
		 transitReceptionInfo = new TransitReceptionVO(2015,0, 0,null,null,null);
		if(transitReceptionInfo .getReceiveYear()==2015){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public ArrayList<TransitReceptionVO> inquireTransitReception(String codeList) {
		// TODO Auto-generated method stub
		TransitReceptionVO  transit = new TransitReceptionVO(2016,11, 2,"0100","12132132432",codeList);
		ArrayList<TransitReceptionVO> list = new ArrayList<TransitReceptionVO>();
		list.add(transit);
		return list;
	}

	@Override
	public boolean createNewLobbyReception(LobbyReceptionVO lobbyReceptionInfo) {
		// TODO Auto-generated method stub
		lobbyReceptionInfo  = new LobbyReceptionVO("12137892321", null, null, null, null,null);
		if(	lobbyReceptionInfo.getCode()!=null){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public ArrayList<LobbyReceptionVO> inquireLobbyReceive(String codes) {
		// TODO Auto-generated method stub
		LobbyReceptionVO lobby = new LobbyReceptionVO(codes, null, null, null, null,null);
		ArrayList<LobbyReceptionVO> list = new ArrayList<LobbyReceptionVO>();
		list.add(lobby);
		return list;
	}

	@Override
	public ArrayList<OrderVO> inquireOrderReceive(String codes) {
		// TODO Auto-generated method stub
		OrderVO order = new OrderVO(codes, null, null, null, null,null,null, null,null, 
				0, 0,PackageCost.valueOf(null, null), Type.cheap, Size.medium, null, 0, 0);
		 ArrayList<OrderVO> list = new ArrayList<OrderVO>();
		 list.add(order);
		return list;
	}

	
}
