package main.businesslogic.receivebl;

import java.util.ArrayList;

import main.data.receive.ReceiveDataController;
import main.dataservice.ReceiveDataService;
import main.po.CenterReceiveListPO;
import main.po.CenterReceivePO;
import main.vo.TransitReceptionVO;

public class TransitListBL {
	private CenterReceiveListPO poList;
	public TransitListBL(String codes){
		poList=new CenterReceiveListPO(codes);
	}
	
	public ArrayList<TransitReceptionVO> inquire(){
		ArrayList<TransitReceptionVO> voList=new ArrayList<TransitReceptionVO>();
		ReceiveDataService service=new ReceiveDataController();
		poList=service.readCenterOrder(poList);
		ArrayList<CenterReceivePO> p=poList.getList();
		for(CenterReceivePO po:p){
			TransitReceptionVO vo=new TransitReceptionVO(
					po.getReceiveYear(),
					po.getReceiveMonth(),
					po.getReceiveDay(),
					po.getCenterNumber(),
					po.getBar(),
					po.getCode());
		
			voList.add(vo);
		}
		return voList;
	}
}
