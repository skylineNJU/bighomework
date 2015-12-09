package test.data_stub;

import  main.dataservice.ReceiveDataService;
import main.po.CenterReceiveListPO;
import  main.po.CenterReceivePO;
import main.po.CourrierPO;
import  main.po.DistributePO;
import main.po.LobbyReceiveListPO;
import  main.po.LobbyReceivePO;
import main.po.OrderListPO;
import  main.po.OrderPO;

public class ReceiveDataService_Stub implements ReceiveDataService {

	@Override
	public boolean writeOrder(OrderPO orderpo) {
		System.out.println("新增订单"+orderpo.getCode()+"成功！");
		return true;
	}

	@Override
	public OrderListPO readOrder(OrderListPO orderPO) {
		OrderListPO orderListPO = orderPO;
		return orderListPO;
	}

	@Override
	public boolean delOrder(String orderBar) {
		System.out.println("删除"+orderBar+"订单成功！");
		return true;
	}

	@Override
	public boolean modifiyOrder(OrderPO orderpo) {
		System.out.println("修改"+ orderpo.getCode()+"成功！");
		return true;
	}

	@Override
	public boolean writeCenterOrder(CenterReceivePO centerReceivePO) {
		System.out.println("新增"+centerReceivePO.getBar()+"成功！");
		return true;
	}

	@Override
	public CenterReceiveListPO readCenterOrder(
			CenterReceiveListPO centerReceivePO) {
		CenterReceiveListPO po = centerReceivePO;
		return po;
	}

	@Override
	public boolean delCenterOrder(String orderBar) {
		System.out.println("删除中转接收单成功！");
		return true;
	}

	@Override
	public boolean modifiyCenterOrder(CenterReceivePO centerReceivePO) {
		System.out.println("修改中转接收单"+centerReceivePO.getCode()+"成功！");
		return true;
	}

	@Override
	public boolean writeLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO) {
		System.out.println("新增营业厅接收单"+lobbyReceivePO.getCode()+"成功！");
		return true;
	}

	@Override
	public LobbyReceiveListPO readLobbyReceiveOrder(LobbyReceiveListPO poList) {
		LobbyReceiveListPO lobbyReceiveListPO = poList;
		return lobbyReceiveListPO;
	}

	@Override
	public boolean delLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO) {
		System.out.println("删除营业厅接收单"+lobbyReceivePO.getCode()+"成功！");
		return true;
	}

	@Override
	public boolean modifiyLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO) {
		System.out.println("修改营业厅接收单"+lobbyReceivePO.getCode()+"成功！");
		return true;
	}

	@Override
	public boolean writeDistributeOrder(DistributePO distributePO) {
		System.out.println("新增分配单"+distributePO.getBar()+"成功！");
		return true;
	}

	@Override
	public boolean readDistributeOrder(String orderBar,
			DistributePO distributePO) {
		System.out.println("读取分配单"+orderBar+"成功！");
		return true;
	}

	@Override
	public boolean delDistributeOrder(String orderBar) {
		System.out.println("删除"+orderBar+"成功！");
		return true;
	}

	@Override
	public boolean modifiyDistributeOrder(DistributePO distributePO) {
		System.out.println("修改分配单"+distributePO.getBar()+"成功！");
		return true;
	}

	@Override
	public CourrierPO getCourrierInfo(CourrierPO po) {
		CourrierPO courrierPO = po;
		return courrierPO;
	}

	@Override
	public void saveDistribute(DistributePO po) {
		System.out.println("保存分配单成功！"+po.getBar());
	}
}
