package main.businesslogic.distributebl;

import java.util.ArrayList;

import main.businesslogicservice.DistributeBLService;
import main.po.DistributePO;
import main.vo.DistributeVO;
import main.vo.RecipientVO;

public class DistributeController implements DistributeBLService{

	//ÎªArrayList<DistributeVO>¸³Öµ
	public ArrayList<DistributeVO> showDistributeList(String courierCode) {
		return new DistributeList().readDistribute(courierCode);
	}

	@Override
	public boolean writeReceiveMessage(RecipientVO recipient) {
		ReceiveMessage receiveMessage = new ReceiveMessage();
		receiveMessage.writeReceviceMessage(recipient);
		return false;
	}
}
