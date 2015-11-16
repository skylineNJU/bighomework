package main.DataService;

import java.util.List;

import main.po.PlaneLoadingPO;
import main.po.TrainLoadingPO;
import main.po.VehicleLoadingPO;

/**
 * װ����Ϣ�Ĳ����ӿ�
 * @author zengpan
 * order��ʾ��ݵ���
 */
public interface LoadDataService {
	
	//��дװ�˱������ݿ�
	//centerNumber��ʾ��������ת����
	public boolean writeVehicleLoadBase(List<VehicleLoadingPO> loadList,String centerNumber);
	
	//�����ݿ��ȡװ����Ϣ  LoadList��װ����Ϣ
	public boolean readVehicleLoadBase(List<VehicleLoadingPO> vehicleLoadingPOList);
	
	//ɾ�����ݿ����װ����Ϣ  loadListΪҪɾ����װ����Ϣ
	public boolean delVehicleLoadBase(List<VehicleLoadingPO> loadList);
	
	public boolean writeTrainLoadBase(List<TrainLoadingPO> loadList,String centerNumber);
	
	//�����ݿ��ȡװ����Ϣ  LoadList��װ����Ϣ
	public boolean readTrainLoadBase(List<TrainLoadingPO> trainLoadingPOList);
	
	//ɾ�����ݿ����װ����Ϣ  loadListΪҪɾ����װ����Ϣ
	public boolean delTrainLoadBase(List<TrainLoadingPO> loadList);
	
	
	public boolean writePlaneLoadBase(List<PlaneLoadingPO> loadList,String centerNumber);
	
	//�����ݿ��ȡװ����Ϣ  LoadList��װ����Ϣ
	public boolean readPlaneLoadBase(List<PlaneLoadingPO> planeLoadingPOList);
	
	//ɾ�����ݿ����װ����Ϣ  loadListΪҪɾ����װ����Ϣ
	public boolean delPlaneLoadBase(List<PlaneLoadingPO> loadList);
}