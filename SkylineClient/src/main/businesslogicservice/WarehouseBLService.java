package main.businesslogicservice;

import java.util.ArrayList;

import main.po.DriverList;
import main.po.InventoryList;
import main.vo.DriverVO;
import main.vo.InventoryVO;
import main.vo.WarehouseInVO;
import main.vo.WarehouseOutVO;


public interface WarehouseBLService {
	/*仓库管理人员输入
	 * 快递编号、入库日期、目的地、区号、排号、架号、位号
	 * 系统显示入库单
	 */
	public boolean WarehouseIn(WarehouseInVO warehouseInInfo);
	
	/*
	 * 仓库管理人员输入
	 * 快递编号、出库日期、目的地、装运形式（火车、飞机、汽车）、中转单编号或者汽运编号
	 * 系统显示出库单
	 */
	public boolean WarehouseOut(WarehouseOutVO warehouseOutInfo);
	
	/*
	 * 系统显示库存信息
	 */
	//库存查看 
	public boolean showInventory(String startdate,String enddate,InventoryVO inventoryInfo);
	ArrayList<WarehouseInVO> showWarehouseInInfo(String code);
	ArrayList<WarehouseOutVO> showWarehouseOutInfo(String code);
	
	//库存盘点 通过入库单得到
	ArrayList<InventoryVO> checkInventory(String code);
	
	
	
}
