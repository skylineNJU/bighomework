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
		System.out.println("��������"+orderpo.getCode()+"�ɹ���");
		return true;
	}

	@Override
	public OrderListPO readOrder(OrderListPO orderPO) {
		OrderListPO orderListPO = orderPO;
		return orderListPO;
	}

	@Override
	public boolean delOrder(String orderBar) {
		System.out.println("ɾ��"+orderBar+"�����ɹ���");
		return true;
	}

	@Override
	public boolean modifiyOrder(OrderPO orderpo) {
		System.out.println("�޸�"+ orderpo.getCode()+"�ɹ���");
		return true;
	}

	@Override
	public boolean writeCenterOrder(CenterReceivePO centerReceivePO) {
		System.out.println("����"+centerReceivePO.getBar()+"�ɹ���");
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
		System.out.println("ɾ����ת���յ��ɹ���");
		return true;
	}

	@Override
	public boolean modifiyCenterOrder(CenterReceivePO centerReceivePO) {
		System.out.println("�޸���ת���յ�"+centerReceivePO.getCode()+"�ɹ���");
		return true;
	}

	@Override
	public boolean writeLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO) {
		System.out.println("����Ӫҵ�����յ�"+lobbyReceivePO.getCode()+"�ɹ���");
		return true;
	}

	@Override
	public LobbyReceiveListPO readLobbyReceiveOrder(LobbyReceiveListPO poList) {
		LobbyReceiveListPO lobbyReceiveListPO = poList;
		return lobbyReceiveListPO;
	}

	@Override
	public boolean delLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO) {
		System.out.println("ɾ��Ӫҵ�����յ�"+lobbyReceivePO.getCode()+"�ɹ���");
		return true;
	}

	@Override
	public boolean modifiyLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO) {
		System.out.println("�޸�Ӫҵ�����յ�"+lobbyReceivePO.getCode()+"�ɹ���");
		return true;
	}

	@Override
	public boolean writeDistributeOrder(DistributePO distributePO) {
		System.out.println("�������䵥"+distributePO.getBar()+"�ɹ���");
		return true;
	}

	@Override
	public boolean readDistributeOrder(String orderBar,
			DistributePO distributePO) {
		System.out.println("��ȡ���䵥"+orderBar+"�ɹ���");
		return true;
	}

	@Override
	public boolean delDistributeOrder(String orderBar) {
		System.out.println("ɾ��"+orderBar+"�ɹ���");
		return true;
	}

	@Override
	public boolean modifiyDistributeOrder(DistributePO distributePO) {
		System.out.println("�޸ķ��䵥"+distributePO.getBar()+"�ɹ���");
		return true;
	}

	@Override
	public CourrierPO getCourrierInfo(CourrierPO po) {
		CourrierPO courrierPO = po;
		return courrierPO;
	}

	@Override
	public void saveDistribute(DistributePO po) {
		System.out.println("������䵥�ɹ���"+po.getBar());
	}
}
