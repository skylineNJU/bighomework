package main.data.receive;

import main.dataservice.ReceiveDataService;
import main.po.CenterReceivePO;
import main.po.DistributePO;
import main.po.LobbyReceivePO;
import main.po.OrderPO;
import main.socketservice.Client;

public class ReceiveDataController implements ReceiveDataService{
	Client client;
	@Override
	//�洢�µĶ�����Ϣ
	//��������Ϣ�洢�����ݿ�
	public boolean writeOrder(OrderPO orderpo){
		return false;
	}
	
	//�鿴������Ϣ
	//orderBarΪ����������
	@Override
	public boolean readOrder(String orderBar,OrderPO orderPO){
		return false;
	}
	
	//ɾ��������Ϣ
	//orderBar��ʾ����������
	@Override
	public boolean delOrder(String orderBar){
		return false;
	}
	
	//�޸Ķ�����Ϣ
	//orderBar��ʾ����������
	@Override
	public boolean modifiyOrder(OrderPO orderpo){
		return false;
	}
	
	//�洢�µ���ת���յ�����Ϣ
	//��������Ϣ�洢�����ݿ�
	@Override
	public boolean writeCenterOrder(CenterReceivePO centerReceivePO){
		return false;
	}
	
	//�鿴��ת���յ�����Ϣ
	//orderBarΪ����������
	@Override
	public boolean readCenterOrder(String orderBar,CenterReceivePO centerReceivePO){
		return false;
	}
	
	//ɾ����ת���յ�����Ϣ
	//orderBar��ʾ����������
	@Override
	public boolean delCenterOrder(String orderBar){
		return false;
	}
	
	//�޸���ת���յ�����Ϣ
	//orderBar��ʾ����������
	@Override
	public boolean modifiyCenterOrder(CenterReceivePO centerReceivePO){
		return false;
	}
	
	//�洢�µĽ��յ�����Ϣ
	//��������Ϣ�洢�����ݿ�
	@Override
	public boolean writeLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO){
		return false;
	}
	
	//�鿴���յ�����Ϣ
	//orderBarΪ����������
	@Override
	public boolean readLobbyReceiveOrder(String orderBar,LobbyReceivePO lobbyReceivePO){
		return false;
	}
	
	//ɾ�����յ�����Ϣ
	//orderBar��ʾ����������
	@Override
	public boolean delLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO){
		return false;
	}
	
	//�޸Ľ��յ�����Ϣ
	//orderBar��ʾ����������
	@Override
	public boolean modifiyLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO){
		return false;
	}
	
	//�洢�µ����͵���Ϣ
	//��������Ϣ�洢�����ݿ�
	@Override
	public boolean writeDistributeOrder(DistributePO distributePO){
		return false;
	}
	
	//�鿴���͵�����Ϣ
	//orderBarΪ����������
	@Override
	public boolean readDistributeOrder(String orderBar,DistributePO distributePO){
		return false;
	}
	
	//ɾ�����͵�����Ϣ
	//orderBar��ʾ����������
	@Override
	public boolean delDistributeOrder(String orderBar){
		return false;
	}
	
	//�޸����͵�����Ϣ
	//orderBar��ʾ����������
	@Override
	public boolean modifiyDistributeOrder(DistributePO distributePO){
		return false;
	}
}
