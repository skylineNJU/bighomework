package main.businesslogic.infobl;

import java.util.ArrayList;

import main.data.finance.FinanceDataController;
import main.data.info.InfoDataController;
import main.dataservice.FinanceDataService;
import main.dataservice.InfoDataService;
import main.po.BankAccountPO;
import main.po.BankList;
import main.po.VehicleInfoPO;
import main.po.VehicleList2PO;
import main.po.VehicleListPO;
import main.vo.BankAccountVO;
import main.vo.VehicleVO;

public class Vehicle {
	private String carID;//��������
	private String engineID;//���̴���
	private String carNum;//������
	private String underpanID;//���̺�
	private String boughtTime;//����ʱ��
	private String usedTime;//����ʱ��
	private VehicleInfoPO po;
	
	public Vehicle(){}
	
	public Vehicle(VehicleVO vo){
		this.carID=vo.getCarID();
		this.engineID=vo.getEngineID();
		this.carNum=vo.getCarNum();
		this.underpanID=vo.getUnderpanID();
		this.boughtTime=vo.getBoughtTime();
		this.usedTime=vo.getUsedTime();
		
	}
	
	public Vehicle(String vehicleCode){
		po=new VehicleInfoPO(vehicleCode, vehicleCode, vehicleCode, vehicleCode, vehicleCode, vehicleCode);
	}
	
	public ArrayList<VehicleVO> inquire(){
		ArrayList<VehicleVO> vehicleList=new ArrayList<VehicleVO>();
		VehicleListPO list=new VehicleListPO();
		list.add(po);
		InfoDataService service=new InfoDataController();
		list=service.readVehicle(list);
		for(VehicleInfoPO info:list.getList()){
			VehicleVO vo=new VehicleVO(info.getCarID(),
									   info.getEngineID(),
									   info.getCarNum(),
									   info.getUnderpanID(),
									   info.getBoughtTime(),
									   info.getUsedTime());
			vehicleList.add(vo);
		}
		return vehicleList;
	}
	
	public ArrayList<VehicleVO> readVehicalList(){
		ArrayList<VehicleVO> vehicalVOList = new ArrayList<VehicleVO>();
		
		InfoDataService dataService = new InfoDataController();
		VehicleList2PO vehicleList = dataService.readVehicleVO();
		for(VehicleInfoPO po:vehicleList.getList()){
			vehicalVOList.add(new VehicleVO(po.getCarID(), po.getEngineID(), po.getCarNum(),
					   po.getUnderpanID(),
					  po.getBoughtTime(),
					   po.getUsedTime()));
		}
		return vehicalVOList;
	}
	
	public boolean saveInfo(){
		InfoDataService service=new InfoDataController();
		po=new VehicleInfoPO(this.carID,
							 this.engineID,
							 this.carNum,
							 this.underpanID,
							 this.boughtTime,
							 this.usedTime);
		service.createNewVehicle(po);
		return true;
	}
	
	public boolean modify(){
		InfoDataService service=new InfoDataController();
		po=new VehicleInfoPO(this.carID,
				 this.engineID,
				 this.carNum,
				 this.underpanID,
				 this.boughtTime,
				 this.usedTime);
		service.modifyVehicle(po);
		return true;
	}
	
	public  boolean delete(){
		InfoDataService service=new InfoDataController();
		service.deleteVehicle(po);
		return true;
	}
	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public String getEngineID() {
		return engineID;
	}

	public void setEngineID(String engineID) {
		this.engineID = engineID;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getUnderpanID() {
		return underpanID;
	}

	public void setUnderpanID(String underpanID) {
		this.underpanID = underpanID;
	}

	public String getBoughtTime() {
		return boughtTime;
	}

	public void setBoughtTime(String boughtTime) {
		this.boughtTime = boughtTime;
	}

	public String getUsedTime() {
		return usedTime;
	}

	public void setUsedTime(String usedTime) {
		this.usedTime = usedTime;
	}
}
