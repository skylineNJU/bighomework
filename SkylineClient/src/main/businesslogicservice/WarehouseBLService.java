package main.businesslogicservice;

import java.util.ArrayList;

import main.po.DriverList;
import main.po.InventoryList;
import main.vo.DriverVO;
import main.vo.InventoryVO;
import main.vo.WarehouseInVO;
import main.vo.WarehouseOutVO;


public interface WarehouseBLService {
	/*�ֿ������Ա����
	 * ��ݱ�š�������ڡ�Ŀ�ĵء����š��źš��ܺš�λ��
	 * ϵͳ��ʾ��ⵥ
	 */
	public boolean WarehouseIn(WarehouseInVO warehouseInInfo);
	
	/*
	 * �ֿ������Ա����
	 * ��ݱ�š��������ڡ�Ŀ�ĵء�װ����ʽ���𳵡��ɻ�������������ת����Ż������˱��
	 * ϵͳ��ʾ���ⵥ
	 */
	public boolean WarehouseOut(WarehouseOutVO warehouseOutInfo);
	
	/*
	 * ϵͳ��ʾ�����Ϣ
	 */
	//���鿴 
	public boolean showInventory(String startdate,String enddate,InventoryVO inventoryInfo);
	ArrayList<WarehouseInVO> showWarehouseInInfo(String code);
	ArrayList<WarehouseOutVO> showWarehouseOutInfo(String code);
	
	//����̵� ͨ����ⵥ�õ�
	ArrayList<InventoryVO> checkInventory(String code);
	
	
	
}
