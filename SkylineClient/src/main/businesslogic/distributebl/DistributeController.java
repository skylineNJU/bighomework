package main.businesslogic.distributebl;

import java.util.ArrayList;

import main.businesslogicservice.DistributeBLService;
import main.vo.DistributeVO;
import main.vo.RecipientVO;

public class DistributeController implements DistributeBLService{

	//ÎªArrayList<DistributeVO>¸³Öµ
	@Override
	public ArrayList<DistributeVO> showDistributeList(String courierCode) {
		return new DistributeList().readDistribute(courierCode);
	}
	
	@Override
	public boolean writeDistributeList(ArrayList<DistributeVO> voList){
		return new DistributeList().writeDistribute(voList);
	}
	@Override
	public boolean writeReceiveMessage(RecipientVO recipient) {
		return new ReceiveMessage().writeReceviceMessage(recipient);
	}
}
