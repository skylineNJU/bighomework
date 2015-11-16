package main.businesslogic.receiptbl.mocktest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.vo.ReceiptVO;
import main.vo.VehicleLoadingVO;

public class ReceiptControllerTest {

	@Test
	public void testShowReceiptList() {
		ArrayList<ReceiptVO> receiptList=new ArrayList<ReceiptVO>();
		assertEquals(true,new MockReceipt().showReceiptList(receiptList));
		ReceiptVO vo=receiptList.get(0);
		assertEquals("1234123121",vo.getID());
	}
	
	@Test
	public void testApprovalReceipt(){
		ArrayList<ReceiptVO> marked=new ArrayList<ReceiptVO>();
		assertEquals(true,new MockReceipt().ApprovalReceipt(marked));
	}

	@Test
	public void testInquireReceiptList(){
		ArrayList<ReceiptVO> receiptList=new ArrayList<ReceiptVO>();
		assertEquals(true,new MockReceipt().inquireReceiptList(receiptList));
		ReceiptVO vo=receiptList.get(0);
		assertEquals("1234123121",vo.getID());
	}
	
	@Test
	public void testModifyReceipt(){
		String orderCodes[]={
				"1324124123",
				"3241324442"
		};
			ReceiptVO receipt=new VehicleLoadingVO("1234123121","2015-01-01","31223412",
					"12413432","南京栖霞","南京金牛","张三",
					"李四",orderCodes,50);
		assertEquals(true,new MockReceipt().saveRecipt(receipt));
	}
	
	@Test
	public void testSubmitReceipt(){
		String receiptCode="3413513353";
		assertEquals(true,new MockReceipt().submitReciptCode(receiptCode));
	}
	
	@Test
	public void testSave(){
		String receiptCode="3413513353";
		assertEquals(true,new MockReceipt().saveReciptCode(receiptCode));
	}
	
	@Test
	public void testDelet(){
		String receiptCode[]={
				"23413432",
				"13243123",
				"62454324"
		};
		assertEquals(true,new MockReceipt().delete(receiptCode));
	}
}
