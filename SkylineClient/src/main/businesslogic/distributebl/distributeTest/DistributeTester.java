package main.businesslogic.distributebl.distributeTest;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import main.vo.DistributeVO;
import main.vo.RecipientVO;



public class DistributeTester{
	
	public boolean testshowDistributeList(ArrayList<DistributeVO> distributeList) {
		MockDistributeList distributeArrayList = new MockDistributeList();
		distributeArrayList.writeDistribute(distributeList);
		assertEquals("123456",distributeList.get(0).getOrderCode());
		return true;
	}

	public boolean testwriteReceiveMessage(RecipientVO recipient) {
		
		MockReceiveMessage receive = new MockReceiveMessage();
		receive.writeReceviceMessage(recipient);
		assertEquals(true,receive.writeReceviceMessage(recipient));
		return true;
	}
}
