package logicservice;

import vo.TransType;
import vo.TransVO;
import vo.VehicleLoadingVO;

public interface LoadBLService {
	/*Ӫҵ��ҵ��Ա
	 * ��¼װ�����ڡ���Ӫҵ�����˱�š������ء�����ء���װԱ��Ѻ��Ա������װ���������˵��š��˷�
	 * ϵͳ��ʾ����װ����
	 */
	
	public VehicleLoadingVO loadVehicle(String  date,String vehiclecode,String from,String to,
			String monitor,String escort,String[] ordercode,double fee);
	
	/*
	 * ��ת���Ĺ���Ա
	 * ��¼װ�����ڡ�����ת���������š������ؾߺš������ء�����ء�����(���ᣬ����Ϊnull)�š���װԱ������װ���������˵��š��˷�
	 * ϵͳ��ʾװ�˵������䷽ʽ��type������
	 */
	
	public TransVO intermidateLoading(TransType type,String Transcode,String Vehiclecode,
			String from,String to,String compartment,String monitor,String[] ordercode);
	
}
