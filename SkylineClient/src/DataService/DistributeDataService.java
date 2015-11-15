package dataservice;

import java.util.List;

import po.OrderPO;
import po.ReceivePO;

//任务分配
public interface DistributeDataService {
	
    //存储快递员的任务
	//account是快递员的账户，list表示该快递员的配送任务
	public boolean saveTask(List<OrderPO> orderpo);
	
	//输入快递员的账户
	//数据库返回其需要分配的订单
	public boolean lookTask(String[] code,List<OrderPO> orderPO);
	
	//增加收件信息
	//数据库保存其订单信息
	public boolean inputOrder(ReceivePO receivePO);
	
}
