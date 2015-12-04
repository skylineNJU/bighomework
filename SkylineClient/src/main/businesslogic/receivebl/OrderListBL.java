package main.businesslogic.receivebl;

import java.util.ArrayList;

import main.data.receive.ReceiveDataController;
import main.dataservice.ReceiveDataService;
import main.po.OrderListPO;
import main.po.OrderPO;
import main.vo.OrderVO;

public class OrderListBL {
	private OrderListPO poList;
	public OrderListBL(String codes){
		poList=new OrderListPO(codes);
	}
	
	public ArrayList<OrderVO> inquire(){
		ArrayList<OrderVO> voList=new ArrayList<OrderVO>();
		ReceiveDataService service=new ReceiveDataController();
		poList=service.readOrder(poList);
		ArrayList<OrderPO> p=poList.getPoList();
		for(OrderPO po:p){
			OrderVO vo=new OrderVO(
					po.getCode(),
					po.getSenderName(),
					po.getSenderAddress(),
					po.getSenderCom(),
					po.getSenderMobile(),
					po.getReceivorName(),
					po.getReceivorAddress(),
					po.getReceivorCom(),
					po.getReceivorMobile(),
					po.getNum(),
					po.getSum(),
					po.getPackageCost(),
					po.getOrderType(),
					po.getSize(),
					po.getCargoName(),
					po.getWeight(),
					po.getVolume());
			vo.setOrderCode(po.getOrderCode());
			voList.add(vo);
		}
		return voList;
	}
}
