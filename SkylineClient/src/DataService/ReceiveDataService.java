package dataservice;

//�������
public interface ReceiveDataService {
	
	//�洢�µĶ�����Ϣ
	//��������Ϣ�洢�����ݿ�
	public void writeOrder(orderOP orderop);
	
	//�鿴������Ϣ
	//orderBarΪ����������
	public opderOP readOrder(String orderBar);
	
	//ɾ��������Ϣ
	//orderBar��ʾ����������
	public void delOrder(String orderBar);
	
	//�޸Ķ�����Ϣ
	//orderBar��ʾ����������
	public opderOP modifiyOrder(String orderBar);
	
	//�洢�µ���ת���յ�����Ϣ
	//��������Ϣ�洢�����ݿ�
	public void writeCenterOrder(orderOP orderop);
	
	//�鿴��ת���յ�����Ϣ
	//orderBarΪ����������
	public opderOP readCenterOrder(String orderBar);
	
	//ɾ����ת���յ�����Ϣ
	//orderBar��ʾ����������
	public void delCenterOrder(String orderBar);
	
	//�޸���ת���յ�����Ϣ
	//orderBar��ʾ����������
	public opderOP modifiyCenterOrder(String orderBar);
	
	//�洢�µĽ��յ�����Ϣ
	//��������Ϣ�洢�����ݿ�
	public void writeReceiveOrder(orderOP orderop);
	
	//�鿴���յ�����Ϣ
	//orderBarΪ����������
	public opderOP readReceiveOrder(String orderBar);
	
	//ɾ�����յ�����Ϣ
	//orderBar��ʾ����������
	public void delReceiveOrder(String orderBar);
	
	//�޸Ľ��յ�����Ϣ
	//orderBar��ʾ����������
	public opderOP modifiyReceiveOrder(String orderBar);
	
	//�洢�µ����͵���Ϣ
	//��������Ϣ�洢�����ݿ�
	public void writeReceiveOrder(orderOP orderop);
	
	//�鿴���͵�����Ϣ
	//orderBarΪ����������
	public opderOP readReceiveOrder(String orderBar);
	
	//ɾ�����͵�����Ϣ
	//orderBar��ʾ����������
	public void delReceiveOrder(String orderBar);
	
	//�޸����͵�����Ϣ
	//orderBar��ʾ����������
	public opderOP modifiyReceiveOrder(String orderBar);
	
}
