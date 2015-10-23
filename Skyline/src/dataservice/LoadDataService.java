package dataservice;

import java.util.List;

import po.PlaneLoadingPO;
import po.TrainLoadingPO;
import po.VehicleLoadingPO;
import State.LoadType;

/**
 * 装运信息的操作接口
 * @author zengpan
 * order表示快递单号
 */
public interface LoadDataService {
	
	//填写装运表到数据库
	//centerNumber表示出发的中转中心
	public void writeVehicleLoadBase(List<VehicleLoadingPO> loadList,String centerNumber);
	
	//从数据库读取装运信息  LoadList是装运信息
	public List<VehicleLoadingPO> readVehicleLoadBase();
	
	//删除数据库里的装运信息  loadList为要删除的装运信息
	public void delVehicleLoadBase(List<VehicleLoadingPO> loadList);
	
	public void writeTrainLoadBase(List<TrainLoadingPO> loadList,String centerNumber);
	
	//从数据库读取装运信息  LoadList是装运信息
	public List<TrainLoadingPO> readTrainLoadBase();
	
	//删除数据库里的装运信息  loadList为要删除的装运信息
	public void delTrainLoadBase(List<TrainLoadingPO> loadList);
	
	
	public void writePlaneLoadBase(List<PlaneLoadingPO> loadList,String centerNumber);
	
	//从数据库读取装运信息  LoadList是装运信息
	public List<PlaneLoadingPO> readPlaneLoadBase();
	
	//删除数据库里的装运信息  loadList为要删除的装运信息
	public void delPlaneLoadBase(List<PlaneLoadingPO> loadList);
}
