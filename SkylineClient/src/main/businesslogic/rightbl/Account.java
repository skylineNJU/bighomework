package main.businesslogic.rightbl;
import main.data.load.LoadDataController;
import main.data.right.RightDataController;
import main.dataservice.LoadDataService;
import main.dataservice.RightDataService;
import main.po.AccountPO;
import main.po.Rights;
import main.po.TrainLoadingPO;
import main.vo.AccountVO;
public class Account {

	private String ID;//员工账号名
	private String code;//密码
	private Rights right;//权限
	private String belong;
	private AccountPO po;
	private RightDataService service;
	private AccountVO vo;
	
	public Account(AccountVO vo) {
		// TODO Auto-generated constructor stub
		this.ID=vo.getAccountName();
		this.code=vo.getCode();
		this.belong=vo.getBelong();
		this.vo=vo;
		this.right=vo.getRight();
		service=new RightDataController();
	}
	
	public AccountVO login(AccountVO vo){
		po=new AccountPO(ID,code,right,belong);
		po=service.login(po);
		System.out.println(po.getRight());
		vo.setRight(po.getRight());
		vo.setBelong(po.getBelong());
		return vo;
	}
	
	
	public Account(String oldCode, String newCode) {
		// TODO Auto-generated constructor stub
		this.code=newCode;
	}
	public Account(String iD2) {
		// TODO Auto-generated constructor stub
		this.ID=iD2;
	}
	public boolean saveInfo(){
		po=new AccountPO(ID,code,right,belong);
		System.out.println("一"+po.getID()+po.getCode()+po.getRight()+po.getBelong());
		po.setCode(code);
		RightDataService service=new RightDataController();
		service.writeAccount(po);
		return true;
	}
	
	public boolean modify(){
		return true;
	}
	public boolean inquire(String ID){
		
		return true;
		
	}
	
	public static boolean delete(String ID){
		return true;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
