package main.businesslogic.receiptbl;

import java.text.SimpleDateFormat;
import java.util.Date;

import main.businesslogicservice.receiptblService.CourrierReceipt;
import main.businesslogicservice.receiptblService.FinanceReceipt;
import main.businesslogicservice.receiptblService.IntermediateReceipt;
import main.businesslogicservice.receiptblService.LobbyReceipt;
import main.businesslogicservice.receiptblService.ReceiptCode;
import main.businesslogicservice.receiptblService.SubmitReceipt;
import main.businesslogicservice.receiptblService.WarehouseReceipt;
import main.vo.ApprovalVO;
import main.vo.CorrierReceiptVO;
import main.vo.FinanceReceiptVO;
import main.vo.IntermediateReciptVO;
import main.vo.LobbyReceiptVO;
import main.vo.WarhouseReceiptVO;

public class ReceiptBLController implements CourrierReceipt,FinanceReceipt,IntermediateReceipt,LobbyReceipt,WarehouseReceipt,SubmitReceipt,
ReceiptCode{

	@Override
	public void saveOrderCode(String orderCode, String userName) {
		// TODO Auto-generated method stub
	    Date dt=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		String time=format.format(dt);
		CourrierReceiptCode receiptCode=new CourrierReceiptCode(userName,orderCode,time,null,null,null);
		receiptCode.saveInfo();
	}

	@Override
	public void saveReceiveCode(String ReceiveCode, String userName) {
		// TODO Auto-generated method stub
		Date dt=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		String time=format.format(dt);
		CourrierReceiptCode receiptCode=new CourrierReceiptCode(userName,null,null,ReceiveCode,time,null);
		receiptCode.saveInfo();
	}

	@Override
	public void saveDistributeCode(String DistributeCode, String userName) {
		// TODO Auto-generated method stub
		CourrierReceiptCode receiptCode=new CourrierReceiptCode(userName,null,null,null,null,DistributeCode);
		receiptCode.saveInfo();
	}

	@Override
	public CorrierReceiptVO getAllReceipt(String userName) {
		// TODO Auto-generated method stub
		CourrierReceiptCode receiptCode=new CourrierReceiptCode(userName,null,null,null,null,null);
		CorrierReceiptVO vo=receiptCode.getReceiptCode();
		return vo;
	}


	@Override
	public void saveCostCode(String userName, String costCode) {
		// TODO Auto-generated method stub
		FinanceReceiptCode finRec=new FinanceReceiptCode(userName,costCode,null);
		finRec.saveInfo();
	}

	@Override
	public void saveEarnCode(String userName, String earnCode) {
		// TODO Auto-generated method stub
		FinanceReceiptCode finRec=new FinanceReceiptCode(userName,null,earnCode);
		finRec.saveInfo();
	}

	@Override
	public FinanceReceiptVO getFinanceCode(String name) {
		// TODO Auto-generated method stub
		FinanceReceiptCode finRec=new FinanceReceiptCode(name,null,null);
		FinanceReceiptVO vo=finRec.inquireFinanceCode();
		return vo;
	}

	@Override
	public void saveIntermReceiptCode(String userName, String code) {
		// TODO Auto-generated method stub
		Date dt=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		String time=format.format(dt);
		IntermediateReceiptCode interm=new IntermediateReceiptCode(userName,code,null,null,null,null,null,null,time);
		interm.saveInfo();;
	}

	@Override
	public void saveAirLoadCode(String userName, String code) {
		// TODO Auto-generated method stub
		Date dt=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		String time=format.format(dt);
		IntermediateReceiptCode interm=new IntermediateReceiptCode(userName,null,code,null,null,time,null,null,null);
		interm.saveInfo();
	}

	@Override
	public void saveRoadLoadCode(String userName, String code) {
		// TODO Auto-generated method stub
		Date dt=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		String time=format.format(dt);
		IntermediateReceiptCode interm=new IntermediateReceiptCode(userName,null,null,null,code,null,null,time,null);
		interm.saveInfo();
	}

	@Override
	public void saveRailLoadCode(String userName, String code) {
		// TODO Auto-generated method stub
		Date dt=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		String time=format.format(dt);
		IntermediateReceiptCode interm=new IntermediateReceiptCode(userName,null,null,code,null,null,time,null,null);
		interm.saveInfo();
	}

	@Override
	public IntermediateReciptVO getIntermediateReceiptCode(String userName) {
		// TODO Auto-generated method stub
		IntermediateReceiptCode interm=new IntermediateReceiptCode(userName,null,null,null,null,null,null,null,null);
		IntermediateReciptVO vo=interm.inquire();
		return vo;
	}

	@Override
	public void SaveReceiveCode(String userName, String code) {
		// TODO Auto-generated method stub
		Date dt=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		String time=format.format(dt);
		LobbyReceiptCode lobby=new LobbyReceiptCode(userName,code,null,time,null,null);
		lobby.saveInfo();
	}

	@Override
	public void SaveEarnCode(String userName, String code) {
		// TODO Auto-generated method stub
		Date dt=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		String time=format.format(dt);
		LobbyReceiptCode lobby=new LobbyReceiptCode(userName,null,code,null,time,null);
		lobby.saveInfo();
	}

	@Override
	public LobbyReceiptVO getLobbyReceiptCode(String userName) {
		// TODO Auto-generated method stub
		LobbyReceiptCode lobby=new LobbyReceiptCode(userName,null,null,null,null,null);
		LobbyReceiptVO vo=lobby.inquireLobbyCode();
		return vo;
	}

	@Override
	public void submit(String code, String kind) {
		// TODO Auto-generated method stub
		ManagerReceiptCode manager=new ManagerReceiptCode(code,kind);
		manager.saveInfo();
	}

	@Override
	public ApprovalVO getApproval() {
		// TODO Auto-generated method stub
		ManagerReceiptCode manager=new ManagerReceiptCode(null,null);
		ApprovalVO vo=manager.inquire();
		return vo;
	}

	
	@Override
	public WarhouseReceiptVO inquireWarehouseReceipt(WarhouseReceiptVO vo) {
		// TODO Auto-generated method stub
		System.out.println("-------"+vo.getUsername()+"-------------");
		WarehouseReceiptCode warehouse=new WarehouseReceiptCode(vo);
		vo=warehouse.inquire();
		return vo;
	}

	@Override
	public void saveWarehouseInCode(String code, String username) {
		// TODO Auto-generated method stub
		Date dt=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		String time=format.format(dt);
		WarehouseReceiptCode warehouse=new WarehouseReceiptCode(code,time,null,null,null,username);
		warehouse.saveInfo();
	}

	@Override
	public void saveWarehouseOutCode(String code, String username) {
		// TODO Auto-generated method stub
		Date dt=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		String time=format.format(dt);
		WarehouseReceiptCode warehouse=new WarehouseReceiptCode(null,null,code,time,null,username);
		warehouse.saveInfo();
	}

	@Override
	public String calculCode(String codeList,String userName) {
		// TODO Auto-generated method stub
		CalculateReceiptCode cal=new CalculateReceiptCode(codeList,userName);
		
		return cal.getCalculatedCode();
	}

	@Override
	public void SaveLoadingCode(String userName, String code) {
		// TODO Auto-generated method stub
		LobbyReceiptCode lobby=new LobbyReceiptCode(userName,null,null,null,null,code);
		lobby.saveInfo();
	}

}
