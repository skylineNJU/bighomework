package test.data_stub;

import  main.dataservice.InfoDataService;
import  main.po.DriverInfoPO;
import main.po.DriverList;
import  main.po.InstitutionPO;
import main.po.IntermediateInfo;
import main.po.LobbyInfo;
import main.po.LobbyInfoList;
import main.po.StaffListPO;
import  main.po.VehicleInfoPO;
import main.po.VehicleListPO;
import main.po.WarehouseInfo;
import  main.po.WorkerPO;


public class InfoDataService_Stub implements InfoDataService{
	//--------------��������--------------------
	

	@Override
	public boolean addLobby(LobbyInfo po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LobbyInfoList inquireLobby(LobbyInfoList po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IntermediateInfo inquireInterm(IntermediateInfo po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addIntermediate(IntermediateInfo po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addWarehouse(WarehouseInfo po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyIntermediate(IntermediateInfo po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyLobby(LobbyInfo po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteIntermediate(IntermediateInfo po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLobby(LobbyInfo po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteWarehouse(WarehouseInfo po) {
		// TODO Auto-generated method stub
		return false;
	}
	//�½�ְ������������ְ�����ƣ�ְλ�����ڵ�λ��ְ�������Լ����
	//���ݿ⽫�����Ա����Ϣ
	@Override
	public boolean createNewStaff(WorkerPO workerPO) {
		// TODO Auto-generated method stub
		return false;
	}
	//���ݿ�ɾ����Ա����Ϣ
	//accountΪԱ�����˻�
	@Override
	public boolean deleteStaff(String account) {
		// TODO Auto-generated method stub
		return false;
	}
	//�޸�ְ����Ϣ
	//accountΪ��Ա�����˻���account�����Ա��޸�
	//String modifyName,String modifyJob,String modifyUnit,String modifyWorkage��ʾҪ�޸ĵ�����
	@Override
	public boolean modifyStaff(WorkerPO workerPO) {
		// TODO Auto-generated method stub
		return false;
	}
	//������ĳ�����Ϣ���������ݿ⣬���복�ƺţ�name�����������ţ�code�����Լ�����ʱ��
	@Override
	public boolean createNewVehicle(VehicleInfoPO vehicleInfoPO) {
		// TODO Auto-generated method stub
		return false;
	}
	//ɾ��������Ϣ
	//code��ʾ��������
	@Override
	public boolean deleteVehicle(VehicleInfoPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyVehicle(VehicleInfoPO vehicleInfoPO) {
		// TODO Auto-generated method stub
		return false;
	}
	//�½�һ��˾����Ϣ������˾����š��������������ڡ����֤�š��ֻ� ���Ա���ʻ֤����
	@Override
	public boolean createNewDriver(DriverInfoPO driveInfoPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDriver(DriverInfoPO po) {
		// TODO Auto-generated method stub
		return false;
	}
	//��ѯ˾����Ϣ������˾�����
	@Override
	public DriverList inquireDriver(DriverList driverlist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyDriver(DriverInfoPO driveInfoPO) {
		// TODO Auto-generated method stub
		return false;
	}
	//���ݿⷵ�ظ��˻�����Ϣ
	//accountΪ��Ա�����˻�
	@Override
	public WorkerPO inquireStaff(WorkerPO workerPO) {
		// TODO Auto-generated method stub
		return null;
	}
	//��ѯ������Ϣ�����복������ ���ݿ��в�ѯ�ô��ŵĳ�����Ϣ
	@Override
	public VehicleListPO readVehicle(VehicleListPO vehiclelist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffListPO readStaff(String unitCode) {
		// TODO Auto-generated method stub
		return null;
	}


}
