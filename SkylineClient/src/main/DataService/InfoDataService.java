package main.dataservice;

import main.po.DriverInfoPO;
import main.po.DriverList;
import main.po.IntermediateInfo;
import main.po.LobbyInfo;
import main.po.LobbyInfoList;
import main.po.StaffListPO;
import main.po.VehicleInfoPO;
import main.po.VehicleListPO;
import main.po.WarehouseInfo;
import main.po.WorkerPO;

	//��������
	//��Ա����
	//������Ϣ����
	//��ʻԱ��Ϣ����
public interface InfoDataService {
	
	public StaffListPO readStaff(String unitCode);
	
	//�����ݿ������ȡĳ���Ļ�����Ϣ
	//category Ϊ���������
	public boolean addLobby(LobbyInfo po);
	
	public LobbyInfoList inquireLobby(LobbyInfoList po);
	
	public IntermediateInfo inquireInterm(IntermediateInfo po);
	//����ĳ���Ļ���
	//�½�һ���������������������ƣ�����λ�ã����
	//���ݿ�洢�û�����Ϣ
	public boolean addIntermediate(IntermediateInfo po);
	
	public boolean addWarehouse(WarehouseInfo po);
	
	//ɾ��ĳ����
	//��������ı��룬���ݿ⽫ɾ���û���
	public boolean modifyIntermediate(IntermediateInfo po);
	
	public boolean modifyLobby(LobbyInfo po);
	
	public boolean deleteIntermediate(IntermediateInfo po);
	
	public boolean deleteLobby(LobbyInfo po);
	
	public boolean deleteWarehouse(WarehouseInfo po);
	
	
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
	public boolean deleteVehicle(VehicleInfoPO po);
		
	
	//�޸ĳ�����Ϣ
	public boolean modifyVehicle(VehicleInfoPO vehicleInfoPO);
		
	//�½�һ��˾����Ϣ������˾����š��������������ڡ����֤�š��ֻ� ���Ա���ʻ֤����
	public boolean createNewDriver(DriverInfoPO driveInfoPO);
		
	//ɾ��˾����Ϣ
	public boolean deleteDriver(DriverInfoPO po);
		
	//��ѯ˾����Ϣ������˾�����
	public DriverList inquireDriver(DriverList driverlist);
		
	//�޸�˾����Ϣ
	public boolean modifyDriver(DriverInfoPO driveInfoPO);

	public WorkerPO inquireStaff(WorkerPO workerPO);

	public VehicleListPO readVehicle(VehicleListPO vehiclelist);


}
