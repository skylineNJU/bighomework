package logicservice;

import vo.InventoryVO;
import vo.WarehouseInVO;
import vo.WarehouseOutVO;

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
	public WarehouseOutVO WarehouseOut(String code,String date,String to,int transport,String TransitCode);
	
	/*
	 * ϵͳ��ʾ�����Ϣ
	 */
	
	public InventoryVO shouInventory();
}
