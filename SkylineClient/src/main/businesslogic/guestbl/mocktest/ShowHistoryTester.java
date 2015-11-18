package main.businesslogic.guestbl.mocktest;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShowHistoryTester {

	@Test
	public void showHistory() {
		MockHistory his1=new MockHistory("1228853904");
		MockHistory his2=new MockHistory("1412500290");
		assertEquals(true,his1.getHistoryInfo());
		assertEquals(false,his2.getHistoryInfo());
		his1.getHistoryInfo();
		assertEquals("南京市栖霞区营业厅",his1.getArriveIntermediate1());
	}

}
