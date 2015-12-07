package main.dataservice;

import main.po.CenterReceiveListPO;
import main.po.CenterReceivePO;
import main.po.CourrierPO;
import main.po.DistributePO;
import main.po.LobbyReceiveListPO;
import main.po.OrderPO;
import main.po.LobbyReceivePO;
import main.po.OrderListPO;

//�������
//��ת���յ� CenterReceivePO
public interface ReceiveDataService {
	
	//�洢�µĶ�����Ϣ
	//��������Ϣ�洢�����ݿ�
	public boolean writeOrder(OrderPO orderpo);
	
	//�鿴������Ϣ
	//orderBarΪ����������
	public OrderListPO readOrder(OrderListPO orderPO);
	
	//ɾ��������Ϣ
	//orderBar��ʾ����������
	public boolean delOrder(String orderBar);
	
	//�޸Ķ�����Ϣ
	//orderBar��ʾ����������
	public boolean modifiyOrder(OrderPO orderpo);
	
	//�洢�µ���ת���յ�����Ϣ
	//��������Ϣ�洢�����ݿ�
	public boolean writeCenterOrder(CenterReceivePO centerReceivePO);
	
	//�鿴��ת���յ�����Ϣ
	//orderBarΪ����������
	public CenterReceiveListPO readCenterOrder(CenterReceiveListPO centerReceivePO);
	
	//ɾ����ת���յ�����Ϣ
	//orderBar��ʾ����������
	public boolean delCenterOrder(String orderBar);
	
	//�޸���ת���յ�����Ϣ
	//orderBar��ʾ����������
	public boolean modifiyCenterOrder(CenterReceivePO centerReceivePO);
	

	//�洢�µĽ��յ�����Ϣ
	//��������Ϣ�洢�����ݿ�
	public boolean writeLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO);
	
	//�鿴���յ�����Ϣ
	//orderBarΪ����������
	public LobbyReceiveListPO readLobbyReceiveOrder(LobbyReceiveListPO poList);
	
	//ɾ�����յ�����Ϣ
	//orderBar��ʾ����������
	public boolean delLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO);
	
	//�޸Ľ��յ�����Ϣ
	//orderBar��ʾ����������
	public boolean modifiyLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO);
	
	//�洢�µ����͵���Ϣ
	//��������Ϣ�洢�����ݿ�
	public boolean writeDistributeOrder(DistributePO distributePO);
	
	//�鿴���͵�����Ϣ
	//orderBarΪ����������
	public boolean readDistributeOrder(String orderBar,DistributePO distributePO);
	
	//ɾ�����͵�����Ϣ
	//orderBar��ʾ����������
	public boolean delDistributeOrder(String orderBar);
	
	//�޸����͵�����Ϣ
	//orderBar��ʾ����������
	public boolean modifiyDistributeOrder(DistributePO distributePO);
	
	public CourrierPO getCourrierInfo(CourrierPO po);
	
	public void saveDistribute(DistributePO po);
}
