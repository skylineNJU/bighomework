package main.businesslogic.infobl;

import java.util.ArrayList;

import main.data.info.InfoDataController;
import main.dataservice.InfoDataService;
import main.po.StaffList2PO;
import main.po.StaffListPO;
import main.po.VehicleInfoPO;
import main.po.VehicleList2PO;
import main.po.WorkerPO;
import main.vo.StaffVO;
import main.vo.VehicleVO;

public class Staff {
	private String name;//姓名
	private String job;//职位
	private String unit;//单位
	private String workage;//入职时间
	private String code;//账号
	private WorkerPO po;
	
	public Staff(){}
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
	public ArrayList<StaffVO> readWorkerList(String unitCode){
		InfoDataService service=new InfoDataController();
		StaffListPO staffListPO = service.readStaff(unitCode);
		 ArrayList<WorkerPO> poList = staffListPO.getList();
		 ArrayList<StaffVO> voList = new ArrayList<StaffVO>();
		 for(WorkerPO workerPO:poList){
			 StaffVO staffVO = new StaffVO(workerPO.getName(), workerPO.getPosition(),
					 workerPO.getBelong(), workerPO.getAge(), workerPO.getCode()
			 );
			 voList.add(staffVO);
		 }
		return voList;
	}
	public ArrayList<StaffVO> readStaffList(){
		ArrayList<StaffVO> staffVOList = new ArrayList<StaffVO>();
		InfoDataService dataService = new InfoDataController();
		StaffList2PO staffList = dataService.readStaffVO();
		for(WorkerPO po:staffList.getList()){
			staffVOList.add(new StaffVO(po.getName(),po.getPosition(),po.getBelong(),
					po.getAge(),po.getCode(),po.getSalary(),po.getCommission()));
		}
		return staffVOList;
	}
	public boolean saveInfo(){
		po=new WorkerPO(this.name,this.job,this.unit,this.workage,this.code);
		InfoDataService service=new InfoDataController();
		service.createNewStaff(po);
		return true;
	}
	
	public boolean saveStaff(StaffVO staffvo){
		WorkerPO workerpo = new WorkerPO(staffvo.getName(),staffvo.getJob(),staffvo.getUnit(),
				staffvo.getWorkage(),staffvo.getCode()
		);
		InfoDataService service=new InfoDataController();
		service.createNewStaff(workerpo);
		return true;
	}
	public boolean modify(StaffVO staffvo){
		delete(staffvo.getCode());
		saveStaff(staffvo);
		return true;
	}
	
	public static boolean delete(String staffcode){
		InfoDataService service=new InfoDataController();
		service.deleteStaff(staffcode);
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
