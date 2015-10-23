package dataservice;

import java.util.List;

import State.LoadType;

/**
 * 装运信息的操作接口
 * @author zengpan
 * order表示快递单号
 */
public interface LoadDataService {
	
	//填写装运表到数据库
	//loadType是枚举类型，即装运的类型 火车、汽车、飞机
	//centerNumber表示出发的中转中心
	public void writeLoadBase(List<order> loadList,LoadType loadType,String centerNumber);
	
	//从数据库读取装运信息  LoadList是装运信息
	public List<order> readLoadBase();
	
	//删除数据库里的装运信息  loadList为要删除的装运信息
	public void delLoadBase(List<order> loadList);
}
