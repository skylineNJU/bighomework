package main.dataservice;

import main.po.DriverInfoPO;
import main.po.DriverList;
import main.po.InstitutionPO;
import main.po.VehicleInfoPO;
import main.po.WorkerPO;

	//��������
	//��Ա����
	//������Ϣ����
	//��ʻԱ��Ϣ����
public interface InfoDataService {

	//--------------��������--------------------
	
	//�����ݿ������ȡĳ���Ļ�����Ϣ
	//category Ϊ���������
	public boolean readInstitution(String code,InstitutionPO institutionPO);
	
	//����ĳ���Ļ���
	//�½�һ���������������������ƣ�����λ�ã����
	//���ݿ�洢�û�����Ϣ
	public boolean addInstitution(InstitutionPO institutionPO);
	
	//ɾ��ĳ����
	//��������ı��룬���ݿ⽫ɾ���û���
	public boolean delInstitution(String code);
	
	//�޸�ĳ��������Ϣ����������Ϊ�����޸Ļ����ĵȼ��������ܽ�Ӫҵ����Ϊ��ת���ģ�������Ϣ���޸ģ�
	//String name,String position,String code��ʾҪ�޸ĵĲ��֣�������޸ģ����֮ǰ����Ϣһ��
	public boolean modifyInstitution(InstitutionPO institutionPO);
	
	//�½�ְ������������ְ�����ƣ�ְλ�����ڵ�λ��ְ�������Լ����
	//���ݿ⽫�����Ա����Ϣ
	public boolean createNewStaff(WorkerPO workerPO);
		
	//���ݿ�ɾ����Ա����Ϣ
	//accountΪԱ�����˻�
	public boolean deleteStaff(String account);
		
		
	//�޸�ְ����Ϣ
	//accountΪ��Ա�����˻���account�����Ա��޸�
	//String modifyName,String modifyJob,String modifyUnit,String modifyWorkage��ʾҪ�޸ĵ�����
	public boolean modifyStaff(WorkerPO workerPO);
		
	//������ĳ�����Ϣ���������ݿ⣬���복�ƺţ�name�����������ţ�code�����Լ�����ʱ��
	public boolean createNewVehicle(VehicleInfoPO vehicleInfoPO);
		
	//ɾ��������Ϣ
	//code��ʾ��������
	public boolean deleteVehicle(String code);
		
	//��ѯ������Ϣ�����복������ ���ݿ��в�ѯ�ô��ŵĳ�����Ϣ
	public boolean readVehicle(String code,VehicleInfoPO vehicleInfoPO);
	
	//�޸ĳ�����Ϣ
	public boolean modifyVehicle(VehicleInfoPO vehicleInfoPO);
		
	//�½�һ��˾����Ϣ������˾����š��������������ڡ����֤�š��ֻ� ���Ա���ʻ֤����
	public boolean createNewDriver(DriverInfoPO driveInfoPO);
		
	//ɾ��˾����Ϣ
	public boolean deleteDriver();
		
	//��ѯ˾����Ϣ������˾�����
	public DriverList inquireDriver(DriverList driverlist);
		
	//�޸�˾����Ϣ
	public boolean modifyDriver(DriverInfoPO driveInfoPO);

	WorkerPO inquireStaff(WorkerPO workerPO);
}
