package main.businesslogicservice.receiptblService;

import main.vo.WarhouseReceiptVO;

public interface WarehouseReceipt {
	public void saveWarehouseInCode(String code,String username);
	public void saveWarehouseOutCode(String code,String username);
	public WarhouseReceiptVO inquireWarehouseReceipt(WarhouseReceiptVO vo);
	
}
