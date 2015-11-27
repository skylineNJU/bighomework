package main.dataservice.receiptdataservice;

import main.po.WarhouseReceiptPO;

public interface WarehouseReceiptDataService {
	public void saveWarehouseReceipt(WarhouseReceiptPO po);
	
	public WarhouseReceiptPO inquireWarehouseReceipt(WarhouseReceiptPO po);
}
