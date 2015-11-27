package main.dataservice.receiptdataservice;

import main.po.CourrierReceiptPO;

public interface CourrierReceiptDataService {
	public void saveCodes(CourrierReceiptPO po);
	public CourrierReceiptPO inquireCourrierCodes(CourrierReceiptPO po);
}
