package businesslogic.guestbl.mocktest;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShowHistoryTester {

	@Test
	public void showHistory() {
		MockHistory his1=new MockHistory("1228853904");
		MockHistory his2=new MockHistory("1412500290");
		assertEquals(true,his1);
		assertEquals(false,his2);
		assertEquals("�Ͼ���ѧ��ϼ��Ӫҵ��",his1.getArriveIntermediate1());
	}

}
