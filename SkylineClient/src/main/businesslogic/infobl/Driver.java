package main.businesslogic.infobl;

import java.util.ArrayList;

import main.data.info.InfoDataController;
import main.dataservice.InfoDataService;
import main.po.DriverInfoPO;
import main.po.DriverList;
import main.vo.DriverVO;

public class Driver {
	private String name;
	private String code;
	private String age;
	private String IDcode;
	private String phoneNumber;
	private String sex;
	private String limit;
	private String carunit;
	private DriverInfoPO po;
	
	public Driver(DriverVO dr){
		this.age=dr.getAge();
		this.code=dr.getCode();
		this.IDcode=dr.getIDcode();
		this.limit=dr.getLimit();
		this.name=dr.getName();
		this.phoneNumber=dr.getPhoneNumber();
		this.sex=dr.getSex();
		this.carunit=dr.getCarunit();
	}
	
	public Driver(String driverCode){
		this.code=driverCode;
	}
	
	public boolean saveInfo(){
		po=new DriverInfoPO(this.code,
							this.name,
							this.age,
							this.IDcode,
							this.phoneNumber,
							this.sex,
							this.limit,
							this.carunit);
		InfoDataService service=new InfoDataController();
		service.createNewDriver(po);
		return true;
	}
	
	public boolean modify(){
		po=new DriverInfoPO(this.code,
				this.name,
				this.age,
				this.IDcode,
				this.phoneNumber,
				this.sex,
				this.limit,
				this.carunit);
		InfoDataService service=new InfoDataController();
		service.modifyDriver(po);
		return true;
	}
	public ArrayList<DriverVO> inquire(String Code){
		InfoDataService service=new InfoDataController();
		po=new DriverInfoPO(Code);
		DriverList driverlist=new DriverList();
		driverlist.add(po);
		driverlist=service.inquireDriver(driverlist);
		ArrayList<DriverVO> volist=new ArrayList<DriverVO>();
		for(DriverInfoPO p:driverlist.getlist()){
			System.out.println(p.getName());
			volist.add(new DriverVO(p.getName(),
									p.getDriverID(),
									p.getBirthDay(),
									p.getIdCard(),
									p.getPhoneNum(),
									p.getSex(),
									p.getDueDate(),
									p.getCarunit()));
		}
		return volist;
	}
	
	public boolean delete(){
		DriverInfoPO po=new DriverInfoPO(code, code, code, code, code, code, code, code);
		InfoDataService service=new InfoDataController();
		service.deleteDriver(po);
		return true;
	}
	
}
