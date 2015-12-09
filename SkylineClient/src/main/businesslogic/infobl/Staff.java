package main.businesslogic.infobl;

import java.util.ArrayList;

import main.data.info.InfoDataController;
import main.dataservice.InfoDataService;
import main.po.WorkerPO;
import main.vo.StaffVO;

public class Staff {
	private String name;//����
	private String job;//ְλ
	private String unit;//��λ
	private String workage;//��ְʱ��
	private String code;//�˺�
	private WorkerPO po;
	public Staff(StaffVO vo){
		this.setName(vo.getName());
		this.setJob(vo.getJob());
		this.setUnit(vo.getUnit());
		this.setWorkage(vo.getWorkage());
		this.setCode(vo.getCode());
	}

	public Staff(String code){
		if(inquire(code)){
			this.name=po.getName();
			this.job=po.getPosition();
			this.unit=po.getBelong();
			this.workage=po.getAge();
			this.code=po.getCode();
		}
	}
	
	private boolean inquire(String code){
		InfoDataService service=new InfoDataController();
		System.out.println(code);
		po=new WorkerPO(code, code, code, code, code);
		po=service.inquireStaff(po);
		return true;
	}
	private ArrayList<StaffVO> readWorkerList(String unitCode){
		
		return null;
	}
	
	public boolean saveInfo(){
		po=new WorkerPO(this.name,this.job,this.unit,this.workage,this.code);
		InfoDataService service=new InfoDataController();
		service.createNewStaff(po);
		return true;
	}
	
	public boolean modify(){
		return true;
	}
	
	public static boolean delete(String staffcode){
		return true;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getWorkage() {
		return workage;
	}

	public void setWorkage(String workage) {
		this.workage = workage;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
