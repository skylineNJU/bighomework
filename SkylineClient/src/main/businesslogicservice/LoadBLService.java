package main.businesslogicservice;

import java.util.ArrayList;

import main.vo.LobbyLoading;
import main.vo.PlaneLoadingVO;
import main.vo.TrainLoadingVO;
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
	
	public boolean loadCar(VehicleLoadingVO vo);
	
	public boolean loadTrain(TrainLoadingVO vo);
	
	public boolean loadPlane(PlaneLoadingVO vo);
	
	public ArrayList<LobbyLoading> inquireLoadVehicle(String codeList);
	
	public ArrayList<PlaneLoadingVO> inquireLoadPlane(String codeList);
	
}
