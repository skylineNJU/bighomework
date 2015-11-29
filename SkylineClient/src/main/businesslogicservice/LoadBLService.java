package main.businesslogicservice;

import main.vo.LobbyLoading;
import main.vo.TransVO;
import main.vo.VehicleLoadingVO;

public interface LoadBLService {
	/*Ӫҵ��ҵ��Ա
	 * ��¼װ�����ڡ���Ӫҵ�����˱�š������ء�����ء���װԱ��Ѻ��Ա������װ���������˵��š��˷�
	 * ϵͳ��ʾ����װ����
	 */
	
	public boolean loadVehicle(LobbyLoading vehicleLoadingInfo);
	
	/*
	 * ��ת���Ĺ���Ա
	 * ��¼װ�����ڡ�����ת���������š������ؾߺš������ء�����ء�����(���ᣬ����Ϊnull)�š���װԱ������װ���������˵��š��˷�
	 * ϵͳ��ʾװ�˵������䷽ʽ��type������
	 */
	
	public boolean intermidateLoading(TransVO transInfo);
	
}
