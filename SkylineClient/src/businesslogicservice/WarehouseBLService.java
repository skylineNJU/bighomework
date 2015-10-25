package businesslogicservice;

import vo.InventoryVO;
import vo.WarehouseInVO;
import vo.WarehouseOutVO;
import vo.WarehouseOutVO.Type;

public interface WarehouseBLService {
	/*�ֿ������Ա����
	 * ��ݱ�š�������ڡ�Ŀ�ĵء����š��źš��ܺš�λ��
	 * ϵͳ��ʾ��ⵥ
	 */
	public WarehouseInVO WarehouseIn(String code,String date,String to,char area,int row,int shelf,int position);
	
	/*
	 * �ֿ������Ա����
	 * ��ݱ�š��������ڡ�Ŀ�ĵء�װ����ʽ���𳵡��ɻ�������������ת����Ż������˱��
	 * ϵͳ��ʾ���ⵥ
	 */
	public WarehouseOutVO WarehouseOut(String code,String date,String to,Type transport,String TransitCode,String vehicleCode);
	
	/*
	 * ϵͳ��ʾ�����Ϣ
	 */
	
	public InventoryVO showInventory(int inNum, int outNum, String orderCode, String damageCondition,char area,int row,int shelf,int position,String destination,String arriveDate);
}
