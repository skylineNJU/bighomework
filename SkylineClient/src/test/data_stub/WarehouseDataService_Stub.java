package test.data_stub;

import java.util.ArrayList;

import main.dataservice.WarehouseDataService;
import main.po.InventoryList;
import main.po.InventoryPO;
import main.po.Message;
import main.po.WarehouseInList;
import main.po.WarehouseInPO;
import main.po.WarehouseOutList;
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
		InventoryPO inventoryPO = new InventoryPO(10, 6, warehouseNumber, "���", "B", 1, 3, 4, "�Ϻ�", "2016/01/01");
		inventoryPOList.add(inventoryPO);
		System.out.println("Succeed!/n");
		return true;
		
	}

	@Override
	public boolean createWarehouseInReceipt(WarehouseInPO warehouseInPO) {
		// TODO Auto-generated method stub
		if(warehouseInPO!=null){
		return true;
	}
		else return false;
	}

	@Override
	public boolean createWarehouseOutReceipt(WarehouseOutPO warehouseOutPO) {
		// TODO Auto-generated method stub
		if(warehouseOutPO!=null){
			return true;
		}
			else return false;
	}

	@Override
	public InventoryList inquireInventory(InventoryList Inventorylist) {
		// TODO Auto-generated method stub
		InventoryPO inventory = new InventoryPO(10, 6, "1231313", "���", "B", 1, 3, 4, "�Ϻ�", "2016/01/01");
		Inventorylist.add(inventory);
		return Inventorylist;
	}

	@Override
	public WarehouseInList inquireWarehouseIn(WarehouseInList warehouseInList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WarehouseOutList inquireWarehouseOut(
			WarehouseOutList warehouseOutList) {
		// TODO Auto-generated method stub
		return null;
	}
}
