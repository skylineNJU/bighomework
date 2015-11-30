package main.dataservice;

import java.util.ArrayList;
import java.util.List;

import main.po.DistributePOList;
import main.po.OrderPO;
import main.po.ReceivePO;
import main.vo.DistributeVO;

//�������
public interface DistributeDataService {
	
    //�洢���Ա������
	//account�ǿ��Ա���˻���list��ʾ�ÿ��Ա����������
	public boolean saveTask(List<OrderPO> orderpo);
	
	//������Ա���˻�
	//���ݿⷵ������Ҫ����Ķ���
	public DistributePOList lookTask(String code);
	
	//�����ռ���Ϣ
	//���ݿⱣ���䶩����Ϣ
	public boolean inputOrder(ReceivePO receivePO);
	
}
