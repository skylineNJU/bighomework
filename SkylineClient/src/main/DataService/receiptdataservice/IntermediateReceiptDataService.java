package main.dataservice.receiptdataservice;

import main.po.IntermediateReceipt;

public interface IntermediateReceiptDataService {
	public void saveIntermCodes(IntermediateReceipt po);
	
	public IntermediateReceipt inquireIntermCodes(IntermediateReceipt po);
}
