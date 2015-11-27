package main.dataservice.receiptdataservice;

import main.po.LobbyReceiptPO;

public interface LobbyReceiptDataService {
	public void  saveLobbyCode(LobbyReceiptPO po);
	public LobbyReceiptPO inquireLobbyReceipt(LobbyReceiptPO po);
}
