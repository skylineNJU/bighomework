package main.data.receipt;

import main.dataservice.receiptdataservice.ApprovalReceiptDataService;
import main.dataservice.receiptdataservice.CourrierReceiptDataService;
import main.dataservice.receiptdataservice.FinanceReceiptDataService;
import main.dataservice.receiptdataservice.IntermediateReceiptDataService;
import main.dataservice.receiptdataservice.LobbyReceiptDataService;
import main.dataservice.receiptdataservice.WarehouseReceiptDataService;
import main.po.ApprovalPO;
import main.po.CourrierReceiptPO;
import main.po.FinanceReceipt;
import main.po.IntermediateReceipt;
import main.po.LobbyReceiptPO;
import main.po.WarhouseReceiptPO;
import main.presentation.mainui.MainController;
import main.socketservice.Client;

public class ReceiptController implements CourrierReceiptDataService,FinanceReceiptDataService,IntermediateReceiptDataService,
LobbyReceiptDataService,ApprovalReceiptDataService,WarehouseReceiptDataService{
	Client client;
	@Override
	public void saveCodes(CourrierReceiptPO po) {
		// TODO Auto-generated method stub
		po.setKey("Save");
		client=MainController.getClient();
		client.writeReceipt(po);
	}
	@Override
	public CourrierReceiptPO inquireCourrierCodes(CourrierReceiptPO po) {
		// TODO Auto-generated method stub
		po.setKey("Inquire");
		client=MainController.getClient();
		client.writeReceipt(po);
		po=(CourrierReceiptPO) client.getResponse();
		return po;
	}
	@Override
	public void saveFinanceCodes(FinanceReceipt po) {
		// TODO Auto-generated method stub
		po.setKey("Save");
		client=MainController.getClient();
		client.writeReceipt(po);
	}
	@Override
	public FinanceReceipt inquireFinanceReceipt(FinanceReceipt po) {
		// TODO Auto-generated method stub
		po.setKey("Inquire");
		client=MainController.getClient();
		client.writeReceipt(po);
		po=(FinanceReceipt)client.getResponse();
		return po;
	}
	@Override
	public void saveIntermCodes(IntermediateReceipt po) {
		// TODO Auto-generated method stub
		po.setKey("Save");
		client=MainController.getClient();
		client.writeReceipt(po);
	}
	@Override
	public IntermediateReceipt inquireIntermCodes(IntermediateReceipt po) {
		// TODO Auto-generated method stub
		po.setKey("Inquire");
		client=MainController.getClient();
		client.writeReceipt(po);
		po=(IntermediateReceipt) client.getResponse();
		return po;
	}
	@Override
	public void saveLobbyCode(LobbyReceiptPO po) {
		// TODO Auto-generated method stub
		po.setKey("Save");
		client=MainController.getClient();
		client.writeReceipt(po);
	}
	@Override
	public LobbyReceiptPO inquireLobbyReceipt(LobbyReceiptPO po) {
		// TODO Auto-generated method stub
		po.setKey("Inquire");
		client=MainController.getClient();
		client.writeReceipt(po);
		po=(LobbyReceiptPO) client.getResponse();
		return po;
	}
	@Override
	public void saveApprovalCode(ApprovalPO po) {
		// TODO Auto-generated method stub
		po.setKey("Save");
		client=MainController.getClient();
		client.writeReceipt(po);
	}
	@Override
	public ApprovalPO inquireApprovalPO(ApprovalPO po) {
		// TODO Auto-generated method stub
		po.setKey("Inquire");
		client=MainController.getClient();
		client.writeReceipt(po);
		po=(ApprovalPO) client.getResponse();
		return po;
	}
	
	@Override
	public void saveWarehouseReceipt(WarhouseReceiptPO po) {
		// TODO Auto-generated method stub
		po.setKey("Save");
		client=MainController.getClient();
		System.out.println("{{{{{{{{{{{{{{:::"+po.getUsername()+" "+po.getWarehouseInCode()+" "+po.getWarehouseInDate()+" "+
				po.getWarehouseOutCode()+" "+po.getWarehouseOutDate()+" "+po.getBelong());
		client.writeReceipt(po);
		
	}
	@Override
	public WarhouseReceiptPO inquireWarehouseReceipt(WarhouseReceiptPO po) {
		// TODO Auto-generated method stub
		po.setKey("Inquire");
		client=MainController.getClient();
		client.writeReceipt(po);
		po=(WarhouseReceiptPO) client.getResponse();
		return po;
	}

}
