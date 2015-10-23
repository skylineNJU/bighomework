package dataservice;

import po.CenterReceivePO;
import po.DistributePO;
import po.LobbyReceivePO;
import po.OrderPO;

//货物接收
//中转接收单 CenterReceivePO
public interface ReceiveDataService {
	
	//存储新的订单信息
	//将订单信息存储进数据库
	public void writeOrder(OrderPO orderpo);
	
	//查看订单信息
	//orderBar为订单条形码
	public OrderPO readOrder(String orderBar);
	
	//删除订单信息
	//orderBar表示订单条形码
	public boolean delOrder(String orderBar);
	
	//修改订单信息
	//orderBar表示订单条形码
	public OrderPO modifiyOrder(OrderPO orderpo);
	
	//存储新的中转接收单单信息
	//将订单信息存储进数据库
	public boolean writeCenterOrder(CenterReceivePO centerReceivePO);
	
	//查看中转接收单单信息
	//orderBar为订单条形码
	public CenterReceivePO readCenterOrder(String orderBar);
	
	//删除中转接收单单信息
	//orderBar表示订单条形码
	public boolean delCenterOrder(String orderBar);
	
	//修改中转接收单单信息
	//orderBar表示订单条形码
	public CenterReceivePO modifiyCenterOrder(CenterReceivePO centerReceivePO);
	
	//存储新的接收单单信息
	//将订单信息存储进数据库
	public boolean writeLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO);
	
	//查看接收单单信息
	//orderBar为订单条形码
	public LobbyReceivePO readLobbyReceiveOrder(String orderBar);
	
	//删除接收单单信息
	//orderBar表示订单条形码
	public boolean delLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO);
	
	//修改接收单单信息
	//orderBar表示订单条形码
	public LobbyReceivePO modifiyLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO);
	
	//存储新的派送单信息
	//将订单信息存储进数据库
	public boolean writeDistributeOrder(DistributePO distributePO);
	
	//查看派送单单信息
	//orderBar为订单条形码
	public DistributePO readDistributeOrder(String orderBar);
	
	//删除派送单单信息
	//orderBar表示订单条形码
	public boolean delDistributeOrder(String orderBar);
	
	//修改派送单单信息
	//orderBar表示订单条形码
	public DistributePO modifiyDistributeOrder(DistributePO distributePO);
	
}
