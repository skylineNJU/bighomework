package main.dataservice;

import java.util.List;

import main.po.LoadingInfoPO;
import main.po.LobbyLoadingList;
import main.po.PlaneLoadingListPO;
import main.po.PlaneLoadingPO;
import main.po.TrainLoadListPO;
import main.po.TrainLoadingPO;
import main.po.VehicleLoadListPO;
import main.po.VehicleLoadingPO;

/**
 * 装运信息的操作接口
 * @author zengpan
 * order表示快递单号
 */
public interface LoadDataService {

	public boolean writeVehicleLoadBase(VehicleLoadingPO po);
	
	public boolean writeTrainLoadBase(TrainLoadingPO po);
	
	public boolean writePlaneLoadBase(PlaneLoadingPO po);
		
	public boolean saveLobbyLoadingReceipt(LoadingInfoPO po);
	
	public LobbyLoadingList inquireLobbyLoadList(LobbyLoadingList po);
	
	public PlaneLoadingListPO inquirePlaneLoadList(PlaneLoadingListPO po);
	
	public TrainLoadListPO inquireTrainLoadList(TrainLoadListPO po);
	
	public VehicleLoadListPO inquireVehicleLoadList(VehicleLoadListPO po);
}
