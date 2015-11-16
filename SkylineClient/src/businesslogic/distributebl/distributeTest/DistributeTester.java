package businesslogic.distributebl.distributeTest;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import vo.DistributeVO;
import vo.RecipientVO;



public class DistributeTester{
	
	public boolean testshowDistributeList(ArrayList<DistributeVO> distributeList) {
		DistributeVO distributeVO = new DistributeVO("123456", "증합", "켓쑴", "12345678", "12356");
		distributeList.set(0, distributeVO);
		MockDistributeList distributeArrayList = new MockDistributeList();
		distributeArrayList.writeDistribute(distributeList);
		assertEquals("123456",distributeList.get(0).getOrderCode());
		return false;
	}

	public boolean testwriteReceiveMessage(RecipientVO recipient) {
		recipient.write("1355", "2015/02/15", "13165", "증합", "153165");
		MockReceiveMessage receive = new MockReceiveMessage();
		assertEquals(true,receive.writeReceviceMessage(recipient));
		return false;
	}
}
