package main.data.receive;

import main.dataservice.ReceiveDataService;
import main.po.CenterReceiveListPO;
import main.po.CenterReceivePO;
import main.po.CourrierPO;
import main.po.DistributePO;
import main.po.LobbyReceiveListPO;
import main.po.LobbyReceivePO;
import main.po.Message;
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
		client.writeReceipt(orderpo);
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
		client.writeReceipt(centerReceivePO);
		return false;
	}
	
	//查看中转接收单单信息
	//orderBar为订单条形码
	@Override
	public CenterReceiveListPO readCenterOrder(CenterReceiveListPO centerReceivePO){
		client=MainController.getClient();
		centerReceivePO.setKey("Inquire");
		client.writeReceipt(centerReceivePO);
		return (CenterReceiveListPO) client.getResponse();
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
		client.writeReceipt(lobbyReceivePO);
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
		client.writeReceipt(poList);
		poList=(LobbyReceiveListPO) client.getResponse();
		return poList;
	}

	@Override
	public OrderListPO readOrder(OrderListPO orderPO) {
		// TODO Auto-generated method stub
		orderPO.setKey("Inquire");
		client=MainController.getClient();
		client.writeReceipt(orderPO);
		orderPO=(OrderListPO) client.getResponse();
		return orderPO;
	}

	@Override
	public CourrierPO getCourrierInfo(CourrierPO po) {
		// TODO Auto-generated method stub
		po.setKey("Inquire");
		client=MainController.getClient();
		client.writeReceipt(po);
		Message message=client.getResponse();
		System.out.println("+++++++++++++++++++"+message.getKey());
		return (CourrierPO) message;
	}

	@Override
	public void saveDistribute(DistributePO po) {
		// TODO Auto-generated method stub
		po.setKey("Save");
		client=MainController.getClient();
		client.writeReceipt(po);
	}
}
