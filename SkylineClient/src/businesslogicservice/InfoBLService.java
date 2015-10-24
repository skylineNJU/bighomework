package businesslogicservice;

import vo.DriverVO;
import vo.InstitutionVO;
import vo.StaffVO;
import vo.VehicleVO;

public interface InfoBLService {
	//�½�һ���������������������ƣ�����λ�ã���ţ�ϵͳ��ʾ�û�����Ϣ
	public InstitutionVO createNewInstitution(String Category,String name,String position,String code);
	
	//ɾ��һ����Ϣ��ϵͳ��ʾɾ���ɹ�
	public boolean deleteInstitution();
	
	//��ѯ���������������ţ�ϵͳ��ʾ������Ϣ
	public InstitutionVO inquireInstitution(String code);
	
	//�޸Ļ�����ϵͳ��ʾ�����޸ĺ����Ϣ
	public InstitutionVO modifyInstitution(String Category,String name,String position,String code);
	
	//�½�ְ������������ְ�����ƣ�ְλ�����ڵ�λ��ְ�������Լ���ţ�ϵͳ��ʾ������ְ����Ϣ
	public StaffVO createNewStaff(String name,String job,String unit,String workage,String code);
	
	//ɾ��һ��ְ����Ϣ��ϵͳ��ʾɾ���ɹ�
	public boolean deleteStaff();
	
	//��ѯְ��������ְ����ţ�ϵͳ��ʾְ����Ϣ
	public StaffVO inquireStaff(String code);
	
	//�޸�ְ����Ϣ��ϵͳ��ʾ�޸ĺ��ְ����Ϣ
	public StaffVO modifyStaff(String name,String job,String unit,String workage,String code);
	
	//��������Ϣ�����복�ƺţ�name�����������ţ�code�����Լ�����ʱ��
	public VehicleVO createNewVehicle(String name,String code,String age);
	
	//ɾ��������Ϣ��ϵͳ��ʾɾ���ɹ�
	public boolean deleteVehicle();
	
	//��ѯ������Ϣ�����복�����ţ�ϵͳ��ʾ������Ϣ
	public VehicleVO inquireVehicle(String code);
	
	//�޸ĳ�����Ϣ��ϵͳ��ʾ�޸ĺ�ĳ�����Ϣ
	public VehicleVO modifyVehicle(String name,String code,String age);
	
	//�½�һ��˾����Ϣ������˾����š��������������ڡ����֤�š��ֻ� ���Ա���ʻ֤���ޣ�ϵͳ��ʾ˾����Ϣ
	public DriverVO createNewDriver(String name,String code,String age,String IDcode
			,String phoneNumber,String sex,String limit);
	
	//ɾ��˾����Ϣ��ϵͳ��ʾɾ���ɹ�
	public boolean deleteDriver();
	
	//��ѯ˾����Ϣ������˾����ţ�ϵͳ��ʾ˾����Ϣ
	public DriverVO inquireDriver(String code);
	
	//�޸�˾����Ϣ��ϵͳ��ʾ�޸ĺ��˾����Ϣ
	public DriverVO modifyDriver(String name,String code,String age,String IDcode
			,String phoneNumber,String sex,String limit);
}
