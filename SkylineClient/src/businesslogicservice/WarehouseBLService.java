package businesslogicservice;

import vo.InventoryVO;
import vo.WarehouseInVO;
import vo.WarehouseOutVO;
import vo.WarehouseOutVO.Type;

public interface WarehouseBLService {
	/*仓库管理人员输入
	 * 快递编号、入库日期、目的地、区号、排号、架号、位号
	 * 系统显示入库单
	 */
	public WarehouseInVO WarehouseIn(String code,String date,String to,char area,int row,int shelf,int position);
	
	/*
	 * 仓库管理人员输入
	 * 快递编号、出库日期、目的地、装运形式（火车、飞机、汽车）、中转单编号或者汽运编号
	 * 系统显示出库单
	 */
	public WarehouseOutVO WarehouseOut(String code,String date,String to,Type transport,String TransitCode,String vehicleCode);
	
	/*
	 * 系统显示库存信息
	 */
	//库存盘点
	public InventoryVO checkInventory(String startdate,String enddate);
	//库存查看
	public InventoryVO showInventory();
}
