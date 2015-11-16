package businesslogic.distributebl.distributeTest;

import java.util.ArrayList;

import vo.DistributeVO;
import vo.RecipientVO;
import businesslogic.distributebl.DistributeController;
import businesslogic.distributebl.DistributeList;
import businesslogic.distributebl.ReceiveMessage;

public class MockDistribute extends DistributeController {
	
	public boolean showDistributeList(ArrayList<DistributeVO> distributeList) {
		DistributeVO distributeVO = new DistributeVO("123456", "증합", "켓쑴", "12345678", "12356");
		distributeList.clear();
		distributeList.set(0, distributeVO);
		return false;
	}

	public boolean writeReceiveMessage(RecipientVO recipient) {
		recipient.write("1355", "2015/02/15", "13165", "증합", "153165");
		return false;
	}
}
