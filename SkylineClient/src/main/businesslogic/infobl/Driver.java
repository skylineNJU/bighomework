package main.businesslogic.infobl;

import main.data.info.InfoDataController;
import main.dataservice.InfoDataService;
import main.po.DriverInfoPO;
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
		if(inquire(driverCode)){
			this.age=po.getBirthDay();
			this.code=po.getDriverID();
			this.IDcode=po.getIdCard();
			this.limit=po.getDueDate();
			this.name=po.getName();
			this.phoneNumber=po.getPhoneNum();
			this.sex=po.getSex();
		}
	}
	
	public boolean saveInfo(){
		po=new DriverInfoPO(this.code,this.name,this.age,this.IDcode,this.phoneNumber,this.sex,this.limit,this.carunit);
		InfoDataService service=new InfoDataController();
		service.createNewDriver(po);
		return true;
	}
	
	public boolean modify(){
		return true;
	}
	private boolean inquire(String driverCode){
		
		return true;
		
	}
	
	public static boolean delete(String driverCode){
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getIDcode() {
		return IDcode;
	}
	public void setIDcode(String iDcode) {
		IDcode = iDcode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
}
