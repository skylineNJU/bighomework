package businesslogic.distributebl;

import java.util.ArrayList;

import businesslogicservice.DistributeBLService;
import vo.DistributeVO;
import vo.RecipientVO;

public class DistributeController implements DistributeBLService{

	//ÎªArrayList<DistributeVO>¸³Öµ
	public boolean showDistributeList(ArrayList<DistributeVO> distributeList) {
		DistributeList distribute = new DistributeList();
		distribute.writeDistribute(distributeList);
		return false;
	}

	@Override
	public boolean writeReceiveMessage(RecipientVO recipient) {
		ReceiveMessage receiveMessage = new ReceiveMessage();
		receiveMessage.writeReceviceMessage(recipient);
		return false;
	}
}
