package test.data_stub;

import java.util.ArrayList;

import main.dataservice.WarehouseDataService;
import main.po.InventoryPO;
import main.po.WarehouseInPO;
import main.po.WarehouseOutPO;


public class WarehouseDataService_Stub implements WarehouseDataService{
	
	//���ʱ��ϵͳ��Ҫ�����Ķ����ű�������Ӧ�ֿ�����ݿ�
	public boolean storage(WarehouseInPO warehouseInPO){
		System.out.println("write Succeed!/n");
		return true;
	}
	
	//���� storageOrder��ʾ���Ķ���������warehouseNumber��ʾ�ֿ���
	//�轫�ֿ�����ݿ��еĶ����Ŷ�ȡ������ɾ��
	public boolean outWarehouse(WarehouseOutPO warehouseOutPO){
		System.out.println("out Succeed!/n");
		return true;
	}
	
	//����Ӧ�ֿ���Ķ�����ȫ����ȡ���� 
	//warehouseNumber��ʾ�ֿ���
	public boolean readWarehouse(String warehouseNumber,ArrayList<InventoryPO> inventoryPOList){
		InventoryPO inventoryPO = new InventoryPO(10, 5, "6767676767", "��˺����޳�֮ͽ", 'A',10, 5, 6, warehouseNumber, warehouseNumber);
		inventoryPOList.add(inventoryPO);
		System.out.println("Succeed!/n");
		return true;
		
	}
}
