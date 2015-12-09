package main.businesslogicservice;

import java.util.ArrayList;

import main.vo.DriverVO;
import main.vo.IntermediateInfoVO;
import main.vo.LobbyInfoVO;
import main.vo.StaffVO;
import main.vo.VehicleVO;
import main.vo.WarehouseInfoVO;

public interface InfoBLService {
	//�½�һ���������������������ƣ�����λ�ã���ţ�ϵͳ��ʾ�û�����Ϣ
	public boolean addNewIntermediate(IntermediateInfoVO vo);
	
	public boolean addNewWarehouse(WarehouseInfoVO voList);
	
	public boolean addNewLobby(LobbyInfoVO vo);
	
	public IntermediateInfoVO inquireInterm(String city);
	
	public ArrayList<LobbyInfoVO> inquireLobby(String cityName);
	
	public boolean modifyIntermediate(IntermediateInfoVO vo);
	
	public boolean modifyLobby(LobbyInfoVO vo);
	
	public boolean deleteIntermediate(IntermediateInfoVO vo);
	
	public boolean deleteLobby(LobbyInfoVO vo);
	
	public boolean deleteWarehouse(WarehouseInfoVO vo);
	
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
