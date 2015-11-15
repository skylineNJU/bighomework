package businesslogic.infobl;

import po.WorkerPO;
import vo.StaffVO;

public class Staff {
	private String name;//姓名
	private String job;//职位
	private String unit;//单位
	private String workage;//入职时间
	private String code;//账号
	private WorkerPO po;
	public Staff(StaffVO vo){
		this.setName(vo.getName());
		this.setJob(vo.getJob());
		this.setUnit(vo.getUnit());
		this.setWorkage(vo.getWorkage());
		this.setCode(vo.getCode());
	}

	public Staff(String code){
		if(inquire()){
			this.name=po.getName();
			this.job=po.getPosition();
			this.unit=po.getBelong();
			this.workage=po.getAge();
			this.code=po.getCode();
		}
	}
	
	private boolean inquire(){
		return true;
	}
	public boolean saveInfo(){
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
