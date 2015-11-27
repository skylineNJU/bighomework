package main.businesslogicservice;

import java.util.ArrayList;

import main.vo.DriverVO;
import main.vo.InstitutionVO;
import main.vo.StaffVO;
import main.vo.VehicleVO;

public interface InfoBLService {
	//�½�һ���������������������ƣ�����λ�ã���ţ�ϵͳ��ʾ�û�����Ϣ
	public boolean createNewInstitution(InstitutionVO institutionInfo);
	
	//ɾ��һ����Ϣ��ϵͳ��ʾɾ���ɹ�
	public boolean deleteInstitution(String insititutionCode);
	
	//��ѯ���������������ţ�ϵͳ��ʾ������Ϣ
	public boolean inquireInstitution(String code,InstitutionVO institutionInfo);
	
	//�޸Ļ�����ϵͳ��ʾ�����޸ĺ����Ϣ
	public boolean modifyInstitution(InstitutionVO institutionInfo);
	
	//�½�ְ������������ְ�����ƣ�ְλ�����ڵ�λ��ְ�������Լ���ţ�ϵͳ��ʾ������ְ����Ϣ
	public boolean createNewStaff(StaffVO staffInfo);
	
	//ɾ��һ��ְ����Ϣ��ϵͳ��ʾɾ���ɹ�
	public boolean deleteStaff(String staffCode);
	
	
	//�޸�ְ����Ϣ��ϵͳ��ʾ�޸ĺ��ְ����Ϣ
	public boolean modifyStaff(StaffVO staffInfo);
	
	//��������Ϣ�����복�ƺţ�name�����������ţ�code�����Լ�����ʱ��
	public boolean createNewVehicle(VehicleVO vehicleInfo);
	
	//ɾ��������Ϣ��ϵͳ��ʾɾ���ɹ�
	public boolean deleteVehicle(String vehicleCode);
	
	//�޸ĳ�����Ϣ��ϵͳ��ʾ�޸ĺ�ĳ�����Ϣ
	public boolean modifyVehicle(VehicleVO vehicleInfo);
	
	//�½�һ��˾����Ϣ������˾����š��������������ڡ����֤�š��ֻ� ���Ա���ʻ֤���ޣ�ϵͳ��ʾ˾����Ϣ
	public boolean createNewDriver(DriverVO driverInfo);
	
	//ɾ��˾����Ϣ��ϵͳ��ʾɾ���ɹ�
	public boolean deleteDriver(String driverCode);
	
	//��ѯ˾����Ϣ������˾����ţ�ϵͳ��ʾ˾����Ϣ
	
	//�޸�˾����Ϣ��ϵͳ��ʾ�޸ĺ��˾����Ϣ
	public boolean modifyDriver(DriverVO driverInfo);

	ArrayList<DriverVO> inquireDriver(String code);

	StaffVO inquireStaff(String staffCode);

	ArrayList<VehicleVO> inquireVehicle(String code);
}
