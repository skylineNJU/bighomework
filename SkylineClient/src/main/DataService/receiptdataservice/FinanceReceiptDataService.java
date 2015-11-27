package main.dataservice.receiptdataservice;

import main.po.FinanceReceipt;

public interface FinanceReceiptDataService {
	public void saveFinanceCodes(FinanceReceipt vo);
	public FinanceReceipt inquireFinanceReceipt(FinanceReceipt vo);
}
