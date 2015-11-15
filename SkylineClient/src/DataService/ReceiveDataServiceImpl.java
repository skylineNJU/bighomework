package dataservice;

import po.CenterReceivePO;
import po.DistributePO;
import po.LobbyReceivePO;
import po.OrderPO;
import socketservice.Client;
import po.MessageType;

public class ReceiveDataServiceImpl implements ReceiveDataService{
    private Client client;
	public ReceiveDataServiceImpl(){
    }
	@Override
	public boolean writeOrder(OrderPO orderpo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean readOrder(String orderBar,OrderPO orderPO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delOrder(String orderBar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifiyOrder(OrderPO orderpo) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean writeCenterOrder(CenterReceivePO centerReceivePO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean readCenterOrder(String orderBar,CenterReceivePO centerReceivePO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delCenterOrder(String orderBar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifiyCenterOrder(CenterReceivePO centerReceivePO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean writeLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO) {
		// TODO Auto-generated method stub
		lobbyReceivePO.setType(MessageType.LobbyReceive);
		client.wrightReceipt(lobbyReceivePO);
		return false;
	}

	@Override
	public boolean readLobbyReceiveOrder(String orderBar,LobbyReceivePO lobbyReceivePO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifiyLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean writeDistributeOrder(DistributePO distributePO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean readDistributeOrder(String orderBar,DistributePO distributePO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delDistributeOrder(String orderBar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifiyDistributeOrder(DistributePO distributePO) {
		// TODO Auto-generated method stub
		return true;
	}

}
