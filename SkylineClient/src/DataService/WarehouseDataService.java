package DataService;

//仓库
public interface WarehouseDataService {
	
	//入库 storageOrder表示入库的订单订单，warehouseNumber表示仓库编号
	//入库时，系统需要将入库的订单号保存至相应仓库的数据库
	public void storage(order storageOrder,String warehouseNumber);
	
	//出库 storageOrder表示入库的订单订单，warehouseNumber表示仓库编号
	//需将仓库的数据库中的订单号读取出来并删除
	public order outWarehouse(order storageOrder,String warehouseNumber);
	
	//将相应仓库里的订单号全部读取出来 
	//warehouseNumber表示仓库编号
	public order readWarehouse(String warehouseNumber);
}
