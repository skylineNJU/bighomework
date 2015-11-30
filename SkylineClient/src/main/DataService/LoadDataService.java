package main.dataservice;

import java.util.List;

import main.po.LoadingInfoPO;
import main.po.LobbyLoadingList;
import main.po.PlaneLoadingPO;
import main.po.TrainLoadingPO;
import main.po.VehicleLoadingPO;
import main.vo.PlaneLoadingVO;
import main.vo.TrainLoadingVO;

/**
 * װ����Ϣ�Ĳ����ӿ�
 * @author zengpan
 * order��ʾ��ݵ���
 */
public interface LoadDataService {
	
	//��дװ�˱����ݿ�
	//centerNumber��ʾ��������ת����
	public boolean writeVehicleLoadBase(VehicleLoadingPO po);
	
	//�����ݿ��ȡװ����Ϣ  LoadList��װ����Ϣ
	public boolean readVehicleLoadBase(List<VehicleLoadingPO> vehicleLoadingPOList);
	
	//ɾ�����ݿ����װ����Ϣ  loadListΪҪɾ����װ����Ϣ
	public boolean delVehicleLoadBase(List<VehicleLoadingPO> loadList);
	
	public boolean writeTrainLoadBase(TrainLoadingPO po);
	
	//�����ݿ��ȡװ����Ϣ  LoadList��װ����Ϣ
	public boolean readTrainLoadBase(List<TrainLoadingPO> trainLoadingPOList);
	
	//ɾ�����ݿ����װ����Ϣ  loadListΪҪɾ����װ����Ϣ
	public boolean delTrainLoadBase(List<TrainLoadingPO> loadList);
	
	
	public boolean writePlaneLoadBase(PlaneLoadingPO po);
	
	//�����ݿ��ȡװ����Ϣ  LoadList��װ����Ϣ
	public boolean readPlaneLoadBase(List<PlaneLoadingPO> planeLoadingPOList);
	
	//ɾ�����ݿ����װ����Ϣ  loadListΪҪɾ����װ����Ϣ
	public boolean delPlaneLoadBase(List<PlaneLoadingPO> loadList);
	
	public boolean saveLobbyLoadingReceipt(LoadingInfoPO po);
	
	public LobbyLoadingList inquireLobbyLoadList(LobbyLoadingList po);
	
}
