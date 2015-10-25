package dataservice;

import java.util.List;

import po.PlaneLoadingPO;
import po.TrainLoadingPO;
import po.VehicleLoadingPO;
import State.LoadType;

/**
 * װ����Ϣ�Ĳ����ӿ�
 * @author zengpan
 * order��ʾ��ݵ���
 */
public interface LoadDataService {
	
	//��дװ�˱����ݿ�
	//centerNumber��ʾ��������ת����
	public boolean writeVehicleLoadBase(List<VehicleLoadingPO> loadList,String centerNumber);
	
	//�����ݿ��ȡװ����Ϣ  LoadList��װ����Ϣ
	public List<VehicleLoadingPO> readVehicleLoadBase();
	
	//ɾ�����ݿ����װ����Ϣ  loadListΪҪɾ����װ����Ϣ
	public boolean delVehicleLoadBase(List<VehicleLoadingPO> loadList);
	
	public boolean writeTrainLoadBase(List<TrainLoadingPO> loadList,String centerNumber);
	
	//�����ݿ��ȡװ����Ϣ  LoadList��װ����Ϣ
	public List<TrainLoadingPO> readTrainLoadBase();
	
	//ɾ�����ݿ����װ����Ϣ  loadListΪҪɾ����װ����Ϣ
	public boolean delTrainLoadBase(List<TrainLoadingPO> loadList);
	
	
	public boolean writePlaneLoadBase(List<PlaneLoadingPO> loadList,String centerNumber);
	
	//�����ݿ��ȡװ����Ϣ  LoadList��װ����Ϣ
	public List<PlaneLoadingPO> readPlaneLoadBase();
	
	//ɾ�����ݿ����װ����Ϣ  loadListΪҪɾ����װ����Ϣ
	public boolean delPlaneLoadBase(List<PlaneLoadingPO> loadList);
}
