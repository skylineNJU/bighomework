package test.data_stub;

import java.util.ArrayList;

import main.dataservice.WarehouseDataService;
import main.po.InventoryPO;
import main.po.WarehouseInPO;
import main.po.WarehouseOutPO;


public class WarehouseDataService_Stub implements WarehouseDataService{
	
	//入库时，系统需要将入库的订单号保存至相应仓库的数据库
	public boolean storage(WarehouseInPO warehouseInPO){
		System.out.println("write Succeed!/n");
		return true;
	}
	
	//出库 storageOrder表示入库的订单订单，warehouseNumber表示仓库编号
	//需将仓库的数据库中的订单号读取出来并删除
	public boolean outWarehouse(WarehouseOutPO warehouseOutPO){
		System.out.println("out Succeed!/n");
		return true;
	}
	
	//将相应仓库里的订单号全部读取出来 
	//warehouseNumber表示仓库编号
	public boolean readWarehouse(String warehouseNumber,ArrayList<InventoryPO> inventoryPOList){
		InventoryPO inventoryPO = new InventoryPO(10, 5, "6767676767", "如此厚颜无耻之徒", 'A',10, 5, 6, warehouseNumber, warehouseNumber);
		inventoryPOList.add(inventoryPO);
		System.out.println("Succeed!/n");
		return true;
		
	}
}
