package dataservice;

import po.CenterReceivePO;
import po.DistributePO;
import po.LobbyReceivePO;
import po.OrderPO;
import presentation.mainui.MainFrame;
import socketservice.Client;
import po.MessageType;

public class ReceiveDataServiceImpl implements ReceiveDataService{
    private Client client;
	public ReceiveDataServiceImpl(){
		client=MainFrame.getClient();
    }
	@Override
	public boolean writeOrder(OrderPO orderpo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderPO readOrder(String orderBar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delOrder(String orderBar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderPO modifiyOrder(OrderPO orderpo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeCenterOrder(CenterReceivePO centerReceivePO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CenterReceivePO readCenterOrder(String orderBar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delCenterOrder(String orderBar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CenterReceivePO modifiyCenterOrder(CenterReceivePO centerReceivePO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO) {
		// TODO Auto-generated method stub
		lobbyReceivePO.setType(MessageType.LobbyReceive);
		client.wrightReceipt(lobbyReceivePO);
		return false;
	}

	@Override
	public LobbyReceivePO readLobbyReceiveOrder(String orderBar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LobbyReceivePO modifiyLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeDistributeOrder(DistributePO distributePO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DistributePO readDistributeOrder(String orderBar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delDistributeOrder(String orderBar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DistributePO modifiyDistributeOrder(DistributePO distributePO) {
		// TODO Auto-generated method stub
		return null;
	}

}
