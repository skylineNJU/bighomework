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
	//�洢�µĶ�����Ϣ
	//��������Ϣ�洢�����ݿ�
	public boolean writeOrder(OrderPO orderpo){
		client=MainController.getClient();
		orderpo.setKey("Save");
		client.writeReceipt(orderpo);
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
		client=MainController.getClient();
		centerReceivePO.setKey("Save");
		client.writeReceipt(centerReceivePO);
		return false;
	}
	
	//�鿴��ת���յ�����Ϣ
	//orderBarΪ����������
	@Override
	public CenterReceiveListPO readCenterOrder(CenterReceiveListPO centerReceivePO){
		client=MainController.getClient();
		centerReceivePO.setKey("Inquire");
		client.writeReceipt(centerReceivePO);
		return (CenterReceiveListPO) client.getResponse();
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
		client=MainController.getClient();
		lobbyReceivePO.setKey("Save");
		System.out.println("begin save");
		client.writeReceipt(lobbyReceivePO);
		System.out.println("save success");
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
