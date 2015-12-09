package main.businesslogic.loadbl;

import main.businesslogic.financebl.UpdateBank;
import main.data.load.LoadDataController;
import main.dataservice.LoadDataService;
import main.po.LoadingInfoPO;
import main.vo.LobbyLoading;

public class Loading {
	private String loadingDate;
	private String vehiclecode;
	private String from;
	private String to;
	private String monitor;
	private String escort;
	private String eara;
	private double fee;
	private String code;
	private LoadingInfoPO po;
	private String belong;
	
	public Loading(LobbyLoading vo){
		this.vehiclecode=vo.getAutoMobileNum();
		this.from=vo.getDeparture();
		this.to=vo.getDestination();
		this.monitor=vo.getMonitor();
		this.escort=vo.getGuard();
		this.setEara(vo.getShipment());
		this.fee=vo.getFreight();
		this.code=vo.getCode();
		this.loadingDate=vo.getLoadingDate();
		this.belong=vo.getBelong();
	}

	
	public void saveInfo(){
		System.out.println("check-------------"+code);
		po=new LoadingInfoPO(this.loadingDate,this.vehiclecode,
				this.from,this.to,this.monitor,this.escort,this.eara,this.fee);
		po.setCode(this.code);
		LoadDataService service=new LoadDataController();
		service.saveLobbyLoadingReceipt(po);
		UpdateBank updateBank=new UpdateBank();
		updateBank.updateMoney(belong, fee);
	}
	
	public boolean saveLoading(){
		return true;
	}
	public String getVehiclecode() {
		return vehiclecode;
	}


	public String getFrom() {
		return from;
	}


	public String getTo() {
		return to;
	}


	public String getMonitor() {
		return monitor;
	}

	public String getEscort() {
		return escort;
	}

	public void setEscort(String escort) {
		this.escort = escort;
	}

	public double getFee() {
		return fee;
	}

	public String getEara() {
		return eara;
	}

	public void setEara(String eara) {
		this.eara = eara;
	}

}
