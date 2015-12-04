package main.data.receive;

import main.dataservice.ReceiveDataService;
import main.po.CenterReceivePO;
import main.po.DistributePO;
import main.po.LobbyReceiveListPO;
import main.po.LobbyReceivePO;
import main.po.OrderListPO;
import main.po.OrderPO;
import main.presentation.mainui.MainController;
import main.socketservice.Client;

public class ReceiveDataController implements ReceiveDataService{
	Client client;
	@Override
	//存储新的订单信息
	//将订单信息存储进数据库
	public boolean writeOrder(OrderPO orderpo){
		client=MainController.getClient();
		orderpo.setKey("Save");
		client.wrightReceipt(orderpo);
		return false;
	}
	
	//删除订单信息
	//orderBar表示订单条形码
	@Override
	public boolean delOrder(String orderBar){
		return false;
	}
	
	//修改订单信息
	//orderBar表示订单条形码
	@Override
	public boolean modifiyOrder(OrderPO orderpo){
		return false;
	}
	
	//存储新的中转接收单单信息
	//将订单信息存储进数据库
	@Override
	public boolean writeCenterOrder(CenterReceivePO centerReceivePO){
		client=MainController.getClient();
		centerReceivePO.setKey("Save");
		client.wrightReceipt(centerReceivePO);
		return false;
	}
	
	//查看中转接收单单信息
	//orderBar为订单条形码
	@Override
	public CenterReceivePO readCenterOrder(CenterReceivePO centerReceivePO){
		client=MainController.getClient();
		centerReceivePO.setKey("Inquire");
		client.wrightReceipt(centerReceivePO);
		return (CenterReceivePO) client.getResponse();
	}
	
	//删除中转接收单单信息
	//orderBar表示订单条形码
	@Override
	public boolean delCenterOrder(String orderBar){
		return false;
	}
	
	//修改中转接收单单信息
	//orderBar表示订单条形码
	@Override
	public boolean modifiyCenterOrder(CenterReceivePO centerReceivePO){
		return false;
	}
	
	//存储新的接收单单信息
	//将订单信息存储进数据库
	@Override
	public boolean writeLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO){
		client=MainController.getClient();
		lobbyReceivePO.setKey("Save");
		System.out.println("begin save");
		client.wrightReceipt(lobbyReceivePO);
		System.out.println("save success");
		return false;
	}
	
	//删除接收单单信息
	//orderBar表示订单条形码
	@Override
	public boolean delLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO){
		return false;
	}
	
	//修改接收单单信息
	//orderBar表示订单条形码
	@Override
	public boolean modifiyLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO){
		return false;
	}
	
	//存储新的派送单信息
	//将订单信息存储进数据库
	@Override
	public boolean writeDistributeOrder(DistributePO distributePO){
		return false;
	}
	
	//查看派送单单信息
	//orderBar为订单条形码
	@Override
	public boolean readDistributeOrder(String orderBar,DistributePO distributePO){
		return false;
	}
	
	//删除派送单单信息
	//orderBar表示订单条形码
	@Override
	public boolean delDistributeOrder(String orderBar){
		return false;
	}
	
	//修改派送单单信息
	//orderBar表示订单条形码
	@Override
	public boolean modifiyDistributeOrder(DistributePO distributePO){
		return false;
	}

	@Override
	public LobbyReceiveListPO readLobbyReceiveOrder(LobbyReceiveListPO poList) {
		// TODO Auto-generated method stub
		poList.setKey("Inquire");
		client=MainController.getClient();
		client.wrightReceipt(poList);
		poList=(LobbyReceiveListPO) client.getResponse();
		return poList;
	}

	@Override
	public OrderListPO readOrder(OrderListPO orderPO) {
		// TODO Auto-generated method stub
		orderPO.setKey("Inquire");
		client=MainController.getClient();
		client.wrightReceipt(orderPO);
		orderPO=(OrderListPO) client.getResponse();
		return orderPO;
	}
}
