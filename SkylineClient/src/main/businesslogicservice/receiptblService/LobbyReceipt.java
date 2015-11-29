package main.businesslogicservice.receiptblService;

import main.vo.LobbyReceiptVO;

public interface LobbyReceipt {
	public void SaveReceiveCode(String userName,String code);
	public void SaveEarnCode(String userName,String code);
	public void SaveLoadingCode(String userName,String code);
	public LobbyReceiptVO getLobbyReceiptCode(String userName);
}
