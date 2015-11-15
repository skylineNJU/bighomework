package data_stub;

import dataservice.ReceiveDataService;
import po.CenterReceivePO;
import po.DistributePO;
import po.LobbyReceivePO;
import po.OrderPO;
import po.OrderPO.PackageCost;
import po.OrderPO.Size;
import po.Type;


public class ReceiveDataService_Stub implements ReceiveDataService {

	//存储新的订单信息
	//将订单信息存储进数据库
	public boolean writeOrder(OrderPO orderpo){
		System.out.println("write Succeed!/n");
		return true;
	}
	
	//查看订单信息
	//orderBar为订单条形码
	public OrderPO readOrder(String orderBar){
		OrderPO orderPO = new OrderPO("张三","北京市三里屯","无","64227112","13242199875","李四","南京市和园" ,
				"无","62238765","19876244534",PackageCost.paperBox,po.Type.normal,1,14.5,30,"衣服",Size.small,orderBar,8);
		System.out.println("Succeed!/n");
		return orderPO;
	}
	
	//删除订单信息
	//orderBar表示订单条形码
	public boolean delOrder(String orderBar){
		System.out.println("delete Succeed!/n");
		return true;
	}
	
	//修改订单信息
	//orderBar表示订单条形码
	public OrderPO modifiyOrder(OrderPO orderPO){
		 orderPO = new OrderPO("张三","北京市三里屯","无","64227112","13242199875","李四","南京市和园" ,
				"无","62238765","19876244534",PackageCost.paperBox,Type.normal,1,14.5,30,"衣服",Size.small,"0100210001",8);
		System.out.println("Succeed!/n");
		return orderPO;
	}
	
	//存储新的中转接收单单信息
	//将订单信息存储进数据库
	public boolean writeCenterOrder(CenterReceivePO centerReceivePO){
		System.out.println("write Succeed!/n");
		return true;
	}
	
	//查看中转接收单单信息
	//orderBar为订单条形码
	public CenterReceivePO readCenterOrder(String orderBar){
		CenterReceivePO centerReceivePO = new CenterReceivePO(2, 23, 226, 78, orderBar);
		System.out.println("Succeed!/n");
		return centerReceivePO;
	}
	
	//删除中转接收单单信息
	//orderBar表示订单条形码
	public boolean delCenterOrder(String orderBar){
		System.out.println("delete Succeed!/n");
		return true;
	}
	
	//修改中转接收单单信息
	//orderBar表示订单条形码
	public CenterReceivePO modifiyCenterOrder(CenterReceivePO centerReceivePO){
		CenterReceivePO centerReceivePO1 = new CenterReceivePO(2, 56, 4656, 2329, null);
		System.out.println("Succeed!/n");
		return centerReceivePO1;
	}
	
	//存储新的接收单单信息
	//将订单信息存储进数据库
	public boolean writeLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO){
		System.out.println("write Succeed!/n");
		return true;
	}
	
	//查看接收单单信息
	//orderBar为订单条形码
	public LobbyReceivePO readLobbyReceiveOrder(String orderBar){
		LobbyReceivePO lobbyReceivePO = new LobbyReceivePO(5649, 2626, 233,56,"NULL", orderBar);
		System.out.println("Succeed!/n");
		return lobbyReceivePO;
	}
	
	//删除接收单单信息
	//orderBar表示订单条形码
	public boolean delLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO){
		System.out.println("delete Succeed!/n");
		return true;
	}
	
	//修改接收单单信息
	//orderBar表示订单条形码
	public LobbyReceivePO modifiyLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO){
		LobbyReceivePO lobbyReceivePO1 = new LobbyReceivePO(45, 78, 12, 23,"null", "asdsad");
		System.out.println("Succeed!/n");
		return lobbyReceivePO1;
	}
	
	//存储新的派送单信息
	//将订单信息存储进数据库
	public boolean writeDistributeOrder(DistributePO distributePO){
		System.out.println("write Succeed!/n");
		return true;
	}
	
	//查看派送单单信息
	//orderBar为订单条形码
	public DistributePO readDistributeOrder(String orderBar){
		DistributePO distributePO = new DistributePO(orderBar, "sadsad", "sadasd");
		System.out.println("Succeed!/n");
		return distributePO;
	}
	
	//删除派送单单信息
	//orderBar表示订单条形码
	public boolean delDistributeOrder(String orderBar){
		System.out.println("delete Succeed!/n");
		return true;
	}
	
	//修改派送单单信息
	//orderBar表示订单条形码
	public DistributePO modifiyDistributeOrder(DistributePO distributePO){
		DistributePO distributePO1 = new DistributePO("sadasd", "sdsa", "sdas");
		System.out.println("Succeed!/n");
		return distributePO1;
	}
}
