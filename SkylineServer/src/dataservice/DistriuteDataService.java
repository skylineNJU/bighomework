package dataservice;

import java.util.List;

import po.OrderPO;
import po.ReceivePO;

//任务分配
public interface DistriuteDataService {
	
    //存储快递员的任务
	//account是快递员的账户，list表示该快递员的配送任务
	public boolean saveTask(List<OrderPO> orderpo);
	
	//输入快递员的账户
	//数据库返回其需要分配的订单
	public List<OrderPO> lookTask(String[] code);
	
	//增加收件信息
	//数据库保存其订单信息
	public void inputOrder(ReceivePO receivePO);
	
}
