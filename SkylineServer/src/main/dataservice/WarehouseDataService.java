package main.dataservice;

import main.po.InventoryPO;
import main.po.WarehouseInPO;
import main.po.WarehouseOutPO;

//�ֿ�
public interface WarehouseDataService {
	
	//���ʱ��ϵͳ��Ҫ�����Ķ����ű�������Ӧ�ֿ�����ݿ�
	public boolean storage(WarehouseInPO warehouseInPO);
	
	//���� storageOrder��ʾ���Ķ���������warehouseNumber��ʾ�ֿ���
	//�轫�ֿ�����ݿ��еĶ����Ŷ�ȡ������ɾ��
	public boolean outWarehouse(WarehouseOutPO warehouseOutPO);
	
	//����Ӧ�ֿ���Ķ�����ȫ����ȡ���� 
	//warehouseNumber��ʾ�ֿ���
	public InventoryPO readWarehouse(String warehouseNumber);
}