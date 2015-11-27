package main.businesslogicservice.receiptblService;

import main.vo.IntermediateReciptVO;

public interface IntermediateReceipt {
	public void saveIntermReceiptCode(String userName,String code);
	public void saveAirLoadCode(String userName,String code);
	public void saveRoadLoadCode(String userName,String code);
	public void saveRailLoadCode(String userName,String code);
	public IntermediateReciptVO getIntermediateReceiptCode(String userName);
}
