package test.bl_stub;

import java.util.ArrayList;

import  main.businesslogicservice.InfoBLService;
import  main.vo.DriverVO;
import main.vo.IntermediateInfoVO;
import main.vo.LobbyInfoVO;
import  main.vo.StaffVO;
import  main.vo.VehicleVO;
import main.vo.WarehouseInfoVO;

public class InfoBLService_Stub implements InfoBLService{

	StaffVO staffVO = new StaffVO("�˷���", "���Ա", "10215", "2015/02/13", "2013");
	IntermediateInfoVO intermediateInfoVO = new IntermediateInfoVO("�Ͼ�", "20135", 188.23, 32);
	LobbyInfoVO lobbyInfoVO = new LobbyInfoVO("�Ͼ�", "5659", 36, 1825.48);
	DriverVO driverVO = new DriverVO("���˷�", "2015", "2015/03/04", "251168135165", "10151818186", "��", "18616");
	VehicleVO vehicleVO = new VehicleVO("58685", "486486", "5156", "4516156", "2013/04/15", "3��");
	@Override
	public ArrayList<StaffVO> readStaff(String unitCode) {
		ArrayList<StaffVO> voList = new ArrayList<StaffVO>();
		voList.add(staffVO);
		return voList;
	}

	@Override
	public boolean addNewIntermediate(IntermediateInfoVO vo) {
		System.out.println("������ת���ĳɹ���");
		return true;
	}

	@Override
	public boolean addNewWarehouse(WarehouseInfoVO voList) {
		System.out.println("������ת�ֿ�ɹ���");
		return true;
	}

	@Override
	public boolean addNewLobby(LobbyInfoVO vo) {
		System.out.println("����Ӫҵ���ɹ���");
		return true;
	}

	@Override
	public IntermediateInfoVO inquireInterm(String city) {
		return intermediateInfoVO;
	}

	@Override
	public ArrayList<LobbyInfoVO> inquireLobby(String cityName) {
		ArrayList<LobbyInfoVO> voList = new ArrayList<LobbyInfoVO>();
		voList.add(lobbyInfoVO);
		return voList;
	}

	@Override
	public boolean modifyIntermediate(IntermediateInfoVO vo) {
		System.out.println("�޸���ת���ĳɹ���");
		return true;
	}

	@Override
	public boolean modifyLobby(LobbyInfoVO vo) {
		System.out.println("�޸�Ӫҵ���ɹ���");
		return true;
	}

	@Override
	public boolean deleteIntermediate(IntermediateInfoVO vo) {
		System.out.println("ɾ����ת���ĳɹ���");
		return true;
	}

	@Override
	public boolean deleteLobby(LobbyInfoVO vo) {
		System.out.println("ɾ��Ӫҵ���ɹ���");
		return true;
	}

	@Override
	public boolean deleteWarehouse(WarehouseInfoVO vo) {
		System.out.println("ɾ���ֿ�ɹ���");
		return true;
	}

	@Override
	public boolean createNewStaff(StaffVO staffInfo) {
		System.out.println("����Ա��"+staffInfo.getName()+"�ɹ���");
		return true;
	}

	@Override
	public boolean deleteStaff(String staffCode) {
		System.out.println("ɾ��"+staffCode+"Ա���ɹ���");
		return true;
	}

	@Override
	public boolean modifyStaff(StaffVO staffInfo) {
		System.out.println("�޸�Ա��"+staffInfo.getCode()+"�ɹ���");
		return true;
	}

	@Override
	public boolean createNewVehicle(VehicleVO vehicleInfo) {
		System.out.println("��������"+vehicleInfo.getCarID()+"�ɹ���");
		return true;
	}

	@Override
	public boolean deleteVehicle(String vehicleCode) {
		System.out.println("ɾ��"+vehicleCode+"�ɹ���");
		return true;
	}

	@Override
	public boolean modifyVehicle(VehicleVO vehicleInfo) {
		System.out.println("�޸ĳ���"+vehicleInfo.getCarID()+"�ɹ���");
		return true;
	}

	@Override
	public boolean createNewDriver(DriverVO driverInfo) {
		System.out.println("����˾��"+driverInfo.getCode()+"�ɹ���");
		return true;
	}

	@Override
	public boolean deleteDriver(String driverCode) {
		System.out.println("ɾ��˾��"+driverCode+"�ɹ���");
		return true;
	}

	@Override
	public boolean modifyDriver(DriverVO driverInfo) {
		System.out.println("�޸�˾��"+driverInfo.getCode()+"�ɹ���");
		return true;
	}

	@Override
	public ArrayList<DriverVO> inquireDriver(String code) {
		ArrayList<DriverVO> voList = new ArrayList<DriverVO>();
		voList.add(driverVO);
		return voList;
	}

	@Override
	public ArrayList<VehicleVO> inquireVehicle(String code) {
		ArrayList<VehicleVO> voList = new ArrayList<VehicleVO>();
		voList.add(vehicleVO);
		return voList;
	}

	@Override
	public StaffVO inquireStaff(String staffCode) {
		return staffVO;
	}
	
}
