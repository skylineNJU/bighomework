package main.businesslogic.distributebl;

import java.util.ArrayList;

import main.businesslogicservice.DistributeBLService;
import main.vo.DistributeVO;
import main.vo.RecipientVO;

public class DistributeController implements DistributeBLService{

	//ÎªArrayList<DistributeVO>¸³Öµ
	public boolean showDistributeList(String courierCode) {
		DistributeList distribute = new DistributeList();
		distribute.writeDistribute(courierCode);
		return false;
	}

	@Override
	public boolean writeReceiveMessage(RecipientVO recipient) {
		ReceiveMessage receiveMessage = new ReceiveMessage();
		receiveMessage.writeReceviceMessage(recipient);
		return false;
	}
}
