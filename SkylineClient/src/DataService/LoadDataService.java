package dataservice;

import java.util.List;

import po.PlaneLoadingPO;
import po.TrainLoadingPO;
import po.VehicleLoadingPO;

/**
 * 装运信息的操作接口
 * @author zengpan
 * order表示快递单号
 */
public interface LoadDataService {
	
	//填写装运表到数据库
	//centerNumber表示出发的中转中心
	public boolean writeVehicleLoadBase(List<VehicleLoadingPO> loadList,String centerNumber);
	
	//从数据库读取装运信息  LoadList是装运信息
	public boolean readVehicleLoadBase(List<VehicleLoadingPO> vehicleLoadingPOList);
	
	//删除数据库里的装运信息  loadList为要删除的装运信息
	public boolean delVehicleLoadBase(List<VehicleLoadingPO> loadList);
	
	public boolean writeTrainLoadBase(List<TrainLoadingPO> loadList,String centerNumber);
	
	//从数据库读取装运信息  LoadList是装运信息
	public boolean readTrainLoadBase(List<TrainLoadingPO> trainLoadingPOList);
	
	//删除数据库里的装运信息  loadList为要删除的装运信息
	public boolean delTrainLoadBase(List<TrainLoadingPO> loadList);
	
	
	public boolean writePlaneLoadBase(List<PlaneLoadingPO> loadList,String centerNumber);
	
	//从数据库读取装运信息  LoadList是装运信息
	public boolean readPlaneLoadBase(List<PlaneLoadingPO> planeLoadingPOList);
	
	//删除数据库里的装运信息  loadList为要删除的装运信息
	public boolean delPlaneLoadBase(List<PlaneLoadingPO> loadList);
}
