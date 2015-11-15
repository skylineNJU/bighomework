package dataservice;

import po.CenterReceivePO;
import po.DistributePO;
import po.OrderPO;
import po.LobbyReceivePO;

//货物接收
//中转接收单 CenterReceivePO
public interface ReceiveDataService {
	
	//存储新的订单信息
	//将订单信息存储进数据库
	public boolean writeOrder(OrderPO orderpo);
	
	//查看订单信息
	//orderBar为订单条形码
	public boolean readOrder(String orderBar,OrderPO orderPO);
	
	//删除订单信息
	//orderBar表示订单条形码
	public boolean delOrder(String orderBar);
	
	//修改订单信息
	//orderBar表示订单条形码
	public boolean modifiyOrder(OrderPO orderpo);
	
	//存储新的中转接收单单信息
	//将订单信息存储进数据库
	public boolean writeCenterOrder(CenterReceivePO centerReceivePO);
	
	//查看中转接收单单信息
	//orderBar为订单条形码
	public boolean readCenterOrder(String orderBar,CenterReceivePO centerReceivePO);
	
	//删除中转接收单单信息
	//orderBar表示订单条形码
	public boolean delCenterOrder(String orderBar);
	
	//修改中转接收单单信息
	//orderBar表示订单条形码
	public boolean modifiyCenterOrder(CenterReceivePO centerReceivePO);
	
	//存储新的接收单单信息
	//将订单信息存储进数据库
	public boolean writeLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO);
	
	//查看接收单单信息
	//orderBar为订单条形码
	public boolean readLobbyReceiveOrder(String orderBar,LobbyReceivePO lobbyReceivePO);
	
	//删除接收单单信息
	//orderBar表示订单条形码
	public boolean delLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO);
	
	//修改接收单单信息
	//orderBar表示订单条形码
	public boolean modifiyLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO);
	
	//存储新的派送单信息
	//将订单信息存储进数据库
	public boolean writeDistributeOrder(DistributePO distributePO);
	
	//查看派送单单信息
	//orderBar为订单条形码
	public boolean readDistributeOrder(String orderBar,DistributePO distributePO);
	
	//删除派送单单信息
	//orderBar表示订单条形码
	public boolean delDistributeOrder(String orderBar);
	
	//修改派送单单信息
	//orderBar表示订单条形码
	public boolean modifiyDistributeOrder(DistributePO distributePO);
	
}
