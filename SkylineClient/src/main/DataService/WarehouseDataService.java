package main.dataservice;

import java.util.ArrayList;

import main.po.InventoryList;
import main.po.InventoryPO;
import main.po.WarehouseInList;
import main.po.WarehouseInPO;
import main.po.WarehouseOutList;
import main.po.WarehouseOutPO;

//仓库
public interface WarehouseDataService {
	
	//入库时，系统需要将入库的订单号保存至相应仓库的数据库
	public boolean storage(WarehouseInPO warehouseInPO);
	
	//出库 storageOrder表示入库的订单订单，warehouseNumber表示仓库编号
	//需将仓库的数据库中的订单号读取出来并删除
	public boolean outWarehouse(WarehouseOutPO warehouseOutPO);
	
	//将相应仓库里的订单号全部读取出来 
	//warehouseNumber表示仓库编号
	public boolean readWarehouse(String warehouseNumber,ArrayList<InventoryPO> inventoryPOList);

	public boolean createWarehouseInReceipt(WarehouseInPO warehouseInPO);
	
	public boolean createWarehouseOutReceipt(WarehouseOutPO warehouseOutPO);

	//查询货物信息，输入订单号
	public InventoryList inquireInventory(InventoryList Inventorylist);
		
	public WarehouseInList inquireWarehouseIn(WarehouseInList warehouseInList);
	
	public WarehouseOutList inquireWarehouseOut(WarehouseOutList warehouseOutList);
	
}
