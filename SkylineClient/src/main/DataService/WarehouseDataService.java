package main.dataservice;

import java.util.ArrayList;

import main.po.InventoryList;
import main.po.InventoryPO;
import main.po.WarehouseInList;
import main.po.WarehouseInPO;
import main.po.WarehouseOutList;
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
	public boolean readWarehouse(String warehouseNumber,ArrayList<InventoryPO> inventoryPOList);

	public boolean createWarehouseInReceipt(WarehouseInPO warehouseInPO);
	
	public boolean createWarehouseOutReceipt(WarehouseOutPO warehouseOutPO);

	//��ѯ������Ϣ�����붩����
	public InventoryList inquireInventory(InventoryList Inventorylist);
		
	public WarehouseInList inquireWarehouseIn(WarehouseInList warehouseInList);
	
	public WarehouseOutList inquireWarehouseOut(WarehouseOutList warehouseOutList);
	
}
