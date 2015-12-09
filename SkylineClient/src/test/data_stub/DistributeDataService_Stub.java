package test.data_stub;

import java.util.ArrayList;
import java.util.List;

import main.dataservice.DistributeDataService;
import main.po.DistributePO;
import main.po.DistributePOList;
import main.po.OrderPO;
import main.po.OrderPO.Size;
import main.po.ReceivePO;

public class DistributeDataService_Stub implements DistributeDataService {
	List<OrderPO> orderlist =new ArrayList<OrderPO>();
	DistributePOList distributeList=new DistributePOList();
	//存储快递员的任务
	//account是快递员的账户，list表示该快递员的配送任务
	@Override
	public boolean saveTask(List<OrderPO> orderpo) {
		// TODO Auto-generated method stub
		System.out.println("------------------Save Success!------------------");
		return true;
	}
	@Override
	public DistributePOList lookTask(String code) {
		// TODO Auto-generated method stub
		OrderPO looktask = new OrderPO("张三","北京市三里屯","无","64227112","13242199875","李四","南京市和园" ,
				"无", null, null, 0, 0, 0, "衣服",Size.small,"0100210001", 8);
		orderlist.clear();
		orderlist.add(looktask);
		return distributeList;
	}

	
	//增加收件信息
	//数据库保存其订单信息
	@Override
	public boolean inputOrder(ReceivePO receivePO) {
		// TODO Auto-generated method stub
		receivePO=new ReceivePO("301280000001","zahngsan","1333333","21555","6666");
		System.out.println("---------------Add Success!---------------");
		System.out.println("---------------Save Success!----------------");
		return true;
	}
	@Override
	public boolean writeDistribute(ArrayList<DistributePO> poList) {
		// TODO Auto-generated method stub
		return false;
	}


}
